package br.com.contmatic.test.model;

import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.MAX_CHARS_GERAL;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.MIN_CHARS_GERAL;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.VAZIO;
import static br.com.contmatic.test.model.fabricaobjetos.EmailFabricaObjetos.EMAILS_IGUAIS_ARGS_OBRIGATORIOS;
import static br.com.contmatic.test.model.fabricaobjetos.EmailFabricaObjetos.EMAIL_COM_ARROBA_INICIO;
import static br.com.contmatic.test.model.fabricaobjetos.EmailFabricaObjetos.EMAIL_SEM_ARROBA;
import static br.com.contmatic.test.model.fabricaobjetos.EmailFabricaObjetos.EMAIL_TODOS_ARGS;
import static br.com.contmatic.test.model.fabricaobjetos.EmailFabricaObjetos.INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_01;
import static br.com.contmatic.test.model.fabricaobjetos.EmailFabricaObjetos.INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_02;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static br.com.contmatic.test.util.ValidacaoTesteUtils.validarAnnotation;

import java.util.Set;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.test.util.ValidacaoTesteUtils;

@FixMethodOrder(MethodSorters.JVM)
public class EmailTest {
    
    private Validator validador;
    
    @Before
    public void gerarValidador() {
        final ValidatorFactory fabricaValidador = Validation.buildDefaultValidatorFactory();
        validador = fabricaValidador.getValidator();
    }
    
    @Test
	public void teste_email_nulo() {
		validarAnnotation(EMAIL_TODOS_ARGS, NotBlank.class, () -> EMAIL_TODOS_ARGS.setEndereco(null));
	}
	
	@Test
	public void teste_email_vazio() {
		validarAnnotation(EMAIL_TODOS_ARGS, NotBlank.class, () -> EMAIL_TODOS_ARGS.setEndereco(VAZIO));
	}
	
	@Test(expected = IllegalStateException.class)
	public void teste_email_sem_arroba() {
		EMAIL_TODOS_ARGS.setEndereco(EMAIL_SEM_ARROBA);
	}
	
	@Test(expected = IllegalStateException.class)
	public void teste_email_inicia_com_arroba() {
		EMAIL_TODOS_ARGS.setEndereco(EMAIL_COM_ARROBA_INICIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void teste_email_abaixo_min_chars() {
		EMAIL_TODOS_ARGS.setEndereco(MIN_CHARS_GERAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void teste_email_acima_max_chars() {
		EMAIL_TODOS_ARGS.setEndereco(MAX_CHARS_GERAL);
	}
	
	@Test
	public void teste_metodo_hashcode() {    
		assertEquals(EMAILS_IGUAIS_ARGS_OBRIGATORIOS.get(INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_01).hashCode(), EMAILS_IGUAIS_ARGS_OBRIGATORIOS.get(INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_02).hashCode());
	}
	
	@Test
	public void teste_metodo_equals() {
	    assertTrue(EMAILS_IGUAIS_ARGS_OBRIGATORIOS.get(INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_01).equals(EMAILS_IGUAIS_ARGS_OBRIGATORIOS.get(INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_01)));
		assertTrue(EMAILS_IGUAIS_ARGS_OBRIGATORIOS.get(INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_01).equals(EMAILS_IGUAIS_ARGS_OBRIGATORIOS.get(INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_02)));
		assertFalse(EMAIL_TODOS_ARGS.equals(new Object()));
		assertFalse(EMAIL_TODOS_ARGS.equals(null));
		assertFalse(EMAILS_IGUAIS_ARGS_OBRIGATORIOS.get(INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_01).equals(EMAIL_TODOS_ARGS));
	}
	
	@Test
	public void teste_metodo_tostring() {
		assertThat(
			EMAIL_TODOS_ARGS.toString(), 
			allOf(
				containsString(EMAIL_TODOS_ARGS.getEndereco())
			)
		);
	}
}
