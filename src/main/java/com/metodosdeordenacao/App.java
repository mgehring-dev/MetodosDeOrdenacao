package com.metodosdeordenacao;

import java.io.IOException;
import java.nio.file.Path;

import com.metodosdeordenacao.algorithms.BubbleSort;
import com.metodosdeordenacao.algorithms.HeapSort;
import com.metodosdeordenacao.algorithms.InsertionSort;
import com.metodosdeordenacao.algorithms.MergeSort;
import com.metodosdeordenacao.algorithms.QuickSort;
import com.metodosdeordenacao.algorithms.SelectionSort;
import com.metodosdeordenacao.algorithms.ShellSort;

public class App {

    private static final int[] TAMANHOS = { 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536 };

    public static void main(String[] args) {

        int[] a = { 1, 3, 5, 7, 4 };
        int[] a2 = { 7, 6, 5, 4, 3, 2, 1 };
        int[] a3 = { 7, 2, 8, 5, 4, 55, 33, 11 };

        BubbleSort bubble = new BubbleSort();
        var b1 = bubble.sort(a).array();
        var b2 = bubble.sort(a2).array();
        var b3 = bubble.sort(a3).array();

        InsertionSort insertion = new InsertionSort();
        var i5 = insertion.sort(a).array();
        var i6 = insertion.sort(a2).array();
        var i3 = insertion.sort(a3).array();

        SelectionSort selection = new SelectionSort();
        var s7 = selection.sort(a).array();
        var s8 = selection.sort(a2).array();
        var s9 = selection.sort(a3).array();

        HeapSort heap = new HeapSort();
        var h2 = heap.sort(a).array();
        var h4 = heap.sort(a2).array();
        var h6 = heap.sort(a3).array();

        ShellSort shell = new ShellSort();
        var sh1 = shell.sort(a).array();
        var sh2 = shell.sort(a2).array();
        var sh3 = shell.sort(a3).array();

        MergeSort merge = new MergeSort();
        var m1 = merge.sort(a).array();
        var m2 = merge.sort(a2).array();
        var m3 = merge.sort(a3).array();

        QuickSort quick = new QuickSort();
        var q1 = quick.sort(a).array();
        var q2 = quick.sort(a2).array();
        var q3 = quick.sort(a3).array();

        int fim;
        fim = 1;

    }
}
