package com.metodosdeordenacao;

public record SortResult(long tempoNs, int[] array, String erro) {

    public SortResult(long tempoNs, int[] array) {
        this(tempoNs, array, null);
    }

    public boolean hasErro() {
        return erro != null;
    }
}
