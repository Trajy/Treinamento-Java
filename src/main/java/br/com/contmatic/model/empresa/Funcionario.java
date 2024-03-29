package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.utils.constantes.ComumConstantes.LISTA_EMAIL_INVALIDO;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.LISTA_EMAIL_QTD_MAX;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.LISTA_TELEFONE_INVALIDO;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.LISTA_TELEFONE_QTD_MAX;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.NAO_VALIDAR_CHARS_REPETIDOS;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.NOME_MAX;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.NOME_MIN;
import static br.com.contmatic.model.utils.constantes.ExpressoesRegulares.LETRAS;
import static br.com.contmatic.model.utils.constantes.ExpressoesRegulares.RG;
import static br.com.contmatic.model.utils.constantes.FuncionarioConstantes.NOME_INVALIDO;
import static br.com.contmatic.model.utils.constantes.FuncionarioConstantes.RG_FUNCINARIO_INVALIDO;
import static br.com.contmatic.model.utils.constantes.FuncionarioConstantes.RG_MAX;
import static br.com.contmatic.model.utils.constantes.FuncionarioConstantes.RG_MIN;
import static br.com.contmatic.model.utils.constantes.FuncionarioConstantes.SALARIO_FUNCINARIO_INVALIDO;
import static br.com.contmatic.model.utils.constantes.FuncionarioConstantes.SALARIO_MAX;
import static br.com.contmatic.model.utils.constantes.FuncionarioConstantes.SALARIO_MIN;
import static br.com.contmatic.model.utils.constantes.FuncionarioConstantes.SETOR_FUNCIONARIO_INVALIDO;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarExpressaoRegularETamanho;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarLista;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarNulo;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarNumeroEntre;
import static br.com.contmatic.model.utils.validacao.ValidacaoCpf.validarCpf;
import static br.com.contmatic.model.utils.validacao.ValidacaoFuncionario.validarIdade;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.contmatic.model.auditoria.Auditoria;
import br.com.contmatic.model.contato.CorreioEletronico;
import br.com.contmatic.model.contato.Telefone;
import br.com.contmatic.model.endereco.Endereco;


public class Funcionario extends Auditoria {

    private String cpf;

    private String nome;

    private LocalDate dataNascimento;

    private String rg;

    private Endereco endereco;

    private String setor;

    private Cargo cargo;

    private AmbienteTrabalho ambienteTrabalho;
    
    private Empresa empresa;

    private List<Telefone> telefones;

    private List<CorreioEletronico> emails;

    private BigDecimal salario;
    
    private Boolean ativo = true;
    
    public Funcionario(String cpf, Empresa empresa) {
        this.setCpf(cpf);
        this.setEmpresa(empresa);
    }
    
    public Funcionario(String cpf, String nome, LocalDate dataNascimento, Endereco endereco, Cargo cargo, BigDecimal salario, Empresa empresa) {
        setCpf(cpf);
        setNome(nome);
        setDataNascimento(dataNascimento);
        setEndereco(endereco);
        setCargo(cargo);
        setSalario(salario);
        setEmpresa(empresa);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        validarCpf(cpf);
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarExpressaoRegularETamanho(nome, LETRAS, NOME_MIN, NOME_MAX, NOME_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate data) {
        validarIdade(data);
        this.dataNascimento = data;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        validarExpressaoRegularETamanho(rg, RG, RG_MIN, RG_MAX, RG_FUNCINARIO_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.rg = rg;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        validarNulo(endereco);
        this.endereco = endereco;
    }
    
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        validarNulo(empresa);
        this.empresa = empresa;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        validarLista(telefones, LISTA_TELEFONE_QTD_MAX, LISTA_TELEFONE_INVALIDO);
        this.telefones = telefones;
    }

    public List<CorreioEletronico> getEmails() {
        return this.emails;
    }

    public void setEmails(List<CorreioEletronico> emails) {
        validarLista(emails, LISTA_EMAIL_QTD_MAX, LISTA_EMAIL_INVALIDO);
        this.emails = emails;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        validarExpressaoRegularETamanho(setor, SETOR_FUNCIONARIO_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.setor = setor;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        validarNulo(cargo);
        this.cargo = cargo;
    }

    public AmbienteTrabalho getAmbienteTrabalho() {
        return ambienteTrabalho;
    }

    public void setAmbienteTrabalho(AmbienteTrabalho ambienteTrabalho) {
        validarNulo(ambienteTrabalho);
        this.ambienteTrabalho = ambienteTrabalho;
    }

    public BigDecimal getSalario() {
        return salario;
    }
    
    public void setSalario(BigDecimal salario) {
        validarNumeroEntre(salario, SALARIO_MIN, SALARIO_MAX, SALARIO_FUNCINARIO_INVALIDO);
        this.salario = salario;
    }
    
    public Boolean isAtivo() {
        return ativo;
    }
    
    public void setAtivo(Boolean ativo) {
        validarNulo(ativo);
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.getCpf())
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
        if(!(obj instanceof Funcionario)) {
            return false;
        }
        Funcionario o = (Funcionario) obj;
        return new EqualsBuilder()
                .append(this.getCpf(), o.getCpf())
                .isEquals();
    }

    @Override
    public String toString() {
        return reflectionToString(this, SHORT_PREFIX_STYLE);
    }

}
