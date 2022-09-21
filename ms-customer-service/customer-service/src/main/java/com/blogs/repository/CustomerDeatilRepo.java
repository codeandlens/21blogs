/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.blogs.entity.CustomerDetail;

@Repository
public interface CustomerDeatilRepo
	extends PagingAndSortingRepository<CustomerDetail, Integer>, JpaSpecificationExecutor<CustomerDetail> {

    public List<CustomerDetail> findByFbLoginId(String fbLoginId);
}
