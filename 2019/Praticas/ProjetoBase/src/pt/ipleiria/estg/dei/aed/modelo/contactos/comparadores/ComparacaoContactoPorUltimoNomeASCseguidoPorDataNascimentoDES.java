package pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.modelo.contactos.contacto;

public enum ComparacaoContactoPorUltimoNomeASCseguidoPorDataNascimentoDES implements Comparacao<contacto> {
    CRITERIO;

    @Override
    //neste caso queremos comparar o ultimo
    //compareTO para comparar string
    // ver dois tipos de comparacao strings
    public int comparar(contacto o1, contacto o2) {
        int comparar = o2.getUltimoNome().compareTo(o1.getUltimoNome());
        //if(o2.getUltimoNome().compareTo(o1.getUltimoNome()))
        //return 0;
        if( comparar != 0){
            return comparar;
            //fazemos sempre asc mas se for preciso Des adicionamos o "-"
        }
        return -o1.getDataNascimento().comparar(o2.getDataNascimento());
    }
}
