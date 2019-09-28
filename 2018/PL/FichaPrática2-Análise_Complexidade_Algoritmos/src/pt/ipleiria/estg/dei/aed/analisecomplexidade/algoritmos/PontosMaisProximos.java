package pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoes;
import pt.ipleiria.estg.dei.aed.utils.Par;

import java.awt.geom.Point2D;


public class PontosMaisProximos {

    public Par<Point2D, Point2D> executar(EstatisticaDeComparacoes estatistica, Point2D... pontos) {

        double distanciaMin = Double.MAX_VALUE;
        double aux = 0;


        for (int i = 0; i < pontos.length; i++) {
            for (int j = i + 1; j < pontos.length; j++) {

                aux = pontos[i].distanceSq(pontos[j]);
                if (aux < distanciaMin) {
                    distanciaMin = aux;

                }
            }
        }


    }
}