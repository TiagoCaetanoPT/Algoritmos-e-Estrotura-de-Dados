package pt.ipleiria.estg.dei.aed.recursividade.utilizacao;

import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.Fatorial;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeChamadas;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.LinkedList;

/**
 *
 */
public class MainPraticaFatorial {

    public MainPraticaFatorial() {
        Fatorial fatorial = new Fatorial(); //cria a variavel fatorial, que pertence á class Fatorial
        int[] ns = {5, 0, -5, 21}; //criação do vetor com os numeros da sequencia
        for (int n :ns){
            fatorial.getEstistica(n); //é atribuido o valor do fatorial ao getestatistica()
        }
        VisualizadorEstatisticas visualizador = new VisualizadorEstatisticas();
        LinkedList<Estatistica> estatisticas = new LinkedList<>();
        for (int i = 1; i < 101; i++) {
            estatisticas.add(fatorial.getEstistica(i));
        }
        visualizador.adicionarEstatisticas("Fatorial", estatisticas);
        visualizador.visualizar();
    }

    public static void main(String[] args){
        new MainPraticaFatorial();
    }
}
