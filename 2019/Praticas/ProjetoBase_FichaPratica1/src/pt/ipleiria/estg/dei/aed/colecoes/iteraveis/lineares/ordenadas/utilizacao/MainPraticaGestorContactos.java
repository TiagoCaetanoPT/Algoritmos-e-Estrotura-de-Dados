package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.utilizacao;

import pt.ipleiria.estg.dei.aed.modelo.contactos.Contacto;
import pt.ipleiria.estg.dei.aed.modelo.Data;
import pt.ipleiria.estg.dei.aed.modelo.contactos.GestorContactos;

public class MainPraticaGestorContactos {

    public MainPraticaGestorContactos() {

        Contacto[] contactosOriginais = new Contacto[] {
                new Contacto("Ana", "Silva", 950000000, "Rua de Leiria", new Data(1, 10, 1990)),
                new Contacto("Ana", "Rita", 990000000, "Travessa 25 de Abril", new Data(15, 6, 2000)),
                new Contacto("Hugo", "Santos", 971234567, "Avenida 1º de Maio", new Data(18, 3, 1994)),
                new Contacto("Teresa", "Silva", 950000001, "Rua de Leiria", new Data(2, 10, 1990)),
                new Contacto("Eça", "Queiroz", 100000000, "Praça do Almada", new Data(25, 11, 1845)),
                new Contacto("Ana", "Queiroz", 100000000, "Praça do Almada", new Data(15, 6, 2000)),
                new Contacto("Teresa", "Santos", 100050000, "Praça do Almada", new Data(18, 3, 1994)),
                new Contacto("Teresa", "Santos", 100100000, "Rua de Leiria", new Data(18, 3, 1994)),
        };

        for (Contacto contacto : contactosOriginais) {
            GestorContactos.INSTANCIA.inserir(contacto);
        }

        Data data1 = new Data(18, 3, 1994);
        System.out.println("Contactos da data: " + data1);
        for (Contacto contacto : GestorContactos.INSTANCIA.consultar(data1)) {
            System.out.println(contacto);
        }

        Data data2 = new Data(15, 6, 2000);
        System.out.println("Contactos entre a data: " + data1 + " e a data: " + data2);
        for (Contacto contacto : GestorContactos.INSTANCIA.consultar(data1, data2)) {
            System.out.println(contacto);
        }

        Data data3 = new Data(10, 1, 2000);
        System.out.println("Contactos da data: " + data3);
        for (Contacto contacto : GestorContactos.INSTANCIA.consultar(data3)) {
            System.out.println(contacto);
        }

        Data data4 = new Data(11, 2, 2000);
        System.out.println("Contactos entre a data: " + data3 + " e a data: " + data4);
        for (Contacto contacto : GestorContactos.INSTANCIA.consultar(data3, data4)) {
            System.out.println(contacto);
        }

        Data data5 = new Data(25, 11, 1845);
        System.out.println("Contactos entre a data: " + data5 + " e a data: " + data2);
        for (Contacto contacto : GestorContactos.INSTANCIA.consultar(data5, data2)) {
            System.out.println(contacto);
        }

        GestorContactos.INSTANCIA.remover(data1);
        System.out.println("Contactos da data: " + data1);
        for (Contacto contacto : GestorContactos.INSTANCIA.consultar(data1)) {
            System.out.println(contacto);
        }

        Contacto contactoARemover = contactosOriginais[1];
        System.out.println("Contactos da data: " + contactoARemover.getDataNascimento());
        for (Contacto contacto : GestorContactos.INSTANCIA.consultar(contactoARemover.getDataNascimento())) {
            System.out.println(contacto);
        }

        GestorContactos.INSTANCIA.remover(contactoARemover);
        System.out.println("Contactos da data: " + contactoARemover.getDataNascimento() + " após remoção do " + contactoARemover);
        for (Contacto contacto : GestorContactos.INSTANCIA.consultar(contactoARemover.getDataNascimento())) {
            System.out.println(contacto);
        }
    }

    public static void main(String[] args) {
        new MainPraticaGestorContactos();
    }
}
