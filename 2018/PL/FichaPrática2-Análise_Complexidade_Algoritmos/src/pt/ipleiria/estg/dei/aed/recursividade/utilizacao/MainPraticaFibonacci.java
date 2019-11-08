package pt.ipleiria.estg.dei.aed.recursividade.utilizacao;

import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.Fibonacci;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.ArrayList;
import java.util.List;

public class MainPraticaFibonacci {
    public MainPraticaFibonacci() {
        Fibonacci fibonacci = new Fibonacci();

        int[] ns = {5, 0, -10, 40, 45};
        for (int n : ns) {
            fibonacci.getEstatistica(n);
        }

        VisualizadorEstatisticas visualizador = new VisualizadorEstatisticas();

        List<Estatistica> estatisticas = new ArrayList<>();
        for (int i = 5; i < 21; i += 3) {
            estatisticas.add(fibonacci.getEstatistica(i));
        }

        visualizador.adicionarEstatisticas("Fibonacci", estatisticas);
        visualizador.visualizar();
    }

    public static void main(String[] args) {
        new MainPraticaFibonacci();
    }
}



