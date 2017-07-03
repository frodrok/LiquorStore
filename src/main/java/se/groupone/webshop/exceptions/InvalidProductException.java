package se.groupone.webshop.exceptions;

public final class InvalidProductException extends ServiceException {
	private static final long serialVersionUID = 6533630916171727186L;

	public InvalidProductException(String message) {
		super(message);
	}
}
