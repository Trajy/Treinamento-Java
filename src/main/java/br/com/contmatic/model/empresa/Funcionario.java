package br.com.contmatic.model.empresa;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import br.com.contmatic.model.auditoria.Auditoria;
import br.com.contmatic.model.contato.Email;
import br.com.contmatic.model.contato.Telefone;
import br.com.contmatic.model.endereco.Endereco;
import static br.com.contmatic.model.utils.validacao.ValidacaoCpf.validarCpf;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarExpressaoRegularETamanho;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarLista;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarNulo;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarNumeroEntre;
import static br.com.contmatic.model.utils.validacao.ValidacaoFuncionario.*;
import static br.com.contmatic.model.utils.constantes.ExpressoesRegulares.LETRAS;
import static br.com.contmatic.model.utils.constantes.ExpressoesRegulares.RG;
import static br.com.contmatic.model.utils.constantes.FuncionarioConstantes.*;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.LISTA_TELEFONE_QTD_MAX;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.LISTA_EMAIL_QTD_MAX;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.LISTA_TELEFONE_INVALIDO;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.LISTA_EMAIL_INVALIDO;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.NOME_MIN;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.NOME_MAX;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.NAO_VALIDAR_CHARS_REPETIDOS;


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

    private List<Email> emails;

    private Float salario;

    public Funcionario(String cpf) {
        this.setCpf(cpf);
    }

    public Funcionario(String cpf, String nome, LocalDate dataNascimento, Endereco endereco, String setor, Cargo cargo, Float salario) {
        setCpf(cpf);
        setNome(nome);

        setDataNascimento(dataNascimento);
        setEndereco(endereco);
        setSetor(setor);
        setCargo(cargo);
        setSalario(salario);
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

    public List<Email> getEmails() {
        return this.emails;
    }

    public void setEmails(List<Email> emails) {
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

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        validarNumeroEntre(salario, SALARIO_MIN, SALARIO_MAX, SALARIO_FUNCINARIO_INVALIDO);
        this.salario = salario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Funcionario other = (Funcionario) obj;
        return Objects.equals(cpf, other.cpf);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder().
            append("funcinario: ").append(nome).
            append("\ncpf: ").append(cpf).
            append("\nrg: ").append(rg).
            append("\ndata de nascimento: ").append(dataNascimento).
            append("\nendereco: ").append(endereco).
            append("\ncargo: ").append(cargo).
            append("\nsetor: ").append(setor).
            append("\nambiente de tabalho: ").append(ambienteTrabalho).
            append("\ntelefones: ").append(telefones).
            append("\nemails: ").append(emails).
            append("\nsalario: ").append(salario).
            append("\nauditoria:").append(super.toString());
        return stringBuilder.toString();
    }

}
