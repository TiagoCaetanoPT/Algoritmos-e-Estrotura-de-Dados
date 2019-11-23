package pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.modelo.contactos.contacto;

//No nome tem que é DES mas sabemos que é não desc porque tem valores iguais
//

public enum ComparacaoContactosPorNumeroTelefoneDES implements Comparacao<contacto> {
    CRITERIO; //

    @Override
    public int comparar(contacto o1, contacto o2) {
        return -Long.compare(o1.getNumeroTelefone(), o2.getNumeroTelefone());
        //quando for tipos primitivos, é usado o compare() e antes o tipo do compare() metemos o tipo neste caso Long
        //Regra: sempre de forma ascendente o1 e depois o2
    }


}
