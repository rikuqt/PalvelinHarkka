package com.harkka.harkkatyo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HenkiloRepository extends JpaRepository<Henkilo, Long> {
    List<Henkilo> findHenkilotByTapahtumatId(Long tapahtumaId);
}