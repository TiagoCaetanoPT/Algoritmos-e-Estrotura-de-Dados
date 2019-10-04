package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;

public class TorresHanoi {
    public int executar(int nDiscos){
        if (nDiscos < 0) {
            throw new IllegalArgumentException("Torres Hanoi(" + nDiscos + ") = argumento inválido: deve ser >= 0");
        }
        if(nDiscos < 2){
            return 1;
        }
        return nDiscos * executar(nDiscos-1);
    }

}
