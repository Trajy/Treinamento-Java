package br.com.contmatic.test.model;

import static br.com.contmatic.test.model.fabricaobjetos.EmailFabricaObjetos.*;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.*;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetos.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.StringContains.containsString;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.JVM)
public class EmailTest {
	
	@BeforeClass
	public static void pre_teste(){
		construirObjetos();
	}
	
	@Test
	public void test_00_instancia() {
		assertEquals(EMAIL_LITERAL_01, EMAIL_01.getEmail());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_01_EMAIL_01_nulo() {
		EMAIL_01.setEmail(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_02_EMAIL_01_vazio() {
		EMAIL_01.setEmail(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_03_EMAIL_01_sem_arroba() {
		EMAIL_01.setEmail(EMAIL_SEM_ARROBA);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_04_EMAIL_01_inicia_com_arroba() {
		EMAIL_01.setEmail(EMAIL_COM_ARROBA_INICIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_05_EMAIL_01_abaixo_min_chars() {
		EMAIL_01.setEmail(TEXTO_COM_1_CHAR);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_06_EMAIL_01_acima_max_chars() {
		EMAIL_01.setEmail(TEXTO_COM_71_CHARS);
	}
	
	@Test
	public void test_07_metodo_hashcode() {
		assertEquals(EMAIL_01.hashCode(), EMAIL_02.hashCode());
	}
	
	@Test
	public void test_08_metodo_equals() {
		assertTrue(EMAIL_01.equals(EMAIL_01));
		assertTrue(EMAIL_01.equals(EMAIL_02));
		assertFalse(EMAIL_01.equals(new Object()));
		assertFalse(EMAIL_01.equals(null));
		
		EMAIL_02.setEmail(EMAIL_LITERAL_02);
		assertFalse(EMAIL_01.equals(EMAIL_02));
	}
	
	@Test
	public void test_09_metodo_tostring() {
		
		assertThat(
			EMAIL_01.toString(), 
			allOf(
				containsString(EMAIL_LITERAL_01.toString())
			)
		);
	}
}
