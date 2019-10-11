package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;

public class Torre {
    private String nome;
    private int numDiscos;
    private int[] discos;

    public Torre(String nome, int maximoDiscos) {
        this.nome = nome;
        numDiscos = 0;
        discos = new int[maximoDiscos + 1];
        discos[0] = maximoDiscos * 3;
    }

    //preencher com discos
    public void PreencherComDiscos() {
        for (int i = 1; i < discos.length; i++) {
            discos[i] = discos.length - i;
        }
        numDiscos = discos.length - 1;
    }
    
    //tirar disco
    //colocar disco
}
