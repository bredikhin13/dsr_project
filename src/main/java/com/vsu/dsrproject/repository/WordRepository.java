package com.vsu.dsrproject.repository;


import com.vsu.dsrproject.entity.Word;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends CrudRepository<Word, Long>{
    Word findByWord(String word);

    @Query(value = "SELECT t FROM Word t WHERE word = ?1")
    Word findByWorldHql(String s);
}
