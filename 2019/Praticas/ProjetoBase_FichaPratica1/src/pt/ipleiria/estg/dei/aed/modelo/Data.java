package pt.ipleiria.estg.dei.aed.modelo;

import java.sql.Struct;
import java.util.InvalidPropertiesFormatException;
import java.util.Objects;

public class Data {

    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public static Data parseData(String data) throws InvalidPropertiesFormatException {
            String[] partes = data.split("/");
            if (partes.length != 3){
                throw new InvalidPropertiesFormatException("Data inválida");
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

    @Override
    public String toString() {
        return  dia + "/" + mes + "/" + ano ;
    }

    public int comparar(Data data) {
        int comparacao = Integer.compare(this.ano, data.ano);

        if(comparacao!=0){
            return comparacao;
        }
        comparacao = Integer.compare(this.mes, data.mes);

        if(comparacao!=0){
            return comparacao;
        }

        return Integer.compare(this.dia, data.dia);
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o instanceof Data)){
            return false;
        }
        Data data = (Data) o;
        return dia == data.dia &&
                mes == data.mes &&
                ano == data.ano;
    }

    @Override
    public int hashCode(){
        return Objects.hash(dia, mes, ano);
    }

}
