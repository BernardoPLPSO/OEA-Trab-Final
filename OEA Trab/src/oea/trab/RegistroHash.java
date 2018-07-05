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
public class RegistroHash {

    String valor;
    String posicaoOriginal;
    String ponteiroColisao;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getPosicaoOriginal() {
        return posicaoOriginal;
    }

    public void setPosicaoOriginal(String posicaoOriginal) {
        this.posicaoOriginal = posicaoOriginal;
    }

    public String getPonteiroColisao() {
        return ponteiroColisao;
    }

    public void setPonteiroColisao(String ponteiroColisao) {
        this.ponteiroColisao = ponteiroColisao;
    }

   

    public RegistroHash leRegistroHash(String din) throws IOException {

        // Definie a forma como caracteres especias estão codificados.
        Charset enc = Charset.forName("UTF-8");
        String coisas[] = din.split("\t");
        
        this.valor = coisas[0];
        this.posicaoOriginal = coisas[1];
        return this;
    }

    public void escreveRegistro(DataOutput dout) throws IOException {
        // Definie a forma como caracteres especias estão codificados.
        Charset enc = Charset.forName("UTF-8");
        dout.write(this.valor.getBytes(enc));
        dout.write("\t".getBytes(enc));
        dout.write(this.posicaoOriginal.getBytes(enc));
        dout.write("\t".getBytes(enc));
        dout.write(this.ponteiroColisao.getBytes(enc));
        dout.write("\n".getBytes(enc));
    }
}
