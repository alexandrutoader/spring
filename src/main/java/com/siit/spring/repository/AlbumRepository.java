package com.siit.spring.repository;

import com.siit.spring.domain.entity.AlbumEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {
    @Query("select a from AlbumEntity a " +
            "order by a.title")
    List<AlbumEntity> getAll();
}
