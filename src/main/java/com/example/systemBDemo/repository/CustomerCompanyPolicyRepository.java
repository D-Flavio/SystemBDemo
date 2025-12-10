package com.example.systemBDemo.repository;

import com.example.systemBDemo.entity.CustomerCompanyPolicyEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerCompanyPolicyRepository extends CrudRepository<CustomerCompanyPolicyEntity, Integer> {

    CustomerCompanyPolicyEntity findById(int id);

}
