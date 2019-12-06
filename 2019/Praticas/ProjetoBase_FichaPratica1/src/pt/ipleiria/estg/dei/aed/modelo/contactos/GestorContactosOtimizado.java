package pt.ipleiria.estg.dei.aed.modelo.contactos;

import pt.ipleiria.estg.dei.aed.ComparacaoLimite;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.associativas.estruturas.TabelaHashPorSondagem;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.associativas.estruturas.TabelaHashPorSondagemComIncrementoQuadratico;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaCircularBaseLimiteOrdenadaDistinta;
import pt.ipleiria.estg.dei.aed.modelo.Data;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoLimiteDatasAscendente;

public enum GestorContactosOtimizado {
    INSTANCIA;

    private ListaDuplaCircularBaseLimiteOrdenadaDistinta<Data> datasNascimento;
    private TabelaHashPorSondagem<Data, GestorContactosDataNascimento> contactosPorDataNascimento;

    GestorContactosOtimizado(){
        datasNascimento = new ListaDuplaCircularBaseLimiteOrdenadaDistinta<>(ComparacaoLimiteDatasAscendente.CRITERIO);
        contactosPorDataNascimento = new TabelaHashPorSondagemComIncrementoQuadratico<>(100);
    }
}
