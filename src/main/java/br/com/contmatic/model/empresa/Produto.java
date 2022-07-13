package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.utils.constantes.ComumConstantes.NAO_VALIDAR_CHARS_REPETIDOS;
import static br.com.contmatic.model.utils.constantes.ExpressoesRegulares.NUMEROS_COM_PONTO;
import static br.com.contmatic.model.utils.constantes.ProdutoConstantes.CODIGO_INVALIDO;
import static br.com.contmatic.model.utils.constantes.ProdutoConstantes.DESCRICAO_PRODUTO_INVALIDA;
import static br.com.contmatic.model.utils.constantes.ProdutoConstantes.NOME_PRODUTO_INVALIDO;
import static br.com.contmatic.model.utils.constantes.ProdutoConstantes.PRECO_MAX_PRODUTO;
import static br.com.contmatic.model.utils.constantes.ProdutoConstantes.PRECO_MIN_PRODUTO;
import static br.com.contmatic.model.utils.constantes.ProdutoConstantes.PRECO_PRODUTO_INVALIDO;
import static br.com.contmatic.model.utils.constantes.ProdutoConstantes.PRODUTO_CODIGO_TAMANHO_MAX;
import static br.com.contmatic.model.utils.constantes.ProdutoConstantes.PRODUTO_CODIGO_TAMANHO_MIN;
import static br.com.contmatic.model.utils.constantes.ProdutoConstantes.PRODUTO_VERSAO_TAMANHO_MAX;
import static br.com.contmatic.model.utils.constantes.ProdutoConstantes.PRODUTO_VERSAO_TAMANHO_MIN;
import static br.com.contmatic.model.utils.constantes.ProdutoConstantes.VERSAO_INVALIDA;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarExpressaoRegularETamanho;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarNulo;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarNumeroEntre;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.contmatic.model.auditoria.Auditoria;
import br.com.contmatic.model.endereco.Endereco;

public class Produto extends Auditoria {

    private String nome;

    private String versao;

    private String codigo;

    private String descricao;
    
    private BigDecimal preco;

    private Empresa empresa;

    public Produto(String codigo) {
        setCodigo(codigo);
    }

    public Produto(String nome, String versao, String codigo, String descricao, BigDecimal preco) {
        setNome(nome);
        setVersao(versao);
        setCodigo(codigo);
        setDescricao(descricao);
        setPreco(preco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarExpressaoRegularETamanho(nome, NOME_PRODUTO_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.nome = nome;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        validarExpressaoRegularETamanho(versao, NUMEROS_COM_PONTO, PRODUTO_VERSAO_TAMANHO_MIN, PRODUTO_VERSAO_TAMANHO_MAX, VERSAO_INVALIDA, NAO_VALIDAR_CHARS_REPETIDOS);
        this.versao = versao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        validarExpressaoRegularETamanho(codigo, NUMEROS_COM_PONTO, PRODUTO_CODIGO_TAMANHO_MIN, PRODUTO_CODIGO_TAMANHO_MAX, CODIGO_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        validarExpressaoRegularETamanho(descricao, DESCRICAO_PRODUTO_INVALIDA, NAO_VALIDAR_CHARS_REPETIDOS);
        this.descricao = descricao;
    }
    
    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        validarNumeroEntre(preco, PRECO_MIN_PRODUTO, PRECO_MAX_PRODUTO, PRECO_PRODUTO_INVALIDO);
        this.preco = preco;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        validarNulo(empresa);
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.getCodigo())
                .hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if(!(obj instanceof Produto)) {
            return false;
        }
        Produto o = (Produto) obj;
        return new EqualsBuilder()
                .append(this.getCodigo(), o.getCodigo())
                .isEquals();
    }

    @Override
    public String toString() {
        return reflectionToString(this, SHORT_PREFIX_STYLE);
    }

}
