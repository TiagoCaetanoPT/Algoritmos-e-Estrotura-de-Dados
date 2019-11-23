package pt.ipleiria.estg.dei.aed.pesquisa.algoritmos;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoes;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class PesquisaTernariaRecursiva<T> extends AlgoritmoPesquisa<T> {

    public PesquisaTernariaRecursiva(Comparacao<T> criterio) {
        super(criterio);
    }

    public int pesquisar(EstatisticaDeComparacoes estatistica, T elemento, T... elementos) {
        int indiceUltimoElemento = elementos.length - 1;
        if (elementos.length == 0 ||
                criterio.comparar(elemento, elementos[0]) < 0 ||
                criterio.comparar(elemento, elementos[indiceUltimoElemento]) > 0) {
            return NAO_ENCONTRADO;
        }
        return pesquisarRecursivo(estatistica, elemento, 0, indiceUltimoElemento, elementos);
    }

    public int pesquisarRecursivo(EstatisticaDeComparacoes estatistica, T elemento, int esq, int dir, T... elementos) {
        if (esq > dir) {
            return NAO_ENCONTRADO;
        }
        int terço = (dir - esq) / 3;
        int iPT = esq + terço;
        int cp = criterio.comparar(elemento, elementos[iPT]);
        estatistica.incrementarComparacoes();

        if (cp < 0) {
            return pesquisarRecursivo(estatistica, elemento, esq, iPT - 1, elementos);
        }
        estatistica.incrementarComparacoes();
        if (cp > 0) {
            int iST = dir - terço;
            cp = criterio.comparar(elemento, elementos[iST]);
            estatistica.incrementarComparacoes();

            if (cp < 0) {
                return pesquisarRecursivo(estatistica, elemento, iPT + 1, iST - 1, elementos);
            }
            estatistica.incrementarComparacoes();
            if (cp > 0) {
                return pesquisarRecursivo(estatistica, elemento, iST + 1, dir, elementos);
            }
            //senao é uma ou outra devolve o iST
            return iST;
        }
        return iPT;
    }

}
