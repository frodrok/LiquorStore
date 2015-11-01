package se.bastagruppen.webshop.model;

import java.util.UUID;

public final class User implements Storable {
	private static final long serialVersionUID = 5282442438623343099L;
	private final String id;
	private final String username;
	private String password; // final

	public User(String username, String password) { // custom implementation of generating ID
		this.id = UUID.randomUUID().toString();
		this.username = username;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return new String(password);
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		User user = (User) o;
		if (!getUsername().equals(user.getUsername())) {
			return false;
		}
		return getPassword().equals(user.getPassword());
	}

	@Override
	public int hashCode() {
		int result = getId().hashCode();
		result = 31 * result + getUsername().hashCode();
		result = 31 * result + getPassword().hashCode();
		return result;
	}
}