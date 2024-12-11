package com.harkka.harkkatyo;


import ch.qos.logback.classic.encoder.JsonEncoder;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;


@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Account extends AbstractPersistable<Long> {

    private String username;
    private String password;

}