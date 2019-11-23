package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.estruturas;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravel;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.ColecaoIteravelLinearNaoOrdenada;


public class ListaDuplaNãoOrdenada<T> implements ColecaoIteravelLinearNaoOrdenada<T> {
    protected No noInicial;
    protected No noFinal;
    protected int numElementos;


    @Override
    public void inserirNoInicio(T elem) {
        if (++numElementos == 1){
            noInicial = noFinal = new No(elem);
        }
        else {
            noInicial = new No(elem, true);
        }

    }

    @Override
    public void inserirNoFim(T elem) {
        noFinal = new No(elem);
        if (++numElementos == 1){
            noInicial = noFinal;
        }
    }

    @Override
    public void inserir(int indice, T elem) {

    }

    @Override
    public T removerDoInicio() {
        return null;
    }

    @Override
    public T removerDoFim() {
        return null;
    }

    @Override
    public T remover(T elem) {
        return null;
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
        return null;
    }

    @Override
    public boolean contem(T elem) {
        return false;
    }

    @Override
    public boolean contemReferencia(T elem) {
        return false;
    }

    @Override
    public IteradorIteravel<T> iterador() {
        return null;
    }

    @Override
    public int getNumeroElementos() {
        return 0;
    }

    protected class No{
        protected T elemento;
        protected No seguinte;
        protected No anterior;

        //Criação de no FInal e coloca -se no final
        protected No(T elem) {
            elemento = elem; //operação 2
            seguinte = null; // operaçao 3
            anterior = noFinal; //operação 4
        }
        //Criacção do no e colocação no Inicio (não null)
        protected  No(T elem, boolean estupido){
            elemento = elem;
            seguinte = noInicial;
            anterior = null;
            noInicial.anterior = this;

        }

    }
}
