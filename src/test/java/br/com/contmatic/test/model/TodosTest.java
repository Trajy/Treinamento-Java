package br.com.contmatic.test.model;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.contmatic.model.Cargo;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	AmbienteDeTrabalhoTest.class,
	Cargo.class,
	CidadeTest.class,
	EmailTest.class,
	EnderecoTest.class,
	FuncionarioTest.class,
	ProdutoTest.class,
	TelefoneTest.class,
	EmpresaTest.class
})

public class TodosTest {

}
