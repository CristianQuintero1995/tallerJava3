package co.com.bancolombia.usecase.animalescase;

import co.com.bancolombia.model.animales.Animales;
import co.com.bancolombia.model.animales.gateways.AnimalesRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

@AllArgsConstructor
public class AnimalesCaseUseCase {

    private AnimalesRepository animalesRepository;

    public void create(Animales animales){
        animalesRepository.create(animales);
    }

    public List<Animales> getAll(){
        return animalesRepository.getAll();
    }

    public void delete(String id){
        animalesRepository.delete(id);
    }

    public Animales update(String id, Animales animales) throws Exception{
        Animales animales1 = animalesRepository.update(id, animales);
        return animales1;
    }

    public Animales read(String id){
        return animalesRepository.read(id);
    }
    }
