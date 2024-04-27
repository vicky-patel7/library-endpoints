package olik.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import olik.library.entities.Rental;
import olik.library.service.RentalService;

@RestController
public class RentalController {
	
	@Autowired
	private RentalService rentalService;
	
	//post a new rental record
	@PostMapping("/api/rentals")
	public Rental addRentalRecord(@RequestBody Rental rental) {
		return this.rentalService.addRental(rental);
	}
	
	//get all the rental records
	@GetMapping("/api/rentals")
	public List<Rental> getAllRentals() {
		return this.rentalService.getAllRentals();
	}
	
	//rent a book 
	@PostMapping("/api/rentals/rent")
	public Rental rentBook(@RequestBody Rental rental) {
		return this.rentalService.rentBook(rental.getBookId(), rental.getRenterName());
	}
	
	//return a book
	@PutMapping("/api/rentals/return/{bookId}")
	public Rental returnBook(@PathVariable String bookId) {
		return this.rentalService.returnBook(Long.parseLong(bookId));
	}
	
	//get overdue records
	@GetMapping("/api/rentals/overdue")
	public List<Rental> getDueRentals(){
		return this.rentalService.getOverdueRentals();
	}
	
	
}
