package com.jonnes.SpringREST_JobAPP.service;

import com.jonnes.SpringREST_JobAPP.model.JobPost;
import com.jonnes.SpringREST_JobAPP.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    public JobRepo repo;

    public void addjob(JobPost jobPost){
        repo.save(jobPost);
    }
    public List<JobPost> getAlljobs(){
      return repo.findAll();
    }

    public JobPost getJob(int postId) {
        return repo.findById(postId).orElse(new JobPost());
    }

    public void updatejob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deletejob(int postId) {
        repo.deleteById(postId);
    }
}
