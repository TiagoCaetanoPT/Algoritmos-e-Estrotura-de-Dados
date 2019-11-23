package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.Vetor;

import java.util.NoSuchElementException;

public class Torre {
    private String nome;
    private int numeroDiscos;
    private int[] discos;

    public Torre(String nome, int maxDiscos) {
        this.nome = nome;
        numeroDiscos = 0;
        discos = new int[maxDiscos+1];
        discos[0] = maxDiscos*3;
    }

    public void prencherDisco(){
        for (int i = 1; i < discos.length ; i++) {
            discos[i]=discos.length-i;
        }
        numeroDiscos=discos.length-1;
    }

    public int tirarDisco() {
        if (numeroDiscos == 0){
            throw new NoSuchElementException("Torre vazia");
        }
        int disco = discos[numeroDiscos];
        discos[numeroDiscos--] = 0;
        return disco;
    }

    public void colocarDisco(int disco){
        if (numeroDiscos == (discos.length - 1)){
            throw new ArrayIndexOutOfBoundsException("Torre cheia");
        }
/*
        if (numeroDiscos > 0 && discos[numeroDiscos] <= disco){
            throw new IllegalArgumentException("Disco tem que ser mais pequeno");
        }
*/
        discos[++numeroDiscos] = disco;
    }

    public void moverDisco(Torre destino){
        destino.colocarDisco(this.tirarDisco());
    }




}
