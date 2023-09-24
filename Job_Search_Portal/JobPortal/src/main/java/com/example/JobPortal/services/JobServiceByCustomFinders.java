package com.example.JobPortal.services;

import com.example.JobPortal.model.Job;
import com.example.JobPortal.model.JobType;
import com.example.JobPortal.repository.IJobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceByCustomFinders {
    @Autowired
    IJobRepo jobRepo;

    public List<Job> getByJobType(JobType jobType) {
        return jobRepo.findByJobType(jobType);
    }

    public List<Job> getByTitleAndLocation(String title, String location) {
        return jobRepo.findByTitleAndLocation(title,location);
    }

    public List<Job> getBySalary(String salary) {
        double newSalary = Double.parseDouble(salary);
        return jobRepo.findBySalaryGreaterThan(newSalary);
    }

    public List<Job> getByDescOrLocation(String description, String location) {
        return jobRepo.findByDescriptionOrLocation(description, location);
    }
}
