package com.example.JobPortal.services;

import com.example.JobPortal.model.Job;
import com.example.JobPortal.model.JobType;
import com.example.JobPortal.repository.IJobRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceByCustomQuery {
    @Autowired
    IJobRepo jobRepo;

    @Transactional
    public String deleteByCompanyName(String companyName) {
        List<Job> list = jobRepo.findByCompanyName(companyName);
        if ( list != null ) {
            jobRepo.deleteByCompanyName(companyName);
            return "Jobs with company name " + companyName + " deleted successfully";
        }
        else {
            return "Jobs with company name " + companyName + " Cannot be found";
        }
    }

    @Transactional
    public String updateSalaryBasedOnId(String jobId , String jobSalary ){
        Long job_Id = Long.parseLong(jobId);

        Double job_Salary = Double.parseDouble(jobSalary);

        Optional<Job> list = jobRepo.findById(job_Id);

        if(!(list.isEmpty())){
            jobRepo.updateSalaryBasedOnId(job_Id , job_Salary);
            return "Job with job_Id "+jobId + " updated successfully";
        }else{
            return "Job with job_Id "+jobId + " not found";
        }
    }




    public List<Job> getJobByType(JobType jobType) {
        String job_type = jobType.toString();
        return jobRepo.getJobsByType(job_type);
    }

    public List<Job> getJobsbySalary(String salary) {
        Double JobSalary = Double.parseDouble(salary);
        return jobRepo. getBySalary(JobSalary);
    }
}
