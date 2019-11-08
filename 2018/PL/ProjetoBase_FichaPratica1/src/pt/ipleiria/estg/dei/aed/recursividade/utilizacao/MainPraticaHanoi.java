package pt.ipleiria.estg.dei.aed.recursividade.utilizacao;

import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.Hanoi;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.ArrayList;
import java.util.List;

public class MainPraticaHanoi {

    int[] ns = {3, 0, 5, 10, 15, 30, 31, 32};

    Hanoi hanoi = new Hanoi();

    for (int n: ns){
        // System.out.println(fatorial.executar(n));
        hanoi.getEstatistica(n);
    }

    VisualizadorEstatisticas visualizador = new VisualizadorEstatisticas();

    List<Estatistica> estatiscicas = new ArrayList<>();
    for (int i = 0; i < 101; i++) {
        estatiscicas.add(hanoi.getEstatistica(i));
    }

    visualizador.adicionarEstatisticas("Fatorial", estatiscicas);
    visualizador.visualizar();
}
