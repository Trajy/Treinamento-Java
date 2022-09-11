package br.com.contmatic.model.contato;

import static br.com.contmatic.model.utils.validacao.ValidacaoContato.validarEmail;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;
import static br.com.contmatic.model.utils.constantes.EmailConstantes.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class CorreioEletronico {
    
    @NotBlank(message = "O email deve ser preenchido")
    @Length(min = EMAIL_MIN, max = EMAIL_MAX, message = "O email deve conter entre {min} e {max} caracteres")
    @Email(message = "email invalido")
    private String endereco;
    
    public CorreioEletronico(String endereco) {
        setEndereco(endereco);
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String email) {
        this.endereco = email;
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
        if(!(obj instanceof CorreioEletronico)) {
            return false;
        }
        CorreioEletronico o = (CorreioEletronico) obj;
        return new EqualsBuilder()
                .append(this.getEndereco(), o.getEndereco())
                .isEquals();
    }

    @Override
    public String toString() {
        return reflectionToString(this, SHORT_PREFIX_STYLE);
    }

}
