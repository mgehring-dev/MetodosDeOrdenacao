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

  // @Override
  // public SortResult sort(int[] array) {
  // int[] arrayCopy = array.clone();

  // long start = System.nanoTime();

  // boolean isSorted = false;
  // while (!isSorted) {

  // isSorted = true;
  // for (int i = 0; i < arrayCopy.length - 1; i++) {
  // int current = arrayCopy[i];
  // int next = arrayCopy[i + 1];

  // if (current > next) {
  // exchange(arrayCopy, i, i + 1);
  // isSorted = false;
  // }
  // }
  // }
  // long elapsed = System.nanoTime() - start;

  // return new SortResult(elapsed, arrayCopy);
  // }
}
