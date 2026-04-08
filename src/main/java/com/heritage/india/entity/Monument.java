package com.heritage.india.entity;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "monuments")
public class Monument {

    // 🔑 Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 📌 Basic Info
    private String name;
    private String location;
    private String era;

    // 📄 Description
    @Column(columnDefinition = "TEXT")
    private String description;

    // 🖼️ Main Image
    @JsonProperty("image_url")   // Maps to frontend JSON key
    @Column(name = "image_url")
    private String imageUrl;

    // 📝 Short Description
    @JsonProperty("short_desc")  // Maps to frontend JSON key
    @Column(name = "short_desc")
    private String shortDesc;

    // 🌍 Extra Info
    private String region;
    private String type;
    private String year;

    // 🌐 Virtual Tour URL (NEW CHANGE)
    @JsonProperty("tour_url")    // Maps to frontend JSON key
    @Column(name = "tour_url", columnDefinition = "TEXT")
    private String tourUrl;

    // 🖼️ Gallery Images (Multiple Images)
    @ElementCollection
    @CollectionTable(
        name = "monument_gallery",
        joinColumns = @JoinColumn(name = "monument_id", foreignKey = @ForeignKey(name = "FK_MONUMENT"))
    )
    private List<String> gallery;

    // ✅ Default Constructor
    public Monument() {}

    // ================= GETTERS & SETTERS ================= //

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEra() {
        return era;
    }

    public void setEra(String era) {
        this.era = era;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTourUrl() {
        return tourUrl;
    }

    public void setTourUrl(String tourUrl) {
        this.tourUrl = tourUrl;
    }

    public List<String> getGallery() {
        return gallery;
    }

    public void setGallery(List<String> gallery) {
        this.gallery = gallery;
    }
}