package com.metodosdeordenacao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ResultWriter {

    private final List<Result> results = new ArrayList<>();

    public void addResult(String cenario, String algoritmo, int tamanho, long tempoNs) {
        results.add(new Result(cenario, algoritmo, tamanho, tempoNs, null));
    }

    public void addResult(String cenario, String algoritmo, int tamanho, long tempoNs, String erro) {
        results.add(new Result(cenario, algoritmo, tamanho, tempoNs, erro));
    }

    public void writeMarkdown(Path path) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("# Resultados - Métodos de Ordenação\n\n");

        Set<String> cenarios = new LinkedHashSet<>();
        Set<String> algoritmos = new LinkedHashSet<>();
        Set<Integer> tamanhos = new LinkedHashSet<>();
        for (Result r : results) {
            cenarios.add(r.cenario);
            algoritmos.add(r.algoritmo);
            tamanhos.add(r.tamanho);
        }

        for (String cenario : cenarios) {
            sb.append("## ").append(cenario).append("\n\n");

            // Header
            sb.append("| Tamanho (n) |");
            for (String alg : algoritmos) {
                sb.append(" ").append(alg).append(" |");
            }
            sb.append("\n");

            // Separator
            sb.append("|-------------|");
            for (int i = 0; i < algoritmos.size(); i++) {
                sb.append("------------|");
            }
            sb.append("\n");

            // Rows by size
            for (int tamanho : tamanhos) {
                sb.append("| ").append(String.format("%11d", tamanho)).append(" |");
                for (String alg : algoritmos) {
                    String valor = findTempo(cenario, alg, tamanho);
                    sb.append(String.format(" %10s |", valor));
                }
                sb.append("\n");
            }
            sb.append("\n");
        }

        Files.writeString(path, sb.toString());
    }

    private String findTempo(String cenario, String algoritmo, int tamanho) {
        for (Result r : results) {
            if (r.cenario.equals(cenario) && r.algoritmo.equals(algoritmo) && r.tamanho == tamanho) {
                if (r.erro != null) {
                    return r.erro;
                }
                return String.format("%d ns", r.tempoNs);
            }
        }
        return "-";
    }

    private static class Result {
        final String cenario;
        final String algoritmo;
        final int tamanho;
        final long tempoNs;
        final String erro;

        Result(String cenario, String algoritmo, int tamanho, long tempoNs, String erro) {
            this.cenario = cenario;
            this.algoritmo = algoritmo;
            this.tamanho = tamanho;
            this.tempoNs = tempoNs;
            this.erro = erro;
        }
    }
}
