package com.metodosdeordenacao.algorithms;

import com.metodosdeordenacao.SortAlgorithm;
import com.metodosdeordenacao.SortResult;

public class SelectionSort extends SortAlgorithm {

  @Override
  public String getName() {
    return "Selection Sort";
  }

  @Override
  public int[] reorder(int[] array) {
    int[] arrayCopy = array.clone();

    for (int min, i = 0; i < arrayCopy.length; i++) {
      min = i;
      for (int j = i + 1; j < arrayCopy.length; j++) {
        if (arrayCopy[j] < arrayCopy[min]) {
          min = j;
        }
      }
      exchange(arrayCopy, min, i);
    }

    return arrayCopy;
  }

  // @Override
  // public SortResult sort(int[] array) {
  //   int[] arrayCopy = array.clone();

  //   long start = System.nanoTime();
  //   for (int min, i = 0; i < arrayCopy.length; i++) {
  //     min = i;
  //     for (int j = i + 1; j < arrayCopy.length; j++) {
  //       if (arrayCopy[j] < arrayCopy[min]) {
  //         min = j;
  //       }
  //     }
  //     exchange(arrayCopy, min, i);
  //   }
  //   long elapsed = System.nanoTime() - start;

  //   return new SortResult(elapsed, arrayCopy);
  // }
}
