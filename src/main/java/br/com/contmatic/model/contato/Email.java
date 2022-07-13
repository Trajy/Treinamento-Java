package br.com.contmatic.model.contato;

import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;

import br.com.contmatic.model.endereco.Endereco;

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
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if(!(obj instanceof Email)) {
            return false;
        }
        Email o = (Email) obj;
        return new EqualsBuilder()
                .append(this.getEmail(), o.getEmail())
                .isEquals();
    }

    @Override
    public String toString() {
        return reflectionToString(this, SHORT_PREFIX_STYLE);
    }

}
