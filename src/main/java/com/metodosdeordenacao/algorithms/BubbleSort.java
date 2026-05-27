package com.metodosdeordenacao.algorithms;

import com.metodosdeordenacao.SortAlgorithm;

public class BubbleSort extends SortAlgorithm {

  @Override
  public String getName() {
    return "Bubble Sort";
  }

  @Override
  public void reorder(int[] array) {
    boolean isSorted = false;
    while (!isSorted) {

      isSorted = true;
      for (int i = 0; i < array.length - 1; i++) {
        int current = array[i];
        int next = array[i + 1];

        if (current > next) {
          exchange(array, i, i + 1);
          isSorted = false;
        }
      }
    }
  }
}
