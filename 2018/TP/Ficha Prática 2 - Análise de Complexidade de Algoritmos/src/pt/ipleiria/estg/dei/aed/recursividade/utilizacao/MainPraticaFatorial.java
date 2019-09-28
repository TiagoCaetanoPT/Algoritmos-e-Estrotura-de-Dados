package pt.ipleiria.estg.dei.aed.recursividade.utilizacao;

import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.Fatorial;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.ArrayList;
import java.util.List;

public class MainPraticaFatorial {
    public MainPraticaFatorial(){
        Fatorial fatorial = new Fatorial();

        int[] ns = {5, 0, -5, 21};
        for (int n: ns){
           // System.out.println(fatorial.executar(n));
            fatorial.getEstatistica(n);
        }

        VisualizadorEstatisticas visualizador = new VisualizadorEstatisticas();

        List<Estatistica> estatiscicas = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            estatiscicas.add(fatorial.getEstatistica(i));
        }

        visualizador.adicionarEstatisticas("Fatorial", estatiscicas);
        visualizador.visualizar();

        /*
        System.out.println(fatorial.executar(5));
        System.out.println(fatorial.executar(0));
        System.out.println(fatorial.executar(-5));
        System.out.println(fatorial.executar(21));
        */
    }

    public static void main(String[] args){
        new MainPraticaFatorial();
    }
}
