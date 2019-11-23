package pt.ipleiria.estg.dei.aed.recursividade.utilizacao;

import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.Fatorial;
import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.Maximo;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.VetorDeInteiros;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.LinkedList;

/**
 *
 */
public class MainPraticaMaximo {

    public MainPraticaMaximo() {
        Maximo maximo = new Maximo();
        maximo.getEstatistica(VetorDeInteiros.criarAleatorioInt(5,-50, 50, true)); //criação do vetor com os numeros da sequencia
        /**
        int[] ns = {5, 0, -10, 40, 45};
        for (int n : ns) {
            try {
                System.out.println(maximo.getEstatistica(n));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
         */
        VisualizadorEstatisticas visualizador = new VisualizadorEstatisticas();
        LinkedList<Estatistica> estatisticas = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            estatisticas.add(maximo.getEstatistica(5, 4, 45, -3));
        }
        visualizador.adicionarEstatisticas("Maximo", estatisticas);
        visualizador.visualizar();
    }

    public static void main(String[] args){
        new MainPraticaMaximo();
    }
}
