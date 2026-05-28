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

    public static void main(String[] args) throws IOException {

        System.out.println("=== Métodos de Ordenação ===\n");

        SortAlgorithm[] algoritmos = {
                new BubbleSort(),
                new InsertionSort(),
                new SelectionSort(),
                new HeapSort(),
                new ShellSort(),
                new MergeSort(),
                new QuickSort(),
        };

        ResultWriter writer = new ResultWriter();

        String[] cenarios = {
                "Ordenado crescente (sem repetição)",
                "Ordenado decrescente (sem repetição)",
                "Aleatório (sem repetição)",
                "Aleatório (com repetição)"
        };

        for (int tamanho : TAMANHOS) {
            int[][] arrays = {
                    SortUtils.gerarCrescente(tamanho),
                    SortUtils.gerarDecrescente(tamanho),
                    SortUtils.gerarAleatorio(tamanho),
                    SortUtils.gerarAleatorioComRepeticao(tamanho)
            };

            for (int c = 0; c < cenarios.length; c++) {
                for (SortAlgorithm alg : algoritmos) {

                    int TOTAL_EXECUTIONS = 10;
                    long[] tempos = new long[TOTAL_EXECUTIONS];

                    String erro = null;
                    for (int i = 0; i < TOTAL_EXECUTIONS; i++) {

                        SortResult result = alg.sort(arrays[c]);

                        if (result.hasErro()) {
                            erro = result.erro();
                            break;
                        } else {
                            tempos[i] = result.tempoNs();
                            System.out.printf("  [%d/%d] %s - parcial: %d ns%n", i + 1, TOTAL_EXECUTIONS, alg.getName(),
                                    tempos[i]);
                        }

                    }

                    if (erro != null) {
                        System.out.printf("  ✗ %s | ERRO: %s%n", alg.getName(), erro);
                        writer.addResult(cenarios[c], alg.getName(), tamanho, 0, erro);
                    } else {

                        long somaTotal = 0;
                        for (long tempo : tempos) {
                            somaTotal += tempo;
                        }
                        long media = somaTotal / TOTAL_EXECUTIONS;

                        somaTotal = 0;
                        for (long tempo : tempos) {
                            somaTotal += (tempo - media) * (tempo - media);
                        }
                        long variancia = somaTotal / (TOTAL_EXECUTIONS - 1);

                        long desvioPadrao = (long) Math.sqrt(variancia);

                        long somaTotalNoIntervalo = 0;
                        int itensNoIntervalo = 0;
                        for (long tempo : tempos) {

                            if (tempo >= media - desvioPadrao && tempo <= media + desvioPadrao) {
                                somaTotalNoIntervalo += tempo;
                                itensNoIntervalo++;
                            }
                        }

                        long mediaNoIntervalo = itensNoIntervalo > 0 ? somaTotalNoIntervalo / itensNoIntervalo : 0;

                        System.out.printf("  ✓ %s | Desvio Padrão: %d ns%n", alg.getName(), mediaNoIntervalo);

                        writer.addResult(cenarios[c], alg.getName(), tamanho, mediaNoIntervalo);
                    }
                }
            }
        }

        Path output = Path.of("resultados.md");
        writer.writeMarkdown(output);
        System.out.println("\nResultados salvos em: " + output.toAbsolutePath());

    }
}
