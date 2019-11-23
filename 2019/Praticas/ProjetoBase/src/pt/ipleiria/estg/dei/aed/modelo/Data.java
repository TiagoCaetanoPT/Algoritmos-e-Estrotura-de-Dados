package pt.ipleiria.estg.dei.aed.modelo;

import java.util.InvalidPropertiesFormatException;

public class Data {
    private int dia; //CTRl + D
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {  //ALT + INSERT atalho
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public static Data valueOf(String data) throws InvalidPropertiesFormatException {
        String[] partes = data.split("/");
        if (partes.length != 3) {
            throw new InvalidPropertiesFormatException("Data invalida");
        }
        return new Data(Integer.valueOf(partes[0]), Integer.valueOf(partes[1]), Integer.valueOf(partes[2]));
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public int comparar(Data data){
        int cp = Integer.compare(ano, data.getAno());

        if(cp !=0){
            return cp;
        }

        cp = Integer.compare(mes, data.getMes());
        if(cp !=0){
            return cp;
            //caso fosse necessario des era dar return do "cp" com um menos antes
        }
        return Integer.compare(dia , data.ano);
    }

    @Override
    public String toString() {
        return "Data{" + "dia = " +dia + ", mes = " + mes + ", ano =" + ano + "}";
    }
}
//nos comparadores o mais importante é o ASC e DES