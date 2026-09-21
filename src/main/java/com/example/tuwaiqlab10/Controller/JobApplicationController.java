package com.example.tuwaiqlab10.Controller;

import com.example.tuwaiqlab10.Api.ApiResponse;
import com.example.tuwaiqlab10.Model.JobApplication;
import com.example.tuwaiqlab10.Service.JobApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/job-application")
@RequiredArgsConstructor
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllJobApplications() {
        return ResponseEntity.status(200).body(jobApplicationService.getAllJobApplications());
    }

    @PostMapping("/apply")
    public ResponseEntity<?> applyForJob(@RequestBody @Valid JobApplication jobApplication,
                                         Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }

        if (!jobApplicationService.addJobApplication(jobApplication)) {
            return ResponseEntity.status(400)
                    .body(new ApiResponse("Invalid user ID or job post ID"));
        }

        return ResponseEntity.status(200).body(new ApiResponse("Job application added successfully"));
    }

    @DeleteMapping("/withdraw/{id}")
    public ResponseEntity<?> withdrawJobApplication(@PathVariable Integer id) {
        if (!jobApplicationService.deleteJobApplication(id)) {
            return ResponseEntity.status(400).body(new ApiResponse("Invalid ID for Job Application"));
        }

        return ResponseEntity.status(200).body(new ApiResponse("Job application withdrawn successfully"));
    }
}
