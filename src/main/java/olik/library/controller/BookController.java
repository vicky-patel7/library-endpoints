package olik.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import olik.library.entities.Book;
import olik.library.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	
	//get all the books
	@GetMapping("/api/books")
	public List<Book> getBooks() {
		return this.bookService.getBooks();
	}
	
	//get book of specific id
	@GetMapping("/api/books/{id}")
	public Book getABook(@PathVariable String id) {
		return this.bookService.getABook(Long.parseLong(id));
	}
	
	//add a new book detail
	@PostMapping("/api/books")
	public Book addABook(@RequestBody Book b) {
		return this.bookService.addABook(b);
	}
	
	//update an existing book details
	@PutMapping("/api/books/{id}")
	public Book updateABook(@PathVariable String id, @RequestBody Book b) {
		return this.bookService.updateBook(Long.parseLong(id), b);
	}
	
	//delete a book with the given id
	@DeleteMapping("/api/books/{id}")
	public void deleteABook(@PathVariable String id) {
		this.bookService.deleteBook(Long.parseLong(id));
		return;
	}	
	
	//retrieve books by author name
	@GetMapping("/api/books/author/{author_name}")
	public List<Book> getBooksByAuthor(@PathVariable String author_name){
		return this.bookService.getBooksByAuthor(author_name);
	}
	
	//retrieve books which are available
	@GetMapping("/api/books/available")
	public List<Book> getAllAvailableBooks(){
		return this.bookService.getAvailableBooks();
	}
	
	//retrieve books which are rented
	@GetMapping("/api/books/rented")
	public List<Book> getAllRentedBooks(){
		return this.bookService.getRentedBooks();
	}
	
}
