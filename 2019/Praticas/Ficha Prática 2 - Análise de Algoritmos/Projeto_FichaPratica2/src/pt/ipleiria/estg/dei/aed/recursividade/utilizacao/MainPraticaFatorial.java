package pt.ipleiria.estg.dei.aed.recursividade.utilizacao;

import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.Fatorial;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.ArrayList;
import java.util.List;

public class MainPraticaFatorial {
    public MainPraticaFatorial() {
        Fatorial fatorial = new Fatorial();
        int[] numeros = {5, 0, -5, 21};
        for (int n : numeros) {
//            System.out.println(fatorial.getEstatistica(n));
            fatorial.getEstatistica(n);
        }

        VisualizadorEstatisticas visualizador = new VisualizadorEstatisticas();

        List<Estatistica> estatisticas = new ArrayList<>();
        for (int i = 1; i < 101; i++) {
            estatisticas.add(fatorial.getEstatistica(i));
        }
        visualizador.adicionarEstatisticas("Fatorial", estatisticas);
        visualizador.visualizar();
    }

    public static void main(String[] args) {
        new MainPraticaFatorial();
    }
}
