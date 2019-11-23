package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeChamadas;

import java.sql.SQLOutput;

public class Fatorial {

   /* public long executar(int n, EstatisticaDeChamadas estatistica) {*/
   public double executar(int n, EstatisticaDeChamadas estatistica) {
        estatistica.incrementarChamadas();
        if(n<0) {
            throw new IllegalArgumentException("fatorial (" + n + ")= argumento inválido");
        }
        if(n<2){
            return 1;
        }
        return n*executar(n-1, estatistica);
    }

    public EstatisticaDeChamadas getEstatistica(int n){
        try{
            EstatisticaDeChamadas estatistica = new EstatisticaDeChamadas(n);
           /* long resultado = executar(n,estatistica);*/
            double resultado = executar(n,estatistica);
            estatistica.parar();
            System.out.println("fatorial (" + n + ") = " + resultado);
            estatistica.apresentar();
            return estatistica;
        }catch (IllegalArgumentException exception){
            /*System.out.println(exception.getMessage() + "\n");*/
            System.err.println(exception.getMessage() + "\n");
            return null;
        }


    }

}
