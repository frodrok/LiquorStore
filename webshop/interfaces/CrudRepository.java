package se.bastagruppen.webshop.interfaces;

import java.util.List;

public interface CrudRepository<T> {
	void create(T item);
	/* TYPGENERISK KEY ISTÄLLET FÖR STRING */
	T findById(String id);

	List<T> getAll();

	void update(T item);

	void delete(String id);
}