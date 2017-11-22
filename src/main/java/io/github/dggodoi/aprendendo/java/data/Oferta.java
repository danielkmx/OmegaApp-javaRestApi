/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dggodoi.aprendendo.java.data;

import java.util.List;

/**
 *
 * @ kmx
 */
public class Oferta {
    private int id;
    private String categoria;
    private String titulo;   
    private String descricao_oferta;
    private String anunciante;
    private double valor;
    private String destaque;
    private String imagens;

    public String getImagens() {
        return imagens;
    }

    public void setImagens(String imagens) {
        this.imagens = imagens;
    }

    public String getDestaque() {
        return destaque;
    }

    public void setDestaque(String destaque) {
        this.destaque = destaque;
    }
 

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public String toString() {
        return "Oferta{" + "id=" + id + ", categoria=" + categoria + ", titulo=" + titulo + ", descricao_oferta=" + descricao_oferta + ", anunciante=" + anunciante + ", valor=" + valor + ", destaque=" + destaque + ", imagens=" + imagens + '}';
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Oferta other = (Oferta) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
     public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao_oferta() {
        return descricao_oferta;
    }

    public void setDescricao_oferta(String descricao_oferta) {
        this.descricao_oferta = descricao_oferta;
    }

    public String getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(String anunciante) {
        this.anunciante = anunciante;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    } 

   

  
    
}
