package pt.ipleiria.estg.dei.aed.recursividade.utilizacao;

import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.TorresHanoi;

public class MainPraticaTorresHanoi {
    public MainPraticaTorresHanoi() {
        int[] numeroDiscos = {3, 5, 10, 15, 30, 31, 32};
        TorresHanoi torresHanoi = new TorresHanoi();
        for (int n : numeroDiscos) {
            torresHanoi.executar(n, 'A', 'B', 'C');
        }
    }

    public static void main(String[] args) {
        new MainPraticaTorresHanoi();
    }
}
