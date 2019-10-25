package pt.ipleiria.estg.dei.aed.ordenacao.utilizacao;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Contacto;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoPorContactosPorUltimoNomeAscendenteSeguidoPorDataNascimentoDescendente;
import pt.ipleiria.estg.dei.aed.modelo.contactos.io.ContactosIO;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.AlgoritmoOrdenacao;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.InsertionSort;
import pt.ipleiria.estg.dei.aed.utils.IOUtils;

import java.io.File;
import java.util.Arrays;

public class MainPraticaComparacaoDeAlgoritmos {
    public MainPraticaComparacaoDeAlgoritmos() {
        File ficheiro = IOUtils.escolherFicheiroAbrir();
        System.out.println("A ler o ficheiro " + ficheiro.getAbsolutePath());
        Contacto[] contactosOriginais = ContactosIO.lerContactos(ficheiro);
        System.out.println("Lidos " + contactosOriginais.length + " contactos.");

        Comparacao<Contacto> comparacao = ComparacaoPorContactosPorUltimoNomeAscendenteSeguidoPorDataNascimentoDescendente.CRITERIO;
        AlgoritmoOrdenacao<Contacto> insertionSort = new InsertionSort<>(comparacao);
        insertionSort.getEstatistica(Arrays.copyOf(contactosOriginais, 10));
    }

    public static void main(String[] args) {
        new MainPraticaComparacaoDeAlgoritmos();
    }
}
