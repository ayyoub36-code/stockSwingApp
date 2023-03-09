package fr.fms.bdd;

import java.util.ArrayList;

public interface Dao<T> {
	public Connection connection = BddConnection.getConnection();
	public ArrayList<T> readAll();
}
