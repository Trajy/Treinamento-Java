package br.com.contmatic.test.model;

import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.VAZIO;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.MAX_CHARS_GERAL;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.MIN_CHARS_GERAL;
import static br.com.contmatic.test.model.fabricaobjetos.EmailFabricaObjetos.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.AllOf.allOf;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.model.contato.Email;
import br.com.six2six.fixturefactory.Fixture;

@FixMethodOrder(MethodSorters.JVM)
public class EmailTest {
    
    private static Email EMAIL;
	
	@BeforeClass
	public static void pre_teste(){
	    construirEmails();
		EMAIL = Fixture.from(Email.class).gimme("todosArgs");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_01_EMAIL_01_nulo() {
		EMAIL.setEmail(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_02_EMAIL_01_vazio() {
		EMAIL.setEmail(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_03_EMAIL_01_sem_arroba() {
		EMAIL.setEmail(EMAIL_SEM_ARROBA);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_04_EMAIL_01_inicia_com_arroba() {
		EMAIL.setEmail(EMAIL_COM_ARROBA_INICIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_05_EMAIL_01_abaixo_min_chars() {
		EMAIL.setEmail(MIN_CHARS_GERAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_06_EMAIL_01_acima_max_chars() {
		EMAIL.setEmail(MAX_CHARS_GERAL);
	}
	
	@Test
	public void test_07_metodo_hashcode() {
	    List<Email> emails = getEmailsIguais(2);
		assertEquals(emails.get(0), emails.get(1));
	}
	
	@Test
	public void test_08_metodo_equals() {
	    final int QUANTIDADE_EMAILS_IGUAIS = 2;
	    final int INDICE_EMAIL_COM_ARGS_OBRIGATORIOS_01 = 0;
	    final int INDICE_EMAIL_COM_ARGS_OBRIGATORIOS_02 = 1;
	    final int INDICE_EMAIL_COM_TODOS_ARGS = 2;
	    List<Email> emails = getEmailsIguais(QUANTIDADE_EMAILS_IGUAIS);
	    assertTrue(emails.get(INDICE_EMAIL_COM_ARGS_OBRIGATORIOS_01).equals(emails.get(INDICE_EMAIL_COM_ARGS_OBRIGATORIOS_01)));
		assertTrue(emails.get(INDICE_EMAIL_COM_ARGS_OBRIGATORIOS_01).equals(emails.get(INDICE_EMAIL_COM_ARGS_OBRIGATORIOS_02)));
		assertFalse(EMAIL.equals(new Object()));
		assertFalse(EMAIL.equals(null));
		
		emails.add(Fixture.from(Email.class).gimme("todosArgs"));
		assertFalse(emails.get(0).equals(emails.get(INDICE_EMAIL_COM_TODOS_ARGS)));
	}
	
	@Test
	public void test_09_metodo_tostring() {
		assertThat(
			EMAIL.toString(), 
			allOf(
				containsString(EMAIL.getEmail())
			)
		);
	}
}
