package pt.ipleiria.estg.dei.aed.pesquisa.utilizacao;

import pt.ipleiria.estg.dei.aed.ComparacaoInteiros;
import pt.ipleiria.estg.dei.aed.analisecomplexidade.utilizacao.MainPraticaPontosMaisProximos;
import pt.ipleiria.estg.dei.aed.pesquisa.algoritmos.AlgoritmoPesquisa;
import pt.ipleiria.estg.dei.aed.pesquisa.algoritmos.PesquisaTernariaIterativa;
import pt.ipleiria.estg.dei.aed.pesquisa.algoritmos.PesquisaTernariaRecursiva;

import java.util.Random;

public class MainPraticaPesquisaTernaria {

    public MainPraticaPesquisaTernaria() {
        Random random = new Random(1);
        AlgoritmoPesquisa<Integer> pesquisaTernariaRecursiva = new PesquisaTernariaRecursiva<>(ComparacaoInteiros.CRITERIO);
        AlgoritmoPesquisa<Integer> pesquisaTernariaIterativa = new PesquisaTernariaIterativa<>(ComparacaoInteiros.CRITERIO);
        Integer[] vetor = new Integer[20];

        for (int i = 0, j=-10; i < 20; i++,j++) {
            vetor[i]=j;
        }

        int elemento= random.nextInt(21)-10;
        pesquisaTernariaRecursiva.getEstatistica(elemento,vetor);
        pesquisaTernariaIterativa.getEstatistica(elemento,vetor);


    }

    public static void main(String[] args) {
        new MainPraticaPesquisaTernaria();
    }
}
