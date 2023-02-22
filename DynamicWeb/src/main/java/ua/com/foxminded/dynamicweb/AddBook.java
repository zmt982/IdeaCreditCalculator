package ua.com.foxminded.dynamicweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddBook {
	
	public static void addBook(String newBook) throws SQLException {
		
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234")) {
			System.out.println("I am ready to add");
			
//			String sql = "insert into books.books (id, name) values (nextval('books_id_seq'), ?)";
//			String sql = "insert into books.books (books_id_seq, name) values (nextval('books_id_seq'), ?)";
//			String sql = "insert into books.books (books_id_seq) values (nextval('books_id_seq'), ?)";
//			String sql = "insert into books.books (id, name) values (nextval('id'), ?)";
//			String sql = "insert into books.books (id, name) values (nextval(), ?)";
			String sql = "insert into books.books (name) values (?)";
			PreparedStatement prst = connection.prepareStatement(sql);
				if (newBook != "" && newBook != null) {
					prst.setString(1, newBook);
					prst.executeUpdate();
				}
		}

		catch (Exception ex) {
			System.out.println("add failed...");
			System.out.println(ex);
			}
	}
	
	public static void deleteBook(int id) throws SQLException {
		
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234")) {
			System.out.println("I am ready to delete");
			
			String sql = "delete from books.books where id = (?)";
			PreparedStatement prst = connection.prepareStatement(sql);
			if (id != 0) {
				prst.setInt(1, id);
				prst.executeUpdate();
			}
		}
		
		catch (Exception ex) {
			System.out.println("delete failed...");
			System.out.println(ex);
		}
	}
	
	/*public static void sequence (String sequence) throws SQLException {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234")) {
			System.out.println("I am waited");
			String sql = "create sequence id_seq minvalue 1 start with 1 increment by 1 nocache";
			PreparedStatement prst = connection.prepareStatement(sql);
			prst.setString(1, sequence);
			prst.executeUpdate();
		}
		
		catch (Exception ex) {
			System.out.println("Connection failed...");
			System.out.println(ex);
			}

	}*/
}