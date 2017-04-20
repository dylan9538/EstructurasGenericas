package tadGrafo;


import java.util.*;


public class Principal {

	private Scanner s = new Scanner(System.in);
	private Grafo grafo = new Grafo();
	private GrafoLista grafoLista;

	/**
	 * Método run.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		new Principal().sistema();
	}

	private void sistema() {
		try {
			
			int menuPrincipal = this.s.nextInt();

			if (menuPrincipal == 2)
				this.criarGrafo();
			else
				this.opcaoInvalida();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}



	private void criarGrafo() {
		try {
			int menuAdjacencia = this.s.nextInt();

			 if (menuAdjacencia == 2) {
				grafo.setRepresentacao(2);
				this.listaAdjacencia();
			} else
				this.opcaoInvalida();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	

	private void menuGrafo() {
		try {
			System.out.println("------ Menu do Grafo ------");
			System.out.println("1 - Imprimir Grafo.");

			int opcao = this.s.nextInt();

			switch (opcao) {
			case 1:
				if (grafo.getRepresentacao() == 2)
					this.grafoLista.imprimir();
				break;
			default:
				break;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Montagem do grafo.
	 */
	

	private void listaAdjacencia() {
		try {
			// Saber se é dirigido.
			System.out.println("Grafo é dirigido:");
			int isDirigido = this.s.nextInt();
			if (isDirigido == 0)
				grafo.setDirigido(false);
			else if (isDirigido == 1)
				grafo.setDirigido(true);
			else
				this.opcaoInvalida();

			// Saber se é ponderado.
			System.out.println("Grafo é ponderado:");
			int isPonderado = this.s.nextInt();
			if (isPonderado == 0)
				grafo.setPonderado(false);
			else if (isPonderado == 1)
				grafo.setPonderado(true);
			else
				this.opcaoInvalida();

			System.out.println("Quantos Vértices:");
			grafo.setVertice(this.s.nextInt());
			this.criarListaAdjacencia();

			this.menuGrafo();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void criarListaAdjacencia() {

	}

	private void opcaoInvalida() {
		System.out.println("Opção inválido");
	}
}