package com.example.JobPortal.controller;

import com.example.JobPortal.model.Job;
import com.example.JobPortal.services.JobServiceByCRUDRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ByCRUD")
public class JobControllerByCRUDRepo {
    @Autowired
    JobServiceByCRUDRepo jobService;

    @PostMapping(value = "/jobs")
    public String addJobs(@Valid @RequestBody List<Job> jobs) {
        return jobService.addJobs(jobs);
    }

    @GetMapping(value = "/jobs")
    public Iterable<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @DeleteMapping(value = "/jobs/{jobId}")
    public String deleteJobByJobId(@PathVariable String jobId) {
        return jobService.deleteByJobId(jobId);
    }

    @PutMapping(value = "/jobs/{jobId}")
    public String updateJobByJobId(@Valid @RequestBody Job job, @PathVariable String jobId) {
        return jobService.updateJobByJobId(job, jobId);
    }
}
