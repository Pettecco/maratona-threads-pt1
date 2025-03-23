import java.util.List;
import java.util.Random;
public class Equipe implements Runnable{
    private final String nome;
    private int pontos;
    private int baloes;
    private final List<Problema> problemas;
    private final Random random;

    public Equipe(String nome, List<Problema> problemas) {
        this.nome = nome;
        this.problemas = problemas;
        this.pontos = 0;
        this.random = new Random();
    }

    public String getNome(){
        return nome;
    }

    public int getPontos(){
        return pontos;
    }

    public int getBaloes() {
        return baloes;
    }

    public void atualizaPontos(Problema problema){
        pontos += problema.getPontos();
    }

    // Organiza equipes por pontos
    public int compareTo(Equipe o) {
        return this.pontos;
    }

    @Override
    public void run() {
        for (Problema problema : problemas) {
            // Encerra a thread com o fim da maratona
            if (Thread.currentThread().isInterrupted()) {
                break; //garante que a thread será finalizada quando a maratona finalizar
            }
            // Faz a submissão do problema
            int numero = random.nextInt(1,11); // Simula resolução aleatória
            problema.submeter(numero);

            // Submite o problema e adiciona a pontuação para equipe em caso de sucesso
            if (problema.getResolvido()) {
                pontos += problema.getPontuacao();
                baloes++;
                System.out.println(nome + " resolveu um problema de dificuldade " + problema.getDificuldade() + " e ganhou " + problema.getPontuacao() + " pontos e 1 balão.");
            } else {
                System.out.println(nome + " errou um problema de dificuldade " + problema.getDificuldade() + " e perdeu pontos.");
            }

            // Simula o tempo de resolução para tentar novamente a submissão
            try {
                Thread.sleep(1000L * problema.getDificuldade());
            } catch (InterruptedException e) {
                //System.out.println(nome + " foi interrompida!");
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
