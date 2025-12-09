package com.example.SystemBDemo.repository;

import com.example.SystemBDemo.entity.CustomerCompanyPolicyEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerCompanyPolicyRepository extends CrudRepository<CustomerCompanyPolicyEntity, Integer> {

    CustomerCompanyPolicyEntity findById(int id);

}
