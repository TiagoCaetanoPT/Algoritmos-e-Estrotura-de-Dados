private long executarRecursivo(EstatisticaDeIteracoes estatistica, Par indicesInicialEFinal, int[] elementos, int esq, int dir) {
    estatistica.incrementarIteracoes();
    if (esq == dir) {
        indicesInicialEFinal.setPrimeiro(esq);
        indicesInicialEFinal.setSegundo(dir);
        return elementos[esq] > 0 ? elementos[esq] : 0;
    }

    int meio = (esq + dir) / 2;
    Par indicesInicialEFinalEsq = new Par<>(0, 0);
    Par indicesInicialEFinalDir = new Par<>(0, 0);
    long somaMaximaEsq = executarRecursivo(estatistica, indicesInicialEFinalEsq, elementos, esq, meio);
    long somaMaximaDir = executarRecursivo(estatistica, indicesInicialEFinalDir, elementos, meio + 1, dir);
    long somaMaximaMeioEsq = 0, somaAtualMeioEsq = 0;
    int inicioEsqDir =  meio + 1;
    for (int i = meio; i >= esq; i--) {
        somaAtualMeioEsq += elementos[i];
        if (somaAtualMeioEsq > somaMaximaMeioEsq) {
            inicioEsqDir = i;
            somaMaximaMeioEsq = somaAtualMeioEsq;
        }
        estatistica.incrementarIteracoes();
    }

    long somaMaximaMeioDir = 0, somaAtualMeioDir = 0;
    int fimEsqDir =  meio;
    for (int i = meio + 1; i <= dir; i++) {
        somaAtualMeioDir += elementos[i];
        if (somaAtualMeioDir > somaMaximaMeioDir) {
            fimEsqDir = i;
            somaMaximaMeioDir = somaAtualMeioDir;
        }
        estatistica.incrementarIteracoes();
    }

    long somaMaximaEsqDir = somaMaximaMeioEsq + somaMaximaMeioDir;
    if (somaMaximaEsq >= somaMaximaDir && somaMaximaEsq >= somaMaximaEsqDir) {
        indicesInicialEFinal.setPrimeiro(indicesInicialEFinalEsq.getPrimeiro());
        indicesInicialEFinal.setSegundo(indicesInicialEFinalEsq.getSegundo());
        return somaMaximaEsq;
    }
    if (somaMaximaDir >= somaMaximaEsqDir) {
        indicesInicialEFinal.setPrimeiro(indicesInicialEFinalDir.getPrimeiro());
        indicesInicialEFinal.setSegundo(indicesInicialEFinalDir.getSegundo());
        return somaMaximaDir;
    }
    indicesInicialEFinal.setPrimeiro(inicioEsqDir);
    indicesInicialEFinal.setSegundo(fimEsqDir);
    return somaMaximaEsqDir;
}