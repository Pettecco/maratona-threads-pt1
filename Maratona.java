import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Maratona {
    private List<Thread> threads;
    private ScheduledExecutorService scheduler;
    private long duracao;
    private TimeUnit unidadeDeTempo;
    private List<Equipe> equipes;

    public Maratona(List<Thread> threads, long duracao, TimeUnit unidadeDeTempo, List<Equipe> equipes) {
        this.threads = threads;
        this.scheduler = Executors.newScheduledThreadPool(1);
        this.duracao = duracao;
        this.unidadeDeTempo = unidadeDeTempo;
        this.equipes = equipes;
    }

    public void iniciarMaratona(){
        // Inicia as threads das equipes
        for(Thread equipe : threads){
            equipe.start();
        }

        // Finaliza a maratona após uma determinada duração
        scheduler.schedule(this::finalizarMaratona, duracao, unidadeDeTempo);
    }

    public void finalizarMaratona(){
        // Finaliza a maratona
        System.out.println("Tempo esgotado! Finalizando a maratona.");
        for (Thread equipe : threads) {
            equipe.interrupt();
        }
        scheduler.shutdown();

        // Realiza a classificação das equipes
        Collections.sort(equipes, Comparator.comparingInt(Equipe::getPontos).reversed());
        System.out.println("\nClassificação Final:");
        for (Equipe equipe : equipes) {
            System.out.println(equipe.getNome() + ": " + equipe.getPontos() + " pontos " + "🎈".repeat(equipe.getBaloes()));
        }
    }
}
