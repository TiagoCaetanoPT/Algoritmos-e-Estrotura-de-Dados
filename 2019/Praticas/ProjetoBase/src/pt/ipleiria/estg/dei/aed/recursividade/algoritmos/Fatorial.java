package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeChamadas;
/**
 * Celso Reis notes**
 * Esta classe calcula o fatorial e faz uma estatistica sobre os tempos de
 * execução e número de chamadas feitas pelo programa
 * Temos aqui tambem uma excepcao (try and catch)
 * Sendo o "n" o numero do fatorial a calcular e "resultado" o numero do fatorial já calculado
 */

public class Fatorial {

    public double executar(EstatisticaDeChamadas estatistica, int n) {
       estatistica.incrementarChamadas();
        if (n < 0){
            throw new IllegalArgumentException("Fatorial ("+ n
                    + ") = Argumento inválido, deve ser >= 0" );
        }
        // n >= 0
        if (n < 2){
            return 1;
        }
        return n * executar(estatistica, n - 1);
    }

    public EstatisticaDeChamadas getEstistica(int n){
        try {
            EstatisticaDeChamadas estatistica = new EstatisticaDeChamadas(n); //criação da VAR estatisticas e é igualada ao numero do fatorial
            double resultado = executar(estatistica, n);
            estatistica.parar(); //sem a linha parar o resultado temos o resultado dos milisegundos a negativo
            System.out.println("Fatorial(" + n + ") = "+ resultado);
            estatistica.apresentar(); //metodo que apresenta a estatistica
            return estatistica;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
            return null;
        }

    }
}
