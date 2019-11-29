package pt.ipleiria.estg.dei.aed.modelo.contactos;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaCircularBaseLimiteOrdenadaDistinta;
import pt.ipleiria.estg.dei.aed.modelo.Data;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoLimiteGestorContactosDataNascimentoPorDataAscendente;

public enum GestorContactos {
    INSTANCIA;

    private ListaDuplaCircularBaseLimiteOrdenadaDistinta<GestorContactosDataNascimento> contactosPorDataNascimento;

    GestorContactos(){
        contactosPorDataNascimento = new ListaDuplaCircularBaseLimiteOrdenadaDistinta<>(ComparacaoLimiteGestorContactosDataNascimentoPorDataAscendente.CRITERIO);
    }

    public void inserir(Contacto contacto) {
    }

}
