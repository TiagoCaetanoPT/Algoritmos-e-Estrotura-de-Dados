package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;

public class TorresHanoi {
    public void executar(int nDiscos, char torreOrigem, char torreAuxiliar, char torreDestino){
        if (nDiscos < 1) {
            throw new IllegalArgumentException("Torres Hanoi(" + nDiscos + ") = argumento inválido: deve ser >= 1");
        }
        // Caso Base
        if (nDiscos == 1) {
            System.out.println("Disco movido de " + torreOrigem + " para " + torreDestino);
            return;
        }

        executar(nDiscos-1, torreOrigem, torreDestino, torreAuxiliar);
        executar(1, torreOrigem, torreAuxiliar, torreDestino);
        executar(nDiscos-1, torreAuxiliar, torreOrigem, torreDestino);
    }

}
