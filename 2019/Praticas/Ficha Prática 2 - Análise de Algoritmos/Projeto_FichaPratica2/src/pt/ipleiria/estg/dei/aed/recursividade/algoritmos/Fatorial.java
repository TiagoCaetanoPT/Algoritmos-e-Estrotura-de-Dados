package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeChamadas;

public class Fatorial {
    public double executar(EstatisticaDeChamadas estatistica, int n) {
        estatistica.incrementarChamadas();
        if (n < 0) {
            throw new IllegalArgumentException("fatorial(" + n + ") = argumento inválido: deve ser >= 0");
        }
        if (n < 2) {
            return 1;
        }
        return n * executar(estatistica, n - 1);
    }

    public EstatisticaDeChamadas getEstatistica(int n) {
        try {
            EstatisticaDeChamadas estatistica = new EstatisticaDeChamadas(n);
            double resultado = executar(estatistica, n);
            estatistica.parar();
            System.out.println("fatorial(" + n + ") = " + resultado);
            estatistica.apresentar();
            return estatistica;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage() + "\n");
            return null;
        }
    }
}
