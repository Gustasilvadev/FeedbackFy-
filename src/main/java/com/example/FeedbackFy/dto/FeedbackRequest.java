package com.example.FeedbackFy.dto;

import java.time.LocalDateTime;

public class FeedbackRequest {

    private String nomeDoUsuario;
    private String emailDoUsuario;
    private String tipo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    public FeedbackRequest() {
    }

    public FeedbackRequest(String nomeDoUsuario, String emailDoUsuario, String tipo, String mensagem, LocalDateTime dataCriacao) {
        this.nomeDoUsuario = nomeDoUsuario;
        this.emailDoUsuario = emailDoUsuario;
        this.tipo = tipo;
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
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
