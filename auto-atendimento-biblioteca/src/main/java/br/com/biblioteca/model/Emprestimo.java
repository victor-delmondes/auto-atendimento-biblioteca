package br.com.biblioteca.model;

import java.sql.Date;

public class Emprestimo {
    private int idEmprestimo;
    private int idUsuarios;
    private int idLivro;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private String status;

    public Emprestimo() {
    }

    public Emprestimo(int idEmprestimo, int idUsuarios, int idLivro, Date dataEmprestimo, Date dataDevolucao, String status) {
        this.idEmprestimo = idEmprestimo;
        this.idUsuarios = idUsuarios;
        this.idLivro = idLivro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
    }

    public Emprestimo(int idUsuarios, int idLivro, Date dataEmprestimo, Date dataDevolucao, String status) {
        this.idUsuarios = idUsuarios;
        this.idLivro = idLivro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
    }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
