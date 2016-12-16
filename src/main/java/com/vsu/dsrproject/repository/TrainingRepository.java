package com.vsu.dsrproject.repository;

import com.vsu.dsrproject.entity.Training;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends CrudRepository<Training, Long> {
    Training findByName(String name);



}
