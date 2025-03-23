import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Criação e adição dos problemas
        List<Problema> problemas = new ArrayList<>();
        int[] dificuldades = {5, 7, 9, 5, 7, 9, 5, 7, 9};
        for (int dificuldade : dificuldades) {
            problemas.add(new Problema(dificuldade));
        }

        // Criação das equipes
        String[] nomesEquipes = {
                "Equipe 1",
                "Equipe 2",
                "Equipe 3",
                "Equipe 4",
                "Equipe 5"
        };
        List<Equipe> equipes = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        // Adição das equipes e das Threads
        for (String nome : nomesEquipes) {
            Equipe equipe = new Equipe(nome, problemas);
            equipes.add(equipe);
            threads.add(new Thread(equipe));
        }

        // Criação da maratona
        Maratona maratona = new Maratona(threads, 60, TimeUnit.SECONDS, equipes);
        maratona.iniciarMaratona(); //iniciando a maratona

        // Aguarda a finalização das threads
        // este trecho garante que as threads terminem antes da Main terminar
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}