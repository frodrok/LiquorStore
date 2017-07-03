package se.groupone.webshop.exceptions;

public final class InvalidUserException extends ServiceException {
	private static final long serialVersionUID = -7138996986714036850L;

	public InvalidUserException(String message) {
		super(message);
	}
}
