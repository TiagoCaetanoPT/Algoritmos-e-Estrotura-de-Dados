package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeChamadas;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoes;
import pt.ipleiria.estg.dei.aed.utils.Par;
import pt.ipleiria.estg.dei.aed.utils.VetorDePoint2D;

import java.awt.geom.Point2D;
import java.math.BigInteger;
import java.util.Arrays;

public class PontosMaisProximos {


    public Par<Point2D, Point2D> executar(EstatisticaDeComparacoes estatistica , Point2D[] pontos) {
        //estatistica.incrementarComparacoes();
        if(pontos.length <2){
            throw new IllegalArgumentException("distancia minima entre pontos(" + Arrays.toString(pontos) + "😞 argumento invalido, deve ter pelo menos 2 argumentos");
        }



        Double distanciaMinima = pontos[0].distanceSq(pontos[1]);
        Point2D p1 = pontos[0],p2 = pontos[1];
        int im= 0, jm=1;

        for (int i = 0; i < pontos.length-2; i++)
        {
            for (int j = i; j < pontos.length; j++) {
                double distancia= pontos[i].distanceSq(pontos[j]);
                estatistica.incrementarComparacoes();
                if(distancia<distanciaMinima){
                    distanciaMinima=distancia;
                    p1=pontos[i];
                    p2=pontos[j];
                    im=i;
                    jm=j;
                }
            }

        }

        return new Par<>(p1,p2);
    }

    public EstatisticaDeComparacoes getEstatistica(Point2D[] valores){
        try{
            EstatisticaDeComparacoes estatistica = new EstatisticaDeComparacoes(valores.length);

            Par<Point2D, Point2D> pontosMaisProximos = executar(estatistica,valores);
            estatistica.parar();
            System.out.println("maximo(" + Arrays.toString(valores) + ") = " + pontosMaisProximos);
            estatistica.apresentar();
            return estatistica;
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
            return null;
        }
    }
}