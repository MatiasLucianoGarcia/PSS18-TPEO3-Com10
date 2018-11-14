package TDAListaDE;

class DNode<E> implements Position<E> {
	E elemento;
	DNode<E> siguiente;
	DNode<E> anterior;
	
	//Constructores:
	public DNode() {
		this(null, null, null);
	}
	
	public DNode(E item) {
		this(null, null, item);
	}
	
	public DNode(DNode<E> ant, DNode<E> sig, E item) {
		elemento = item;
		siguiente = sig;
		anterior = ant;
	}
	
	
	
	//Comandos y Consultas:
	public E element() {
		return elemento;
	}
	
	public void setElemento(E elemento) {
		this.elemento=elemento;
	}
	
	public DNode<E> getSiguiente() {
		return siguiente;
	}
	
	public void setSiguiente (DNode<E> siguiente) {
		this.siguiente = siguiente;
	}
	
	public DNode<E> getAnterior() {
		return anterior;
	}
	
	public void setAnterior (DNode<E> ant) {
		this.anterior = ant;
	}
}
