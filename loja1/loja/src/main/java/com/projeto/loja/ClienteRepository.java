package com.projeto.loja;
import com.projeto.loja.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    boolean existsByEmailAndSenha(String email, String senha);
    boolean existsByEmail(String email);
}