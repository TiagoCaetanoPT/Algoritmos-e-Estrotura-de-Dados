package pt.ipleiria.estg.dei.aed.ordenacao.utilizacao;

import pt.ipleiria.estg.dei.aed.modelo.Data;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Contacto;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoContactosPorNumeroTelefoneDescendente;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoPorContactosPorUltimoNomeAscendenteSeguidoPorDataNascimentoDescendente;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.AlgoritmoOrdenacao;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.InsertionSort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainPraticaOrdenacaoContactos {
    public MainPraticaOrdenacaoContactos() {
        Contacto[] contactosOriginais = new Contacto[]{
                new Contacto("Ana", "Silva", 950000000, "Rua de Leiria", new Data(1, 10, 1990)),
                new Contacto("Ana", "Rita", 990000000, "Travessa 25 de Abril", new Data(15, 06, 2000)),
                new Contacto("Hugo", "Santos", 971234567, "Avenida 1º de Maio", new Data(13, 03, 1994)),
                new Contacto("Teresa", "Silva", 950000001, "Rua de Leiria", new Data(02, 10, 1990)),
                new Contacto("Eça", "Queiroz", 100000000, "Praça do Almada ", new Data(25, 11, 1845)),
        };

        Contacto[] copia1 = Arrays.copyOf(contactosOriginais, 5);
        Contacto[] copia2 = Arrays.copyOf(contactosOriginais, 5);

        AlgoritmoOrdenacao<Contacto> algoritmoOrdenacao = new InsertionSort<>(ComparacaoContactosPorNumeroTelefoneDescendente.CRITERIO);
        InsertionSort<Contacto> insertionSort = new InsertionSort<>(ComparacaoPorContactosPorUltimoNomeAscendenteSeguidoPorDataNascimentoDescendente.CRITERIO);

        algoritmoOrdenacao.getEstatistica(copia1);
        insertionSort.getEstatistica(copia2);
    }

    public static void main(String[] args) {
        new MainPraticaOrdenacaoContactos();
    }
}
