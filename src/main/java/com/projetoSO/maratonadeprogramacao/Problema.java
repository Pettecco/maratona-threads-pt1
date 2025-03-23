package com.projetoSO.maratonadeprogramacao;

public class Problema {
    private final int dificuldade; // entre 1 e 10
    private final int pontos;

    public Problema(int dificuldade) {
        this.dificuldade = dificuldade;
        this.pontos = 100;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public int getPontos() {
        return pontos;
    }

    public boolean verificarSubmissao(int submissao){
        int dificuldadeSubmissao = 10 * dificuldade;
        return submissao >= dificuldadeSubmissao;
    }
}