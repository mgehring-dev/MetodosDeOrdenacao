package com.metodosdeordenacao;

import java.util.Random;

public class SortUtils {
    public static int[] gerarCrescente(int tamanho) {
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    public static int[] gerarDecrescente(int tamanho) {
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = tamanho - i;
        }
        return array;
    }

    public static int[] gerarAleatorio(int tamanho) {
        Random random = new Random(42);
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = random.nextInt(tamanho);
        }
        return array;
    }
}
