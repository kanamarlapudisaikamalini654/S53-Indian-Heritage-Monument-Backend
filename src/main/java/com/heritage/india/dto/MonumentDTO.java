package com.heritage.india.dto;

import lombok.Data;
import java.util.List;

@Data
public class MonumentDTO {
    private Long id;
    private String name;
    private String location;
    private String era;
    private String description;
    private String imageUrl;
    private List<String> facts;

    // You can add extra fields here that aren't in the database 
    // but are helpful for the UI, like a formatted string.
    private String displayTitle; 
}