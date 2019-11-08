package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeChamadas;

public class Hanoi {

    public class Hanoi {
        private void executar(EstatisticaDeChamadas estatistica, int numeroDiscos){
            estatistica.incrementarChamadas();
            if(numeroDiscos < 0){
                throw new IllegalArgumentException("fatorial(" + numeroDiscos + ") = argumento inválido: deve ser > ou = 0");
            }
            if(numeroDiscos < 2){
                return 1;
            }
            return numeroDiscos * executar(estatistica,numeroDiscos-1);
        }

        public EstatisticaDeChamadas getEstatistica(int n){
            try{
                EstatisticaDeChamadas estatistica = new EstatisticaDeChamadas(n);
                double resultado = executar(estatistica, n);
                estatistica.parar();

                System.out.println("fatorial(" + n + ") = " + resultado);
                estatistica.apresentar();
                return estatistica;

            }catch (IllegalArgumentException exception){
                System.err.println(exception.getMessage() + "\n");
                return null;
            }
        }
    }



}
