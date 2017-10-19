package lab.aikibo.crudspringbootangular.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "app_user")
@ToString
public class User implements Serializable {

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
