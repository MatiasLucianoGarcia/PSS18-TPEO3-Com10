package TDAListaDE;

import java.util.Iterator;

public class ElementIterator<E> implements Iterator<E>{
	protected PositionList<E> list;
	protected Position<E> cursor;
	
	//Constructor:
	public ElementIterator(PositionList<E> L) throws EmptyListException {
		list = L;
		cursor = (list.isEmpty()) ? null : list.first();
	}
	
	
	
	//Consultas:
	public boolean hasNext() {
		return cursor != null;
	}
	
	public E next() {
		try {
			if (cursor == null)
				throw new NoSuchElementException("No hay siguiente elemento.");
			E toReturn = cursor.element();
			cursor = (cursor == list.last()) ? null : list.next(cursor);
			return toReturn;
		}
		catch(EmptyListException | BoundaryViolationException | InvalidPositionException | NoSuchElementException exc) {
			System.out.println(exc.getMessage() + "\n" + exc.getStackTrace());
			return null;
		}
	}
	
	public void remove(E e) {
		Position<E> pos = new DNode<E>(e);
		try {
			list.remove(pos);
		}
		catch (InvalidPositionException exc) {
			System.out.println(exc.getMessage() + "\n" + exc.getStackTrace());
		}
	}
}
