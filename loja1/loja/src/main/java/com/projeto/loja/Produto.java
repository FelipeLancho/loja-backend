package com.projeto.loja;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int codigo;
    public String nome;
    public String descricao;
    public float preco;
    public float precoAntigo;
    public String imagem;
    public float valor;
    public String descritivo;
    public int quantidade;
    public String especificacoes;

    public Produto(){}
    
    public Produto(int codigo, String nome, String descricao, float preco, float precoAntigo, String imagem,
    float valor, String descritivo, int quantidade, String especificacoes){
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.precoAntigo = precoAntigo;
        this.imagem = imagem;
        this.valor = valor;
        this.descritivo = descritivo;
        this.quantidade = quantidade;
        this.especificacoes = especificacoes;
    }
    
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    public float getPrecoAntigo() {
        return precoAntigo;
    }
    public void setPrecoAntigo(float precoAntigo) {
        this.precoAntigo = precoAntigo;
    }
    public String getImagem() {
        return imagem;
    }
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public String getDescritivo() {
        return descritivo;
    }
    public void setDescritivo(String descritivo) {
        this.descritivo = descritivo;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public String getEspecificacoes() {
        return especificacoes;
    }
    public void setEspecificacoes(String especificacoes) {
        this.especificacoes = especificacoes;
    }

    
}
