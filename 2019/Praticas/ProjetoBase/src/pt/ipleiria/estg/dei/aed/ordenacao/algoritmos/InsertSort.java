package pt.ipleiria.estg.dei.aed.ordenacao.algoritmos;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoesETrocas;

public class InsertSort<T> extends AlgoritmoOrdenacao<T> {

    public InsertSort(Comparacao<T> criterio) {
        super(criterio);
    }

    @Override
    public void ordenar(EstatisticaDeComparacoesETrocas estatistica, T... elementos) {
        for (int i = 1; i < elementos.length; i++) {
            T atualpos = elementos[i];
            //for (int j = i - 1; j <= 0 ; j--) {
            int j = i - 1;
            do {
                estatistica.incrementarComparacoes();
                if (criterio.comparar(atualpos, elementos[j]) > 0) {
                    elementos[j + 1] = elementos[j];

                } else {
                    break;
                }
            } while (--j >= 0);
            elementos[j + 1] = atualpos;
            estatistica.incrementarTrocas();

        }
    }
}
//}
