package com.projeto.loja;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class ProdutoController {

    @Autowired
    ProdutoRepository bd;

    @PostMapping("/api/produtos/novo")
    public String gravar(@RequestBody Produto obj) {
        bd.save(obj);
        return "O produto " + obj.getNome() + " foi gravado!";
    }

    @PutMapping("/api/produtos/{id}")
    public String alterar(@PathVariable int id, @RequestBody Produto obj) {
        Optional<Produto> produtoExistente = bd.findById(id);
        if (produtoExistente.isPresent()) {
            obj.setId(id); 
            bd.save(obj); 
            return "O produto " + obj.getNome() + " foi alterado!";
        }
        return "Produto com ID " + id + " não encontrado!";
    }

    @GetMapping("/api/produtos/{id}")
    public Produto carregar(@PathVariable int id) {
        Optional<Produto> obj = bd.findById(id);
        return obj.orElse(null); 
    }

    
    @DeleteMapping("/api/produtos/{id}")
    public String remover(@PathVariable int id) {
        bd.deleteById(id);
        return "Produto " + id + " removido com sucesso!";
    }

    
    @GetMapping("/api/produtos")
    public List<Produto> todos() {
        return bd.findAll();
    }
}
