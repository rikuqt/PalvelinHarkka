package com.harkka.harkkatyo;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.ArrayList;
import java.util.List;


@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Tapahtuma extends AbstractPersistable<Long> {
    private String tapahtumaPaikka;
    private String tapahtumaNimi;
    private String mista;
    private String mihin;

    @ManyToMany
    @JoinTable(name = "tapahtuma_henkilot",
            joinColumns = { @JoinColumn(name = "tapahtuma_id") },
            inverseJoinColumns = { @JoinColumn(name = "henkilo_id") })
    private List<Henkilo> henkilot = new ArrayList<>();


}
