package pt.ipleiria.estg.dei.aed.recursividade.utilizacao;

import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.TorresHanoi;

public class MainPraticaTorresHanoi {
    public MainPraticaTorresHanoi(){
        TorresHanoi torresHanoi = new TorresHanoi();
        int [] numero = {3, 0, 5, 10, 15, 30, 31, 32};
        for (int n : numero) {
            System.out.println(torresHanoi.executar(n));
        }
    }

    public static void main(String[] args) {
    }
}
