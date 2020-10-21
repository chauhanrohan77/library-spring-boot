package com.example.springboot.controller;

import com.example.springboot.model.BookEntity;
import com.example.springboot.model.StudentEntity;
import com.example.springboot.model.TransactionEntity;
import com.example.springboot.repository.BookRepository;
import com.example.springboot.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/library")
public class TransactionController {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/get-all-transactions")
    public List<TransactionEntity> getAllStudent(){
        List<TransactionEntity> transactionEntityList = transactionRepository.findAll();
        return transactionEntityList;
    }

    @PostMapping("/issue-book")
    public TransactionEntity issueBook(@RequestBody TransactionEntity transactionEntity){
       // Logger logger = Logger.getLogger("MyLog");

        TransactionEntity newTransaction = transactionRepository.save(transactionEntity);



        //logger.info("********************TransactionEntity:  "+transactionEntity);
        BookEntity book = bookRepository.findById(newTransaction.getBookId()).get();
        book.setAvailability(false);
        bookRepository.save(book);
        return newTransaction;
    }

    @PostMapping("/return-book")
    public Map<String, Boolean> returnBook(@RequestBody TransactionEntity transactionEntity){

        TransactionEntity transaction = transactionRepository.findByName(transactionEntity.getPersonId());

        BookEntity book = bookRepository.findById(transactionEntity.getBookId()).get();
        book.setAvailability(true);
        bookRepository.save(book);

        //TransactionEntity transactionUpdated = transactionRepository.findById(transactionEntity.getOperation_id()).get();
        transaction.setReturnDate(transactionEntity.getReturnDate());
        transactionRepository.save(transaction);

        Map<String, Boolean> response = new HashMap<>();
        response.put("updated", Boolean.TRUE);
        return response;
    }

    @GetMapping("/availability/{id}")
    public Boolean checkAvailability(@PathVariable(value = "id") Integer bookId){
        return bookRepository.findById(bookId).get().getAvailability();
    }
}
