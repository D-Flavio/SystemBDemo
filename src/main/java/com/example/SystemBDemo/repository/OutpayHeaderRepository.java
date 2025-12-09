package com.example.SystemBDemo.repository;

import com.example.SystemBDemo.entity.OutpayHeaderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OutpayHeaderRepository extends CrudRepository<OutpayHeaderRepository, Integer> {

    OutpayHeaderEntity findById(int id);
}
