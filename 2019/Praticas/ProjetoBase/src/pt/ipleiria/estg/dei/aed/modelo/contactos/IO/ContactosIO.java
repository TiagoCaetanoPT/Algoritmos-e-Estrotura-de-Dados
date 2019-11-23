package pt.ipleiria.estg.dei.aed.modelo.contactos.IO;

import pt.ipleiria.estg.dei.aed.modelo.Data;
import pt.ipleiria.estg.dei.aed.modelo.contactos.contacto;

import java.io.*;
import java.util.InvalidPropertiesFormatException;

public class ContactosIO {
    public static contacto[] lercontactos(File ficheiro){
        try {
            BufferedReader br = new BufferedReader(new FileReader(ficheiro));
            String primeiraLinha = br.readLine();
            int numeroContactos = Integer.valueOf(primeiraLinha);
            contacto[] contactos = new contacto[numeroContactos];
            String linha = null;
            int nc = 0;
            while ((linha = br.readLine()) != null){
                String[] partes = linha.split(",");
                if(partes.length != 5){
                    throw new InvalidPropertiesFormatException("Contacto Inválido");
                }
                contactos[nc++] = new contacto(partes[0], partes[1], Long.valueOf(partes[2]), partes[3], Data.valueOf(partes[4]));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return new contacto[0];
    }
}
