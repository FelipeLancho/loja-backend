package com.projeto.loja;

public class Cesta {
    public int codigo;
    public Cliente cliente;
    public float total;
    public Item item;
    
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public float getTotal() {
        return total;
    }
    public void setTotal(float total) {
        this.total = total;
    }
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }

    
}
