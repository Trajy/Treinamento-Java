package br.com.contmatic.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.print.attribute.standard.DateTimeAtProcessing;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.StringContains.containsString;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.model.contato.Email;

import static br.com.contmatic.model.ConstantsTest.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmailTest {
	
	// objetos de teste
	private Email email;
	private Email outroEmail;
	
	@Before
	public void pre_test(){
		email = new Email(EMAIL_LITERAL_01);
		outroEmail = new Email(EMAIL_LITERAL_01);
	}
	
	@Test
	public void test_00_instancia() {
		assertEquals(EMAIL_LITERAL_01, email.getEmail());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_01_email_nulo() {
		email.setEmail(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_02_email_vazio() {
		email.setEmail(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_03_email_sem_arroba() {
		email.setEmail(EMAIL_SEM_ARROBA);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_04_email_inicia_com_arroba() {
		email.setEmail(EMAIL_COM_ARROBA_INICIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_05_email_abaixo_min_chars() {
		email.setEmail(TEXTO_COM_1_CHAR);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_06_email_acima_max_chars() {
		email.setEmail(TEXTO_COM_71_CHARS);
	}
	
	@Test
	public void test_07_metodo_hashcode() {
		assertEquals(email.hashCode(), outroEmail.hashCode());
	}
	
	@Test
	public void test_08_metodo_equals() {
		assertTrue(email.equals(email));
		assertTrue(email.equals(outroEmail));
		assertFalse(email.equals(ENDERECO_01));
		assertFalse(email.equals(null));
		
		outroEmail.setEmail(EMAIL_LITERAL_02);
		assertFalse(email.equals(outroEmail));
	}
	
	@Test
	public void test_09_metodo_tostring() {
		
		assertThat(
			email.toString(), 
			allOf(
				containsString(EMAIL_01.toString())
			)
		);
	}
}
