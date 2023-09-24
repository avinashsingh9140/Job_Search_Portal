package com.example.JobPortal.repository;

import com.example.JobPortal.model.Job;
import com.example.JobPortal.model.JobType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJobRepo extends CrudRepository<Job,Long> {
    public List<Job> findByJobType(JobType jobType);

    public List<Job> findByTitleAndLocation(String title, String location);

    public List<Job> findBySalaryGreaterThan(Double salary);

    public List<Job> findByDescriptionOrLocation(String description, String location);

    @Modifying
    @Query(value = "Delete from Jobs where company_name = :companyName " , nativeQuery = true)
    public void deleteByCompanyName(String companyName);


    @Modifying
    @Query(value = "update Jobs set salary = :jobSalary where id = :job_Id" , nativeQuery = true)
    public void updateSalaryBasedOnId(Long job_Id , Double jobSalary);

    public List<Job> findByCompanyName(String companyName);


    @Query(value = "select * from Jobs where job_type = :jobType", nativeQuery = true)
    public List<Job> getJobsByType(String jobType);

    @Query(value = "select * from Jobs where salary > :expSalary", nativeQuery = true)
    public List<Job> getBySalary(Double expSalary);

}
