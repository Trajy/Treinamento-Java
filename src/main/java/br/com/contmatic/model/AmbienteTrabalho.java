package br.com.contmatic.model;

import java.util.Objects;
import br.com.contmatic.model.endereco.Endereco;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarComumAlfanumerico;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarNome;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarNulo;

public class AmbienteTrabalho {

    private String nome;
    private String tipoEstabelecimento;
    private Endereco endereco;
    private String responsavel;
    private String descricao;
    
    public AmbienteTrabalho(String nome, String resposavel) {
        setNome(nome);
        setResponsavel(resposavel);
    }
    
    public AmbienteTrabalho(String nome, String tipoEstabelecimento, Endereco endereco, String responsavel,
            String descricao) {
        setNome(nome);
        setTipoEstabelecimento(tipoEstabelecimento);
        setEndereco(endereco);
        setResponsavel(responsavel);
        setDescricao(descricao);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        validarComumAlfanumerico(nome);
        this.nome = nome;
    }
    public String getTipoEstabelecimento() {
        return tipoEstabelecimento;
    }
    public void setTipoEstabelecimento(String tipoEstabelecimento) {
        validarComumAlfanumerico(tipoEstabelecimento);
        this.tipoEstabelecimento = tipoEstabelecimento;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
    	validarNulo(endereco);
        this.endereco = endereco;
    }
    public String getResponsavel() {
        return responsavel;
    }
    public void setResponsavel(String responsavel) {
        validarNome(responsavel);
        this.responsavel = responsavel;
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
		return Objects.hash(nome, responsavel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AmbienteTrabalho other = (AmbienteTrabalho) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(responsavel, other.responsavel);
	}

	@Override
    public String toString() {
        return "AmbienteDeTrabalho [descricao=" + descricao + ", endereco=" + endereco + ", nome=" + nome
                + ", responsavel=" + responsavel + ", tipoEstabelecimento=" + tipoEstabelecimento + "]";
    }
    
}
