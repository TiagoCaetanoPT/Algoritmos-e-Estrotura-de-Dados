package pt.ipleiria.estg.dei.aed.pesquisa.algoritmos;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoes;

import java.sql.SQLOutput;

public class PesquisaTernariaRecursiva<T> extends AlgoritmoPesquisa <T>{

    public PesquisaTernariaRecursiva(Comparacao<T> criterio) {
        super(criterio);
    }
    @Override
    public int pesquisar(EstatisticaDeComparacoes estatistica, T elemento, T... elementos) {
        int indiceUltimoElemento=elementos.length-1;
        if(elementos.length==0 || criterio.comparar(elemento,elementos[0])<0 || criterio.comparar(elemento,elementos[indiceUltimoElemento])>0){
            return NAO_ENCONTRADO;
        }
        return pesquisarRecursivo(estatistica, elemento,0 , indiceUltimoElemento, elementos);
    }

    private int pesquisarRecursivo(EstatisticaDeComparacoes estatistica, T elemento, int esq, int dir, T... elementos) {
        if (esq>dir){
            return NAO_ENCONTRADO;
        }

        int terco = (dir-esq)/3;
        int terco1 = esq + terco;
        int cp=criterio.comparar(elemento, elementos[terco1]);
        estatistica.incrementarComparacoes();
        if(cp == 0){
            return terco1;
        }
        estatistica.incrementarComparacoes();
        if(cp<0){
            return pesquisarRecursivo(estatistica,elemento,esq,terco1-1,elementos);
        }

        int terco2 = terco1 + terco;
        cp=criterio.comparar(elemento,elementos[terco2]);
        estatistica.incrementarComparacoes();
        if(cp==0){
            return terco2;
        }
        estatistica.incrementarComparacoes();
        if(cp<0){
            return pesquisarRecursivo(estatistica,elemento,terco1+1,terco2-1,elementos);
        }

        return pesquisarRecursivo(estatistica, elemento, terco2+1, dir, elementos);
    }


}
