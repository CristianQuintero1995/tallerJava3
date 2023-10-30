package co.com.bancolombia.model.animales.gateways;

import co.com.bancolombia.model.animales.Animales;
import reactor.core.publisher.Mono;

import java.util.List;

public interface AnimalesRepository {

    void create(Animales animales);
    List<Animales> getAll();
    void delete(String id);
    default Animales update(String id, Animales animales) throws Exception{
        return animales;
    };
    Animales read(String id);

}
