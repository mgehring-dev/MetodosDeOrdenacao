package com.metodosdeordenacao.algorithms;

import com.metodosdeordenacao.SortAlgorithm;

public class SelectionSort extends SortAlgorithm {

  @Override
  public String getName() {
    return "Selection Sort";
  }

  @Override
  public void reorder(int[] array) {
    for (int min, i = 0; i < array.length; i++) {
      min = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[min]) {
          min = j;
        }
      }
      exchange(array, min, i);
    }
  }
}
