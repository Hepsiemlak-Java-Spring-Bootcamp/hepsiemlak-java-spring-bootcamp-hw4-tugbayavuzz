package emlakburada.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Integer id;
    private String email;


}
