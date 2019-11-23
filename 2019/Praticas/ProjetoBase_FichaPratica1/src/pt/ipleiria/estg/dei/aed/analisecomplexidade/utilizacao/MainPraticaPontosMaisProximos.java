package pt.ipleiria.estg.dei.aed.analisecomplexidade.utilizacao;

import pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos.PontosMaisProximos;
import pt.ipleiria.estg.dei.aed.utils.VetorDePoint2D;

public class MainPraticaPontosMaisProximos {


    public MainPraticaPontosMaisProximos(){

        PontosMaisProximos ponto= new PontosMaisProximos();
        ponto.getEstatisticas(VetorDePoint2D.criarAleatorio(6));
    }

    public static void main(String[] args){
        new MainPraticaPontosMaisProximos();
    }
}
