package com.metodosdeordenacao.algorithms;

import com.metodosdeordenacao.SortAlgorithm;

public class InsertionSort extends SortAlgorithm {

  @Override
  public String getName() {
    return "Insertion Sort";
  }

  @Override
  public void reorder(int[] array) {
    for (int i = 1; i < array.length; i++) {
      for (int j = i; j > 0 && array[j - 1] > array[j]; j--) {
        exchange(array, j - 1, j);
      }
    }
  }
}
