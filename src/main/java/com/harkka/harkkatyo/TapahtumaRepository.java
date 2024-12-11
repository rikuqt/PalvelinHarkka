package com.harkka.harkkatyo;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TapahtumaRepository extends JpaRepository<Tapahtuma, Long> {
    List<Tapahtuma> findTapahtumatByHenkilotId(Long henkiloId);

    @EntityGraph(attributePaths = {"henkilot"})
    List<Tapahtuma> findAll();
}