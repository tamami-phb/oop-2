package lab.aikibo.entity;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @NonNull
    private Long id;

    @Getter @Setter @NonNull
    private String name;

    @Getter @Setter @NonNull
    private Integer age;

    @Getter @Setter @NonNull
    private BigDecimal salary;

}
