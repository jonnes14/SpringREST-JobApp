package com.jonnes.SpringREST_JobAPP;

import com.jonnes.SpringREST_JobAPP.model.JobPost;
import com.jonnes.SpringREST_JobAPP.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class JobRestController {

    @Autowired
    JobService service;

    @GetMapping("jobPost")
    public List<JobPost> getAlljobs(){
        return service.getAlljobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable int postId){
        return service.getJob(postId);
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchKeyword(@PathVariable String keyword){
        return service.search(keyword);
    }

    @PostMapping("jobPost")
    public void addjob(@RequestBody JobPost jobPost){
        service.addjob(jobPost);
    }

    @PutMapping("jobPost")
    public void updatejob(@RequestBody JobPost jobPost){
        service.updatejob(jobPost);
    }

    @DeleteMapping("jobPost/{postId}")
    public String deletejob(@PathVariable int postId){
        service.deletejob(postId);
        return "deleted";
    }
}
