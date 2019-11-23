package pt.ipleiria.estg.dei.aed.ordenacao.utilizacao;

import pt.ipleiria.estg.dei.aed.ComparacaoInteiros;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.InsertionSort;
import pt.ipleiria.estg.dei.aed.utils.VetorDeInteiros;

public class MainPraticaInsertionSort {

    public MainPraticaInsertionSort() {
        InsertionSort<Integer> yeah= new InsertionSort<>(ComparacaoInteiros.CRITERIO);
        yeah.getEstatistica(VetorDeInteiros.criarAleatorioInteger(10,-10,10,false));
    }

    public static void main(String[] args) {
        new MainPraticaInsertionSort();
    }
}
