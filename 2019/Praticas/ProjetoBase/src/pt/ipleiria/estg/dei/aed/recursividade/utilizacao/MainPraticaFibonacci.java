package pt.ipleiria.estg.dei.aed.recursividade.utilizacao;

import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.Fatorial;
import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.Fibonacci;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.LinkedList;

/**
 *
 */
public class MainPraticaFibonacci {

    public MainPraticaFibonacci() {
        Fibonacci fibonacci = new Fibonacci();
        int[] ns = {5, 0, -10, 40, 45};
        for (int n :ns){
            fibonacci.getEstistica(n);
        }
        VisualizadorEstatisticas visualizador = new VisualizadorEstatisticas();
        LinkedList<Estatistica> estatisticas = new LinkedList<>();
        for (int i = 5; i < 21; i = i+3) {
            estatisticas.add(fibonacci.getEstistica(i));
        }
        visualizador.adicionarEstatisticas("Fibonacci", estatisticas);
        visualizador.visualizar();
    }

    public static void main(String[] args){
        new MainPraticaFibonacci();
    }
}
