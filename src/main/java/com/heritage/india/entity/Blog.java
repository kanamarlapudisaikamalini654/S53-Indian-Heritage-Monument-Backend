package com.heritage.india.entity;



import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "blogs")
@Data // This automatically generates Getters and Setters if you have Project Lombok
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String date; // You can use String for simplicity or LocalDate for advanced logic
    private String category;

    @Column(length = 1000) // Excerpts can be long
    private String excerpt;

    @Column(length = 500) // URLs can be long
    private String image;

    @Column(columnDefinition = "TEXT") // The full story/content
    private String content;
}