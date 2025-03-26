import com.projetoSO.maratonadeprogramacao.Equipe;
import com.projetoSO.maratonadeprogramacao.Maratona;
import com.projetoSO.maratonadeprogramacao.Problema;

import java.util.*;

public class Main{
    public static void main(String[] args) {
        List<Problema> problemas = new ArrayList<>();
        Equipe[] equipes = new Equipe[5];

        // Criar problemas e adicioná-los na lista de problemas
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int dificuldade = random.nextInt(10) + 1;
            Problema problema = new Problema(dificuldade);
            problemas.add(problema);
        }

        for (int i = 0; i < equipes.length; i++) {
            equipes[i] = new Equipe("Equipe " + (i + 1), new ArrayList<>(problemas));
        }

        Maratona maratona = new Maratona(equipes, 10);
        maratona.run();
    }
}