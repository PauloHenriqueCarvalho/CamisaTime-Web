/*
 * To cHange this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Paulo
 */
public class CarrinhoProduto {
    private int idCarrinhoProduto;
    private int carrinho;
    private int produto;
    private String tamanhoSelecionado;

    public CarrinhoProduto() {
    }

    public CarrinhoProduto(int idCarrinhoProduto, int carrinho, int produto, String tamanhoSelecionado) {
        this.idCarrinhoProduto = idCarrinhoProduto;
        this.carrinho = carrinho;
        this.produto = produto;
        this.tamanhoSelecionado = tamanhoSelecionado;
    }

    public int getIdCarrinhoProduto() {
        return idCarrinhoProduto;
    }

    public void setIdCarrinhoProduto(int idCarrinhoProduto) {
        this.idCarrinhoProduto = idCarrinhoProduto;
    }

    public int getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(int carrinho) {
        this.carrinho = carrinho;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public String getTamanhoSelecionado() {
        return tamanhoSelecionado;
    }

    public void setTamanhoSelecionado(String tamanhoSelecionado) {
        this.tamanhoSelecionado = tamanhoSelecionado;
    }

     
    
}
