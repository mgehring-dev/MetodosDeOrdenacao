package com.metodosdeordenacao.algorithms;

import com.metodosdeordenacao.SortAlgorithm;

public class InsertionSort extends SortAlgorithm {

  @Override
  public String getName() {
    return "Insertion Sort";
  }

  @Override
  public int[] reorder(int[] array) {
    int[] arrayCopy = array.clone();

    for (int i = 1; i < arrayCopy.length; i++) {
      for (int j = i; j > 0 && arrayCopy[j - 1] > arrayCopy[j]; j--) {
        exchange(arrayCopy, j - 1, j);
      }
    }

    return arrayCopy;
  }
}
