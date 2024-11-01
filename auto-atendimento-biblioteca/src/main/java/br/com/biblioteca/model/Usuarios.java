package br.com.biblioteca.model;

import javax.swing.text.StyledEditorKit;

public class Usuarios {

    //Declaração de variaveis
    private String nome, CPF, endereco, telefone, cidade, estado, email, senha;
    private int id;
    private Boolean tipo;

    public Usuarios(){

    }
    public Usuarios(String email, String senha){

    }

    public Usuarios(String nome, String CPF, String endereco, String telefone, String cidade, String estado, String email, String senha, Boolean tipo){
        this.nome = nome;
        this.CPF = CPF;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cidade = cidade;
        this.estado = estado;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    public Usuarios(String nome, String CPF, String endereco, String telefone, String cidade, String estado, String email, String senha, int id, Boolean tipo){
        this.nome = nome;
        this.CPF = CPF;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cidade = cidade;
        this.estado = estado;
        this.email = email;
        this.senha = senha;
        this.id = id;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public int getId() {
        return id;
    }

    public Boolean getTipo() {
        return tipo;
    }
}
