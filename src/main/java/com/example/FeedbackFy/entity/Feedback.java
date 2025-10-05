package com.example.FeedbackFy.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="nome_do_usuario")
    private String nomeDoUsuario;

    @Column(name="email_do_usuario")
    private String emailDoUsuario;

    @Column(name="tipo")
    private String tipo;

    @Column(name="mensagem")
    private String mensagem;

    @Column(name="data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name="data_alteracao")
    private LocalDateTime dataAlteracao;

    @PrePersist
    public void prePersist(){
        this.dataCriacao = LocalDateTime.now();
        this.dataAlteracao = LocalDateTime.now();
    }


    public Feedback() {
    }

    public Feedback(Integer id, String nomeDoUsuario, String emailDoUsuario, String tipo, String mensagem, LocalDateTime dataCriacao) {
        this.id = id;
        this.nomeDoUsuario = nomeDoUsuario;
        this.emailDoUsuario = emailDoUsuario;
        this.tipo = tipo;
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeDoUsuario() {
        return nomeDoUsuario;
    }

    public void setNomeDoUsuario(String nomeDoUsuario) {
        this.nomeDoUsuario = nomeDoUsuario;
    }

    public String getEmailDoUsuario() {
        return emailDoUsuario;
    }

    public void setEmailDoUsuario(String emailDoUsuario) {
        this.emailDoUsuario = emailDoUsuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
