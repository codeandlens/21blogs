/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.msgb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.blogs.msgb.entity.Queue;

@Repository
public interface QueueRepository extends PagingAndSortingRepository<Queue, Integer>, JpaSpecificationExecutor<Queue> {
    
	@Query(value = "SELECT * FROM Queue WHERE Queue.MAINSERVICENAME  IN (:mainServiceList) "
		+ "AND Queue.LAST_MODIFIED_DATE > parsedatetime(:lastModifiedDate, 'yyyy-MM-dd hh:mm:ss.SSS') ", nativeQuery = true)
	public List<Queue> findByMainServiceNameAndLastModifiedDate(String mainServiceList, String lastModifiedDate);

	@Query("SELECT q FROM Queue q WHERE q.mainServiceName  IN (:mainServiceList) AND q.lastModifiedDate > parsedatetime(:lastModifiedDate, 'yyyy-MM-dd hh:mm:ss.SSS') ")
	public List<Queue> findByMainServiceNameListAndLastModifiedDate(List<String> mainServiceList, String lastModifiedDate);

}
