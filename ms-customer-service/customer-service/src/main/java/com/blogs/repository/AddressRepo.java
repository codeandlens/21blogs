/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.blogs.entity.Address;

@Repository
public interface AddressRepo extends PagingAndSortingRepository<Address, Integer>, JpaSpecificationExecutor<Address> {

    public Address findByCustomerId(Integer id);

}