package br.com.biblioteca.model;

public class Livros {

    private String id;
    private String titulo;
    private String autor;
    private String isbn;
    private String quantidade;
    private String editora;
    private String anoPublicacao;
    private String sinopse;
    private String categoria;
    private String image;
    private String location;

    public Livros(){

    }

    public Livros(String titulo, String autor, String isbn, String editora, String quantidade, String anoPublicacao, String sinopse, String categoria, String image, String location){
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
        this.autor = autor;
        this.isbn = isbn;
        this.quantidade = quantidade;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.categoria = categoria;
        this.image = image;
        this.location = location;
    }

    public Livros(String titulo, String autor, String isbn, String editora, String quantidade, String anoPublicacao, String id, String sinopse, String categoria, String image, String location){
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
        this.autor = autor;
        this.isbn = isbn;
        this.quantidade = quantidade;
        this.titulo = titulo;
        this.id = id;
        this.sinopse = sinopse;
        this.categoria = categoria;
        this.image = image;
        this.location = location;
    }

    public String getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(String anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getId() {
        return id;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
