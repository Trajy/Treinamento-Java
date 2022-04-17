package br.com.contmatic.test.model;

import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetos.*;
import static br.com.contmatic.test.model.fabricaobjetos.EmpresaFabricaObjetos.EMPRESA_TODOS_ATRIBUTOS;
import static br.com.contmatic.test.model.fabricaobjetos.AuditoriaFabricaObjetos.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuditoriaTest {
    
    @BeforeClass
    public static void pre_teste() {
        construirObjetos();
    }
    
    @Test
    public void test_01_auditoria_classe_empresa() {
        assertEquals(NOME_USUARIO_CRIACAO, EMPRESA_TODOS_ATRIBUTOS.getNomeUsuarioCriacao());
        assertEquals(NOME_USUARIO_ALTERACAO, EMPRESA_TODOS_ATRIBUTOS.getNomeUsuarioAlteracao());
        assertEquals(IP_CRIACAO, EMPRESA_TODOS_ATRIBUTOS.getIpCriacao());
        assertEquals(IP_ALTERACAO, EMPRESA_TODOS_ATRIBUTOS.getIpAlteracao());
        assertEquals(HOJE, EMPRESA_TODOS_ATRIBUTOS.getDataCriacao());
        assertEquals(HOJE, EMPRESA_TODOS_ATRIBUTOS.getDataAlteracao());
    }
   
    
    
    
    
    

}
