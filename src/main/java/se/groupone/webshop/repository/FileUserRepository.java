package se.groupone.webshop.repository;

import se.groupone.webshop.interfaces.UserRepository;
import se.groupone.webshop.model.User;

import java.util.ArrayList;
import java.util.List;

public final class FileUserRepository extends FileRepository
		implements
        UserRepository {

	private final List<User> users;

	@SuppressWarnings("unchecked")
	public FileUserRepository(String dir, String filename) {
		super(dir, filename);
		this.users = (List<User>) restoreFromDisk();
	}

	@Override
	public void create(User user) {
		if (!users.contains(user)) {
			users.add(user);
			writeToDisk(users);
		}
	}

	@Override
	public User findById(String id) {
		for (User user : users) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		return new ArrayList<>(users);
	}

	@Override
	public void update(User item) {
		for (int i = 0; i < users.size(); i++) {
			if (item.getId().equals(users.get(i).getId())) {
				users.remove(i);
				users.add(item);
				writeToDisk(users);
				break;
			}
		}
	}

	@Override
	public void delete(String id) {
		for (int i = 0; i < users.size(); i++) {
			if (id.equals(users.get(i).getId())) {
				users.remove(i);
				writeToDisk(users);
				break;
			}
		}
	}
}
