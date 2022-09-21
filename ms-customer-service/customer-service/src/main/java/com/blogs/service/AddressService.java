package com.blogs.service;

import com.blogs.entity.Address;

public interface AddressService {

    public Address saveAddress(Address entity);
    public Address getAddressById(Integer id);
    public Address getAddressByCustomerId(Integer id);
    public void deleteAddressById(Integer id);
    public void deleteAddressByCustomerId(Integer customerId);
}
