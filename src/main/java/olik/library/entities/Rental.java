package olik.library.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "renter_name")
    private String renterName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "rental_date")
    private Date rentalDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "return_date")
    private Date returnDate;

    public Rental() {
        // Default constructor
    }

    public Rental(Long bookId, String renterName, Date rentalDate) {
        this.bookId = bookId;
        this.renterName = renterName;
        this.rentalDate = rentalDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
