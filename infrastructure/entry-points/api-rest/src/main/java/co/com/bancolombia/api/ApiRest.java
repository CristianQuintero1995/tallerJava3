package co.com.bancolombia.api;
import co.com.bancolombia.model.animales.Animales;
import co.com.bancolombia.usecase.animalescase.AnimalesCaseUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@ResponseBody
public class ApiRest {

    private final AnimalesCaseUseCase animalesCaseUseCase;


    @GetMapping(path = "/readanimales/{id}")
    public Animales read(@PathVariable String id) {
        return animalesCaseUseCase.read(id);
    }

    @PostMapping(path = "/createanimales")
    public void create(@RequestBody Animales animales){
        animalesCaseUseCase.create(animales);
    }

    @PutMapping(path = "/updateanimales/{id}")
    public Animales update(@PathVariable String id, @RequestBody Animales animales){
        try{
            animalesCaseUseCase.update(id, animales);
            return animales;
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping(path = "/deleteanimales/{id}")
    public void delete(@PathVariable String id) {
            animalesCaseUseCase.delete(id);
    }

    @GetMapping(path = "/animales")
    public List<Animales> getAll() {
        return animalesCaseUseCase.getAll();
    }
}
