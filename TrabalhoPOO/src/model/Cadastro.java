/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lefoly
 */
public class Cadastro {
    
    private int idCadastro;
    private String nome;
    private String caixa;
    private String quantidade;
    private String preco;

    public Cadastro(String nome, String caixa, String quantidade, String preco) {
        this.nome = nome;
        this.caixa = caixa;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Cadastro() {
//        
    }

    public void setIdCadastro(int idCadastro) {
        this.idCadastro = idCadastro;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCaixa(String caixa) {
        this.caixa = caixa;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public int getIdCadastro() {
        return idCadastro;
    }

    public String getNome() {
        return nome;
    }

    public String getCaixa() {
        return caixa;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public String getPreco() {
        return preco;
    }

    
    @Override
    public String toString() {
        return idCadastro + " | " + nome + " | " + caixa + " | " + quantidade + " | " + preco;
    }
    
}
