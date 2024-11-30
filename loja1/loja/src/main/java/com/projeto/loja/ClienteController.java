package com.projeto.loja;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/clientes") 
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/novo")
    public ResponseEntity<String> gravar(@RequestBody Cliente obj) {
        if (clienteRepository.existsByEmail(obj.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("E-mail já cadastrado.");
        }
        clienteRepository.save(obj);
        return ResponseEntity.ok("O cliente " + obj.getNome() + " foi gravado!");
    }

    @PutMapping("/{codigo}")
    public String alterar(@PathVariable int codigo, @RequestBody Cliente obj) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(codigo);
        if (clienteExistente.isPresent()) {
            obj.setCodigo(codigo);
            clienteRepository.save(obj);
            return "O cliente " + obj.getNome() + " foi alterado!";
        }
        return "Cliente com código " + codigo + " não encontrado!";
    }

    @GetMapping("/{codigo}")
    public Cliente carregar(@PathVariable int codigo) {
        Optional<Cliente> obj = clienteRepository.findById(codigo);
        return obj.orElse(null);
    }

    @DeleteMapping("/{codigo}")
    public String remover(@PathVariable int codigo) {
        clienteRepository.deleteById(codigo);
        return "Cliente " + codigo + " removido com sucesso!";
    }

    @GetMapping
    public List<Cliente> todos() {
        return clienteRepository.findAll();
    }

    @PostMapping("/login")
    public ResponseEntity<String> validarLogin(@RequestBody LoginRequest loginRequest) {
        boolean isValido = clienteRepository.existsByEmailAndSenha(loginRequest.getEmail(), loginRequest.getSenha());

        if (isValido) {
            return ResponseEntity.ok("Login bem-sucedido!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas.");
        }
    }
}
