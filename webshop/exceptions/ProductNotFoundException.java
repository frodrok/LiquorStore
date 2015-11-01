package se.bastagruppen.webshop.exceptions;

public final class ProductNotFoundException extends Exception {
	private static final long serialVersionUID = -4458433386433975912L;

	public ProductNotFoundException(String message) {
		super(message);
	}
}
