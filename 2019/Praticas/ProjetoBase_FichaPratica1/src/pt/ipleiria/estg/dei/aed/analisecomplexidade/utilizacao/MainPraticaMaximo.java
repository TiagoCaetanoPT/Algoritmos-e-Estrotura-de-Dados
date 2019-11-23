package pt.ipleiria.estg.dei.aed.analisecomplexidade.utilizacao;

import pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos.Maximo;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.VetorDeInteiros;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.ArrayList;
import java.util.List;

public class MainPraticaMaximo {

    public MainPraticaMaximo() {

        Maximo maximo = new Maximo();
        //VetorDeInteiros vetor = new VetorDeInteiros();

        maximo.getEstatisticas(VetorDeInteiros.criarAleatorioInt(5,-50,50,true));
        maximo.getEstatisticas(VetorDeInteiros.criarAleatorioInt(10,-50,50,true));
        List<Estatistica> estatisticas = new ArrayList<>();

        for (int i = 10; i < 501; i+=10) {
            estatisticas.add(maximo.getEstatisticas(VetorDeInteiros.criarAleatorioInt(i,true)));
        }

        VisualizadorEstatisticas visualizador = new VisualizadorEstatisticas();
        visualizador.adicionarEstatisticas("Maximo", estatisticas);
        visualizador.visualizar();

    }


    public static void main(String[] args){
        new MainPraticaMaximo();
    }
}
