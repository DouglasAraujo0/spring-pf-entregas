package br.com.fiap.springpfentregas.resource;

import br.com.fiap.springpfentregas.entity.Endereco;
import br.com.fiap.springpfentregas.entity.Pessoa;
import br.com.fiap.springpfentregas.repository.EnderecoRepository;
import br.com.fiap.springpfentregas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/endereco")
public class EnderecoResource {

    @Autowired
    private EnderecoRepository repo;

    @Autowired
    private PessoaRepository repoPessoa;

    @GetMapping
    public List<Endereco> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/cep/{cep}")
    public List<Endereco> findByCep(@PathVariable String cep) {
        List<Endereco> end = repo.findAll();
        List<Long> id = new ArrayList<>();
        for (Endereco obj : end ){
            if(obj.getCep().equals(cep)){
                id.add( obj.getId());
            }
        }

        return repo.findAllById(id);
    }

    @GetMapping(value = "/pessoa/{idPessoa}")
    public Endereco findByIdPessoa(@PathVariable Long idPessoa) {
        Pessoa pessoa = repoPessoa.findById(idPessoa).orElseThrow();
        return repo.findById(pessoa.getId()).orElseThrow();

    }

    @Transactional
    @PostMapping
    public Endereco save(@RequestBody Endereco p) {
        if(Objects.isNull(p)) return null;
        p.setId(null);

        return repo.save(p);

    }
}
