package br.com.fiap.springpfentregas.resource;


import br.com.fiap.springpfentregas.entity.Produto;
import br.com.fiap.springpfentregas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/produto")
public class ProdutoResource {

    @Autowired
    private ProdutoRepository repo;

    @GetMapping
    public List<Produto> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Produto findById(@PathVariable Long id) {
        return repo.findById( id ).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Produto save(@RequestBody Produto produto) {
        if(Objects.isNull(produto)) return null;
        produto.setId(null);

        return repo.save(produto);
    }
}
