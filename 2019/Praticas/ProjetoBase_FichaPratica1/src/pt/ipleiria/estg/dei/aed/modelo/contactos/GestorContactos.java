package pt.ipleiria.estg.dei.aed.modelo.contactos;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravelDuplo;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaNaoOrdenada;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaCircularBaseLimiteOrdenadaDistinta;
import pt.ipleiria.estg.dei.aed.modelo.Data;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoLimiteGestorContactosDataNascimentoPorDataAscendente;

public enum GestorContactos {
    INSTANCIA;

    private static final IteradorIteravelDuplo<Contacto> ITERADOR_DUPLO_COLECAO_VAZIA_CONTACTOS = new ListaDuplaNaoOrdenada<Contacto>().iterador();
    private ListaDuplaCircularBaseLimiteOrdenadaDistinta<GestorContactosDataNascimento> contactosPorDataNascimento;

    GestorContactos(){
        contactosPorDataNascimento = new ListaDuplaCircularBaseLimiteOrdenadaDistinta<>(ComparacaoLimiteGestorContactosDataNascimentoPorDataAscendente.CRITERIO);
    }

    // inserir um contacto
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

    //remover um contacto
    public Contacto remover(Contacto contacto){
        GestorContactosDataNascimento contactosNaDataNascimento = contactosPorDataNascimento.consultarDistinto(new GestorContactosDataNascimento(contacto.getDataNascimento()));
        if (contactosNaDataNascimento == null){
            return null; // não há contactos para esta data
        }

        Contacto contactoRemovido = contactosNaDataNascimento.remover(contacto);
        if (contactosNaDataNascimento.isVazia()){
            contactosPorDataNascimento.remover(contactosNaDataNascimento);
        }
        return contactoRemovido;
    }

    //remover todos os contactos de uma dada data de nascimento
    public IteradorIteravelDuplo<Contacto> remover(Data dataNascimento){
        GestorContactosDataNascimento contactosNaDataNascimento = contactosPorDataNascimento.remover(new GestorContactosDataNascimento(dataNascimento));
        return contactosNaDataNascimento == null ? ITERADOR_DUPLO_COLECAO_VAZIA_CONTACTOS : contactosNaDataNascimento.iterador();
    }

    //consultar todos os contactos de uma dada data
    public IteradorIteravelDuplo<Contacto> consultar(Data dataNascimento) {
        GestorContactosDataNascimento contactosNaDataNascimento = contactosPorDataNascimento.consultarDistinto(new GestorContactosDataNascimento(dataNascimento));
        return contactosNaDataNascimento == null ? ITERADOR_DUPLO_COLECAO_VAZIA_CONTACTOS : contactosNaDataNascimento.iterador();
    }

    //consultar todos os contactos entre duas datas
    public IteradorIteravelDuplo<Contacto> consultar(Data dataNascimentoInicio, Data dataNascimentoFim) {
        return new Iterador(dataNascimentoInicio, dataNascimentoFim);
    }

    private class Iterador implements IteradorIteravelDuplo<Contacto> {
        protected IteradorIteravelDuplo<GestorContactosDataNascimento> iteradorGestoresContactoDataNascimento;
        protected IteradorIteravelDuplo<Contacto> iteradorContactos;

        public Iterador(Data dataNascimentoInicio, Data dataNascimentoFim) {
            iteradorGestoresContactoDataNascimento = contactosPorDataNascimento.consultar(new GestorContactosDataNascimento(dataNascimentoInicio), new GestorContactosDataNascimento(dataNascimentoFim));
            reiniciar();
        }

        @Override
        public void reiniciar() {
            iteradorGestoresContactoDataNascimento.reiniciar();
            iteradorContactos = ITERADOR_DUPLO_COLECAO_VAZIA_CONTACTOS;
        }

        @Override
        public Contacto corrente() {
            return iteradorContactos.corrente();
        }

        @Override
        public boolean podeAvancar() {
            return iteradorContactos.podeAvancar() || iteradorGestoresContactoDataNascimento.podeAvancar();
        }

        @Override
        public Contacto avancar() {
            if (!iteradorContactos.podeAvancar()) {
                iteradorContactos = iteradorGestoresContactoDataNascimento.avancar().iterador();
            }
            return iteradorContactos.avancar();
        }

        @Override
        public boolean podeRecuar() {
            return iteradorContactos.podeRecuar() || iteradorGestoresContactoDataNascimento.podeRecuar();
        }

        @Override
        public Contacto recuar() {
            if (!iteradorContactos.podeRecuar()) {
                iteradorContactos = iteradorGestoresContactoDataNascimento.recuar().iterador();
            }
            return iteradorContactos.recuar();
        }
    }
}