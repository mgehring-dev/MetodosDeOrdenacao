package com.metodosdeordenacao;

import java.io.IOException;
import java.nio.file.Path;

import com.metodosdeordenacao.algorithms.BubbleSort; 

public class App {

    private static final int[] TAMANHOS = { 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536 };

    public static void main(String[] args) throws IOException {

        BubbleSort alg = new BubbleSort();
        int[] a = { 7, 2, 8, 5, 4 };
        var reordered = alg.sort(a);
        

        // System.out.println("=== Métodos de Ordenação ===\n");

        // SortAlgorithm[] algoritmos = {
        // new BubbleSort(),
        // new InsertionSort(),
        // new SelectionSort()
        // };

        // ResultWriter writer = new ResultWriter();

        // String[] cenarios = {
        // "Ordenado crescente (sem repetição)",
        // "Ordenado decrescente (sem repetição)",
        // "Aleatório"
        // };

        // for (int tamanho : TAMANHOS) {
        // int[][] arrays = {
        // SortUtils.gerarCrescente(tamanho),
        // SortUtils.gerarDecrescente(tamanho),
        // SortUtils.gerarAleatorio(tamanho)
        // };

        // for (int c = 0; c < cenarios.length; c++) {
        // for (SortAlgorithm alg : algoritmos) {
        // SortResult result = alg.sort(arrays[c]);

        // System.out.println(
        // alg.getName() + " (" + tamanho + " elementos): " + result.tempoNs() + " ns");
        // writer.addResult(cenarios[c], alg.getName(), tamanho, result.tempoNs());
        // }
        // }
        // }

        // Path output = Path.of("resultados.md");
        // writer.writeMarkdown(output);
        // System.out.println("\nResultados salvos em: " + output.toAbsolutePath());
    }
}
