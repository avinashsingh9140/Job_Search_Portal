package com.example.JobPortal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Jobs")
@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String title;
    @NotEmpty

    @Length(min = 4, max = 255, message = "Title length should be between 1 and 255")
    private String description;
    @NotEmpty
    private String location;
    @NotNull
    private Double salary;

    @Column(name = "company_name")
    private String companyName;
    @Column(name = "employer_name")
    private String employerName;

    @Enumerated(EnumType.STRING)
    @Column(name = "job_type")
    private JobType jobType;
    @Column(name = "applied_date")
    private LocalDate appliedDate;
}
