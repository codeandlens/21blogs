package com.blogs.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.blogs.entity.User;

@Repository
public interface AdminRepo extends PagingAndSortingRepository<User, Integer>, JpaSpecificationExecutor<User>{
    
    @Query("SELECT u FROM User u WHERE u.username =:username ")
    public User findByUsername(String username);
    
    @Query(value = "SELECT * FROM USER ORDER BY LAST_MODIFIED_DATE DESC LIMIT 1", nativeQuery = true)
    public User getLastest();

}
