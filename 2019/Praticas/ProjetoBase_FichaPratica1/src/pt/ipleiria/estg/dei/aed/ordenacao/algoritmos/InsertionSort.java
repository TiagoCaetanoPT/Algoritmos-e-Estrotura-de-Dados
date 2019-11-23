package pt.ipleiria.estg.dei.aed.ordenacao.algoritmos;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoesETrocas;

public class InsertionSort<T> extends AlgoritmoOrdenacao<T> {

    public InsertionSort(Comparacao<T> criterio) {
        super(criterio);
    }

    @Override
    public void ordenar(EstatisticaDeComparacoesETrocas estatistica, T... elementos) {

        for (int i = 1; i < elementos.length ; i++) {
            T pivot=elementos[i];
            int anteriores=i-1;
            do {
                estatistica.incrementarComparacoes();
                if(criterio.comparar(pivot,elementos[anteriores])<0){
                    estatistica.incrementarTrocas();
                    elementos[anteriores+1]=elementos[anteriores];
                    anteriores--;
                }else{
                    break;
                }
            }while (anteriores>=0);
            elementos[anteriores+1]=pivot;
        }
    }
}
