package br.com.contmatic.test.model.fabricaobjetos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static br.com.contmatic.test.model.fabricaobjetos.AmbienteTrabalhoFabricaObjetos.*;
import static br.com.contmatic.test.model.fabricaobjetos.CargoFabricaObjetos.*;
import static br.com.contmatic.test.model.fabricaobjetos.EmailFabricaObjetos.*;
import static br.com.contmatic.test.model.fabricaobjetos.EnderecoFabricaObjetos.*;
import static br.com.contmatic.test.model.fabricaobjetos.TelefoneFabricaObjetos.*;
import br.com.contmatic.model.empresa.Funcionario;

public final class FuncionarioFabricaObjetos {
    
    private FuncionarioFabricaObjetos() {
        
    }
    
    public static String CPF_01;
    public static String CPF_02;
    public static String CPF_03;
    public static String CPF_04;
    public static String CPF_05;
    public static String CPF_06;
    public static String CPF_07;
    public static String CPF_08;
    public static String NOME_01;
    public static String NOME_02;
    public static String RG_01;
    public static String RG_02;
    public static LocalDate DATA_NASCIMENTO_01;
    public static LocalDate DATA_NASCIMENTO_02;
    public static String  SETOR_01;
    public static String SETOR_02;
    public static Float SALARIO_01;
    public static Float SALARIO_02;
    public static Funcionario FUNCIONARIO_01;
    public static Funcionario FUNCIONARIO_02;
    public static Funcionario FUNCIONARIO_03;
    public static Funcionario FUNCIONARIO_04;
    public static Funcionario FUNCIONARIO_05;
    public static Funcionario FUNCIONARIO_06;
    public static Funcionario FUNCIONARIO_07;
    public static Funcionario FUNCIONARIO_08;
    public static Funcionario FUNCIONARIO_ATRIBUTOS_OBRIGATORIOS;
    public static Funcionario OUTRO_FUNCIONARIO_ATRIBUTOS_OBRIGATORIOS;
    public static Funcionario FUNCIONARIO_TODOS_ATRIBUTOS;
    public static List<Funcionario> FUNCIONARIOS;
    public static List<Funcionario> LISTA_FUNCINARIOS_ACIMA_LIMITE;
    
    public static Float SALARIO_NEGATIVO;
    public static Float SALARIO_NEGATIVO_COM_PONTO;
    public static Float SALARIO_ACIMA_LIMITE;
    public static String CPF_INVALIDO;
    public static String CPF_COM_QUANTIDADE_DIG_DIFERENTE;
    public static String CPF_NUMEROS_REPETIDOS;
       
    static void construirFuncionario() {           
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
        DATA_NASCIMENTO_01 = LocalDate.of(1998, 5, 22);
        DATA_NASCIMENTO_02 = LocalDate.of(2000, 12, 30);
        SETOR_01 = "Programacao";
        SETOR_02 = "Producao";
        SALARIO_01 = 20000.00f;
        SALARIO_02 = 4500.95f;
        FUNCIONARIO_01 = new Funcionario(CPF_01, NOME_01, DATA_NASCIMENTO_01, ENDERECO_01, SETOR_01, CARGO_01, SALARIO_01);
        FUNCIONARIO_02 = new Funcionario(CPF_02, NOME_02, DATA_NASCIMENTO_02, ENDERECO_02, SETOR_02, CARGO_02, SALARIO_02);
        FUNCIONARIO_03 = new Funcionario(CPF_03);
        FUNCIONARIO_04 = new Funcionario(CPF_04);
        FUNCIONARIO_05 = new Funcionario(CPF_05);
        FUNCIONARIO_06 = new Funcionario(CPF_06);
        FUNCIONARIO_07 = new Funcionario(CPF_07);
        FUNCIONARIO_08 = new Funcionario(CPF_08);
        FUNCIONARIO_ATRIBUTOS_OBRIGATORIOS = new Funcionario(CPF_01);
        OUTRO_FUNCIONARIO_ATRIBUTOS_OBRIGATORIOS = new Funcionario(CPF_02);
        FUNCIONARIO_TODOS_ATRIBUTOS = new Funcionario(CPF_01, NOME_01, DATA_NASCIMENTO_01 , ENDERECO_01, SETOR_01, CARGO_01, SALARIO_01);
        FUNCIONARIO_TODOS_ATRIBUTOS.setRg(RG_01);
        FUNCIONARIO_TODOS_ATRIBUTOS.setEmails(EMAILS);
        FUNCIONARIO_TODOS_ATRIBUTOS.setTelefones(TELEFONES);
        FUNCIONARIO_TODOS_ATRIBUTOS.setAmbienteTrabalho(AMBIENTE_TRAB_01);
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
        
        SALARIO_NEGATIVO = -1000f;
        SALARIO_NEGATIVO_COM_PONTO = 0.0f;
        SALARIO_ACIMA_LIMITE = 105000f;  
        CPF_INVALIDO = "44632236011";
        CPF_COM_QUANTIDADE_DIG_DIFERENTE = "446322360121";
        CPF_NUMEROS_REPETIDOS = "22222222222";
        
    }
}