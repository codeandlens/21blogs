package com.blogs.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.blogs.entity.CustomerDetail;
import com.blogs.model.CustomerDetailModel;
import com.blogs.model.CustomerSearchRequestModel;
import com.blogs.model.RequestModel;
import com.blogs.model.ResponseModel;
import com.blogs.repository.CustomerDeatilRepo;
import com.blogs.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDeatilRepo repository;

    @Override
    public CustomerDetail saveCustomer(CustomerDetail entity) {
	CustomerDetail result = repository.save(entity);
	return result;
    }

    @Override
    public CustomerDetail getCustomerById(Integer id) {
	CustomerDetail result = repository.findById(id).orElse(null);
	return result;
    }

    @Override
    public void deleteCustomerById(Integer id) {
	repository.deleteById(id);
    }
    
    @Override
    public ResponseModel<List<CustomerDetailModel>> searchCustomer(RequestModel<CustomerSearchRequestModel> param) {
	ResponseModel<List<CustomerDetailModel>> result = new ResponseModel<>();
	CustomerSearchRequestModel searchParam = param.getCriteria();
	Specification<CustomerDetail> specification = new Specification<CustomerDetail>() {
	    private static final long serialVersionUID = 1L;

	    @Override
	    public Predicate toPredicate(Root<CustomerDetail> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
		Predicate andPredicate = cb.conjunction();
		Predicate orPredicate = cb.disjunction();
		

		if (searchParam != null && searchParam.getIsByPhoneNo() != null && searchParam.getIsByPhoneNo()
			&& StringUtils.isNotEmpty(searchParam.getSearchText())) {
		    orPredicate.getExpressions().add(cb.like(root.get("telNo"), "%" + searchParam.getSearchText() + "%"));
		}

//		if (searchParam != null && searchParam.getIsByNid() != null && searchParam.getIsByNid()
//			&& StringUtils.isNotEmpty(searchParam.getSearchText())) {
//		    orPredicate.getExpressions().add(cb.like(root.get("citizenId"), "%" + searchParam.getSearchText() + "%"));
//		}

		if (searchParam != null && searchParam.getIsByName() && StringUtils.isNotEmpty(searchParam.getSearchText())) {
		    orPredicate.getExpressions().add(cb.like(cb.lower(cb.concat(cb.concat(cb.concat(cb.concat(cb.coalesce(root.get("firstName"),"")," "), cb.coalesce(root.get("lastName"),""))," "),cb.coalesce(root.get("nickName"),""))),
			    "%" + searchParam.getSearchText().toLowerCase() + "%"));
		}
		
		if(!orPredicate.getExpressions().isEmpty()) {
		    andPredicate.getExpressions().add(cb.and(orPredicate));
		}

//		if (param != null && StringUtils.isNotBlank(searchParam.getSortBy())) {
//		    cq.orderBy(cb.desc(root.get(searchParam.getSortBy())));
//		}
		
		return andPredicate;
	    }
	};
	
	Page<CustomerDetail> pages = repository.findAll(specification,
		PageRequest.of(param.getPage(), param.getSize()));
	List<CustomerDetailModel> dataList = new ArrayList<CustomerDetailModel>();
	if (pages != null && !pages.getContent().isEmpty()) {
	    for (CustomerDetail src : pages.getContent()) {
		CustomerDetailModel target = new CustomerDetailModel();
		BeanUtils.copyProperties(src, target);
		dataList.add(target);
	    }
	}
	result.setData(dataList);
	result.setTotalElements(pages.getTotalElements());
	result.setTotalPages(pages.getTotalPages());
	return result;
    }

}
