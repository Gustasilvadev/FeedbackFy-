package com.example.FeedbackFy.dto;

import jakarta.persistence.PrePersist;

import java.time.LocalDateTime;

public class FeedbackUpdateRequest {

    private String nomeDoUsuario;
    private String emailDoUsuario;
    private String tipo;
    private String mensagem;
    private LocalDateTime dataAlteracao;

    public FeedbackUpdateRequest() {
    }

    public FeedbackUpdateRequest(String nomeDoUsuario, String emailDoUsuario, String tipo, String mensagem, LocalDateTime dataAlteracao) {
        this.nomeDoUsuario = nomeDoUsuario;
        this.emailDoUsuario = emailDoUsuario;
        this.tipo = tipo;
        this.mensagem = mensagem;
        this.dataAlteracao = dataAlteracao;
    }

    @PrePersist
    public void dataAlteracao(){
        this.dataAlteracao = LocalDateTime.now();
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

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
}
