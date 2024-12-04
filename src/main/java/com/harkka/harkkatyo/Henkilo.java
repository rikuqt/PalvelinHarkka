package com.harkka.harkkatyo;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.ArrayList;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Henkilo extends AbstractPersistable<Long>{
    private String nimi;

    @ManyToMany(mappedBy = "henkilot")
    private List<Tapahtuma> tapahtumat = new ArrayList<>();
}
