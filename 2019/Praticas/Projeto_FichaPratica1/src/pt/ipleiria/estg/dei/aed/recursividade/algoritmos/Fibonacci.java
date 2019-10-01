package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeChamadas;

public class Fibonacci {
    public int executar(EstatisticaDeChamadas estatistica, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Fibonacci(" + n + ") = argumento inválido: deve ser >= 0");
        }
        if (n < 2) {
            return n;
        }
        return executar(estatistica, n-2) + executar(estatistica,n-1);
    }


    public EstatisticaDeChamadas getEstatistica(int n) {
        try {
            EstatisticaDeChamadas estatistica = new EstatisticaDeChamadas(n);
            double resultado = executar(estatistica, n);
            estatistica.parar();
            System.out.println("Fibonacci(" + n + ") = " + resultado);
            estatistica.apresentar();
            return estatistica;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage() + "\n");
            return null;
        }
    }



}
