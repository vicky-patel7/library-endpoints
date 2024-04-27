package olik.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import olik.library.entities.Author;

public interface AuthorDao extends JpaRepository<Author, Long> {

}
