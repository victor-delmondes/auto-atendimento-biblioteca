package br.com.biblioteca.model;

public class Emprestimo {
    private String idEmprestimo;
    private String idUsuarios;
    private String idLivro;
    private String dataEmprestimo;
    private String dataDevolucao;
    private String status;

    public Emprestimo() {
    }

    public Emprestimo(String idEmprestimo, String idUsuarios, String idLivro, String dataEmprestimo, String dataDevolucao, String status) {
        this.idEmprestimo = idEmprestimo;
        this.idUsuarios = idUsuarios;
        this.idLivro = idLivro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
    }

    public Emprestimo(String idUsuarios, String idLivro, String dataEmprestimo, String dataDevolucao, String status) {
        this.idUsuarios = idUsuarios;
        this.idLivro = idLivro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
    }

    public String getIdEmprestimo() {
        return idEmprestimo;
    }

    public String getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(String idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(String idLivro) {
        this.idLivro = idLivro;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
