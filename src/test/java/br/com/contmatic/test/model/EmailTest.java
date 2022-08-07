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

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.JVM)
public class EmailTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void test_01_EMAIL_TODOS_ARGS_01_nulo() {
		EMAIL_TODOS_ARGS.setEmail(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_02_EMAIL_TODOS_ARGS_01_vazio() {
		EMAIL_TODOS_ARGS.setEmail(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_03_EMAIL_TODOS_ARGS_01_sem_arroba() {
		EMAIL_TODOS_ARGS.setEmail(EMAIL_SEM_ARROBA);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_04_EMAIL_TODOS_ARGS_01_inicia_com_arroba() {
		EMAIL_TODOS_ARGS.setEmail(EMAIL_COM_ARROBA_INICIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_05_EMAIL_TODOS_ARGS_01_abaixo_min_chars() {
		EMAIL_TODOS_ARGS.setEmail(MIN_CHARS_GERAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_06_EMAIL_TODOS_ARGS_01_acima_max_chars() {
		EMAIL_TODOS_ARGS.setEmail(MAX_CHARS_GERAL);
	}
	
	@Test
	public void test_07_metodo_hashcode() {    
		assertEquals(EMAILS_IGUAIS_ARGS_OBRIGATORIOS.get(INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_01), EMAILS_IGUAIS_ARGS_OBRIGATORIOS.get(INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_02));
	}
	
	@Test
	public void test_08_metodo_equals() {
	    assertTrue(EMAILS_IGUAIS_ARGS_OBRIGATORIOS.get(INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_01).equals(EMAILS_IGUAIS_ARGS_OBRIGATORIOS.get(INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_01)));
		assertTrue(EMAILS_IGUAIS_ARGS_OBRIGATORIOS.get(INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_01).equals(EMAILS_IGUAIS_ARGS_OBRIGATORIOS.get(INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_02)));
		assertFalse(EMAIL_TODOS_ARGS.equals(new Object()));
		assertFalse(EMAIL_TODOS_ARGS.equals(null));
		assertFalse(EMAILS_IGUAIS_ARGS_OBRIGATORIOS.get(INDICE_EMAIL_TODOS_ARGS_COM_ARGS_OBRIGATORIOS_01).equals(EMAIL_TODOS_ARGS));
	}
	
	@Test
	public void test_09_metodo_tostring() {
		assertThat(
			EMAIL_TODOS_ARGS.toString(), 
			allOf(
				containsString(EMAIL_TODOS_ARGS.getEmail())
			)
		);
	}
}
