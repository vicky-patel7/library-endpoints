package olik.library.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String author;
	private String isbn;
	private int publication_year;
	private boolean available;
	public Book(Long id, String title, String author, String isbn, int publication_year, boolean available) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publication_year = publication_year;
		this.available = available;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String title, String author, String isbn, int publication_year, boolean available) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publication_year = publication_year;
		this.available = available;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getauthor() {
		return author;
	}
	public void setauthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getpublication_year() {
		return publication_year;
	}
	public void setpublication_year(int publication_year) {
		this.publication_year = publication_year;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", publication_year="
				+ publication_year + ", available=" + available + "]";
	}	
}
