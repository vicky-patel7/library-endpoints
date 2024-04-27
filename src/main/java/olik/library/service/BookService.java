package olik.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import olik.library.dao.BookDao;
import olik.library.entities.Book;

@Service
public class BookService {

	@Autowired
	private BookDao bookDao;

	// adding a new book detail to the database;
	public Book addABook(Book book) {
		return this.bookDao.save(book);
	}
	
	//getting the list of all books
	public List<Book> getBooks() {
		return this.bookDao.findAll();
	}
	
	//get a single book detail from database
	public Book getABook(Long id) {
		Optional<Book> optionalBook = this.bookDao.findById(id);
	    if (optionalBook.isPresent()) {
	        return optionalBook.get();
	    } else {
	        System.out.println("Book not found in the database");
	        return null;
	    }
	}
	
	//update an existing book detail in the database
	public Book updateBook(Long id, Book b) {
		bookDao.save(b);
		return b;
	}
	
	
	//delete a book detail from database using its id
	public void deleteBook(Long id) {
		this.bookDao.deleteById(id);
		return;
	}
	
	//retrieving books by author name
	public List<Book> getBooksByAuthor(String author_name){
		return this.bookDao.findByAuthor(author_name);
	}
	
	//retrieving books which are available
	public List<Book> getAvailableBooks(){
		return this.bookDao.findByAvailable(true);
	}
	
	//retrieving books which are rented
	public List<Book> getRentedBooks(){
		return this.bookDao.findByAvailable(false);
	}
	
}
