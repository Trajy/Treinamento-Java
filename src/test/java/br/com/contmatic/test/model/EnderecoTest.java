package br.com.contmatic.test.model;

import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.MAX_CHARS_GERAL;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.TEXTO_COM_1_CHAR;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.TEXTO_COM_CHAR_NAO_ALFANUMERICO;
import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.VAZIO;
import static br.com.contmatic.test.model.fabricaobjetos.CriacaoObjetos.construirObjetos;
import static br.com.contmatic.test.model.fabricaobjetos.EnderecoFabricaObjetos.CEP_02;
import static br.com.contmatic.test.model.fabricaobjetos.EnderecoFabricaObjetos.CEP_CHARS_REPETIDOS;
import static br.com.contmatic.test.model.fabricaobjetos.EnderecoFabricaObjetos.CEP_COM_LETRA;
import static br.com.contmatic.test.model.fabricaobjetos.EnderecoFabricaObjetos.CEP_TAMANHO_ERRADO;
import static br.com.contmatic.test.model.fabricaobjetos.EnderecoFabricaObjetos.ENDERECOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS;
import static br.com.contmatic.test.model.fabricaobjetos.EnderecoFabricaObjetos.ENDERECO_ATRIBUTOS_OBRIGATORIOS;
import static br.com.contmatic.test.model.fabricaobjetos.EnderecoFabricaObjetos.ENDERECO_NUM_ACIMA_TAMANHO_MAX;
import static br.com.contmatic.test.model.fabricaobjetos.EnderecoFabricaObjetos.ENDERECO_TODOS_ATRIBUTOS;
import static br.com.contmatic.test.model.fabricaobjetos.EnderecoFabricaObjetos.NUMERO_ENDERECO_02;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.INDICE_01;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.INDICE_02;
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
public class EnderecoTest {

    @BeforeClass
    public static void pre_test() {
        construirObjetos();
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_03_numero_nulo() {
        ENDERECO_TODOS_ATRIBUTOS.setNumero(null);
    }

    @Test(expected = IllegalStateException.class)
    public void test_04_numero_acima_max_chars() {
        ENDERECO_TODOS_ATRIBUTOS.setNumero(ENDERECO_NUM_ACIMA_TAMANHO_MAX);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_05_cep_nulo() {
        ENDERECO_TODOS_ATRIBUTOS.setCEP(null);
    }

    @Test(expected = IllegalStateException.class)
    public void test_06_cep_vazio() {
        ENDERECO_TODOS_ATRIBUTOS.setCEP(VAZIO);
    }

    @Test(expected = IllegalStateException.class)
    public void test_07_cep_tamanho_errado() {
        ENDERECO_TODOS_ATRIBUTOS.setCEP(CEP_TAMANHO_ERRADO);
    }

    @Test(expected = IllegalStateException.class)
    public void test_08_cep_com_letra() {
        ENDERECO_TODOS_ATRIBUTOS.setCEP(CEP_COM_LETRA);
    }

    @Test(expected = IllegalStateException.class)
    public void test_09_cep_com_chars_repstidos() {
        ENDERECO_TODOS_ATRIBUTOS.setCEP(CEP_CHARS_REPETIDOS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_10_rua_nula() {
        ENDERECO_TODOS_ATRIBUTOS.setRua(null);
    }

    @Test(expected = IllegalStateException.class)
    public void test_11_rua_vazia() {
        ENDERECO_TODOS_ATRIBUTOS.setRua(VAZIO);
    }

    @Test(expected = IllegalStateException.class)
    public void test_12_rua_com_char_nao_alfanumerico() {
        ENDERECO_TODOS_ATRIBUTOS.setRua(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
    }

    @Test(expected = IllegalStateException.class)
    public void test_13_rua_abaixo_min_chars() {
        ENDERECO_TODOS_ATRIBUTOS.setRua(TEXTO_COM_1_CHAR);
    }

    @Test(expected = IllegalStateException.class)
    public void test_14_rua_acima_max_chars() {
        ENDERECO_TODOS_ATRIBUTOS.setRua(MAX_CHARS_GERAL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_15_bairro_nulo() {
        ENDERECO_TODOS_ATRIBUTOS.setBairro(null);
    }

    @Test(expected = IllegalStateException.class)
    public void test_16_bairro_vazio() {
        ENDERECO_TODOS_ATRIBUTOS.setBairro(VAZIO);
    }

    @Test(expected = IllegalStateException.class)
    public void test_17_bairro_com_chars_nao_alfanumerico() {
        ENDERECO_TODOS_ATRIBUTOS.setBairro(TEXTO_COM_CHAR_NAO_ALFANUMERICO);
    }

    @Test(expected = IllegalStateException.class)
    public void test_18_barrio_abaixo_min_chars() {
        ENDERECO_TODOS_ATRIBUTOS.setBairro(TEXTO_COM_1_CHAR);
    }

    @Test(expected = IllegalStateException.class)
    public void test_19_bairro_acima_max_chars() {
        ENDERECO_TODOS_ATRIBUTOS.setBairro(MAX_CHARS_GERAL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_20_cidade_nula() {
        ENDERECO_TODOS_ATRIBUTOS.setCidade(null);
    }

    @Test
    public void test_21_metodo_hashcode() {
        assertEquals(ENDERECOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_01).hashCode(), ENDERECOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_02).hashCode());
    }

    @Test
    public void test_22_metodo_equals() {
        assertTrue(ENDERECOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_01).equals(ENDERECOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_01)));
        assertTrue(ENDERECOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_01).equals(ENDERECOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_02)));
        assertFalse(ENDERECO_ATRIBUTOS_OBRIGATORIOS.equals(null));
        assertFalse(ENDERECO_TODOS_ATRIBUTOS.equals(new Object()));

        ENDERECOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_01).setNumero(NUMERO_ENDERECO_02);
        assertFalse(ENDERECO_ATRIBUTOS_OBRIGATORIOS.equals(ENDERECO_TODOS_ATRIBUTOS));
        ENDERECOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS.get(INDICE_01).setCEP(CEP_02);
        assertFalse(ENDERECO_ATRIBUTOS_OBRIGATORIOS.equals(ENDERECO_TODOS_ATRIBUTOS));
    }

    @Test
    public void test_23_metodo_tostring() {
        assertThat(ENDERECO_TODOS_ATRIBUTOS.toString(), allOf(containsString(ENDERECO_TODOS_ATRIBUTOS.getNumero().toString()), containsString(ENDERECO_TODOS_ATRIBUTOS.getCep()),
            containsString(ENDERECO_TODOS_ATRIBUTOS.getRua()), containsString(ENDERECO_TODOS_ATRIBUTOS.getBairro()), containsString(ENDERECO_TODOS_ATRIBUTOS.getCidade().toString())));
    }
}
