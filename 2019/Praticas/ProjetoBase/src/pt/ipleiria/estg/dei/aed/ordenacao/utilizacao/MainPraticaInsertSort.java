package pt.ipleiria.estg.dei.aed.ordenacao.utilizacao;

import pt.ipleiria.estg.dei.aed.ComparacaoInteiros;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.InsertSort;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.SelectionSort;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class MainPraticaInsertSort {

    public MainPraticaInsertSort() {
        InsertSort<Integer> insertSort = new InsertSort<>(ComparacaoInteiros.CRITERIO);
        insertSort.getEstatistica(5, 2, 4, 6, 1, 3);
    }

    public static void main(String[] args) {
        new MainPraticaInsertSort();
    }
}
