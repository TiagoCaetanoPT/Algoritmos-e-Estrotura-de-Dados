package pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores;

import pt.ipleiria.estg.dei.aed.ComparacaoLimite;
import pt.ipleiria.estg.dei.aed.modelo.Data;
import pt.ipleiria.estg.dei.aed.modelo.contactos.GestorContactosDataNascimento;

public enum ComparacaoLimiteGestorContactosDataNascimentoPorDataAscendente implements ComparacaoLimite<GestorContactosDataNascimento> {
    CRITERIO;

    private static final GestorContactosDataNascimento LIMITE = new GestorContactosDataNascimento(new Data(0,0,Integer.MAX_VALUE));

    @Override
    public GestorContactosDataNascimento getLimite(){
        return LIMITE;
    }

    @Override
    public int comparar(GestorContactosDataNascimento o1, GestorContactosDataNascimento o2) {
        return o1.comparar(o2);
    }
}
