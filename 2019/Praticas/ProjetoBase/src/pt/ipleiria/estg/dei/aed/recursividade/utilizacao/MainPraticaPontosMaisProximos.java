package pt.ipleiria.estg.dei.aed.recursividade.utilizacao;

import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.PontosMaisProximos;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.VetorDePoint2D;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.LinkedList;

public class MainPraticaPontosMaisProximos {

    public MainPraticaPontosMaisProximos() {
        PontosMaisProximos pontosMaisProximos = new PontosMaisProximos();

        for (int tam = 5; tam < 16; tam+=5) {
            pontosMaisProximos.getEstatistica(VetorDePoint2D.criarAleatorio(tam));
        }


       /* VisualizadorEstatisticas visualizador = new VisualizadorEstatisticas();
        LinkedList<Estatistica> estatisticas = new LinkedList<>();

        visualizador.adicionarEstatisticas("Distancia", estatisticas);
        visualizador.visualizar();*/
    }

    public static void main(String[] args) {
        new MainPraticaPontosMaisProximos();
    }
}