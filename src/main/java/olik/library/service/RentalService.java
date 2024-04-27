package olik.library.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import olik.library.dao.BookDao;
import olik.library.dao.RentalDao;
import olik.library.entities.Book;
import olik.library.entities.Rental;

@Service
public class RentalService {

	@Autowired
	private RentalDao rentalDao;
	
	@Autowired
	private BookDao bookDao;
	
	//adding a rental record
	public Rental addRental(Rental rental) {
		rental.setRentalDate(new Date());
		return this.rentalDao.save(rental);
	}

	// get all the rental records
	public List<Rental> getAllRentals() {
		return this.rentalDao.findAll();
	}
	
	//rent a book
	public Rental rentBook(Long bookId, String renterName) {
		//check if book is available
		Book book =bookDao.findById(bookId).orElseThrow(()->new IllegalArgumentException("Book not found"));
		if(!book.isAvailable()) {
			throw new IllegalStateException("Book is already rented");
		}
		//mark the book as rented
		book.setAvailable(false);
		bookDao.save(book);
		//create the rental record
		Rental rental=new Rental();
		rental.setBookId(bookId);
		rental.setRenterName(renterName);
		rental.setRentalDate(new Date());
		rentalDao.save(rental);
		return rental;
	}
	
	//return a book
	public Rental returnBook(Long bookId) {
		// Find the rental record for the book
        Rental rental = rentalDao.findFirstByBookIdOrderByRentalDateDesc(bookId);
        if (rental == null) {
            throw new IllegalStateException("No rental record found for the book");
        }
        // Update the book status to available
        Book book = bookDao.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Book not found"));
        book.setAvailable(true);
        bookDao.save(book);

        // Update the return date of the rental record
        rental.setReturnDate(new Date()); // Set return date to current date
        rentalDao.save(rental);
        return rental;
	}
	
	// Check for overdue rentals
    public List<Rental> getOverdueRentals() {
        Date currentDate = new Date();
        // Find rental records with return date in the past and no actual return date
        return rentalDao.findByReturnDateIsNullAndRentalDateBefore(currentDate);
    }
	
	
}
