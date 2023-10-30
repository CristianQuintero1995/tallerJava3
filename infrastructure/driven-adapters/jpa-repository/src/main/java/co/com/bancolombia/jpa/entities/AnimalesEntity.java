package co.com.bancolombia.jpa.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Setter
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "animales")
public class AnimalesEntity {
    @Id private String id;
    @Column private String specie;
    @Column private char gender;
    @Column private int numLeg;
    @Column private String habitat;
    @Column private boolean domestic;

}
