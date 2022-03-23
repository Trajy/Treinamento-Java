package br.com.contmatic.model.contato;

import java.util.Objects;
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
        return Objects.hash(enderecoEmail);
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
        StringBuilder stringBuilder = new StringBuilder().
            append("email: ").append(enderecoEmail);
        return stringBuilder.toString();
    }

}
