package br.com.contmatic.model;

import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarNumeros;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarComumAlfanumerico;

public class Cargo {
    
    private String cbo;
    private String nome;
    private String descricao;

    public Cargo(String cbo) {
        setCBO(cbo);
    }
    
    public Cargo(String cbo, String nome, String descricao) {
        setCBO(cbo);
        setNome(nome);
        setDescricao(descricao);
    }

    public String getCBO() {
        return cbo;
    }
    public void setCBO(String cbo) {
        validarNumeros(cbo);
        this.cbo = cbo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        validarComumAlfanumerico(nome);
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        validarComumAlfanumerico(descricao);
        this.descricao = descricao;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + cbo.hashCode();
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cargo other = (Cargo) obj;
        return cbo.equals(other.cbo);
    }
    @Override
    public String toString() {
        return "Cargo [cbo=" + cbo + ", descricao=" + descricao + ", nome=" + nome + "]";
    }

}
