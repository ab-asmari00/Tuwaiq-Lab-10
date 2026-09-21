package com.example.tuwaiqlab10.Controller;

import com.example.tuwaiqlab10.Api.ApiResponse;
import com.example.tuwaiqlab10.Model.JobPost;
import com.example.tuwaiqlab10.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/job-post")
@RequiredArgsConstructor
public class JobPostController {

    private final JobPostService jobPostService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllJobPosts() {
        return ResponseEntity.status(200).body(jobPostService.getAllJobPosts());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addJobPost(@RequestBody @Valid JobPost jobPost, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }

        jobPostService.addJobPost(jobPost);
        return ResponseEntity.status(200).body(new ApiResponse("Job post added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateJobPost(@PathVariable Integer id, @RequestBody @Valid JobPost jobPost,
                                           Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }

        if (!jobPostService.updateJobPost(id, jobPost)) {
            return ResponseEntity.status(400).body(new ApiResponse("Invalid ID for Job Post"));
        }

        return ResponseEntity.status(200).body(new ApiResponse("Job post updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJobPost(@PathVariable Integer id) {
        if (!jobPostService.deleteJobPost(id)) {
            return ResponseEntity.status(400).body(new ApiResponse("Invalid ID for Job Post"));
        }

        return ResponseEntity.status(200).body(new ApiResponse("Job post deleted successfully"));
    }
}
