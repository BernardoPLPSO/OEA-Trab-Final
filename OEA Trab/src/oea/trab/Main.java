/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oea.trab;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

/**
 *
 * @author Pirlimpimposo
 */
public class Main {

    public static void main(String[] args) throws Exception {
        String linha, nome, nomeAnt;
        int i = 0;
        int j = 0;
        int ini = 0, fim = 0;
        Long contador = 1L;
        String colunas[];
        long posicao = 1;
        char primTds = 'A';
        ArrayList<Registro> a = new ArrayList<Registro>();
        RandomAccessFile f = new RandomAccessFile("f://desktop//bolsa.csv", "r");
        RandomAccessFile fi = new RandomAccessFile("f://desktop//bolsaOrdenada.csv", "rw");
        f.readLine();//pula cabeçalho
        if (fi.readLine() == null) {
            fi.seek(0);
            while (f.getFilePointer() < f.length()) {
                Registro r = new Registro();
                r = r.leRegistro(f.readLine());
                a.add(r);
                i++;
            }
            f.close();
            Collections.sort(a);
            for (Registro r : a) {
                r.escreveRegistro(fi);
            }
        }
        System.out.println("Terminou ORDENAÇÃO");

        RandomAccessFile hash = new RandomAccessFile("f://desktop//bolsaHash.csv", "rw");

        if (hash.readLine() == null) {
            while (fi.getFilePointer() < fi.length()) {
                Registro r = new Registro();
                r.leRegistro(fi.readLine());
                char prim = r.getNome().charAt(0);
                if (prim != primTds) {
                    primTds = prim;
                    j = 0;
                }
                if (prim == primTds && j == 0) {
                    RegistroHash h = new RegistroHash();
                    h.setValor(r.getNome());
                    h.setPosicaoOriginal(contador.toString());
                    h.setPonteiroColisao("");
                    h.escreveRegistro(hash);
                    j++;
                }
                contador++;
            }
        }
        System.out.println("Terminou INDEXAÇÃO");
        //começa busca
        Scanner scan = new Scanner(System.in);

        System.out.println(
                "Digite um nome para pesquisa: ");
        String nomePesquisa = scan.nextLine();

        scan.close();
        char primPesquisa = nomePesquisa.charAt(0);

        hash.seek(
                0);
        while (hash.getFilePointer()
                < hash.length()) {
            RegistroHash h = new RegistroHash();
            h = h.leRegistroHash(hash.readLine());
            if (primPesquisa == h.getValor().charAt(0)) {
                ini = Integer.parseInt(h.getPosicaoOriginal());
                h = h.leRegistroHash(hash.readLine());
                fim = Integer.parseInt(h.getPosicaoOriginal());
                break;
            }
        }

        System.out.println(BuscaBinaria(nomePesquisa, ini, fim));

        hash.close();

        fi.close();
    }

    public static String BuscaBinaria(String nomePesquisa, int ini, int fim) throws Exception {
        String linha;
        int meio = (ini + fim) / 2;
        try (Stream<String> lines = Files.lines(Paths.get("f://desktop//bolsaOrdenada.csv"))) {
            linha = lines.skip(meio - 1).findFirst().get();
        }
        Registro r = new Registro();
        r = r.leRegistro(linha);
        if (ini > fim) {
            return "Nome não presente";
        } else if (nomePesquisa.compareTo(r.getNome()) < 0) {
            return BuscaBinaria(nomePesquisa, ini, meio - 1);
        } else if (nomePesquisa.compareTo(r.getNome()) > 0) {
            return BuscaBinaria(nomePesquisa, meio + 1, fim);
        } else {
            return "UF: " + r.getUf() + "\n"
                    + "Siafi: " + r.getSiafi() + "\n"
                    + "Municipio: " + r.getMunicipio() + "\n"
                    + "Codigo Função: " + r.getCodFunc() + "\n"
                    + "Codigo SubFunção: " + r.getCodSubFunc() + "\n"
                    + "Codigo Programa: " + r.getCodProg() + "\n"
                    + "Codigo Ação: " + r.getCodAcao() + "\n"
                    + "NIS: " + r.getNis() + "\n"
                    + "Nome Favorecido: " + r.getNome() + "\n"
                    + "Fonte-Finalidade: " + r.getFonte() + "\n"
                    + "Valor Parcela: " + r.getValor() + "\n"
                    + "Mês Competência: " + r.getMes();
        }
    }
}
//BYANKA LESLY BRANDAO DA SILVA SANTOS
//58481
//BRUNO CRUZ SANTANA
//58415
//BERNADETE SIMAO DE SOUSA PEREIRA
//56240