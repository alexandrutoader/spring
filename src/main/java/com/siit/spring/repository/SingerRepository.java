package com.siit.spring.repository;

import com.siit.spring.domain.entity.SingerEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SingerRepository extends JpaRepository<SingerEntity, Long> {

    @Query("select s from SingerEntity s " +
            "left join fetch s.albums " +
            "order by s.firstName")
    List<SingerEntity> getAll();
}
