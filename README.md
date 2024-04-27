# Setup of the project
1. First clone the project in your local system
2. Setup the credentials in .properties file (i.e. the credentials for your MySQL database)
3. Update your repository and then run the LibraryApplication file 

# End Points

## Book
GET /api/books  -> retrieve all the books from the database

GET /api/books/{id}  -> retrieve the book details of the specified book id

POST /api/books  -> create a new book details in the database

PUT /api/books/{id} -> update the book details

DELETE /api/books/{id} -> delete the book details from the database

GET /api/books/author/{author_name}  -> retrieve books of the specified author name

GET /api/books/available  -> get all the available books from the database

GET /api/books/rented  -> retrieve all the books which are rented

## Author
GET /api/authors  -> retrieve all the authors from the database

GET /api/authors/{id}  -> get author detail of the specific author id

POST /api/authors  -> add a new author detail to the database

PUT /api/authors/{id}  -> update the author detail of the specified author detail

DELETE /api/authors/{id}  -> delete the author detail of the specified id

## Rental

POST /api/rentals  -> create a new rental detail

GET /api/rentals  -> get all the rental records created so far

POST /api/rentals/rent  -> rent a book

PUT /api/rentals/return/{bookId}  -> return the book rented

GET /api/rentals/overdue -> return the rental records which are overdue (i.e. rented for more than 14 days)
