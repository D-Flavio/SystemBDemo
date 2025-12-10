package com.example.systemBDemo.repository;

import com.example.systemBDemo.entity.ZTPSPFEntity;
import org.springframework.data.repository.CrudRepository;

public interface ZTPSPFRepository extends CrudRepository<ZTPSPFEntity, Integer> {

    ZTPSPFEntity findById(int id);
}
