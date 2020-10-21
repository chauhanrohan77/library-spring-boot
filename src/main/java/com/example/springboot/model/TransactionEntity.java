package com.example.springboot.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer operation_id;

    @Column(name = "person_id", nullable = false)
    private Integer personId;

    @Column(name = "book_id", nullable = false)
    private Integer bookId;

    @Column(name = "issue_date",nullable = false)
    private Date issueDate;

    @Column(name = "return_date",nullable = false)
    private Date returnDate;

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public TransactionEntity() {
    }

    public TransactionEntity(Integer personId, Integer bookId, Date issueDate, Date returnDate) {
        this.personId = personId;
        this.bookId = bookId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public Integer getOperation_id() {
        return operation_id;
    }

    public void setOperation_id(Integer operation_id) {
        this.operation_id = operation_id;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}
