package olik.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import olik.library.dao.AuthorDao;
import olik.library.entities.Author;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorDao authorDao;
	
	//get all the author details
	public List<Author> getAllAuthor(){
		return this.authorDao.findAll();
	}
	
	//get the detail of single author
	public Author getASingleAuthor(Long id) {
		Optional<Author> author=this.authorDao.findById(id);
		if(author.isPresent()) {
			return author.get();
		}else {
			System.out.println("Author detail with this id is not found");
			return null;
		}
	}
	
	public Author addAAuthor(Author author) {
		return this.authorDao.save(author);
	}
	
	//update an existing author detail
	public  Author updateAuthor(Long id, Author author) {
		return this.authorDao.save(author);
	}
	
	//delete an author detail with the given id
	public void deleteAuthor(Long id) {
		this.authorDao.deleteById(id);
		return;
	}
	
	
}
