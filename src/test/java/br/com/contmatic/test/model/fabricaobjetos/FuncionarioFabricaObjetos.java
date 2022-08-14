package br.com.contmatic.test.model.fabricaobjetos;

import static br.com.contmatic.test.model.fabricaobjetos.CargoFabricaObjetos.CARGO_01;
import static br.com.contmatic.test.model.fabricaobjetos.CargoFabricaObjetos.CARGO_02;
import static br.com.contmatic.test.model.fabricaobjetos.CargoFabricaObjetos.CARGO_TODOS_ATRIBUDOS;
import static br.com.contmatic.test.model.fabricaobjetos.EmpresaFabricaObjetos.EMPRESA_ATRIBUTOS_OBRIGATORIOS_02;
import static br.com.contmatic.test.model.fabricaobjetos.EmpresaFabricaObjetos.EMPRESA_TODOS_ATRIBUTOS;
import static br.com.contmatic.test.model.fabricaobjetos.EnderecoFabricaObjetos.ENDERECO_01;
import static br.com.contmatic.test.model.fabricaobjetos.EnderecoFabricaObjetos.ENDERECO_02;
import static br.com.contmatic.test.model.fabricaobjetos.EnderecoFabricaObjetos.ENDERECO_TODOS_ATRIBUTOS;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.fabricarObjeto;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.gerarAPartirRegex;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.gerarNomeAleatorio;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.gerarValorNumerico;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.obterObjeto;
import static br.com.contmatic.test.model.fabricaobjetos.FabricaObjetosUtils.obterVariosObjetos;
import static br.com.contmatic.test.model.fabricaobjetos.ObjetoFixtureTemplate.OBRIGATORIOS_ARGS;
import static br.com.contmatic.test.model.fabricaobjetos.ObjetoFixtureTemplate.TODOS_ARGS;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.contmatic.model.empresa.Empresa;
import br.com.contmatic.model.empresa.Funcionario;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.function.impl.CpfFunction;

public final class FuncionarioFabricaObjetos {

    private FuncionarioFabricaObjetos() {

    }

    public static final String CPF_01;
    public static final String CPF_02;
    public static final String CPF_03;
    public static final String CPF_04;
    public static final String CPF_05;
    public static final String CPF_06;
    public static final String CPF_07;
    public static final String CPF_08;
    public static final String NOME_01;
    public static final String NOME_02;
    public static final String RG_01;
    public static final String RG_02;
    public static final LocalDate DATA_ATUAL;
    public static final LocalDate DATA_NASCIMENTO_01;
    public static final LocalDate DATA_NASCIMENTO_02;
    public static final LocalDate DATA_ACIMA_MAX;
    public static final LocalDate DATA_ABAIXO_MIN;
    public static final String SETOR_01;
    public static final String SETOR_02;
    public static final BigDecimal SALARIO_01;
    public static final BigDecimal SALARIO_02;
    public static final Funcionario FUNCIONARIO_01;
    public static final Funcionario FUNCIONARIO_02;
    public static final Funcionario FUNCIONARIO_03;
    public static final Funcionario FUNCIONARIO_04;
    public static final Funcionario FUNCIONARIO_05;
    public static final Funcionario FUNCIONARIO_06;
    public static final Funcionario FUNCIONARIO_07;
    public static final Funcionario FUNCIONARIO_08;
    public static final Funcionario FUNCIONARIO_ATRIBUTOS_OBRIGATORIOS;
    public static final Funcionario OUTRO_FUNCIONARIO_ATRIBUTOS_OBRIGATORIOS;
    public static final Funcionario FUNCIONARIO_TODOS_ATRIBUTOS;
    public static final List<Funcionario> FUNCIONARIOS;
    public static final List<Funcionario> LISTA_FUNCINARIOS_ACIMA_LIMITE;

    public static final BigDecimal SALARIO_NEGATIVO;
    public static final BigDecimal SALARIO_NEGATIVO_COM_PONTO;
    public static final BigDecimal SALARIO_ACIMA_LIMITE;
    public static final String CPF_INVALIDO;
    public static final String CPF_COM_QUANTIDADE_DIG_DIFERENTE;
    public static final String CPF_NUMEROS_REPETIDOS;
    public static final List<Funcionario> FUNCIONARIOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS;

    static {
        CPF_01 = "44632236012";
        CPF_02 = "38275183006";
        CPF_03 = "16916182091";
        CPF_04 = "62827689006";
        CPF_05 = "16421920071";
        CPF_06 = "45636760043";
        CPF_07 = "77189772006";
        CPF_08 = "82647631034";
        NOME_01 = "Julio";
        NOME_02 = "Ana";
        RG_01 = "243847701";
        RG_02 = "349694643";
        DATA_ATUAL = LocalDate.now();
        DATA_NASCIMENTO_01 = LocalDate.of(DATA_ATUAL.getYear() - 24, 5, 22);
        DATA_NASCIMENTO_02 = LocalDate.of(DATA_ATUAL.getYear() - 22, 12, 30);
        DATA_ACIMA_MAX = LocalDate.of(DATA_ATUAL.getYear() - 101, 9, 20);
        DATA_ABAIXO_MIN = LocalDate.of(DATA_ATUAL.getYear() - 15, 11, 15);
        SETOR_01 = "Programacao";
        SETOR_02 = "Producao";
        SALARIO_01 = new BigDecimal("20000.0");
        SALARIO_02 = new BigDecimal("4500.95");
        FUNCIONARIO_01 = new Funcionario(CPF_01, NOME_01, DATA_NASCIMENTO_01, ENDERECO_01, CARGO_01, SALARIO_01, EMPRESA_TODOS_ATRIBUTOS);
        FUNCIONARIO_01.setSetor(SETOR_01);
        FUNCIONARIO_02 = new Funcionario(CPF_02, NOME_02, DATA_NASCIMENTO_02, ENDERECO_02, CARGO_02, SALARIO_02, EMPRESA_TODOS_ATRIBUTOS);
        FUNCIONARIO_02.setSetor(SETOR_02);
        FUNCIONARIO_03 = new Funcionario(CPF_01, EMPRESA_TODOS_ATRIBUTOS);
        FUNCIONARIO_04 = new Funcionario(CPF_04, EMPRESA_ATRIBUTOS_OBRIGATORIOS_02);
        FUNCIONARIO_05 = new Funcionario(CPF_05, EMPRESA_TODOS_ATRIBUTOS);
        FUNCIONARIO_06 = new Funcionario(CPF_06, EMPRESA_TODOS_ATRIBUTOS);
        FUNCIONARIO_07 = new Funcionario(CPF_07, EMPRESA_TODOS_ATRIBUTOS);
        FUNCIONARIO_08 = new Funcionario(CPF_08, EMPRESA_TODOS_ATRIBUTOS);
        FUNCIONARIO_ATRIBUTOS_OBRIGATORIOS = new Funcionario(CPF_01, EMPRESA_TODOS_ATRIBUTOS);
        OUTRO_FUNCIONARIO_ATRIBUTOS_OBRIGATORIOS = new Funcionario(CPF_02, EMPRESA_TODOS_ATRIBUTOS);
        FUNCIONARIOS = new ArrayList<>();
        FUNCIONARIOS.add(FUNCIONARIO_01);
        FUNCIONARIOS.add(FUNCIONARIO_02);
        FUNCIONARIOS.add(FUNCIONARIO_03);
        FUNCIONARIOS.add(FUNCIONARIO_04);
        FUNCIONARIOS.add(FUNCIONARIO_05);
        FUNCIONARIOS.add(FUNCIONARIO_06);
        FUNCIONARIOS.add(FUNCIONARIO_07);
        FUNCIONARIOS.add(FUNCIONARIO_08);
        LISTA_FUNCINARIOS_ACIMA_LIMITE = new ArrayList<>();
        LISTA_FUNCINARIOS_ACIMA_LIMITE.addAll(FUNCIONARIOS);
        LISTA_FUNCINARIOS_ACIMA_LIMITE.add(FUNCIONARIO_01);

        SALARIO_NEGATIVO = new BigDecimal("-1000.0");
        SALARIO_NEGATIVO_COM_PONTO = BigDecimal.ZERO;
        SALARIO_ACIMA_LIMITE = new BigDecimal("105000");
        CPF_INVALIDO = "44632236011";
        CPF_COM_QUANTIDADE_DIG_DIFERENTE = "446322360121";
        CPF_NUMEROS_REPETIDOS = "22222222222";

        Class<Funcionario> classe = Funcionario.class;
        
        fabricarFuncionarios(classe);

        final int QTD_FUNCIONARIOS_IGUAIS = 2;
        FUNCIONARIOS_IGUAIS_ATRIBUTOS_OBRIGATORIOS = obterVariosObjetos(classe, OBRIGATORIOS_ARGS, QTD_FUNCIONARIOS_IGUAIS);
        FUNCIONARIO_TODOS_ATRIBUTOS = obterObjeto(classe, TODOS_ARGS);
    }

    static void construirFuncionario() {

    }
    
    private static void fabricarFuncionarios(Class classe) {
        fabricarObjeto(classe, TODOS_ARGS, new Rule() {{
            add("cpf", gerarCpf());
            add("nome", gerarNomeAleatorio());
            add("dataNascimento", gerarDataNascimento());
            add("endereco", ENDERECO_TODOS_ATRIBUTOS);
            add("cargo", CARGO_TODOS_ATRIBUDOS);
            add("salario", gerarSalario());
            add("empresa", new Empresa("11222333000181"));  
        }});
        fabricarObjeto(classe, OBRIGATORIOS_ARGS, new Rule() {{
            add("cpf", gerarCpf());
            add("empresa", new Empresa("11222333000181"));
        }});
    }

    private static String gerarCpf() {
        String cpfTest = new CpfFunction().generateValue();
        return new CpfFunction().generateValue();
    }
    
    private static BigDecimal gerarSalario() {
        final int SALARIO_MIN = 800;
        final int SALARIO_MAX = 100000;
        return new BigDecimal(gerarValorNumerico(SALARIO_MIN, SALARIO_MAX));
    }
    
    private static String gerarRg() {
        final String RG_EXPRESSAO_REGULAR = "[0-9xX]{8,10}";
        return gerarAPartirRegex(RG_EXPRESSAO_REGULAR);
    }
    
    private static LocalDate gerarDataNascimento() {
        return LocalDate.of(LocalDate.now().getYear() - 22, 12, 30);
    }
    
    
}
