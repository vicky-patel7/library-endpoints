package olik.library.dao;

import java.util.List;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import olik.library.entities.Rental;

public interface RentalDao extends JpaRepository<Rental, Long> {
	Rental findByBookId(Long bookId);
	Rental findFirstByBookIdOrderByRentalDateDesc(Long bookId);
	List<Rental> findByReturnDateIsNullAndRentalDateBefore(Date currentDate);
}
