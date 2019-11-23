package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeChamadasEMovimentos;

public class JogoTorresHanoi {
        public void executar(EstatisticaDeChamadasEMovimentos estatistica, int nDiscos, Torre torreOrigem, Torre torreAuxiliar, Torre torreDestino, boolean mostrarMovimentos) {
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


        public EstatisticaDeChamadasEMovimentos getEstatistica(int numerodisco) {
            try {
                Torre torreOrigem = new Torre("Origem", numerodisco);
                Torre torreAuxiliar = new Torre("Auxiliar", numerodisco);
                Torre torreDestino = new Torre("Destino", numerodisco);
                //preencher torreOrigem com discos
                torreOrigem.preencherComDiscos();

                EstatisticaDeChamadasEMovimentos estatistica = new EstatisticaDeChamadasEMovimentos(numerodisco);
                //executar(estatistica, ndiscos, 'A', 'B', 'C', true);
                executar(estatistica, numerodisco, torreOrigem, torreAuxiliar, torreDestino, false);
                estatistica.parar();
                estatistica.apresentar();
                return estatistica;
            } //catch (IllegalArgumentException exception) {
            catch (RuntimeException exception) {
                System.err.println(exception.getMessage() + "\n");
                return null;
            }
        }
}
