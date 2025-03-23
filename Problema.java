public class Problema {
    private int dificuldade;
    private int pontuacao;
    private int penalidade;
    private boolean resolvido = false;

    public Problema(int dificuldade) {
        this.dificuldade = dificuldade;
        this.pontuacao = 100;
        this.penalidade = 0;
    }

    public int getPontuacao() {
        return Math.max(0, pontuacao - penalidade);
    }

    public int getDificuldade(){
        return dificuldade;
    }
    public boolean getResolvido() {return resolvido;}

    public void submeter(int numero) {
        if (numero < getDificuldade()) {
            penalidade += 10; // Exemplo de penalidade por submissão errada
        }
        else{
            resolvido = true;
        }
    }

    public int getPontos() {
        return pontuacao;
    }
}
