package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarNulo;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarExpressaoRegularETamanho;
import static br.com.contmatic.model.utils.constantes.ExpressoesRegulares.NUMEROS;
import static br.com.contmatic.model.utils.constantes.ExpressoesRegulares.LETRAS;
import static br.com.contmatic.model.utils.constantes.Avisos.CEP_INVALIDO;
import static br.com.contmatic.model.utils.constantes.Avisos.NUMERO_ENDERECO_INVALIDO;
import static br.com.contmatic.model.utils.constantes.Avisos.RAZAO_SOCIAL_INVALIDO;
import static br.com.contmatic.model.utils.constantes.Avisos.RUA_INVALIDO;
import static br.com.contmatic.model.utils.constantes.Avisos.BAIRRO_INVALIDO;
import static br.com.contmatic.model.utils.constantes.CamposLimites.CEP_TAMANHO;
import static br.com.contmatic.model.utils.constantes.CamposLimites.ENDERECO_NUMERO_MIN;
import static br.com.contmatic.model.utils.constantes.CamposLimites.ENDERECO_NUMERO_MAX;
import static br.com.contmatic.model.utils.constantes.CamposLimites.RUA_MIN;
import static br.com.contmatic.model.utils.constantes.CamposLimites.RUA_MAX;
import static br.com.contmatic.model.utils.constantes.CamposLimites.BAIRRO_MIN;
import static br.com.contmatic.model.utils.constantes.CamposLimites.BAIRRO_MAX;
import static br.com.contmatic.model.utils.constantes.CamposLimites.NAO_VALIDAR_CHARS_REPETIDOS;
import static br.com.contmatic.model.utils.constantes.CamposLimites.VALIDAR_CHARS_REPETIDOS;

import java.util.Objects;

public class Endereco extends Auditoria {

    private Integer numero;

    private String cep;

    private String rua;

    private String bairro;

    private Cidade cidade;
    
    private String empresa;

    public Endereco(Integer numero, String cep) {
        setNumero(numero);
        setCEP(cep);
    }

    public Endereco(Integer numero, String cep, String rua, String bairro, Cidade cidade) {
        setNumero(numero);
        setCEP(cep);
        setRua(rua);
        setBairro(bairro);
        setCidade(cidade);
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        validarExpressaoRegularETamanho(numero, NUMEROS, ENDERECO_NUMERO_MIN, ENDERECO_NUMERO_MAX, NUMERO_ENDERECO_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.numero = numero;
    }

    public String getCEP() {
        return cep;
    }

    public void setCEP(String cep) {
        validarExpressaoRegularETamanho(cep, NUMEROS, CEP_TAMANHO, CEP_INVALIDO, VALIDAR_CHARS_REPETIDOS);
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        validarExpressaoRegularETamanho(rua, LETRAS, RUA_MIN, RUA_MAX, RUA_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        validarExpressaoRegularETamanho(bairro, LETRAS, BAIRRO_MIN, BAIRRO_MAX, BAIRRO_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return this.cidade;
    }

    public void setCidade(Cidade cidade) {
        validarNulo(cidade);
        this.cidade = cidade;
    }
    
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        validarExpressaoRegularETamanho(empresa, RAZAO_SOCIAL_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cep, numero);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Endereco other = (Endereco) obj;
        return Objects.equals(cep, other.cep) && Objects.equals(numero, other.numero);
    }

    @Override
    public String toString() {
        return "Endereco [numero=" + numero + ", cep=" + cep + ", rua=" + rua + ", bairro=" + bairro + ", enderecoDb=" + cidade + "]";
    }

}