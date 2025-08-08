package com.jonnes.SpringREST_JobAPP;

import com.jonnes.SpringREST_JobAPP.model.JobPost;
import com.jonnes.SpringREST_JobAPP.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class JobRestController {

    @Autowired
    JobService service;


    @GetMapping("jobPosts")

    public List<JobPost> getAlljobs(){
        return service.getAlljobs();
    }
}
