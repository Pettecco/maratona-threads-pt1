# Trabalho de Threads em Sistemas Operacionais

## Ideia Geral: Maratona de Programação

A ideia consiste em simular uma *maratona de programação* através de **Threads**, seguindo a seguinte estrutura:
 - Haverá uma lista de problemas em que cada problema terá um grau de dificuldade.
 - Cada equipe na execução da sua Thread tentará submeter a resposta de um problema escolhido aleatoriamente. Caso o "dado", ou seja, o número aleatório que será gerado pela equipe, for maior que o grau de dificuldade da questão a submissão estará correta. Caso contrário, a equipe soma uma submissão incorreta para a devida questão.
 - Todas as questões valem 100 pontos, e vão diminuindo com os critérios de: a cada submissão correta, a devida questão passará a valer uma quantidade menor de pontos para a próxima equipe que fizer uma submissão correta. Outro critério é que, a cada submissão errada, se a submissão for correta no final, pontos também serão descontados dela.
 - Por fim, vence a equipe que realizar todas as questões (e ganhar todos os balões) ou a com a maior quantidade de balões ao final da competição.
 - Haverá uma Thread para cada equipe e um thread para controlar o tempo da competição

classe problema:
    grau de dificuldade
    pontuação

    função verificaResultado:
        função que verifica se acertou ou não o problema

classe equipe que extende de threads:
    problema que será resolvido
    valor aleatório
    pontuação da equipe

    função resolveProblema:
        recebe um problema, retornando a pontuação

classe maratona:
    inicializa a competição, recebendo as equipes
    tempo total da competição

    função verificarVencedor:
        verifica o vencedor baseado em quantos pontos foram feitos

classe temporizador:
    vai realizar a função de cronometrar o tempo em segundos ou minutos