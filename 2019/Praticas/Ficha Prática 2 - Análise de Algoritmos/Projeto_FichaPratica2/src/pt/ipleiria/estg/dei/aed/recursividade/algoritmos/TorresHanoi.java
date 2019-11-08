package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeChamadas;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeChamadasEMovimentos;

public class TorresHanoi {
    public void executar(EstatisticaDeChamadasEMovimentos estatistica, int nDiscos, Torre torreOrigem, Torre torreAuxiliar, Torre torreDestino, boolean mostrarMovimentos) {
        estatistica.incrementarChamadas();
        if (nDiscos < 1) {
            throw new IllegalArgumentException("Torres Hanoi(" + nDiscos + ") = argumento inválido: deve ser >= 1");
        }
        // Caso Base
        if (nDiscos == 1) {
            estatistica.incrementarMovimentos();
            //retirar de uma torre e colocar na outra
            torreDestino.colocarDisco(torreOrigem.tirarDisco());
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
            //criar 3 torres
            Torre torreOrigem = new Torre("Origem", nDiscos);
            Torre torreAuxiliar = new Torre("Auxiliar", nDiscos);
            Torre torreDestino = new Torre("Destino", nDiscos);

            //preencher torre de origem
            torreOrigem.preencherComDiscos();

            EstatisticaDeChamadasEMovimentos estatistica = new EstatisticaDeChamadasEMovimentos(nDiscos);
            executar(estatistica, nDiscos, torreOrigem, torreAuxiliar, torreDestino, false);
            //executar(estatistica, nDiscos, 'A', 'B', 'C', false);
            estatistica.parar();
            estatistica.apresentar();
            return estatistica;
        } catch (RuntimeException exception) {
            System.err.println(exception.getMessage() + "\n");
            return null;
        }
    }
}
