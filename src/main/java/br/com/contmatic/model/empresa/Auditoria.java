package br.com.contmatic.model.empresa;

import java.time.LocalDate;

abstract class Auditoria {
    
private LocalDate dataCriacao;
    
    private String ipCriacao;
    
    private String nomeUsuarioAlteracao;
    
    private LocalDate dataAlteracao;
    
    private String ipAlteracao;
    
    private String nomeUsuarioCriacao;
    
    public String getNomeUsuarioCriacao() {
        return nomeUsuarioCriacao;
    }

    public void setNomeUsuarioCriacao(String nomeUsuarioCriacao) {
        this.nomeUsuarioCriacao = nomeUsuarioCriacao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getIpCriacao() {
        return ipCriacao;
    }

    public void setIpCriacao(String ipCriacao) {
        this.ipCriacao = ipCriacao;
    }

    public String getNomeUsuarioAlteracao() {
        return nomeUsuarioAlteracao;
    }

    public void setNomeUsuarioAlteracao(String nomeUsuarioAlteracao) {
        this.nomeUsuarioAlteracao = nomeUsuarioAlteracao;
    }

    public LocalDate getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDate dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public String getIpAlteracao() {
        return ipAlteracao;
    }

    public void setIpAlteracao(String ipAlteracao) {
        this.ipAlteracao = ipAlteracao;
    } 
}
