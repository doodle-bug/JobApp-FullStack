package com.fr3nzy.spring_boot_rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
//this will help you so you don't  have to create getter, setters and toString method'
@NoArgsConstructor
//this will tell that there is no default constructor
@AllArgsConstructor
//this will tell that it will take all the constructor as input

@Component
//this will make the below method as java managed component
@Entity
public class JobPost {
    @Id
    private int postId;
    private String postProfile;
    private String postDesc;
    private int reqExperience;
    private List<String> postTechStack;


}
