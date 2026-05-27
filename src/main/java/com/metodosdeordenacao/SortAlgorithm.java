package com.metodosdeordenacao;

public abstract class SortAlgorithm {
  public abstract String getName();

  public abstract int[] reorder(int[] array);

  // public abstract SortResult sort(int[] array);
  protected SortResult sort(int[] array) {
    int[] arrayCopy = array.clone();

    long start = System.nanoTime();
    arrayCopy = reorder(arrayCopy);
    long elapsed = System.nanoTime() - start;

    return new SortResult(elapsed, arrayCopy);
  }

  protected static void exchange(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
}