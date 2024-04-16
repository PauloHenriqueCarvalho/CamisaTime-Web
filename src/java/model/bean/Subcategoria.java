/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author paulo
 */
public class Subcategoria {
    private int idSubcategoria;
    private int categoria;
    private String nome;

    public Subcategoria() {
    }

    public Subcategoria(int idSubcategoria, int categoria, String nome) {
        this.idSubcategoria = idSubcategoria;
        this.categoria = categoria;
        this.nome = nome;
    }

    public int getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(int idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
