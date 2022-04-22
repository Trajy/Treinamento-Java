package br.com.contmatic.test.model;

import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetos.*;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.*;
import static br.com.contmatic.test.model.fabricaobjetos.EmpresaFabricaObjetos.EMPRESA_TODOS_ATRIBUTOS;
import static br.com.contmatic.test.model.fabricaobjetos.CargoFabricaObjetos.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.JVM)
public class CargoTest {
	
	@BeforeClass
	public static void pre_test() {
		construirObjetos();
	}
	
	@Test
	public void test_02_instancia_com_construtor_todos_os_artributos() {
		assertEquals(CBO_01, CARGO_01.getCBO());
		assertEquals(NOME_CARGO_01, CARGO_01.getNome());
		assertEquals(DESCRICAO_CARGO_01, CARGO_01.getDescricao());
		assertEquals(EMPRESA_TODOS_ATRIBUTOS, CARGO_01.getEmpresa());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_03_cbo_nulo() {
		CARGO_03.setCBO(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_04_cbo_vazio() {
		CARGO_01.setCBO(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_05_cbo_somente_espacos() {
		CARGO_03.setCBO(SOMENTE_ESPACOS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_06_cbo_com_letras() {
		CARGO_01.setCBO(NUMEROS_COM_LETRA_LITERAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_07_cbo_maior_que_permitido() {
		CARGO_01.setCBO(TEXTO_COM_71_CHARS);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_08_nome_nulo() {
		CARGO_01.setNome(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_09_nome_vazio() {
		CARGO_01.setNome(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_10_nome_acima_max_chars() {
		CARGO_01.setNome(TEXTO_COM_71_CHARS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_11_nome_abaixo_min_chars() {
		CARGO_03.setNome(TEXTO_COM_1_CHAR);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_12_nome_nao_alfanumerico() {
		CARGO_03.setNome(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_13_descricao_nula() {
		CARGO_03.setDescricao(NULO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_14_descricao_vazio() {
		CARGO_01.setDescricao(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_15_descricao_acima_max_chars() {
		CARGO_01.setDescricao(TEXTO_COM_71_CHARS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_16_descricao_abaixo_min_chars() {
		CARGO_03.setDescricao(TEXTO_COM_1_CHAR);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_17_descricao_nao_alfanumerico() {
		CARGO_03.setDescricao(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
	}
	
	@Test
	public void test_18_metodo_hashcode() {
		assertEquals(CARGO_04.hashCode(), CARGO_01.hashCode());
	}
	
	@Test
	public void test_19_validar_metodo_equals() {
		assertTrue(CARGO_04.equals(CARGO_01));
		assertTrue(CARGO_04.equals(CARGO_04));
		assertFalse(CARGO_01.equals(new Object()));
		assertFalse(CARGO_04.equals(null));
		CARGO_04.setCBO(CBO_02);
		assertFalse(CARGO_01.equals(CARGO_04));
	}
	
	@Test
	public void test_20_metodo_tostring() {
		assertThat(
			CARGO_01.toString(), 
			allOf(
				containsString(CBO_01),
				containsString(NOME_CARGO_01),
				containsString(DESCRICAO_CARGO_01)
			)
		);
	}
	
	@Test(expected = IllegalArgumentException.class)
    public void test_31_validar_empresa_nulo() {
        CARGO_01.setEmpresa(null);
    }
		
}
