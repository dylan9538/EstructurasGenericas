package tadGrafo;

import java.io.Serializable;
import java.util.List;


public class Grafo implements GrafoTad, Serializable {

	/**
	 * Serial UID.
	 */
	private static final long serialVersionUID = 1L;

	private List<Aresta> aresta;
	private Integer vertice;
	private Boolean ponderado;
	private Integer representacao;
	private Boolean dirigido;

	public Grafo() {
	}

	/**
	 * @param aresta
	 * @param vertice
	 * @param ponderado
	 * @param representacao
	 * @param dirigido
	 */
	public Grafo(List<Aresta> aresta, Integer vertice, Boolean ponderado,
			Integer representacao, Boolean dirigido) {
		this.aresta = aresta;
		this.vertice = vertice;
		this.ponderado = ponderado;
		this.representacao = representacao;
		this.dirigido = dirigido;
	}

	/**
	 * @return the aresta
	 */
	public List<Aresta> getAresta() {
		return aresta;
	}

	/**
	 * @param aresta
	 *            the aresta to set
	 */
	public void setAresta(List<Aresta> aresta) {
		this.aresta = aresta;
	}

	/**
	 * @return the vertice
	 */
	public Integer getVertice() {
		return vertice;
	}

	/**
	 * @param vertice
	 *            the vertice to set
	 */
	public void setVertice(Integer vertice) {
		this.vertice = vertice;
	}

	/**
	 * @return the ponderado
	 */
	public Boolean getPonderado() {
		return ponderado;
	}

	/**
	 * @param ponderado
	 *            the ponderado to set
	 */
	public void setPonderado(Boolean ponderado) {
		this.ponderado = ponderado;
	}

	/**
	 * @return the representacao
	 */
	public Integer getRepresentacao() {
		return representacao;
	}

	/**
	 * @param representacao
	 *            the representacao to set
	 */
	public void setRepresentacao(Integer representacao) {
		this.representacao = representacao;
	}

	/**
	 * @return the dirigido
	 */
	public Boolean getDirigido() {
		return dirigido;
	}

	/**
	 * @param dirigido
	 *            the dirigido to set
	 */
	public void setDirigido(Boolean dirigido) {
		this.dirigido = dirigido;
	}

	public void imprimir() {
		// TODO Auto-generated method stub
	}
}