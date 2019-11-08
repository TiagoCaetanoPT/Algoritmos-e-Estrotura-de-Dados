package pt.ipleiria.estg.dei.aed.ordenacao.algoritmos;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoesETrocas;


public class InsertionSort<T> extends AlgoritmoOrdenacao<T> {


    public InsertionSort(Comparacao<T> criterio) {
        super(criterio);
    }

    @Override
    public void ordenar(EstatisticaDeComparacoesETrocas estatistica, T... elementos) {

        for (int i = 1; i < elementos.length; i++) {
            T atual = elementos[i];
            int j = i - 1;

            do {
                if (criterio.comparar(elementos[i], elementos[j]) < 0) {
                    elementos[j + 1] = elementos[j];
                    j--;
                } else {
                    break;
                }
            } while (j >= 0);
            elementos[j + 1] = atual;
        }

    }
}
