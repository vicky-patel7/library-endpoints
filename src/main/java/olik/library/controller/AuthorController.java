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

import olik.library.entities.Author;
import olik.library.service.AuthorService;

@RestController
public class AuthorController {
	
	@Autowired
	AuthorService authorService;
	
	
	@GetMapping("/api/authors")
	public List<Author> getAuthors(){
		return this.authorService.getAllAuthor();
	}
	
	@GetMapping("/api/authors/{id}")
	public Author getAAuthor(@PathVariable String id) {
		return this.authorService.getASingleAuthor(Long.parseLong(id));
	}
	
	@PostMapping("/api/authors")
	public Author addAAuthor(@RequestBody Author author) {
		return this.authorService.addAAuthor(author);
	}
	
	@PutMapping("/api/authors/{id}")
	public Author updateAAuthor(@PathVariable String id, @RequestBody Author author) {
		return this.authorService.updateAuthor(Long.parseLong(id), author);
	}
	
	@DeleteMapping("/api/authors/{id}")
	public void deleteAAuthor(@PathVariable String id) {
		this.authorService.deleteAuthor(Long.parseLong(id));
		return;
	}
	
}
