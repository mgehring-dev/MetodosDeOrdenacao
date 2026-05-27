package com.metodosdeordenacao.algorithms;

import com.metodosdeordenacao.SortAlgorithm;

public class HeapSort extends SortAlgorithm {

  @Override
  public String getName() {
    return "Heap Sort";
  }

  @Override
  public void reorder(int[] array) {
    buildMaxHeap(array);
    heapSort(array);

  }

  private static void buildMaxHeap(int[] a) {
    for (int i = a.length / 2 - 1; i >= 0; i--) {
      maxHeapify(a, i, a.length);
    }
  }

  private static void maxHeapify(int[] a, int i, int n) {
    int max = 2 * i + 1;
    if (max + 1 < n && a[max] < a[max + 1]) {
      max++;
    }
    if (max < n && a[max] > a[i]) {
      exchange(a, i, max);
      maxHeapify(a, max, n);
    }
  }

  public static void heapSort(int[] a) {
    buildMaxHeap(a);
    for (int i = a.length - 1; i > 0; i--) {
      exchange(a, 0, i);
      maxHeapify(a, 0, i);
    }
  }
}
