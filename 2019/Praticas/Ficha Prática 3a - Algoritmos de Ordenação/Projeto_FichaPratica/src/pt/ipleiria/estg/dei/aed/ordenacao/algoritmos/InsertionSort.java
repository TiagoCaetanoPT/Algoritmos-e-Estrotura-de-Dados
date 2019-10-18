package pt.ipleiria.estg.dei.aed.ordenacao.algoritmos;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoesETrocas;

public class InsertionSort<T> extends AlgoritmoOrdenacao<T> {

    public InsertionSort(Comparacao<T> criterio) {
        super(criterio);
    }

    @Override
    public void ordenar(EstatisticaDeComparacoesETrocas estatistica, T... elementos) {
        for (int i = 1; i < elementos.length; i++) { //precorrer a subsquencia não ordenada
            T aux = elementos[i]; // guardar elemento atual
            int j = i - 1;
            do {
                if (criterio.comparar(elementos[i], elementos[j]) >= 0) { //comparar aux com elementos[j]
                    break;
                }
                elementos[j+1] = elementos[j];
                j--;
            } while (j >= 0);
            //colocar o elemento atual na posicao a seguir à ultima posição verificada
            elementos[j+1] = aux;
        }
    }
}