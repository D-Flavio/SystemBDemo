package com.example.SystemBDemo.repository;

import com.example.SystemBDemo.entity.ZTPSPFEntity;
import org.springframework.data.repository.CrudRepository;

public interface ZTPSPFRepository extends CrudRepository<ZTPSPFEntity, Integer> {

    ZTPSPFEntity findById(int id);
}
