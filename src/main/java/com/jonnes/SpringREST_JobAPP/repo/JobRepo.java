package com.jonnes.SpringREST_JobAPP.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import com.jonnes.SpringREST_JobAPP.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {

    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile,String postDesc);
}