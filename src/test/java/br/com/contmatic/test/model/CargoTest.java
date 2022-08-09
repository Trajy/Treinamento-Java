package br.com.contmatic.test.model;

import static br.com.contmatic.test.model.fabricaobjetos.CargoFabricaObjetos.CARGO_01;
import static br.com.contmatic.test.model.fabricaobjetos.CargoFabricaObjetos.CARGO_04;
import static br.com.contmatic.test.model.fabricaobjetos.CargoFabricaObjetos.CARGO_TODOS_ATRIBUDOS;
import static br.com.contmatic.test.model.fabricaobjetos.CargoFabricaObjetos.CARGOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS;
import static br.com.contmatic.test.model.fabricaobjetos.CargoFabricaObjetos.INDICE_01;
import static br.com.contmatic.test.model.fabricaobjetos.CargoFabricaObjetos.INDICE_02;
import static br.com.contmatic.test.model.fabricaobjetos.CargoFabricaObjetos.CBO_01;
import static br.com.contmatic.test.model.fabricaobjetos.CargoFabricaObjetos.CBO_02;
import static br.com.contmatic.test.model.fabricaobjetos.CargoFabricaObjetos.DESCRICAO_CARGO_01;
import static br.com.contmatic.test.model.fabricaobjetos.CargoFabricaObjetos.NOME_CARGO_01;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.MAX_CHARS_GERAL;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.NUMEROS_COM_LETRA_LITERAL;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.SOMENTE_ESPACOS;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.TEXTO_COM_1_CHAR;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.TEXTO_COM_CHAR_NAO_ALFANUMERICO;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.VAZIO;
import static br.com.contmatic.test.model.fabricaobjetos.CriacaoObjetos.construirObjetos;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CargoTest {
	
	@Before
	public void pre_test() {
		construirObjetos();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_03_cbo_nulo() {
		CARGO_TODOS_ATRIBUDOS.setCBO(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_04_cbo_vazio() {
		CARGO_TODOS_ATRIBUDOS.setCBO(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_05_cbo_somente_espacos() {
		CARGO_TODOS_ATRIBUDOS.setCBO(SOMENTE_ESPACOS);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_06_cbo_com_letras() {
		CARGO_TODOS_ATRIBUDOS.setCBO(NUMEROS_COM_LETRA_LITERAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_07_cbo_maior_que_permitido() {
		CARGO_TODOS_ATRIBUDOS.setCBO(MAX_CHARS_GERAL);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_08_nome_nulo() {
		CARGO_TODOS_ATRIBUDOS.setNome(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_09_nome_vazio() {
		CARGO_TODOS_ATRIBUDOS.setNome(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_10_nome_acima_max_chars() {
		CARGO_TODOS_ATRIBUDOS.setNome(MAX_CHARS_GERAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_11_nome_abaixo_min_chars() {
		CARGO_TODOS_ATRIBUDOS.setNome(TEXTO_COM_1_CHAR);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_12_nome_nao_alfanumerico() {
		CARGO_TODOS_ATRIBUDOS.setNome(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_13_descricao_nula() {
		CARGO_TODOS_ATRIBUDOS.setDescricao(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_14_descricao_vazio() {
		CARGO_01.setDescricao(VAZIO);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_15_descricao_acima_max_chars() {
		CARGO_TODOS_ATRIBUDOS.setDescricao(MAX_CHARS_GERAL);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_16_descricao_abaixo_min_chars() {
		CARGO_TODOS_ATRIBUDOS.setDescricao(TEXTO_COM_1_CHAR);
	}
	
	@Test(expected = IllegalStateException.class)
	public void test_17_descricao_nao_alfanumerico() {
		CARGO_TODOS_ATRIBUDOS.setDescricao(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
	}
	
	@Test
	public void test_18_metodo_hashcode() {
	    assertEquals(
		    CARGOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_01).hashCode(),
		    CARGOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_02).hashCode()
	   );
	}
	
	@Test
	public void test_19_validar_metodo_equals() {
		assertTrue(CARGOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_01).equals(CARGOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_01)));
		assertTrue(CARGOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_01).equals(CARGOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_02)));
		assertFalse(CARGO_01.equals(new Object()));
		assertFalse(CARGO_04.equals(null));
		assertFalse(CARGO_TODOS_ATRIBUDOS.equals(CARGOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_01)));
	}
	
	@Test
	public void test_20_metodo_tostring() {
		assertThat(
			CARGO_TODOS_ATRIBUDOS.toString(), 
			allOf(
				containsString(CARGO_TODOS_ATRIBUDOS.getCBO()),
				containsString(CARGO_TODOS_ATRIBUDOS.getNome()),
				containsString(CARGO_TODOS_ATRIBUDOS.getDescricao())
			)
		);
	}
	
	@Test(expected = IllegalArgumentException.class)
    public void test_31_validar_empresa_nulo() {
        CARGO_TODOS_ATRIBUDOS.setEmpresa(null);
    }
		
}
