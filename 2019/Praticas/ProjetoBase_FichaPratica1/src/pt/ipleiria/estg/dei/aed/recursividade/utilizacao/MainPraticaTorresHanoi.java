package pt.ipleiria.estg.dei.aed.recursividade.utilizacao;


import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.Torre;
import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.TorresHanoi;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.LinkedList;

public class MainPraticaTorresHanoi {

    public MainPraticaTorresHanoi() {


        TorresHanoi torresHanoi = new TorresHanoi();
       // int[] ns = {3, 0, 5, 10, 15, 30, 31, 32};
        /*for (int n : ns){
            System.out.println("Número de discos: " + n);
            torresHanoi.getEstatistica(n, 'A', 'B', 'C');
        }*/

        /*LinkedList<Estatistica> estatisticas = new LinkedList<>();
        VisualizadorEstatisticas visualizador = new VisualizadorEstatisticas();

        for (int n = 3; n < 16; n ++){
            estatisticas.add(torresHanoi.getEstatistica(n));
        }*/

        torresHanoi.getEstatistica(15);
        /*visualizador.adicionarEstatisticas("torresHanoi",estatisticas);
        visualizador.visualizar();*/

    }

    public static void main(String[] args){
        new MainPraticaTorresHanoi();
    }
}
