package olik.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import olik.library.entities.Book;

public interface BookDao extends JpaRepository<Book, Long> {
//	@Query("SELECT b FROM Book b WHERE b.author_name =:author_name")
	List<Book> findByAuthor(String author);
	List<Book> findByAvailable(Boolean available);
}
