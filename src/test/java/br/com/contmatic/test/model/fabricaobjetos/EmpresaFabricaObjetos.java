package br.com.contmatic.test.model.fabricaobjetos;

import static br.com.contmatic.test.model.fabricaobjetos.AmbienteTrabalhoFabricaObjetos.*;
import static br.com.contmatic.test.model.fabricaobjetos.CargoFabricaObjetos.*;
import static br.com.contmatic.test.model.fabricaobjetos.EmailFabricaObjetos.ACIMA_LIMITE_EMAILS;
import static br.com.contmatic.test.model.fabricaobjetos.EmailFabricaObjetos.getEmailsIguais;
import static br.com.contmatic.test.model.fabricaobjetos.EnderecoFabricaObjetos.*;
import static br.com.contmatic.test.model.fabricaobjetos.FuncionarioFabricaObjetos.*;
import static br.com.contmatic.test.model.fabricaobjetos.ProdutoFabricaObjetos.*;
import static br.com.contmatic.test.model.fabricaobjetos.TelefoneFabricaObjetos.*;

import br.com.contmatic.model.empresa.Empresa;

public final class EmpresaFabricaObjetos {
    
    private EmpresaFabricaObjetos() {
        
    }
    
    public static String CNPJ;
    public static String CNPJ_02;
    public static String OUTRO_CNPJ;
    public static String RAZAO_SOCIAL;
    public static String OUTRA_RAZAO_SOCIAL;
    public static String NOME_FANTASIA;
    public static String OUTRO_NOME_FANTASIA;
    public static String AREA_ATUACAO;
    public static Empresa EMPRESA_TODOS_ATRIBUTOS;
    public static Empresa EMPRESA_ATRIBUTOS_OBRIGATORIOS;
    public static Empresa EMPRESA_ATRIBUTOS_OBRIGATORIOS_02;
    
    public static String CNPJ_INVALIDO;
    public static String CNPJ_NUMEROS_REPETIDOS;
    public static String CNPJ_COM_LETRA;
    public static String CNPJ_COM_QUATIDADE_DIGITOS_DIFERENTE;
    
    static {
        CNPJ = "11222333000181";
        CNPJ_02 = "34757271000108";
        OUTRO_CNPJ = "61830755000108";
        RAZAO_SOCIAL = "SOFTMATIC ... LTDA";
        OUTRA_RAZAO_SOCIAL = "Teste SOFTMATIC";
        NOME_FANTASIA = "CONTMATIC ... LTDA";
        OUTRO_NOME_FANTASIA = "Teste CONTMATIC";
        AREA_ATUACAO = "Software";     
        EMPRESA_TODOS_ATRIBUTOS = new Empresa(CNPJ_02, RAZAO_SOCIAL, NOME_FANTASIA, AREA_ATUACAO);   
        EMPRESA_ATRIBUTOS_OBRIGATORIOS = new Empresa(CNPJ_02);
        EMPRESA_ATRIBUTOS_OBRIGATORIOS_02 = new Empresa(CNPJ);
        
        CNPJ_INVALIDO = "58119371000178";
        CNPJ_NUMEROS_REPETIDOS = "11111111111111";
        CNPJ_COM_LETRA = "5811937a00017";
        CNPJ_COM_QUATIDADE_DIGITOS_DIFERENTE = "123456789012345";
    }
    
    static void setDemaisDadosEmpresa() {
        EMPRESA_TODOS_ATRIBUTOS.setEmails(getEmailsIguais(ACIMA_LIMITE_EMAILS));
        EMPRESA_TODOS_ATRIBUTOS.setTelefones(TELEFONES);
        EMPRESA_TODOS_ATRIBUTOS.setEnderecos(ENDERECOS);
        EMPRESA_TODOS_ATRIBUTOS.setFuncionarios(FUNCIONARIOS);
        EMPRESA_TODOS_ATRIBUTOS.setProdutos(PRODUTOS);
        EMPRESA_TODOS_ATRIBUTOS.setCargos(CARGOS);
        EMPRESA_TODOS_ATRIBUTOS.setAmbientesTrabalho(AMBIENTES_DE_TRABALHO); 
    }

}
