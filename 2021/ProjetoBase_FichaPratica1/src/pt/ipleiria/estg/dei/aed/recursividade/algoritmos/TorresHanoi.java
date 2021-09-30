package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeChamadasEMovimentos;

public class TorresHanoi {
    public void executar(EstatisticaDeChamadasEMovimentos estatistica, int nDiscos, char torreOrigem, char torreAuxiliar, char torreDestino, boolean mostrarMovimentos) {
        estatistica.incrementarChamadas();
        if (nDiscos < 1) {
            throw new IllegalArgumentException("Torres Hanoi(" + nDiscos + ") = argumento inválido: deve ser >= 1");
        }
        // Caso Base
        if (nDiscos == 1) {
            estatistica.incrementarMovimentos();
            if (mostrarMovimentos) {
                System.out.println("Disco movido de " + torreOrigem + " para " + torreDestino);
            }
            return;
        }
        executar(estatistica, nDiscos - 1, torreOrigem, torreDestino, torreAuxiliar, mostrarMovimentos);
        executar(estatistica, 1, torreOrigem, torreAuxiliar, torreDestino, mostrarMovimentos);
        executar(estatistica, nDiscos - 1, torreAuxiliar, torreOrigem, torreDestino, mostrarMovimentos);
    }


    public EstatisticaDeChamadasEMovimentos getEstatistica(int nDiscos) {
        try {
            EstatisticaDeChamadasEMovimentos estatistica = new EstatisticaDeChamadasEMovimentos(nDiscos);
            executar(estatistica, nDiscos, 'A', 'B', 'C', false);
            estatistica.parar();
            estatistica.apresentar();
            return estatistica;
        } catch (IllegalArgumentException exception) {
            System.err.println(exception.getMessage() + "\n");
            return null;
        }
    }
}