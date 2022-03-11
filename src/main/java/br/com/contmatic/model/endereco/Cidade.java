package br.com.contmatic.model.endereco;

import java.util.Objects;

import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarExpressaoRegularETamanho;
import static br.com.contmatic.model.utils.constantes.ExpressoesRegulares.LETRAS;
import static br.com.contmatic.model.utils.constantes.EnderecoConstantes.CIDADE_INVALIDO;
import static br.com.contmatic.model.utils.constantes.EnderecoConstantes.ESTADO_INVALIDO;
import static br.com.contmatic.model.utils.constantes.EnderecoConstantes.PAIS_INVALIDO;
import static br.com.contmatic.model.utils.constantes.EnderecoConstantes.CIDADE_MIN;
import static br.com.contmatic.model.utils.constantes.EnderecoConstantes.CIDADE_MAX;
import static br.com.contmatic.model.utils.constantes.EnderecoConstantes.ESTADO_MIN;
import static br.com.contmatic.model.utils.constantes.EnderecoConstantes.ESTADO_MAX;
import static br.com.contmatic.model.utils.constantes.EnderecoConstantes.PAIS_MIN;
import static br.com.contmatic.model.utils.constantes.EnderecoConstantes.PAIS_MAX;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.NAO_VALIDAR_CHARS_REPETIDOS;


public final class Cidade {

    private String nome;
    
    private String uf;
    
    private String pais;

    public Cidade(String nome, String uf, String pais) {
        // TODO - refazer uf para estado
        setNome(nome);
        setUf(uf);
        setPais(pais);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarExpressaoRegularETamanho(nome, LETRAS, CIDADE_MIN, CIDADE_MAX, CIDADE_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        validarExpressaoRegularETamanho(uf, LETRAS, ESTADO_MIN, ESTADO_MAX, ESTADO_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.uf = uf;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        validarExpressaoRegularETamanho(pais, LETRAS, PAIS_MIN, PAIS_MAX, PAIS_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.pais = pais;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, uf, pais);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cidade other = (Cidade) obj;
        return Objects.equals(nome, other.nome) && Objects.equals(uf, other.uf) && Objects.equals(pais, other.pais);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder().
            append("cidade: ").append(nome).
            append("\nestado: ").append(uf).
            append("\npais: ").append(pais);
        return stringBuilder.toString();
    }

}
