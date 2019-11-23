package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeChamadas;

import java.util.NoSuchElementException;

public class Torre {
    private int[] basemaisDiscos; //vetor de inteiros
    private int numeroDiscos;
     private String nome;
    public Torre(String nome, int n) {
        basemaisDiscos = new int[n+1]; //metodo para reservar espaços no vetor Int = [n+1]
        basemaisDiscos[0] = 3 * n;
        numeroDiscos = 0;
        this.nome = nome;
    }

    public void preencherComDiscos() {
        for (int i = 1; i < basemaisDiscos.length ; i++) {
            basemaisDiscos[i] = basemaisDiscos.length - i;
        }
        numeroDiscos = basemaisDiscos.length - 1;
    }

    public void colocarDisco(int disco){
        if(numeroDiscos == basemaisDiscos.length - 1 ){  //torre cheia
            throw new ArrayIndexOutOfBoundsException("Torre Cheia");
        }
        if(numeroDiscos > 0 && basemaisDiscos[numeroDiscos] <= disco){
            throw new IllegalArgumentException("Disco tem que ser mais pequeno");
        }
        basemaisDiscos[++numeroDiscos] = disco; //incrementa o disco - codigo novo combinação dos outros dois
        //basemaisDiscos[numeroDiscos + 1] = disco; - codigo inicial
        //numeroDiscos++; - codigo incial
    }
    //Remover Disco
    public void moverDisco(Torre destino) {
        destino.colocarDisco(this.retirarDisco());
    }

    private int retirarDisco() {
        if (numeroDiscos == 0){
            throw new NoSuchElementException("Torre Vazia");
        }
        int disco = basemaisDiscos[numeroDiscos]; //guardamos o disco
        basemaisDiscos[numeroDiscos--] = 0; //descontamos o disco -
        return disco;
    }
}

