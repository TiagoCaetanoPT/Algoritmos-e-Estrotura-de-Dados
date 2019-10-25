package pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.modelo.Data;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Contacto;

public enum ComparacaoPorContactosPorUltimoNomeAscendenteSeguidoPorDataNascimentoDescendente implements Comparacao<Contacto> {
    CRITERIO;

    @Override
    public int comparar(Contacto o1, Contacto o2) {
        int comparacao = o1.getUltimoNome().compareTo(o2.getUltimoNome()); //vai guardar o resultado da comparacao dos nomes

        if (comparacao != 0) { //se os nomes forem diferentes devolve logo o resultado da comparação
            return comparacao;
        }
        return -o1.getDataNascimento().comparar(o2.getDataNascimento());// caso os nomes sejam igual tem que comparar pela data
        // com o sinal "-" no inicio para inverter a ordem (porque queremos descendente)
    }
}

