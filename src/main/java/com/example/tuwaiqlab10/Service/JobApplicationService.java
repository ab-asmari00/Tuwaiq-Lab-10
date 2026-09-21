package com.example.tuwaiqlab10.Service;

import com.example.tuwaiqlab10.Model.JobApplication;
import com.example.tuwaiqlab10.Repository.JobApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;

    public List<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();
    }

    public void addJobApplication(JobApplication jobApplication) {
        jobApplicationRepository.save(jobApplication);
    }

    public boolean deleteJobApplication(Integer id) {
        JobApplication jobApplication = jobApplicationRepository.findJobApplicationById(id);
        if (jobApplication == null) {
            return false;
        }

        jobApplicationRepository.delete(jobApplication);
        return true;
    }
}
