/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.blogs.entity.Admin;

@Repository
public interface AdminRepo extends PagingAndSortingRepository<Admin, Integer>, JpaSpecificationExecutor<Admin>{
    
    @Query("SELECT u FROM User u WHERE u.username =:username ")
    public Admin findByUsername(String username);

    @Query(value = "SELECT * FROM USER ORDER BY LAST_MODIFIED_DATE DESC LIMIT 1", nativeQuery = true)
    public Admin getLastest();
}
