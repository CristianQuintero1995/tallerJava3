package co.com.bancolombia.model.animales;
import lombok.*;

@Data
@Setter
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Animales {
    private String id;
    private String specie;
    private char gender;
    private int numLeg;
    private String habitat;
    private boolean domestic;

}