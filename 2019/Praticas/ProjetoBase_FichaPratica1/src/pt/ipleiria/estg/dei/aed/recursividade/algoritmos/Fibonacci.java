package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeChamadas;

public class Fibonacci {
    public long executar(int n, EstatisticaDeChamadas estatistica){
        estatistica.incrementarChamadas();
        if(n<0){
            throw new IllegalArgumentException("fibonacci (" + n + ")= argumento inválido, tem de ser maior ou igual a zero");
        }
        if(n<2){
            return n;
        }
        return executar(n-2, estatistica)+executar(n-1, estatistica);
    }

    public EstatisticaDeChamadas getEstatistica(int n){
        try {
            EstatisticaDeChamadas estatistica = new EstatisticaDeChamadas(n);
            long resultado = executar(n,estatistica);
            estatistica.parar();
            System.out.println("fibonacci (" + n + ") = " + resultado);
            estatistica.apresentar();
            return estatistica;
        }catch (IllegalArgumentException exception){
            System.err.println(exception.getMessage() + "\n");
            return null;
        }
    }
}
