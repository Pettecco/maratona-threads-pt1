package com.projetoSO.maratonadeprogramacao;

public class Maratona implements Runnable {
    private final Equipe[] equipes;
    private final int tempo; // tempo de duração da maratona em segundos

    public Maratona(Equipe[] equipes, int tempo) {
        this.equipes = equipes;
        this.tempo = tempo;
    }

    public void sort(Equipe[] equipes)
    {
        int n = equipes.length;
        for (int i = 1; i < n; ++i) {
            Equipe key = equipes[i];
            int j = i - 1;
            while (j >= 0 && equipes[j].getPontos() < key.getPontos()) {
                equipes[j + 1] = equipes[j];
                j = j - 1;
            }
            equipes[j + 1] = key;
        }
    }

    @Override
    public void run() {
        Thread[] threads = new Thread[equipes.length];
        try {
            for (int i = 0; i < equipes.length; i++) {
                threads[i] = new Thread(equipes[i], equipes[i].getNome());
                threads[i].start();
            }

            Thread.sleep(tempo * 1000L);

            System.out.println("O tempo acabou! Interrompendo todas as equipes...");
            for (Thread t : threads) {
                t.interrupt();
            }

        } catch (InterruptedException e) {
            System.out.println("Maratona foi interrompida inesperadamente.");
        } finally {
            for (Thread t : threads) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("A maratona foi finalizada.");
            sort(equipes);
            for (Equipe equipe : equipes) {
                System.out.println(equipe.getNome() + " fez a pontuação de: " + equipe.getPontos() + " " + equipe.getBaloes());
            }
        }
    }
}