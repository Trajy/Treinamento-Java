package br.com.contmatic.test.model.fabricaobjetos;

import static br.com.contmatic.test.model.fabricaobjetos.ComumErroFabricaObjetos.construirComumErro;
import static br.com.contmatic.test.model.fabricaobjetos.AmbienteTrabalhoFabricaObjetos.construirAmbienteTrabalho;
import static br.com.contmatic.test.model.fabricaobjetos.AmbienteTrabalhoFabricaObjetos.AMBIENTE_TRAB_01;
import static br.com.contmatic.test.model.fabricaobjetos.CargoFabricaObjetos.construirCargo;
import static br.com.contmatic.test.model.fabricaobjetos.CargoFabricaObjetos.CARGO_01;
import static br.com.contmatic.test.model.fabricaobjetos.EmailFabricaObjetos.construirEmail;
import static br.com.contmatic.test.model.fabricaobjetos.EmpresaFabricaObjetos.construirEmpresa;
import static br.com.contmatic.test.model.fabricaobjetos.EmpresaFabricaObjetos.EMPRESA_TODOS_ATRIBUTOS;
import static br.com.contmatic.test.model.fabricaobjetos.EnderecoFabricaObjetos.construirEndereco;
import static br.com.contmatic.test.model.fabricaobjetos.FuncionarioFabricaObjetos.construirFuncionario;
import static br.com.contmatic.test.model.fabricaobjetos.FuncionarioFabricaObjetos.FUNCIONARIO_01;
import static br.com.contmatic.test.model.fabricaobjetos.ProdutoFabricaObjetos.construirProduto;
import static br.com.contmatic.test.model.fabricaobjetos.ProdutoFabricaObjetos.PRODUTO_01;
import static br.com.contmatic.test.model.fabricaobjetos.TelefoneFabricaObjetos.construirTelefone;

public final class FabricaObjetos {
    
    private FabricaObjetos() {
        
    }
    
    public static final void construirObjetos() {
        construirComumErro();
        construirEmail();
        construirTelefone();
        construirEndereco();
        construirProduto();
        construirCargo();
        construirAmbienteTrabalho();
        construirFuncionario();
        construirEmpresa();
        construirEmpresa();
        relacionarEmpresa();
    }
    
    private static final void relacionarEmpresa() {
        PRODUTO_01.setEmpresa(EMPRESA_TODOS_ATRIBUTOS);
        CARGO_01.setEmpresa(EMPRESA_TODOS_ATRIBUTOS);
        AMBIENTE_TRAB_01.setEmpresa(EMPRESA_TODOS_ATRIBUTOS);
        FUNCIONARIO_01.setEmpresa(EMPRESA_TODOS_ATRIBUTOS);   
    }
}
