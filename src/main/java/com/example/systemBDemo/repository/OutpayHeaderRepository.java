package com.example.systemBDemo.repository;

import com.example.systemBDemo.entity.OutpayHeaderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OutpayHeaderRepository extends CrudRepository<OutpayHeaderEntity, Integer> {

    OutpayHeaderEntity findById(int id);
}
