package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;

public class Fibonacci {
    public int executar(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Fibonacci(" + n + ") = argumento inválido: deve ser >= 0");
        }
        if (n < 2) {
            return n;
        }
        return executar(n-2) + executar(n-1);
    }
}
