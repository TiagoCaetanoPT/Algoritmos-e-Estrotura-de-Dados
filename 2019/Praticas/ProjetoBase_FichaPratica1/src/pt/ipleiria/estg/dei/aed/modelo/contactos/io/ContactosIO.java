package pt.ipleiria.estg.dei.aed.modelo.contactos.io;

import pt.ipleiria.estg.dei.aed.modelo.Data;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Contacto;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.InsertionSort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;

public class ContactosIO {
        public static Contacto[] lerContactos(File ficheiro){
            try (BufferedReader br = new BufferedReader(new FileReader(ficheiro))){
                String primeiraLinha = br.readLine().trim();
                int numTotalContactos = Integer.valueOf(primeiraLinha);
                Contacto[] contactos = new Contacto[numTotalContactos];
                String linha = null;
                int numContactos = 0;

                while ((linha = br.readLine())!= null){
                    String[] partes = linha.split(",");
                    if(partes.length!=5){
                        throw new InvalidPropertiesFormatException("Contacto Inválido");
                    }
                    contactos[numContactos++]= new Contacto(partes[0],partes[1],Long.valueOf(partes[2]),partes[3], Data.parseData(partes[4]));
                }
                //

            }catch (IOException exeption){
                exeption.printStackTrace();
            }
            return new Contacto[0];
        }
}
