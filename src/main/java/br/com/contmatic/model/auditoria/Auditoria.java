package br.com.contmatic.model.auditoria;

import static br.com.contmatic.model.utils.constantes.ComumConstantes.NAO_VALIDAR_CHARS_REPETIDOS;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.NOME_MAX;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.NOME_MIN;
import static br.com.contmatic.model.utils.constantes.AuditoriaConstantes.IP_INVALIDO;
import static br.com.contmatic.model.utils.constantes.ExpressoesRegulares.IP;
import static br.com.contmatic.model.utils.constantes.ExpressoesRegulares.LETRAS;
import static br.com.contmatic.model.utils.constantes.FuncionarioConstantes.NOME_INVALIDO;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarExpressaoRegularETamanho;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarAgora;

import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public abstract class Auditoria {
    
    private String nomeUsuarioCriacao;
    
    private LocalDateTime dataCriacao;
    
    private String ipCriacao;
    
    private String nomeUsuarioAlteracao;
    
    private LocalDateTime dataAlteracao;
    
    private String ipAlteracao;
    
    public String getNomeUsuarioCriacao() {
        return nomeUsuarioCriacao;
    }

    public void setNomeUsuarioCriacao(String nomeUsuarioCriacao) {
        validarExpressaoRegularETamanho(nomeUsuarioCriacao, LETRAS, NOME_MIN, NOME_MAX, NOME_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.nomeUsuarioCriacao = nomeUsuarioCriacao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        validarAgora(dataCriacao);
        this.dataCriacao = dataCriacao;
    }
 
    public String getIpCriacao() {
        return ipCriacao;
    }

    public void setIpCriacao(String ipCriacao) {
        validarExpressaoRegularETamanho(ipCriacao, IP, IP_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.ipCriacao = ipCriacao;
    }

    public String getNomeUsuarioAlteracao() {
        return nomeUsuarioAlteracao;
    }

    public void setNomeUsuarioAlteracao(String nomeUsuarioAlteracao) {
        validarExpressaoRegularETamanho(nomeUsuarioAlteracao, LETRAS, NOME_MIN, NOME_MAX, NOME_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.nomeUsuarioAlteracao = nomeUsuarioAlteracao;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        validarAgora(dataAlteracao);
        this.dataAlteracao = dataAlteracao;
    }

    public String getIpAlteracao() {
        return ipAlteracao;
    }

    public void setIpAlteracao(String ipAlteracao) {
        validarExpressaoRegularETamanho(ipAlteracao, IP, IP_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.ipAlteracao = ipAlteracao;
    }
}
