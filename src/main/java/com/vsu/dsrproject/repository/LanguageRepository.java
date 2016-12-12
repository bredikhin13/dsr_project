package com.vsu.dsrproject.repository;

import com.vsu.dsrproject.entity.Language;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
    Language findByName(String name);

    @Query("SELECT l FROM Language l WHERE l.name = ?1")
    Language findByNameHql(String name);
}
