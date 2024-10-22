package br.com.biblioteca.model;

public class Emprestimo {

    private int id;
    private String status;


    public Emprestimo(String status) {
        this.status = status;
    }

    public Emprestimo(String status, int id) {
        this.status = status;
        this.id = id;
    }

    public Emprestimo() {
    }

    public String getStatus() {
        return status;
    }
}
