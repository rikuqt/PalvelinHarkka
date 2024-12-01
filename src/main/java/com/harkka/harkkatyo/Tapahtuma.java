package com.harkka.harkkatyo;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Tapahtuma extends AbstractPersistable<Long> {
    private String tapahtumaNimi;
    private String tapahtumaPaikka;
    private String mista;
    private String mihin;
}
