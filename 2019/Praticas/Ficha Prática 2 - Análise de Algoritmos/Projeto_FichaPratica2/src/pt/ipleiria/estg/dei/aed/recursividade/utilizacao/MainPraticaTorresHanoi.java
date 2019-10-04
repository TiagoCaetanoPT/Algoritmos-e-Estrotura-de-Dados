package pt.ipleiria.estg.dei.aed.recursividade.utilizacao;

import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.TorresHanoi;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.ArrayList;
import java.util.List;

public class MainPraticaTorresHanoi {
    public MainPraticaTorresHanoi() {
        TorresHanoi torresHanoi = new TorresHanoi();

        int[] numeroDiscos = {3, 0, 5, 10, 15, 30, 31, 32};
        for (int n : numeroDiscos) {
//            torresHanoi.executar(n, 'A', 'B', 'C');
            torresHanoi.getEstatistica(n);
        }
    }

    public static void main(String[] args) {
        new MainPraticaTorresHanoi();
    }
}


