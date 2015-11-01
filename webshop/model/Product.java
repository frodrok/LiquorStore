package se.bastagruppen.webshop.model;

import java.util.UUID;

public final class Product implements Storable {
	private static final long serialVersionUID = 8256573226310050410L;
	private final String id;
	private final String name;
	private Double price; // sett final, discount klass för att manipulera priset beroende på olika faktorer

	public Product(String name, Double price) {
		this.id = UUID.randomUUID().toString();
		this.price = price;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Product product = (Product) o;

		if (!getName().equals(product.getName())) {
			return false;
		}
		return getPrice().equals(product.getPrice());
	}

	@Override
	public int hashCode() {
		int result = 1;
		result = 31 * result + getName().hashCode();
		result = 31 * result + getPrice().hashCode();
		return result;
	}
}
