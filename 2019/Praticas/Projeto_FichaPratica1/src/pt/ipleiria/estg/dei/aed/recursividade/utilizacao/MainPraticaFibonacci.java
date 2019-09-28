package pt.ipleiria.estg.dei.aed.recursividade.utilizacao;

import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.Fibonacci;

public class MainPraticaFibonacci {
    public MainPraticaFibonacci() {
        Fibonacci fibonacci = new Fibonacci();
        int[] numeros = {5, 0, -10, 40, 45};
        for (int n : numeros) {
            System.out.println(fibonacci.executar(n));
        }
    }


    public static void main(String[] args) {
        new MainPraticaFibonacci();
    }
}
