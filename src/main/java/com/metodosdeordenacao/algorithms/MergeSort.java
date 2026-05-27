package com.metodosdeordenacao.algorithms;

import com.metodosdeordenacao.SortAlgorithm;

public class MergeSort extends SortAlgorithm {
  @Override
  public void reorder(int[] array) {
    int[] aux = new int[array.length];
    divide(array, aux, 0, array.length - 1);
  }

  @Override
  public String getName() {
    return "Merge Sort";
  }

  private static void divide(int[] a, int[] aux, int low, int high) {
    if (low >= high)
      return;
    int middle = (low + high) / 2;
    divide(a, aux, low, middle);
    divide(a, aux, middle + 1, high);
    conquer(a, aux, low, middle, high);
  }

  private static void conquer(int[] a, int[] aux, int low, int middle, int high) {
    for (int k = low; k <= high; k++) {
      aux[k] = a[k];
    }
    int i = low, j = middle + 1;
    for (int k = low; k <= high; k++) {
      if (i > middle)
        a[k] = aux[j++];
      else if (j > high)
        a[k] = aux[i++];
      else if (aux[j] < aux[i])
        a[k] = aux[j++];
      else
        a[k] = aux[i++];
    }
  }
}
