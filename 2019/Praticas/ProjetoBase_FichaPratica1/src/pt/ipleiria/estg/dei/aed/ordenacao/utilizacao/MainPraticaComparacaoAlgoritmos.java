package pt.ipleiria.estg.dei.aed.ordenacao.utilizacao;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Contacto;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoContactosPorUltimoNomeAscendenteSeguidoPorDataNascimentoDescendente;
import pt.ipleiria.estg.dei.aed.modelo.contactos.io.ContactosIO;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.*;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.IOUtils;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//dizer ao duarte que foi criada uma nova class
//usamos o utils-IOutils
public class MainPraticaComparacaoAlgoritmos {

    public MainPraticaComparacaoAlgoritmos() {
        File ficheiro = IOUtils.escolherFicheiroAbrir();
        System.out.println(" A ler o Ficheiro " + ficheiro.getAbsolutePath());
        Contacto[] contactosOriginais = ContactosIO.lerContactos(ficheiro);

        System.out.println("lidos " + contactosOriginais.length + " contactos");

        Comparacao<Contacto> comparacao = ComparacaoContactosPorUltimoNomeAscendenteSeguidoPorDataNascimentoDescendente.CRITERIO;
        AlgoritmoOrdenacao<Contacto> algoritmo1 = new InsertionSort<>(comparacao);

        //depois fazer isto com um ciclo
        algoritmo1.getEstatistica(Arrays.copyOf(contactosOriginais, 50000));


        AlgoritmoOrdenacao<Contacto>[] algoritmos = new AlgoritmoOrdenacao[]{
                new SelectionSort(comparacao),
                new BubbleSortOtimizado(comparacao),
                new QuickSort(comparacao),
                new InsertionSort(comparacao) };

        VisualizadorEstatisticas visualizador = new VisualizadorEstatisticas();

        List<Estatistica> estatisticas;

        for (AlgoritmoOrdenacao<Contacto> algoritmo : algoritmos) {

            estatisticas = new ArrayList<>();

            for (int i = 10 ; i < 51; i++) {
                estatisticas.add(algoritmo.getEstatistica(Arrays.copyOf(contactosOriginais, i)));
            }

            visualizador.adicionarEstatisticas(algoritmo.getClass().getSimpleName(), estatisticas);
        }

        visualizador.visualizar();
    }

    public static void main(String[] args) {
        new MainPraticaComparacaoAlgoritmos();
    }
}
