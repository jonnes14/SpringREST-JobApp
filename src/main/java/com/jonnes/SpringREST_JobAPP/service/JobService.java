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
        repo.addjob(jobPost);
    }
    public List<JobPost> getAlljobs(){
      return repo.getAlljobs();
    }

    public JobPost getJob(int postId) {
        return repo.getJob(postId);
    }

    public void updatejob(JobPost jobPost) {
        repo.updatejob(jobPost);
    }

    public void deletejob(int postId) {
        repo.deletejob(postId);
    }
}
