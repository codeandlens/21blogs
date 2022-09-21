package com.blogs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.entity.Address;
import com.blogs.repository.AddressRepo;
import com.blogs.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepo repository;

    @Override
    public Address saveAddress(Address entity) {
	Address address = repository.save(entity);
	return address;
    }

    @Override
    public Address getAddressById(Integer id) {
	Address address = repository.findById(id).orElse(null);
	return address;
    }

    @Override
    public Address getAddressByCustomerId(Integer id) {
	Address address = repository.findByCustomerId(id);
	return address;
    }

    @Override
    public void deleteAddressById(Integer id) {
	repository.deleteById(id);
    }

    @Override
    public void deleteAddressByCustomerId(Integer customerId) {
	Address address = getAddressByCustomerId(customerId);
	if (address != null) {
	    repository.delete(address);
	}
    }

}
