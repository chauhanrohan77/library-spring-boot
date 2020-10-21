package com.example.springboot.controller;

import com.example.springboot.model.BookEntity;
import com.example.springboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
public class BookController {
    @Autowired
    BookRepository bookrepository;

    @GetMapping("/get-all-books")
    public List<BookEntity> getAllBook(){
        List<BookEntity> allBooklist = bookrepository.findAll();
        return allBooklist;
    }

    @GetMapping("/get-book/{id}")
    public BookEntity getBookbyId(@PathVariable(value = "id") Integer bookId)

    {
        BookEntity BookEntity = bookrepository.findById(bookId).get();

        return BookEntity;
    }

    @PostMapping("/create-books")
    public BookEntity createBook(@RequestBody BookEntity book) {

        BookEntity savedBook = bookrepository.save(book);

        return savedBook;
    }

    @PutMapping("/update-books/{id}")
    public ResponseEntity<BookEntity> updateBook(@PathVariable(value = "id") Integer bookId,
                                                       @RequestBody BookEntity bookDetails) {
        BookEntity book = bookrepository.findById(bookId).get();

        book.setAuthor(bookDetails.getAuthor());
        book.setAvailability(bookDetails.getAvailability());
        book.setName(bookDetails.getName());
        final BookEntity updatedBook = bookrepository.save(book);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/delete-books/{id}")
    public Map<String, Boolean> deleteBook(@PathVariable(value = "id") Integer bookId)
    {
        BookEntity book = bookrepository.findById(bookId).get();

        bookrepository.delete(book);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
