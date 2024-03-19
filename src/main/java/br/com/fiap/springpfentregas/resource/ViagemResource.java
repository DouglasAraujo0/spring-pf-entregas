package br.com.fiap.springpfentregas.resource;

import br.com.fiap.springpfentregas.entity.Viagem;
import br.com.fiap.springpfentregas.repository.ViagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/viagem")

public class ViagemResource {

    @Autowired
    private ViagemRepository repo;
    @GetMapping
    public List<Viagem> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Viagem findById(@PathVariable Long id) {
        return repo.findById( id ).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Viagem save(@RequestBody Viagem viagem) {
        if (Objects.isNull(viagem)) return null;
        viagem.setId( null );

        return repo.save( viagem );
    }
}
