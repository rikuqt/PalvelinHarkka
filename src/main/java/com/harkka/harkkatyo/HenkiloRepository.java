package com.harkka.harkkatyo;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HenkiloRepository extends JpaRepository<Henkilo, Long> {
    List<Henkilo> findHenkilotByTapahtumatId(Long tapahtumaId);

    Optional<Henkilo> findByNimi(String nimi);

    @EntityGraph(attributePaths = {"tapahtumat"})
    List<Henkilo> findAll();
}