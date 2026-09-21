package com.example.tuwaiqlab10.Service;

import com.example.tuwaiqlab10.Model.JobApplication;
import com.example.tuwaiqlab10.Repository.JobApplicationRepository;
import com.example.tuwaiqlab10.Repository.JobPostRepository;
import com.example.tuwaiqlab10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    private final JobPostRepository jobPostRepository;
    private final UserRepository userRepository;

    public List<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();
    }

    public boolean addJobApplication(JobApplication jobApplication) {
        if (userRepository.findUserById(jobApplication.getUserId()) == null || jobPostRepository.findJobPostById(jobApplication.getJobPostId()) == null) {
            return false;
        }

        jobApplicationRepository.save(jobApplication);
        return true;
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
