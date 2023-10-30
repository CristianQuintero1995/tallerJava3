package co.com.bancolombia.jpa;

import co.com.bancolombia.model.animales.Animales;
import co.com.bancolombia.model.animales.gateways.AnimalesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class JpaAnimalesImpl implements AnimalesRepository {
    private JPARepositoryAdapter jpaRepositoryAdapter;

    @Override
    public void create(Animales animales){
        String id = UUID.randomUUID().toString();
        animales.setId(id);
        jpaRepositoryAdapter.save(animales);
    }

    @Override
    public Animales read(String id) {
        return jpaRepositoryAdapter.findById(id);
    }

    @Override
    public Animales update(String id, Animales animales) throws Exception{
        Animales animalesDb = jpaRepositoryAdapter.findById(id);
        if(animalesDb == null) throw new Exception("Animal not found :" + id);
        animalesDb.setSpecie(animales.getSpecie());
        animalesDb.setGender(animales.getGender());
        animalesDb.setNumLeg(animales.getNumLeg());
        animalesDb.setHabitat(animales.getHabitat());
        animalesDb.setDomestic(animales.isDomestic());

        jpaRepositoryAdapter.save(animalesDb);

        return animalesDb;
    }

    @Override
    public void delete(String id) {
        jpaRepositoryAdapter.deleteById(id) ;
    }

    @Override
    public List<Animales> getAll(){

        return jpaRepositoryAdapter.findAll();
    }
}
