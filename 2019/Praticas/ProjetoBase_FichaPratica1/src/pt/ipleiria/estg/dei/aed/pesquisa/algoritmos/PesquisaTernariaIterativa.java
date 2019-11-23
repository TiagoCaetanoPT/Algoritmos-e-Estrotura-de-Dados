package pt.ipleiria.estg.dei.aed.pesquisa.algoritmos;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoes;

public class PesquisaTernariaIterativa<T> extends AlgoritmoPesquisa<T> {

    public PesquisaTernariaIterativa(Comparacao<T> criterio) {
        super(criterio);
    }

    @Override
    public int pesquisar(EstatisticaDeComparacoes estatistica, T elemento, T... elementos) {
        int indiceUltimoElemento = elementos.length - 1;
        if (elementos.length == 0 || criterio.comparar(elemento, elementos[0]) < 0 || criterio.comparar(elemento, elementos[indiceUltimoElemento]) > 0) {
            return NAO_ENCONTRADO;
        }

        int esq= 0;
        int dir=indiceUltimoElemento;



        while(esq<=dir){
            int terco = (dir-esq)/3;
            int terco1 = esq + terco;
            int cp = criterio.comparar(elemento,elementos[terco1]);
            estatistica.incrementarComparacoes();
            if(cp==0){
                return terco1;
            }

            estatistica.incrementarComparacoes();
            if(cp<0){
                dir=terco1-1;
                continue;
            }


            int terco2 = terco1 + terco;
            cp = criterio.comparar(elemento,elementos[terco2]);

            estatistica.incrementarComparacoes();
            if(cp==0){
                return terco2;
            }

            estatistica.incrementarComparacoes();
            if (cp<0){
                esq=terco1+1;
                dir=terco2-1;
                continue;
            }
            esq=terco2+1;
        }

        return NAO_ENCONTRADO;
    }


}
