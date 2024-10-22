package br.com.biblioteca.model;

public class Livros {

    private int id;
    private String titulo;
    private String autor;
    private String isbn;
    private int quantidade;
    private String editora;
    private int anoPublicacao;

    public Livros(){

    }

    public Livros(String titulo, String autor, String isbn, String editora, int quantidade, int anoPublicacao){
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
        this.autor = autor;
        this.isbn = isbn;
        this.quantidade = quantidade;
        this.titulo = titulo;
    }

    public Livros(String titulo, String autor, String isbn, String editora, int quantidade, int anoPublicacao, int id){
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
        this.autor = autor;
        this.isbn = isbn;
        this.quantidade = quantidade;
        this.titulo = titulo;
        this.id = id;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
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

    public int getId() {
        return id;
    }
}
