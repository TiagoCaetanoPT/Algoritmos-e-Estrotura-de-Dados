package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas;

import pt.ipleiria.estg.dei.aed.ComparacaoLimite;

public class ListaDuplaCircularBaseLimiteOrdenadaDistinta<T> extends ListaDuplaCircularBaseLimiteOrdenada<T> {

    public ListaDuplaCircularBaseLimiteOrdenadaDistinta(ComparacaoLimite<T> cpl) {
        super(cpl);
    }

    @Override
    public void inserir(T elem) {
        No no = getNo(elem);
        if (criterio.comparar(no.elemento, elem) == 0){
            throw new IllegalArgumentException("Elemento Duplicado");
        }
        new No(elem, no);
        numeroElementos++;
    }

    public T consultarDistinto(T elem){
        No no = getNo(elem);
        /*if (criterio.comparar(no.elemento, elem) == 0){
            return no.elemento;
        }
        return null;*/
        return criterio.comparar(no.elemento, elem) == 0 ? no.elemento: null;
    }
}
