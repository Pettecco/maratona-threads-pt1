package com.projetoSO.maratonadeprogramacao;

public class Maratona implements Runnable {
    private final Equipe[] equipes;
    private final int tempo; // tempo de duração da maratona em segundos

    public Maratona(Equipe[] equipes, int tempo) {
        this.equipes = equipes;
        this.tempo = tempo;
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
            for (Equipe equipe : equipes) {
                System.out.println(equipe.getNome() + " fez a pontuação de: " + equipe.getPontos() + " " + equipe.getBaloes());
            }
        }
    }
}