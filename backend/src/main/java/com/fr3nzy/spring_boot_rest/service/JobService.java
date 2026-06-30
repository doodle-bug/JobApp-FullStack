package com.fr3nzy.spring_boot_rest.service;


import com.fr3nzy.spring_boot_rest.model.JobPost;
import com.fr3nzy.spring_boot_rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost){
        repo.save(jobPost);
//        here jobPost kind of object is called DTO - Data Transfer Object
    }

    public List<JobPost> getAllJobs(){
        return repo.findAll();
    }

    public JobPost getJob(int postId) {

        return repo.findById(postId).orElse(new JobPost());
        // if not found return an empty jobPost instead of throwing an exception
    }

    public void updateJob(JobPost jobPost){
        repo.save(jobPost);

    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }

    public void load() {
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
                new JobPost(1, "Java Developer",
                        "Looking for an experienced Java developer to work on enterprise applications",
                        3,
                        List.of("Java", "Spring Boot", "MySQL", "REST API")),
                new JobPost(2, "Frontend Developer",
                        "Seeking a creative frontend developer with strong UI/UX skills",
                        2,
                        List.of("React", "JavaScript", "HTML", "CSS", "Tailwind")),
                new JobPost(3, "Full Stack Developer",
                        "Full stack developer needed for building scalable web applications",
                        5,
                        List.of("Java", "Spring", "Angular", "PostgreSQL", "Docker")),
                new JobPost(4, "DevOps Engineer",
                        "DevOps engineer to manage CI/CD pipelines and cloud infrastructure",
                        4,
                        List.of("AWS", "Jenkins", "Kubernetes", "Terraform", "Linux")),
                new JobPost(5, "Data Scientist",
                        "Data scientist to analyze data and build machine learning models",
                        3,
                        List.of("Python", "TensorFlow", "Pandas", "SQL", "Jupyter"))
        ));

        repo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
