package pt.ipleiria.estg.dei.aed.recursividade.utilizacao;

import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.TorresHanoi;

public class MainPraticaTorresHanoi {
    public MainPraticaTorresHanoi(){
        TorresHanoi torresHanoi = new TorresHanoi();
        torresHanoi.executar(3, 'A', 'B', 'C');
    }

    public static void main(String[] args) {
        new MainPraticaTorresHanoi();
    }
}
