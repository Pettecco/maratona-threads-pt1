package com.projetoSO.maratonadeprogramacao;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Equipe {
    private String nome;
    private int pontos; // Quantidade de questões resolvidas
    private final List<String> baloes; // Lista de emojis dos balões
    private final Map<Problema, Integer> submissoesErradas; // Map para associar um problema à quantidade de submissões erradas

    public Equipe(String nome) {
        this.nome = nome;
        this.pontos = 0;
        this.baloes = new ArrayList<>();
        this.submissoesErradas = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos += pontos;
    }

    public List<String> getBaloes() {
        return baloes;
    }

    public void setBaloes(String balao) {
        this.baloes.add(balao);
    }

    public Map<Problema, Integer> getSubmissoesErradas() {
        return submissoesErradas;
    }

    // TODO: implementar o método resolver problema
}