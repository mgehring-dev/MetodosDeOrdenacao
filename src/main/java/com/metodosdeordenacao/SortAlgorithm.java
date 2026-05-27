package com.metodosdeordenacao;

public abstract class SortAlgorithm {
  public abstract String getName();

  public abstract void reorder(int[] array);

  protected SortResult sort(int[] array) {
    int[] arrayCopy = array.clone();

    try {
      long start = System.nanoTime();
      reorder(arrayCopy);
      long elapsed = System.nanoTime() - start;

      return new SortResult(elapsed, arrayCopy);
    } catch (StackOverflowError e) {
      return new SortResult(0, arrayCopy, "StackOverflowError");
    }
  }

  protected static void exchange(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
}