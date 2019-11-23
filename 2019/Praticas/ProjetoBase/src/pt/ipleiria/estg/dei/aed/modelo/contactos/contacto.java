package pt.ipleiria.estg.dei.aed.modelo.contactos;

import pt.ipleiria.estg.dei.aed.modelo.Data;

public class contacto {
    private String primeiroNome;
    private String ultimoNome;
    private long numeroTelefone;
    private Data dataNascimento;
    private String morada;

    public contacto(String primeiroNome, String ultimoNome, long numeroTelefone, String morada, Data dataNascimento) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.numeroTelefone = numeroTelefone;
        this.dataNascimento = dataNascimento;
        this.morada = morada;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public long getNumeroTelefone() {
        return numeroTelefone;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public String getMorada() {
        return morada;
    }

    @Override
    public String toString() {
        return primeiroNome + " " + ultimoNome + "Nº " + numeroTelefone + " - " + dataNascimento + " - " + morada;
    }
}
