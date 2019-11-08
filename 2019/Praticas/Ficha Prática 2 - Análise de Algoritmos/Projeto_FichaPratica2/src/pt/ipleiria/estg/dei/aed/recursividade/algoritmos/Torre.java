package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;

import java.util.NoSuchElementException;

public class Torre {
    private String nome;
    private int numDiscos;
    private int[] discos;

    public Torre(String nome, int maximoDiscos) {
        this.nome = nome;
        numDiscos = 0;
        discos = new int[maximoDiscos + 1];
        discos[0] = maximoDiscos * 3;
    }

    //preencher com discos
    public void preencherComDiscos() {
        for (int i = 1; i < discos.length; i++) {
            discos[i] = discos.length - i;
        }
        numDiscos = discos.length - 1;
    }

    //tirar disco
    public int tirarDisco() {
        if (numDiscos == 0) {
            throw new NoSuchElementException("Não há discos para tirar da torre.");
        }
        int disco = discos[numDiscos];
        //discos[numDiscos] = 0;
        //numDiscos--;
        discos[numDiscos--] = 0;
        return disco;
    }

    //colocar disco
    public void colocarDisco(int disco) {
        if (numDiscos == (discos.length - 1)) {
            throw new ArrayIndexOutOfBoundsException("Não há espaço para colocar discos na torre.");
        }
            discos[++numDiscos] = disco;
    }
}