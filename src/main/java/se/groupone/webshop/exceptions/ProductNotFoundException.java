package se.groupone.webshop.exceptions;

public final class ProductNotFoundException extends ServiceException {
	private static final long serialVersionUID = -4458433386433975912L;

	public ProductNotFoundException(String message) {
		super(message);
	}
}
