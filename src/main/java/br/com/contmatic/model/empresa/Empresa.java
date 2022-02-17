package br.com.contmatic.model.empresa;

import java.util.List;
import java.util.Objects;

import br.com.contmatic.model.contato.Email;
import br.com.contmatic.model.contato.Telefone;

import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarExpressaoRegularETamanho;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarLista;
import static br.com.contmatic.model.utils.validacao.ValidacaoCnpj.validarCnpj;
import static br.com.contmatic.model.utils.constantes.Avisos.RAZAO_SOCIAL_INVALIDO;
import static br.com.contmatic.model.utils.constantes.Avisos.NOME_FANTASIA_INVALIDO;
import static br.com.contmatic.model.utils.constantes.Avisos.AREA_ATUACAO_INVALIDO;
import static br.com.contmatic.model.utils.constantes.CamposLimites.LISTA_EMAIL_QTD_MAX;
import static br.com.contmatic.model.utils.constantes.CamposLimites.LISTA_TELEFONE_QTD_MAX;
import static br.com.contmatic.model.utils.constantes.CamposLimites.LISTA_FUNCIONARIO_QTD_MAX;
import static br.com.contmatic.model.utils.constantes.CamposLimites.LISTA_CARGO_QTD_MAX;
import static br.com.contmatic.model.utils.constantes.CamposLimites.LISTA_AMBIENTE_TRABALHO_QTD_MAX;
import static br.com.contmatic.model.utils.constantes.CamposLimites.LISTA_PRODUTO_QTD_MAX;
import static br.com.contmatic.model.utils.constantes.CamposLimites.LISTA_ENDERECO_QTD_MAX;
import static br.com.contmatic.model.utils.constantes.CamposLimites.NAO_VALIDAR_CHARS_REPETIDOS;

public class Empresa extends Auditoria {

    private String cnpj;

    private String razaoSocial;

    private String nomeFantasia;

    private String areaAtuacao;

    private List<Email> emails;

    private List<Telefone> telefones;

    private List<Endereco> enderecos;

    private List<Funcionario> funcionarios;

    private List<Produto> produtos;

    private List<Cargo> cargos;

    private List<AmbienteTrabalho> ambientesTrabalho;

    public Empresa(String cnpj) {
        setCnpj(cnpj);
    }

    public Empresa(String cnpj, String razaoSocial, String nomeFantasia, String areaAtuacao) {
        setCnpj(cnpj);
        setRazaoSocial(razaoSocial);
        setNomeFantasia(nomeFantasia);
        setAreaAtuacao(areaAtuacao);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        validarCnpj(cnpj);
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        validarExpressaoRegularETamanho(razaoSocial, RAZAO_SOCIAL_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        validarExpressaoRegularETamanho(nomeFantasia, NOME_FANTASIA_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.nomeFantasia = nomeFantasia;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        validarExpressaoRegularETamanho(areaAtuacao, AREA_ATUACAO_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.areaAtuacao = areaAtuacao;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        validarLista(emails, LISTA_EMAIL_QTD_MAX);
        this.emails = emails;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        validarLista(telefones, LISTA_TELEFONE_QTD_MAX);
        this.telefones = telefones;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        validarLista(enderecos, LISTA_ENDERECO_QTD_MAX);
        this.enderecos = enderecos;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        validarLista(funcionarios, LISTA_FUNCIONARIO_QTD_MAX);
        this.funcionarios = funcionarios;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        validarLista(produtos, LISTA_PRODUTO_QTD_MAX);
        this.produtos = produtos;
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        validarLista(cargos, LISTA_CARGO_QTD_MAX);
        this.cargos = cargos;
    }

    public List<AmbienteTrabalho> getAmbientesTrabalho() {
        return ambientesTrabalho;
    }

    public void setAmbientesTrabalho(List<AmbienteTrabalho> ambientesTrabalho) {
        validarLista(ambientesTrabalho, LISTA_AMBIENTE_TRABALHO_QTD_MAX);
        this.ambientesTrabalho = ambientesTrabalho;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Empresa other = (Empresa) obj;
        return Objects.equals(cnpj, other.cnpj);
    }

    @Override
    public String toString() {
        return "Empresa [ambientesTrabalho=" + ambientesTrabalho + ", areaAtuacao=" + areaAtuacao + ", cargos=" + cargos + ", cnpj=" + cnpj + ", emails=" + emails + ", enderecos=" + enderecos +
            ", funcionarios=" + funcionarios + ", nomeFantasia=" + nomeFantasia + ", produtos=" + produtos + ", razaoSocial=" + razaoSocial + ", telefones=" + telefones + "]";
    }

}
