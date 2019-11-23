package pt.ipleiria.estg.dei.aed.ordenacao.utilizacao;

import org.w3c.dom.CDATASection;
import pt.ipleiria.estg.dei.aed.modelo.Data;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoContactoPorUltimoNomeASCseguidoPorDataNascimentoDES;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoContactosPorNumeroTelefoneDES;
import pt.ipleiria.estg.dei.aed.modelo.contactos.contacto;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.InsertSort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainPraticaOrdenacaoContactos {
    public MainPraticaOrdenacaoContactos() { //ATL + INSERT
        contacto[] contactosOriginais = new contacto[]{
                    new contacto("Ana", "Silva", 950000000, "Rua de Leiria", new Data(1, 10, 1990)),
                    new contacto("Ana", "Rita", 990000000, "Travessa 25 de Abril", new Data(15, 6, 2000)),
                    new contacto("Hugo", "Santos", 971234567, "Avenida 1º de Maio", new Data(18, 3, 1994)),
                    new contacto("Teresa", "Silva", 950000001, "Rua de Leiria", new Data(2, 10, 1990)),
                    new contacto("Eça", "Queiroz", 100000000, "Praça do Almada", new Data(25, 11, 1845))

        };
        contacto[] copia1 = contactosOriginais.clone();
        contacto[] copia2 = Arrays.copyOf(contactosOriginais, contactosOriginais.length);

    new InsertSort<>(ComparacaoContactosPorNumeroTelefoneDES.CRITERIO).getEstatistica(copia1);

    new InsertSort<>(ComparacaoContactoPorUltimoNomeASCseguidoPorDataNascimentoDES.CRITERIO).getEstatistica(copia2);
   //mete um no insertion sort
    }

    public static void main(String[] args) { //psv atalho
        new MainPraticaOrdenacaoContactos();
    }
}