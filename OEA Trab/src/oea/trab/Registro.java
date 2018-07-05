/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oea.trab;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 *
 * @author Pirlimpimposo
 */
public class Registro implements Comparable {

    String uf;
    String siafi;
    String municipio;
    String codFunc;
    String codSubFunc;
    String codProg;
    String codAcao;
    String nis;
    String nome;
    String fonte;
    String valor;
    String mes;

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getSiafi() {
        return siafi;
    }

    public void setSiafi(String siafi) {
        this.siafi = siafi;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCodFunc() {
        return codFunc;
    }

    public void setCodFunc(String codFunc) {
        this.codFunc = codFunc;
    }

    public String getCodSubFunc() {
        return codSubFunc;
    }

    public void setCodSubFunc(String codSubFunc) {
        this.codSubFunc = codSubFunc;
    }

    public String getCodProg() {
        return codProg;
    }

    public void setCodProg(String codProg) {
        this.codProg = codProg;
    }

    public String getCodAcao() {
        return codAcao;
    }

    public void setCodAcao(String codAcao) {
        this.codAcao = codAcao;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Registro leRegistro(String din) throws IOException {
        // Definie a forma como caracteres especias estão codificados.
        Charset enc = Charset.forName("UTF-8");
        String coisas[] = din.split(",");

        //System.out.println("Coisas 0: "+ coisas[0]);
        this.uf = coisas[0];
        //System.out.println("Coisas 1: "+ coisas[1]);
        this.siafi = coisas[1];
        this.municipio = coisas[2];
        this.codFunc = coisas[3];
        this.codSubFunc = coisas[4];
        this.codProg = coisas[5];
        this.codAcao = coisas[6];
        this.nis = coisas[7];
        this.nome = coisas[8];
        this.fonte = coisas[9];
        this.valor = coisas[10];
        this.mes = coisas[11];

        return this;

    }

    public void escreveRegistro(DataOutput dout) throws IOException {
        // Definie a forma como caracteres especias estão codificados.
        Charset enc = Charset.forName("UTF-8");
        dout.write(this.uf.getBytes(enc));
        dout.write(",".getBytes(enc));
        dout.write(this.siafi.getBytes(enc));
        dout.write(",".getBytes(enc));
        dout.write(this.municipio.getBytes(enc));
        dout.write(",".getBytes(enc));
        dout.write(this.codFunc.getBytes(enc));
        dout.write(",".getBytes(enc));
        dout.write(this.codSubFunc.getBytes(enc));
        dout.write(",".getBytes(enc));
        dout.write(this.codProg.getBytes(enc));
        dout.write(",".getBytes(enc));
        dout.write(this.codAcao.getBytes(enc));
        dout.write(",".getBytes(enc));
        dout.write(this.nis.getBytes(enc));
        dout.write(",".getBytes(enc));
        dout.write(this.nome.getBytes(enc));
        dout.write(",".getBytes(enc));
        dout.write(this.fonte.getBytes(enc));
        dout.write(",".getBytes(enc));
        dout.write(this.valor.getBytes(enc));
        dout.write(",".getBytes(enc));
        dout.write(this.mes.getBytes(enc));
        dout.write("\n".getBytes(enc));
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Registro) {
            if (this.getNome().compareTo(((Registro) o).getNome()) < 0) {
                return -1;
            } else if (this.getNome().compareTo(((Registro) o).getNome()) > 0) {
                return 1;
            }
        }
        return 0;
    }
}
