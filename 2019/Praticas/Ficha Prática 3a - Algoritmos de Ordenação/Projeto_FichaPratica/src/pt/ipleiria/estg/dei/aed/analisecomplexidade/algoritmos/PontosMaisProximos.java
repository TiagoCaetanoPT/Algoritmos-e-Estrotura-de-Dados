package pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoes;
import pt.ipleiria.estg.dei.aed.utils.Par;

import java.awt.geom.Point2D;
import java.lang.reflect.Array;
import java.util.Arrays;

public class PontosMaisProximos {
    public Par<Point2D, Point2D> executar(EstatisticaDeComparacoes estatistica, Point2D... pontos) {
        if (pontos.length < 2) {
            throw new IllegalArgumentException("É necessário pelo menos 2 pontos");
        }
        if (pontos.length == 2) { //quando só há dois pontos, são sempre os mais proximos
            return new Par<Point2D, Point2D>(pontos[0], pontos[1]);
        }

        double distMinima = Double.MAX_VALUE; //para grardar a distancia entre os pontos... Começa com o máximo para garantir que tudo o que vai entrar é menor que o valor atual
        int indicePonto1 = 0, indicePonto2 = 0;

        for (int i = 0; i < pontos.length - 1; i++) {
            for (int j = i + 1; j < pontos.length; j++) {
                double dist = pontos[i].distanceSq(pontos[j]);
                estatistica.incrementarComparacoes();
                if (dist < distMinima) {
                    distMinima = dist;
                    indicePonto1 = i;
                    indicePonto2 = j;
                }
            }
        }

        return new Par<>(pontos[indicePonto1], pontos[indicePonto2]);
    }

    public EstatisticaDeComparacoes getEstatistica(Point2D... pontos) {
        try {
            EstatisticaDeComparacoes estatistica = new EstatisticaDeComparacoes(pontos.length);
            Par<Point2D,Point2D>maisProximos = executar(estatistica, pontos);
            estatistica.parar();
            System.out.println("Pontos mais proximos(" + Arrays.toString(pontos) + ")= Par([" + maisProximos.getPrimeiro().getX() + "," + maisProximos.getPrimeiro().getY() + "], [" + maisProximos.getSegundo().getX() + "," + maisProximos.getSegundo().getY() + "])");
            estatistica.apresentar();
            return estatistica;
        } catch (IllegalArgumentException exeption) {
            System.out.println(exeption.getMessage() + "\n");
            return null;
        }
    }

}
