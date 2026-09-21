package com.example.tuwaiqlab10.Repository;

import com.example.tuwaiqlab10.Model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost, Integer> {

    JobPost findJobPostById(Integer id);
}
