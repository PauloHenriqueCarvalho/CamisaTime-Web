/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Joao Guilherme
 */
public class ProdutoPedido {
    private int idProdutoPedido;
    private int pedido;
    private int produto;
    private String tamanho;

    public ProdutoPedido() {
    }

    public ProdutoPedido(int idProdutoPedido, int pedido, int produto, String tamanho) {
        this.idProdutoPedido = idProdutoPedido;
        this.pedido = pedido;
        this.produto = produto;
        this.tamanho = tamanho;
    }

    public int getIdProdutoPedido() {
        return idProdutoPedido;
    }

    public void setIdProdutoPedido(int idProdutoPedido) {
        this.idProdutoPedido = idProdutoPedido;
    }

    public int getPedido() {
        return pedido;
    }

    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    
    
    
    
}
