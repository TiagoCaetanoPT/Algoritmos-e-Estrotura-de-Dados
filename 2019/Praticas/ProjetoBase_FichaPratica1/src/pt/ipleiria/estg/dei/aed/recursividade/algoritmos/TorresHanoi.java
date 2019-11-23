package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeChamadasEMovimentos;

public class TorresHanoi {

    //3,
    public void executar(EstatisticaDeChamadasEMovimentos estatistica, int n,/* char torreInicial, char torreAuxiliar, char torreFinal*/
            Torre torreInicial, Torre torreAuxiliar, Torre torreFinal, boolean mostrarMovimentos){

        estatistica.incrementarChamadas();

        if (n <= 0) {
            throw new IllegalArgumentException("Torres de Hanói(" + n + ") = argumento inválido, deve ser > 0");
        } else if (n == 1) {
            estatistica.incrementarMovimentos();
            torreFinal.colocarDisco(torreInicial.tirarDisco());
            if(mostrarMovimentos) {
                System.out.println(torreInicial + " -> " + torreFinal);
            }
            return;
        }

        executar(estatistica, n - 1, torreInicial, torreFinal, torreAuxiliar, mostrarMovimentos);
        executar(estatistica, 1, torreInicial, torreAuxiliar ,torreFinal, mostrarMovimentos);
        executar(estatistica, n - 1, torreAuxiliar, torreInicial, torreFinal, mostrarMovimentos);
    }

    public EstatisticaDeChamadasEMovimentos getEstatistica(int n){
        try {

            Torre torreA = new Torre("A", n);
            Torre torreB = new Torre("B", n);
            Torre torreC = new Torre("C", n);

            torreA.prencherDisco();

            EstatisticaDeChamadasEMovimentos estatistica = new EstatisticaDeChamadasEMovimentos(n);
            //System.out.println(executar(estatistica, n, torreInicial, torreAuxiliar, torreFinal));
            executar(estatistica, n, torreA, torreB, torreC, false);
            estatistica.parar();
            estatistica.apresentar();
            return estatistica;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()+"\n");
        }
        return null;
    }
}

