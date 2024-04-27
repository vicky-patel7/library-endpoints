package olik.library.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String biography;
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Author(Long id, String name, String biography) {
		super();
		this.id = id;
		this.name = name;
		this.biography = biography;
	}
	public Author(String name, String biography) {
		super();
		this.name = name;
		this.biography = biography;
	}
	public Long getid() {
		return id;
	}
	public void setid(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getbiography() {
		return biography;
	}
	public void setbiography(String biography) {
		this.biography = biography;
	}
	
	
	
}
