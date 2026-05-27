package com.metodosdeordenacao.algorithms;

import com.metodosdeordenacao.SortAlgorithm;

public class ShellSort extends SortAlgorithm {

  @Override
  public void reorder(int[] array) {
    int h = 1;
    while (3 * h + 1 < array.length) {
      h = 3 * h + 1;
    }
    while (h > 0) {
      for (int i = h; i < array.length; i++) {
        for (int j = i; j >= h && array[j - h] > array[j]; j -= h) {
          exchange(array, j - h, j);
        }
      }
      h /= 3;
    }
  }

  @Override
  public String getName() {
    return "Shell Sort";
  }
}
