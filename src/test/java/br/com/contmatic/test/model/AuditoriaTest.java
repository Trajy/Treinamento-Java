package br.com.contmatic.test.model;

import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetos.*;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuditoriaTest {
    
    @BeforeClass
    public static void pre_teste() {
        construirObjetos();
    }
    
    

}
