package se.bastagruppen.webshop.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import se.bastagruppen.webshop.model.Storable;

public abstract class FileRepository {
	protected final File directory;
	protected final File source;

	protected FileRepository(String directory, String filename) {
		this.directory = new File(directory);
		this.source = new File(directory, filename);

		if (!this.directory.exists()) {
			this.directory.mkdir();
		}
	}

	protected void writeToDisk(List<? extends Storable> list) {
		try (ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream(source))) {
			out.writeObject(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	protected List<? extends Storable> restoreFromDisk() {
		if (source.exists()) {
			try (ObjectInputStream in = new ObjectInputStream(
					new FileInputStream(source))) {
				List<? extends Storable> items;
				items = (List<? extends Storable>) in.readObject();
				return items;
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return new ArrayList<>();
	}
}