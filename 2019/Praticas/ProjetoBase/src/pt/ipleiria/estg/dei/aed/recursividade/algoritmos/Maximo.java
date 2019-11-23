package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoes;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Maximo {

    //public double executar(EstatisticaDeComparacoes estatistica, int... valores){
      public int executar(EstatisticaDeComparacoes estatistica,  int... valores){
        estatistica.incrementarComparacoes();
        if (valores.length < 1){
            throw new IllegalArgumentException("maximo (" + Arrays.toString(valores) + ") = argumento invalido deve ter pelo menos 1 elemento");
        }
        int indiceMaximo = 0;
        for (int i = 1; i < valores.length; i++){
            estatistica.incrementarComparacoes();
            if(valores[i] > valores[indiceMaximo]){
                indiceMaximo = i;
            }
        }
        return valores[indiceMaximo];
    }

    public EstatisticaDeComparacoes getEstatistica(int... valores){
         EstatisticaDeComparacoes estatistica = new EstatisticaDeComparacoes(valores.length);
         double maximo = executar(estatistica, valores);
         estatistica.parar();
         System.out.println("maximo (" + Arrays.toString(valores) + ") = " + maximo);
         return estatistica;
      }

    }

