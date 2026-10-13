
package br.com.fiap.cidadesesg.controller;

import br.com.fiap.cidadesesg.model.Cidade;
import br.com.fiap.cidadesesg.repository.CidadeRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidades")
public class CidadeController {

    private final CidadeRepository repository;

    public CidadeController(CidadeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Cidade> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Cidade buscar(@PathVariable Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new org.springframework.web.server.ResponseStatusException(
                HttpStatus.NOT_FOUND, "Cidade não encontrada"
            ));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cidade cadastrar(@Valid @RequestBody Cidade cidade) {
        cidade.setId(null);
        return repository.save(cidade);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new org.springframework.web.server.ResponseStatusException(
                HttpStatus.NOT_FOUND, "Cidade não encontrada"
            );
        }
        repository.deleteById(id);
    }
}
