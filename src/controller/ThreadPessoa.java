package controller;

import java.util.concurrent.Semaphore;

public class ThreadPessoa extends Thread {
	private int idPessoa;
	private Semaphore semaforo;
	private static int posChegada;

	public ThreadPessoa(int idPessoa, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		pessoaAndando();
		try {
			semaforo.acquire();
			abrirPorta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		
	}

	private void pessoaAndando() {
		int distanciaTotal = 200;
		int distanciaPercorrida = 0;
		int deslocamento = (int) ((Math.random() * 5) + 2);
		int tempo = 1000;
		while (distanciaPercorrida < distanciaTotal) {
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("#" + idPessoa + " ja andou " + distanciaPercorrida + "m.");
		}
		posChegada++;
		System.out.println("#" + idPessoa + " foi o " + posChegada + " o. a chegar na porta");
	}

	private void abrirPorta() {
		System.out.println("#" + idPessoa + " abriu a porta");
		int tempo = (int) ((Math.random() * 1001) + 1000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
