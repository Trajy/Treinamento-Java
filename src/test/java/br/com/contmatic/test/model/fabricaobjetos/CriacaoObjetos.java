package br.com.contmatic.test.model.fabricaobjetos;

import static br.com.contmatic.test.model.fabricaobjetos.AmbienteTrabalhoFabricaObjetos.construirAmbienteTrabalho;
import static br.com.contmatic.test.model.fabricaobjetos.AmbienteTrabalhoFabricaObjetos.AMBIENTE_TRAB_01;
import static br.com.contmatic.test.model.fabricaobjetos.CargoFabricaObjetos.construirCargo;
import static br.com.contmatic.test.model.fabricaobjetos.CargoFabricaObjetos.CARGO_01;
import static br.com.contmatic.test.model.fabricaobjetos.EmpresaFabricaObjetos.setDemaisDadosEmpresa;
import static br.com.contmatic.test.model.fabricaobjetos.EmpresaFabricaObjetos.EMPRESA_TODOS_ATRIBUTOS;
import static br.com.contmatic.test.model.fabricaobjetos.EnderecoFabricaObjetos.construirEndereco;
import static br.com.contmatic.test.model.fabricaobjetos.FuncionarioFabricaObjetos.construirFuncionario;
import static br.com.contmatic.test.model.fabricaobjetos.ProdutoFabricaObjetos.construirProduto;
import static br.com.contmatic.test.model.fabricaobjetos.ProdutoFabricaObjetos.PRODUTO_TODOS_ATRIBUTOS;
import static br.com.contmatic.test.model.fabricaobjetos.TelefoneFabricaObjetos.construirTelefone;
import static br.com.contmatic.test.model.fabricaobjetos.UnidadeFederativaFabricaObjetos.construirUnidadeFederativa;
import static br.com.contmatic.test.model.fabricaobjetos.AuditoriaFabricaObjetos.*;

public final class CriacaoObjetos {
    
    private CriacaoObjetos() {
        
    }
    
    public static final void construirObjetos() {
        construirTelefone();
        construirUnidadeFederativa();
        construirEndereco();
        construirProduto();
        construirCargo();
        construirAmbienteTrabalho();
        construirFuncionario();
        construirAuditoria();
        relacionarAuditoria();
        setDemaisDadosEmpresa();
        relacionarEmpresaDemaisClasses();
    }
    
    private static final void relacionarEmpresaDemaisClasses() {
        PRODUTO_TODOS_ATRIBUTOS.setEmpresa(EMPRESA_TODOS_ATRIBUTOS);
        CARGO_01.setEmpresa(EMPRESA_TODOS_ATRIBUTOS);
        AMBIENTE_TRAB_01.setEmpresa(EMPRESA_TODOS_ATRIBUTOS);   
    }
    
    private static final void relacionarAuditoria() {
        EMPRESA_TODOS_ATRIBUTOS.setNomeUsuarioCriacao(NOME_USUARIO_CRIACAO);
        EMPRESA_TODOS_ATRIBUTOS.setNomeUsuarioAlteracao(NOME_USUARIO_ALTERACAO);
        EMPRESA_TODOS_ATRIBUTOS.setIpCriacao(IP_CRIACAO);
        EMPRESA_TODOS_ATRIBUTOS.setIpAlteracao(IP_ALTERACAO);
        EMPRESA_TODOS_ATRIBUTOS.setDataCriacao(HOJE);
        EMPRESA_TODOS_ATRIBUTOS.setDataAlteracao(HOJE);
    }
}
