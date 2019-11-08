package pt.ipleiria.estg.dei.aed.analisecomplexidade.utilizacao;

import pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos.PontosMaisProximos;
import pt.ipleiria.estg.dei.aed.utils.VetorDePoint2D;

public class MainPraticaPontosMaisProximos {
    public MainPraticaPontosMaisProximos(){
        PontosMaisProximos pontosMaisProximos = new PontosMaisProximos();

        pontosMaisProximos.getEstatistica(VetorDePoint2D.criarAleatorio(3));
    }

    public static void main(String[] args) {
        new MainPraticaPontosMaisProximos();
    }
}
