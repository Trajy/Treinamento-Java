package br.com.contmatic.test.model.fabricaobjetos;

import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.fabricarObjeto;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.obterObjeto;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.obterVariosObjetos;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.gerarLetrasAleatorias;
import static br.com.contmatic.test.model.fabricaobjetos.ObjetoFixtureTemplate.TODOS_ARGS;
import static br.com.contmatic.test.model.fabricaobjetos.ObjetoFixtureTemplate.OBRIGATORIOS_ARGS;
import static br.com.contmatic.test.model.fabricaobjetos.AmbienteTrabalhoFabricaObjetos.AMBIENTES_DE_TRABALHO;
import static br.com.contmatic.test.model.fabricaobjetos.CargoFabricaObjetos.CARGOS;
import static br.com.contmatic.test.model.fabricaobjetos.EmailFabricaObjetos.EMAILS_IGUAIS_ARGS_OBRIGATORIOS;
import static br.com.contmatic.test.model.fabricaobjetos.EnderecoFabricaObjetos.ENDERECOS;
import static br.com.contmatic.test.model.fabricaobjetos.FuncionarioFabricaObjetos.FUNCIONARIOS;
import static br.com.contmatic.test.model.fabricaobjetos.ProdutoFabricaObjetos.PRODUTOS;
import static br.com.contmatic.test.model.fabricaobjetos.TelefoneFabricaObjetos.TELEFONES;

import java.util.List;

import br.com.contmatic.model.empresa.Empresa;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.function.impl.CnpjFunction;

public final class EmpresaFabricaObjetos {
    
    private EmpresaFabricaObjetos() {
        
    }
    
    public static final String CNPJ;
    public static final String CNPJ_02;
    public static final String OUTRO_CNPJ;
    public static final String RAZAO_SOCIAL;
    public static final String OUTRA_RAZAO_SOCIAL;
    public static final String NOME_FANTASIA;
    public static final String OUTRO_NOME_FANTASIA;
    public static final String AREA_ATUACAO;
    public static final Empresa EMPRESA_TODOS_ATRIBUTOS;
    public static final Empresa EMPRESA_ATRIBUTOS_OBRIGATORIOS;
    public static final Empresa EMPRESA_ATRIBUTOS_OBRIGATORIOS_02;
    
    public static final String CNPJ_INVALIDO;
    public static final String CNPJ_NUMEROS_REPETIDOS;
    public static final String CNPJ_COM_LETRA;
    public static final String CNPJ_COM_QUATIDADE_DIGITOS_DIFERENTE;
    
    public static final List<Empresa> EMPRESAS_IGUAIS_ATRIBUTOS_OBRIGATORIOS;
    
    static {
        CNPJ = "11222333000181";
        CNPJ_02 = "34757271000108";
        OUTRO_CNPJ = "61830755000108";
        RAZAO_SOCIAL = "SOFTMATIC ... LTDA";
        OUTRA_RAZAO_SOCIAL = "Teste SOFTMATIC";
        NOME_FANTASIA = "CONTMATIC ... LTDA";
        OUTRO_NOME_FANTASIA = "Teste CONTMATIC";
        AREA_ATUACAO = "Software";        
        EMPRESA_ATRIBUTOS_OBRIGATORIOS = new Empresa(CNPJ_02);
        EMPRESA_ATRIBUTOS_OBRIGATORIOS_02 = new Empresa(CNPJ);
        
        CNPJ_INVALIDO = "58119371000178";
        CNPJ_NUMEROS_REPETIDOS = "11111111111111";
        CNPJ_COM_LETRA = "5811937a00017";
        CNPJ_COM_QUATIDADE_DIGITOS_DIFERENTE = "123456789012345";
        
        Class<Empresa> classe = Empresa.class;
        fabricarEmpresas(classe);
        
        final int QTD_EMPRESAS_IGUAIS = 2;
        EMPRESAS_IGUAIS_ATRIBUTOS_OBRIGATORIOS = obterVariosObjetos(classe, OBRIGATORIOS_ARGS, QTD_EMPRESAS_IGUAIS);
        EMPRESA_TODOS_ATRIBUTOS = obterObjeto(classe, TODOS_ARGS);
        
    }
    
    static void setDemaisDadosEmpresa() {
        EMPRESA_TODOS_ATRIBUTOS.setEmails(EMAILS_IGUAIS_ARGS_OBRIGATORIOS);
        EMPRESA_TODOS_ATRIBUTOS.setTelefones(TELEFONES);
        EMPRESA_TODOS_ATRIBUTOS.setEnderecos(ENDERECOS);
        EMPRESA_TODOS_ATRIBUTOS.setFuncionarios(FUNCIONARIOS);
        EMPRESA_TODOS_ATRIBUTOS.setProdutos(PRODUTOS);
        EMPRESA_TODOS_ATRIBUTOS.setCargos(CARGOS);
        EMPRESA_TODOS_ATRIBUTOS.setAmbientesTrabalho(AMBIENTES_DE_TRABALHO); 
    }
    
    private static void fabricarEmpresas(Class classe) {
        fabricarObjeto(classe, TODOS_ARGS, new Rule() {{
            add("cnpj", gerarCnpj());
            add("razaoSocial", gerarLetrasAleatorias());
            add("nomeFantasia", gerarLetrasAleatorias());
            add("areaAtuacao", gerarAreaAtuacao());
        }});
        fabricarObjeto(classe, OBRIGATORIOS_ARGS, new Rule() {{
            add("cnpj", gerarCnpj());
        }});
    }
    
    private static String gerarCnpj() {
        return new CnpjFunction().generateValue();
    }
    
    private static String gerarAreaAtuacao() {
        final int AREA_ATUACAO_TAMANHO_MIN = 4;
        final int AREA_ATUACAO_TAMANHO_MAX = 40;
        return gerarLetrasAleatorias(AREA_ATUACAO_TAMANHO_MIN, AREA_ATUACAO_TAMANHO_MAX);
    }

}
