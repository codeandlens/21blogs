/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.blogs.entity.Admin;

@Repository
public interface AdminRepo extends PagingAndSortingRepository<Admin, Integer>, JpaSpecificationExecutor<Admin>{
    
    public Admin findOneByUsername(String username);

}
