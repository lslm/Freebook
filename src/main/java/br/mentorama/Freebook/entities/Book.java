package br.mentorama.Freebook.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String ano;

    @Column(nullable = false)
    private String synopsis;

    @Column(nullable = false)
    private String edition;

    @Column(nullable = false)
    private String publisher;

    public Book() {}

    public Book(String title, String author, String gender, String isbn, String ano, String synopsis, String edition, String publisher) {
        this.title = title;
        this.author = author;
        this.gender = gender;
        this.isbn = isbn;
        this.ano = ano;
        this.synopsis = synopsis;
        this.edition = edition;
        this.publisher = publisher;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", gender='" + gender + '\'' +
                ", isbn='" + isbn + '\'' +
                ", ano='" + ano + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", edition='" + edition + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
