package pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoes;
import pt.ipleiria.estg.dei.aed.utils.Par;

import java.awt.geom.Point2D;
import java.util.Arrays;

public class PontosMaisProximos {

    public Par<Point2D,Point2D> executar(EstatisticaDeComparacoes comparacoes, Point2D ... pontos){

        if(pontos.length<=1){
            throw new IllegalArgumentException("o vetor de pontos tem de ser maior que 1");
        }
        if(pontos.length==2){
            return new Par<>(pontos[0],pontos[1]);
        }
        double distMinima= Double.MAX_VALUE;
        int indicePonto1 = 0;
        int indicePonto2 = 0;



        for (int i = 0; i < pontos.length-1; i++) {
            for (int j = i+1; j < pontos.length ; j++) {
                comparacoes.incrementarComparacoes();
                double dist = pontos[i].distanceSq(pontos[j]);
                if (dist<distMinima){
                    indicePonto1=i;
                    indicePonto2=j;
                    distMinima=dist;
                }

            }
        }


        return new Par<>(pontos[indicePonto1],pontos[indicePonto2]) ;
    }

    public EstatisticaDeComparacoes getEstatisticas(Point2D ... pontos){
        try{
            EstatisticaDeComparacoes comparacoes =new EstatisticaDeComparacoes(pontos.length);
            Par<Point2D,Point2D> par =executar(comparacoes, pontos);
            comparacoes.parar();
            System.out.println("E este o Par = "+par);
            comparacoes.apresentar();
            return comparacoes;
        }catch (IllegalArgumentException exeption){
            System.err.println(exeption.getMessage()+ "\n");
            return null;
        }
    }



}
