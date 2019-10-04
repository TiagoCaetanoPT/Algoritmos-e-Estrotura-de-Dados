package pt.ipleiria.estg.dei.aed.analisecomplexidade.utilizacao;

import pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos.Maximo;
import pt.ipleiria.estg.dei.aed.utils.VetorDeInteiros;

public class MainPraticaMaximo {
    public MainPraticaMaximo() {
        Maximo maximo = new Maximo();

        maximo.getEstatistica(VetorDeInteiros.criarAleatorioInt(5, -50, 50, true));
        maximo.getEstatistica(VetorDeInteiros.criarAleatorioInt(10, -50, 50, false));
    }


    public static void main(String[] args) {
        new MainPraticaMaximo();
    }
}
