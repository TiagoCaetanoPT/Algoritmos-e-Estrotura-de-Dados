package pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Contacto;

public enum ComparacaoContactosPorUltimoNomeAscendenteSeguidoPorDataNascimentoDescendente implements Comparacao<Contacto> {
    CRITERIO;

    @Override
    public int comparar(Contacto o1, Contacto o2) {

        int comparacao = o1.getUltimoNome().compareTo(o2.getUltimoNome());

        if(comparacao!=0){
            return comparacao;
        }
        return -o1.getDataNascimento().comparar(o2.getDataNascimento());
    }
}
