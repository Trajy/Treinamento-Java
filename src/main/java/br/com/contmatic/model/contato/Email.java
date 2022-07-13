package br.com.contmatic.model.contato;

import java.util.Objects;

import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import static br.com.contmatic.model.utils.validacao.ValidacaoContato.validarEmail;

public class Email {

    private String enderecoEmail;

    public Email(String email) {
        setEmail(email);
    }

    public String getEmail() {
        return this.enderecoEmail;
    }

    public void setEmail(String email) {
        validarEmail(email);
        this.enderecoEmail = email;
    }

    @Override
    public int hashCode() {
        return reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Email other = (Email) obj;
        return Objects.equals(enderecoEmail, other.enderecoEmail);
    }

    @Override
    public String toString() {
        return reflectionToString(this, SHORT_PREFIX_STYLE);
    }

}
