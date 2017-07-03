package se.groupone.webshop.interfaces;

import java.util.List;

public interface CrudRepository<T, U> {
	void create(T item);

	/* old signature:
		T findById(String id);

	   new signature:
	   	CrudRepository<T, U> where T is Item type and U is Key type
	   	T findById(U id);
	 */

	T findById(U id);

	List<T> getAll();

	void update(T item);

	void delete(U id);
}