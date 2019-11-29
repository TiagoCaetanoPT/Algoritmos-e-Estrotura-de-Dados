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
        Data dataNascimento = contacto.getDataNascimento();

        GestorContactosDataNascimento contactosDataNascimento = new GestorContactosDataNascimento(dataNascimento);

        //procurar na lista contactosPorDataNascimento o gestor com esta data
        GestorContactosDataNascimento contactosNaDataNascimento = contactosPorDataNascimento.consultarDistinto(contactosDataNascimento);

        if(contactosNaDataNascimento == null){
            contactosNaDataNascimento = contactosDataNascimento;
            contactosPorDataNascimento.inserir(contactosNaDataNascimento);
        }

        //inserir contacto no gestor daquela data
        contactosNaDataNascimento.inserir(contacto);
    }

}
