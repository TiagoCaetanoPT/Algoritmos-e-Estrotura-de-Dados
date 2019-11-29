package pt.ipleiria.estg.dei.aed.modelo.contactos;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravelDuplo;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaCircularBaseLimiteOrdenada;
import pt.ipleiria.estg.dei.aed.modelo.Data;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoLimiteContactosPorPrimeiroNomeAscendenteSeguidoPorUltimoNomeAscendente;

import java.util.Objects;

public class GestorContactosDataNascimento {
    private Data dataNascimento;
    private ListaDuplaCircularBaseLimiteOrdenada<Contacto> contactos;

    public GestorContactosDataNascimento(Data dataNascimento){
        this.dataNascimento = dataNascimento;
        contactos = new ListaDuplaCircularBaseLimiteOrdenada<>(ComparacaoLimiteContactosPorPrimeiroNomeAscendenteSeguidoPorUltimoNomeAscendente.CRITERIO);
    }

    public void inserir(Contacto contacto){
        contactos.inserir(contacto);
    }

    public Contacto remover(Contacto contacto){
        return contactos.remover(contacto);
    }

    public boolean isVazia(){
        return contactos.isVazia();
    }

    public IteradorIteravelDuplo<Contacto> iterador(){
        return contactos.iterador();
    }

    public int comparar(GestorContactosDataNascimento gestorContactosDataNascimento){
        return dataNascimento.comparar(gestorContactosDataNascimento.dataNascimento);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GestorContactosDataNascimento)) return false;
        GestorContactosDataNascimento that = (GestorContactosDataNascimento) o;
        return Objects.equals(dataNascimento, that.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataNascimento);
    }
}
