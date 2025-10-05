package com.example.FeedbackFy.dto;

import com.example.FeedbackFy.entity.Feedback;

import java.time.LocalDateTime;

public class FeedbackUpdateResponse {

    private Integer id;
    private String nomeDoUsuario;
    private String emailDoUsuario;
    private String tipo;
    private String mensagem;
    private LocalDateTime dataAlteracao;

    public FeedbackUpdateResponse() {
    }

    public FeedbackUpdateResponse(Feedback feedback) {
        this.id = feedback.getId();
        this.nomeDoUsuario = feedback.getNomeDoUsuario();
        this.emailDoUsuario = feedback.getEmailDoUsuario();
        this.tipo = feedback.getTipo();
        this.mensagem = feedback.getMensagem();
        this.dataAlteracao = feedback.getDataCriacao();
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

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
}
