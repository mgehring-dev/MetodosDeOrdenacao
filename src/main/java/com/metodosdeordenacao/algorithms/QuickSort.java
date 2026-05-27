package com.metodosdeordenacao.algorithms;

import com.metodosdeordenacao.SortAlgorithm;

public class QuickSort extends SortAlgorithm {
  @Override
  public String getName() {
    return "Quick Sort";
  }

  @Override
  public void reorder(int[] array) {
    sort(array, 0, array.length - 1);
  }

  private static void sort(int[] a, int low,
      int high) {
    if (low >= high)
      return;
    int p = partition(a, low, high);
    sort(a, low, p - 1);
    sort(a, p + 1, high);
  }

  private static int partition(int[] a, int low, int high) {
    int pivot = a[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
      if (a[j] <= pivot) {
        exchange(a, ++i, j);
      }
    }
    exchange(a, i + 1, high);
    return i + 1;
  }

}
