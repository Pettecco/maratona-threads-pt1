### Classe Equipe
```java
package com.projetoSO.maratonadeprogramacao;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Equipe implements Runnable{
    private String nome;
    private int pontos; // Quantidade de questões resolvidas
    private final List<String> baloes; // Lista de emojis dos balões
    private final Map<Problema, Integer> submissoesErradas; // Map para associar um problema à quantidade de submissões erradas

    public Equipe(String nome) {
        this.nome = nome;
        this.pontos = 0;
        this.baloes = new ArrayList<>();
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

    public void setBaloes(String balao) {
        this.baloes.add(balao);
    }

    public Map<Problema, Integer> getSubmissoesErradas() {
        return submissoesErradas;
    }

    public void run(){
        // TODO: implementar o método resolver problema
    }
}

```

### Classe Maratona
```java
package com.projetoSO.maratonadeprogramacao;

public class Maratona {
    public Equipe equipes[];
    public int tempo;

    /* TODO:
        implementar os possives métodos:
        iniciarCompetição, verificarVencedor, cronometrar(?)
        atualizar ponto de problema(?)
    */
}

```

### Classe Problema
```java
package com.projetoSO.maratonadeprogramacao;

public class Problema {
    public int dificuldade;
    public int pontos;

    public int verificaResultado(){
        return resultado;
    }

    // TODO: implementar os métodos verificarSubmissão e atualizar pontos
}

```

### Temporizador
Existe uma classe Timer no java.utils, que permite colocar um timer em funcionamento para threads. Vai ser bem útil pra
definir o tempo da competição.
Uma outra forma seria definir um tempo para cada problema, caso quisermos

```java
import java.util.Timer;
import java.util.TimerTask;

public class TimerExample {
    public static void main(String[] args) {
        Timer timer = new Timer(); // cria um novo timer

        # cria uma task para ser executada num certo tempo
        TimerTask task1 = new TimerTask() {
            public void run() {
                System.out.println("Task 1 executed!");
            }
        };

        TimerTask task2 = new TimerTask() {
            public void run() {
                System.out.println("Task 2 executed!");
            }
        };

        TimerTask task3 = new TimerTask() {
            public void run() {
                System.out.println("Task 3 executed!");
            }
        };

        
        timer.schedule(task1, 2000); // task 1 será executada em 2 segundos
        timer.schedule(task2, 4000); // task 1 será executada em 4 segundos
        timer.schedule(task3, 6000); // task 1 será executada em 6 segundos
    }
}

```
### Execution
Existe também a classe ExecutorService, que parece ser melhor para lidar com várias threads
```java
// Java Program to Demonstrate ExecutorService Interface

// Importing required classes
import java.util.concurrent.*;

// Class
// Main class
public class SimpleExecutor {

	// Main driver method
	public static void main(String[] args)
	{
		// Creating objects of CountDownLatch class
		CountDownLatch cd1 = new CountDownLatch(5);
		CountDownLatch cd2 = new CountDownLatch(5);
		CountDownLatch cd3 = new CountDownLatch(5);
		CountDownLatch cd4 = new CountDownLatch(5);

		// Creating objects of ExecutorService class
		ExecutorService es
			= Executors.newFixedThreadPool(2);

		// Display message only for better readability
		System.out.println("Starting");

		// Executing the tasks 
		es.execute(new MyThread(cd1, "A"));
		es.execute(new MyThread(cd2, "B"));
		es.execute(new MyThread(cd3, "C"));
		es.execute(new MyThread(cd4, "D"));

		// Try block to check for exceptions
		try {
			// Waiting for tasks to complete
			cd1.await();
			cd2.await();
			cd3.await();
			cd4.await();
		}

		// Catch block to handle exceptions
		catch (InterruptedException e) {
			System.out.println(e);
		}

		// Making all current executing threads to terminate
		es.shutdown();

		// Display message only for better readability
		System.out.println("Done");
	}
}

// Class 2
// Helper class
class MyThread implements Runnable {

	// Class data members
	String name;
	CountDownLatch latch;

	// Constructor
	MyThread(CountDownLatch latch, String name){

		// this keyword refers to current instance itself
		this.name = name;
		this.latch = latch;

		new Thread(this);
	}

	// Method
	// Called automatically when thread is started
	public void run(){
		for (int i = 0; i < 5; i++) {
			System.out.println(name + ": " + i);
			latch.countDown();
		}
	}
}

```
