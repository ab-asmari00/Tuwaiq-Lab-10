package com.example.tuwaiqlab10.Service;

import com.example.tuwaiqlab10.Model.JobPost;
import com.example.tuwaiqlab10.Repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {

    private final JobPostRepository jobPostRepository;

    public List<JobPost> getAllJobPosts() {
        return jobPostRepository.findAll();
    }

    public void addJobPost(JobPost jobPost) {
        jobPostRepository.save(jobPost);
    }

    public boolean updateJobPost(Integer id, JobPost jobPost) {
        JobPost oldJobPost = jobPostRepository.findJobPostById(id);
        if (oldJobPost == null) {
            return false;
        }

        oldJobPost.setTitle(jobPost.getTitle());
        oldJobPost.setDescription(jobPost.getDescription());
        oldJobPost.setLocation(jobPost.getLocation());
        oldJobPost.setSalary(jobPost.getSalary());
        jobPostRepository.save(oldJobPost);
        return true;
    }

    public boolean deleteJobPost(Integer id) {
        JobPost jobPost = jobPostRepository.findJobPostById(id);
        if (jobPost == null) {
            return false;
        }

        jobPostRepository.delete(jobPost);
        return true;
    }
}
