package pt.ipleiria.estg.dei.aed.modelo.contactos.io;

import pt.ipleiria.estg.dei.aed.modelo.Data;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Contacto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;

public class ContactosIO {
    public static Contacto[] lerContactos(File ficheiro) {
        try (BufferedReader bufferedReader = new BufferedReader((new FileReader(ficheiro)))) {
            String primeiraLinha = bufferedReader.readLine().trim(); //trim para remover possiveis espaços existentes
            int numTotalContactos = Integer.valueOf(primeiraLinha); //para converter a primeira linha num numero
            Contacto[] contactos = new Contacto[numTotalContactos];
            String linha = null;
            int numContactos = 0;
            while ((linha = bufferedReader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length != 5) { //contacto no ficheiro com formato invalido
                    throw new InvalidPropertiesFormatException("Contacto Inválido!");
                }
                contactos[numContactos++] = new Contacto(partes[0], partes[1], Long.valueOf(partes[2]), partes[3], Data.parseData(partes[4]));
            }
            // verificar numero de contactos lido
            if (numTotalContactos != numContactos) {
                throw new InvalidPropertiesFormatException("Numero de contactos incorretos!");
            }
            return contactos;
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return new Contacto[0];
    }
}
