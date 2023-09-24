package com.example.JobPortal.services;

import com.example.JobPortal.model.Job;
import com.example.JobPortal.repository.IJobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceByCRUDRepo {
    @Autowired
    IJobRepo jobRepo;


    public String addJobs(List<Job> jobs) {
        Iterable<Job> listOfJobs = jobRepo.saveAll(jobs);
        if ( listOfJobs != null ) {
            return "Jobs added successfully";
        }
        else {
            return "Job not added";
        }
    }

    public Iterable<Job> getAllJobs() {
        return jobRepo.findAll();
    }

    public String deleteByJobId(String jobId) {
        long job_id = Long.parseLong(jobId);

        Optional<Job> list = jobRepo.findById(job_id);

        if ( !(list.isEmpty())) {
            jobRepo.deleteById(job_id);
            return "Job with jobId " + jobId + " deleted successfully";
        }
        else {
            return "Job with jobId " + jobId + " cannot be found";
        }

//        jobRepo.deleteById(jobId);
    }

    public String updateJobByJobId(Job job, String jobId) {
        long job_id = Long.parseLong(jobId);

        Optional<Job> list = jobRepo.findById(job_id);
        if ( !(list.isEmpty())) {
            job.setId(job_id);
            jobRepo.save(job);
            return "Job with jobId " + jobId + " updated successfully";
        }
        else {
            return "Job with jobId " + jobId + " cannot be found";
        }
    }
}
