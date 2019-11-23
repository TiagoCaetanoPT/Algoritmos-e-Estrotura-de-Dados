package pt.ipleiria.estg.dei.aed.recursividade.utilizacao;

import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.Fibonacci;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.ArrayList;
import java.util.List;

public class MainPraticaFibonacci {

    public MainPraticaFibonacci() {
        Fibonacci fibonacci= new Fibonacci();
        System.out.println(fibonacci.getEstatistica(5));
        System.out.println(fibonacci.getEstatistica(0));
        System.out.println(fibonacci.getEstatistica(-10));
        System.out.println(fibonacci.getEstatistica(40));
        System.out.println(fibonacci.getEstatistica(45));

    }
     public static void main(String[] args){
        new MainPraticaFibonacci();
     }

}
