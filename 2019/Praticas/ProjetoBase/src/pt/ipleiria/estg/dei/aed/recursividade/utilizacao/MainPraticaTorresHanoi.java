package pt.ipleiria.estg.dei.aed.recursividade.utilizacao;
import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.JogoTorresHanoi;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;


import java.util.ArrayList;
import java.util.List;

public class MainPraticaTorresHanoi {
    public MainPraticaTorresHanoi() {
        JogoTorresHanoi jogoTorresHanoi = new JogoTorresHanoi();



        VisualizadorEstatisticas visualizador = new VisualizadorEstatisticas();
        List<Estatistica> estatisticas = new ArrayList<>();
        for (int i = 3; i < 15 ; i++) {
            estatisticas.add(jogoTorresHanoi.getEstatistica(i));
        }
        visualizador.adicionarEstatisticas("torres hanoi", estatisticas);
        visualizador.visualizar();
    }

    public static void main(String[] args) {
        new MainPraticaTorresHanoi();
    }
}


/*
public class MainPraticaTorresHanoi {

    public MainPraticaTorresHanoi(){
        Torre torreA = new Torre(5, "A");
        Torre torreB = new Torre(5, "B");
        Torre torreC = new Torre(5, "C");
        torreA.preencherComDiscos();
    }

    public static void main(String[] args) {

    }
}*/
