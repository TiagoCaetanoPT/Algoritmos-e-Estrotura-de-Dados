package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.estruturas;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravel;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravelDuplo;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.ColecaoIteravelLinearNaoOrdenada;

import java.io.Serializable;
import java.util.NoSuchElementException;

public class ListaDuplaNaoOrdenada<T> implements ColecaoIteravelLinearNaoOrdenada<T> {

    private static final long serialVersionUID = 1L;
    //ajuda da professora;
    protected No noInicial;
    protected No noFinal;
    protected int numeroElementos;

    protected class No implements Serializable{
        private static final long serialVersionUID = 1L;

        protected T elemento;
        protected No anterior;
        protected No seguinte;

        //criar um nó após o noFinal
        protected No(T elem){
            elemento = elem;

            //como é apos o final, no seguinte não tem nada
            seguinte = null;
            anterior = noFinal;
        }

        //criar um nó antes o nó seguinte
        protected No(T elem, No seg){
            elemento = elem;
            seguinte = seg;
            anterior = seg.anterior;
            seg.anterior = this;
            if(anterior != null){
                anterior.seguinte = this;
            }
        }
    }

    //construtor da lista
    public ListaDuplaNaoOrdenada(){
        numeroElementos = 0;
        noInicial = null;
        noFinal = null;
    }

    @Override
    public void inserirNoInicio(T elem) {
        if(++numeroElementos == 1){
            noInicial = new No(elem);
            noFinal = noInicial;
        }else {
            noInicial = new No(elem, noInicial);
        }
    }

    @Override
    public void inserirNoFim(T elem) {
        noFinal = new No(elem);
        if(++numeroElementos == 1){
            //Lista vazia
            noInicial = noFinal;
        }else {
            (noFinal.anterior).seguinte = noFinal;
        }
    }

    //efetuar os métodos de pesquisa de pesquisa
    private No getNo(int indice){
        if(indice < 0 || indice >= numeroElementos){
            throw new IndexOutOfBoundsException();
        }
        No atual;
        if (indice < numeroElementos/2){
            //está na 1ª metade dos elementos
            atual = noInicial;
            while (indice-- > 0){
                atual = atual.seguinte;
            }
        }else{
            //está na 2ª metade dos elementos
            atual = noFinal;
            while (++indice < numeroElementos){
                atual = atual.anterior;
            }
        }
        return atual;
    }

    protected No getNo(T elem){
        No atual = noInicial;
        while (atual != null && !atual.elemento.equals(elem)){
            atual = atual.seguinte;
        }
        return atual;
    }

    protected No getNoPorReferencia(T elem){
        No atual = noInicial;
        while (atual != null && atual.elemento != elem){
            atual = atual.seguinte;
        }
        return atual;
    }


    @Override
    public void inserir(int indice, T elem) {
        if(indice == 0){
            inserirNoInicio(elem);
        } else if(indice == numeroElementos){
            inserirNoInicio(elem);
        }else{
            new No(elem, getNo(indice));
            numeroElementos++;
        }
    }

    @Override
    public T removerDoInicio() {
        if(numeroElementos == 0){
            return null;
        }
        No aux = noInicial;
        noInicial = noInicial.seguinte;
        if (--numeroElementos == 0) {
            noFinal = null;
        } else {
            noInicial.anterior = null;
        }
        return aux.elemento;
    }

    @Override
    public T removerDoFim() {
        if(numeroElementos == 0){
            return null;
        }
        No aux = noFinal;
        noFinal = noFinal.anterior;
        if (--numeroElementos == 0) {
            noInicial = null;
        } else {
            noFinal.seguinte = null;
        }
        return aux.elemento;
    }

    @Override
    public T remover(T elem) {
        if (numeroElementos == 0) {
            return null;
        }
        if (noInicial.elemento.equals(elem)) {
            return removerDoInicio();
        }
        if (noFinal.elemento.equals(elem)){
            return removerDoFim();
        }
        No aux = getNo(elem);
        return aux != null ? removerNo(aux).elemento : null ;
    }

    private No removerNo(No NoParaRemover){
        NoParaRemover.anterior.seguinte = NoParaRemover.seguinte;
        NoParaRemover.seguinte.anterior = NoParaRemover.anterior;
        numeroElementos--;
        return NoParaRemover;
    }

    @Override
    public T remover(int indice) {
        return null;
    }

    @Override
    public T removerPorReferencia(T elem) {
        return null;
    }

    @Override
    public T consultar(int indice) {
        return getNo(indice).elemento;
    }

    @Override
    public boolean contem(T elem) {
        return getNo(elem) != null;
    }

    @Override
    public boolean contemReferencia(T elem) {
        return getNoPorReferencia(elem) != null;
    }

    @Override
    public IteradorIteravelDuplo<T> iterador() {
        return new Interador();
    }

    @Override
    public int getNumeroElementos() {
        return 0;
    }

    private class Iterador implements IteradorIteravelDuplo<T> {
        protected No atual;
        protected No anterior;
        protected No proximo;

        public Iterador(){
            reiniciar();
        }

        @Override
        public void reiniciar() {
            atual = null;
            proximo = noInicial;
            anterior = noFinal;
        }

        @Override
        public T corrente() {
            if (atual == null) {
                throw new NoSuchElementException();
            }
            return atual.elemento;
        }

        @Override
        public boolean podeAvancar() {
            return proximo != null;
        }

        @Override
        public T avancar() {
            if (!podeAvancar()){
                throw new NoSuchElementException();
            }
            anterior = atual;
            atual = proximo;
            proximo = proximo.seguinte;
            return atual.elemento;
        }

        @Override
        public boolean podeRecuar() {
            return false;
        }

        @Override
        public T recuar() {
            return null;
        }
    }
}
