package pt.ipleiria.estg.dei.aed.ordenacao.utilizacao;

import pt.ipleiria.estg.dei.aed.ComparacaoInteiros;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.InsertionSort;
import pt.ipleiria.estg.dei.aed.utils.VetorDeInteiros;

public class MainPraticaInsertionSort {
    public MainPraticaInsertionSort() {
        InsertionSort<Integer> insertionSort = new InsertionSort(ComparacaoInteiros.CRITERIO);

        insertionSort.getEstatistica(VetorDeInteiros.criarAleatorioInteger(10, -10, 10, false)); // seed a false para que os valores aleatorios sejam sempre os mesmos
    }

    public static void main(String[] args) {
        new MainPraticaInsertionSort();
    }
}
