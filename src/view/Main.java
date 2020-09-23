package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPessoa;

public class Main {

	public static void main(String[] args) {
		int porta = 1;
		Semaphore semaforo = new Semaphore(porta);
		
		for(int idPessoa = 0; idPessoa < 4; idPessoa++) {
			Thread tPessoa = new ThreadPessoa(idPessoa, semaforo);
			tPessoa.start();
		}

	}

}
