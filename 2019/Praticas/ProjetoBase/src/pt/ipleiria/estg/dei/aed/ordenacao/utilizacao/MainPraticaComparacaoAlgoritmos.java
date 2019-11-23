package pt.ipleiria.estg.dei.aed.ordenacao.utilizacao;

import pt.ipleiria.estg.dei.aed.modelo.contactos.IO.ContactosIO;
import pt.ipleiria.estg.dei.aed.modelo.contactos.contacto;
import pt.ipleiria.estg.dei.aed.utils.IOUtils;

import java.io.File;

public class MainPraticaComparacaoAlgoritmos {

    public MainPraticaComparacaoAlgoritmos(){
        File ficheiro = IOUtils.escolherFicheiroAbrir();
        if (ficheiro == null) {
            return;
        }

        System.out.printf("A ler ficheiro" + ficheiro.getAbsolutePath());
        contacto[] contactosOriginais = ContactosIO.lercontactos(ficheiro);
        System.out.printf("Lidos "+ contactosOriginais.length + " contactos");
    }


    public static void main(String[] args) {
        new MainTeoricaComparacaoAlgoritmosOrdenacao();
    }
}
