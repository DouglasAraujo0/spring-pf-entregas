package br.com.fiap.springpfentregas.resource;

import br.com.fiap.springpfentregas.entity.Passageiro;
import br.com.fiap.springpfentregas.repository.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/passageiro")
public class PassageiroResource {

    @Autowired
    private PassageiroRepository repo;

    @GetMapping
    public List<Passageiro> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Passageiro findById(@PathVariable Long id) {
        return repo.findById( id ).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Passageiro save(@RequestBody Passageiro passageiro) {
        if(Objects.isNull(passageiro)) return null;
        passageiro.setId(null);

        return repo.save(passageiro);
    }
}