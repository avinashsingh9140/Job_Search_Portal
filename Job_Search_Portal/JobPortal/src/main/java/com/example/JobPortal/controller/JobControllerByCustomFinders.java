package com.example.JobPortal.controller;

import com.example.JobPortal.model.Job;
import com.example.JobPortal.model.JobType;
import com.example.JobPortal.services.JobServiceByCustomFinders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/custom")
public class JobControllerByCustomFinders {
    @Autowired
    JobServiceByCustomFinders jobService;

    @GetMapping(value = "/jobs/jobType")
    public List<Job> getByJobType(@RequestParam JobType jobType) {
        return jobService.getByJobType(jobType);
    }
    @GetMapping(value = "/jobs/title/location")
    public List<Job> getByTitleAndLocation(@RequestParam String title,@RequestParam String location ) {
        return jobService.getByTitleAndLocation(title, location);
    }

    @GetMapping(value = "/jobs/salary")
    public List<Job> getBySalary(@RequestParam String salary) {
        return jobService.getBySalary(salary);
    }

    @GetMapping(value = "/jobs/description/location")
    public List<Job> getByDescOrLocation(@RequestParam String description, @RequestParam String location) {
        return jobService.getByDescOrLocation(description,location);
    }
}
