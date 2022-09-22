/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.blogs.entity.CustomerDetail;

@Repository
public interface CustomerDeatilRepo
	extends PagingAndSortingRepository<CustomerDetail, Integer>, JpaSpecificationExecutor<CustomerDetail> {

	@Query(value ="SELECT * FROM CUSTOMER_DETAIL ORDER BY LAST_MODIFIED_DATE DESC LIMIT 1", nativeQuery = true)
	public CustomerDetail getLastest();
	
	public CustomerDetail findCustomerDetailByUsername(String username);
	
	
}
