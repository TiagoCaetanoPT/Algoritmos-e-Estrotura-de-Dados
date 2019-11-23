package pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoes;

import java.util.Arrays;

public class Maximo {

    public int executar(EstatisticaDeComparacoes comparacoes, int ... valores) {

        if(valores.length==0){
            throw new IllegalArgumentException("tem de conter pelo menos 1 valor.");
        }

        int indiceMaximo = 0;

        for (int i = 1; i < valores.length; i++) {
            comparacoes.incrementarComparacoes();
            if (valores[i] > valores[indiceMaximo]) {
                indiceMaximo=i;
            }
        }

        return valores[indiceMaximo];
    }

    public EstatisticaDeComparacoes getEstatisticas(int... valores){
        try{
            EstatisticaDeComparacoes comparacoes =new EstatisticaDeComparacoes(valores.length);
            int maximo= executar(comparacoes, valores);
            comparacoes.parar();
            System.out.println("máximo("+ Arrays.toString(valores)+")= "+maximo);
            comparacoes.apresentar();
            return comparacoes;
        }catch (IllegalArgumentException exeption){
            System.err.println(exeption.getMessage()+ "\n");
            return null;
        }
    }

}
