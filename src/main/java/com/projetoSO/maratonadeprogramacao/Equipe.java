package com.projetoSO.maratonadeprogramacao;
import java.util.*;

public class Equipe implements Runnable{
    private final String nome;
    private int pontos;
    private final List<String> baloes;
    private final List<Problema> problemas;
    private final Map<Problema, Integer> submissoesErradas;

    public Equipe(String nome, List<Problema> problemas) {
        this.nome = nome;
        this.pontos = 0;
        this.baloes = new ArrayList<>();
        this.problemas = problemas;
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
    public String getProblemas(){
        return problemas.toString();
    }

    public void setBaloes() {
        this.baloes.add("\uD83C\uDF88");
    }

    private void realizaSubmissao() throws IndexOutOfBoundsException{
        Random random = new Random();
        if (problemas.isEmpty()) {
            System.out.println(this.nome + " resolveu todos os problemas!");
            return;
        }

        int index = random.nextInt(problemas.size());
        Problema problema = problemas.get(index);
        int submissao = random.nextInt(1, 100);
        boolean tentativa = problema.verificarSubmissao(submissao);

        if (tentativa) {
            System.out.println(this.nome + " acertou o problema " + (index + 1) + "!");
            setBaloes();
            problemas.remove(index);
            setPontos(100 - (submissoesErradas.getOrDefault(problema, 0) * 2));
        } else {
            System.out.println(this.nome + " errou o problema " + (index + 1) + "!");
            submissoesErradas.put(problema, submissoesErradas.getOrDefault(problema, 0) + 1);
        }
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println(this.nome + " está programando...");
                realizaSubmissao();
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}