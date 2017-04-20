package tadGrafo;

import java.util.List;


public class GrafoLista extends Grafo implements GrafoTad {

	/**
	 * Serial UID.
	 */
	private static final long serialVersionUID = 1L;

	private int[] lista;

	/**
*
*/
	public GrafoLista() {
		super();
	}

	/**
	 * @param aresta
	 * @param vertice
	 * @param ponderado
	 * @param representacao
	 * @param dirigido
	 */
	public GrafoLista(List<Aresta> aresta, Integer vertice, Boolean ponderado,
			Integer representacao, Boolean dirigido) {
		super(aresta, vertice, ponderado, representacao, dirigido);
	}

	@Override
	public void imprimir() {
		String retorno = "";
		for (int i = 0; i < this.getVertice(); i++) {
			retorno += "1 -> ";
			retorno += this.lista[i] + " ";
			retorno += "\n";
		}
		System.out.println(retorno);
	}

	/**
	 * @return the lista
	 */
	public int[] getLista() {
		return lista;
	}

	/**
	 * @param lista
	 *            the lista to set
	 */
	public void setLista(int[] lista) {
		this.lista = lista;
	}
}
