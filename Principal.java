import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;
import java.util.*;


class Pessoa {
    String nome;
    LocalDate dataNascimento;
    
    Pessoa(String nome, LocalDate dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
}

class Funcionario extends Pessoa {
    BigDecimal salario;
    String funcao;
    
    Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao){
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }
}

public class Principal {
    public static void main(String[]args){
        
        //inserindo todos funcionários 
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000,10,18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990,5,12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961,5,2), new BigDecimal("9836.14"), "Coordenador"));        
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988,10,14), new BigDecimal("19119.88"), "Diretor"));        
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995,1,5), new BigDecimal("2234.68"), "Recepcionista"));        
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999,11,19), new BigDecimal("1582.72"), "Operador"));    
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993,3,31), new BigDecimal("4071.84"), "Contador"));        
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994,7,8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003,5,24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996,9,2), new BigDecimal("1799.93"), "Gerente"));
        
        
        //removendo o João 3.2
        funcionarios.removeIf(f -> f.nome.equals("João"));

        
        //imprimir todos funcionários 3.3
        for (Funcionario f: funcionarios){
            System.out.println("Nome: " + f.nome);
            System.out.println("Data Nascimento: " + f.dataNascimento);
            System.out.println("Salário: " + f.salario);
            System.out.println("Função: " + f.funcao);
            
        
        }
        
        //funcionarios receberam 10% aumento 3.4
        for (Funcionario f : funcionarios){
        f.salario = f.salario.multiply(new BigDecimal("1.10"));
        }
        
        for (Funcionario f: funcionarios){
        System.out.println("\nNome: " + f.nome);
        System.out.println("Salário: " + f.salario);
        }
        
        // 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
        
        // 3.6 – Imprimir os funcionários, agrupados por função.
        
        // 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        for (Funcionario f : funcionarios) {
            if (f.dataNascimento.getMonthValue() == 10 || f.dataNascimento.getMonthValue() == 12) {
                System.out.println("\nNome: " + f.nome);
                System.out.println("Data de Nascimento: " + f.dataNascimento);
            }
        }
        
        // 3.9 – Imprimir o funcionário com a maior idade, exibir nome e idade.
        Funcionario maisVelho = Collections.max(funcionarios, Comparator.comparing(f -> f.dataNascimento));
        System.out.println("Nome: " + maisVelho.nome);
        System.out.println("Idade: " + (LocalDate.now().getYear() - maisVelho.dataNascimento.getYear()));

        // 3.10 – Lista de funcionários por ordem alfabética.
        funcionarios.sort(Comparator.comparing(f -> f.nome));
        for (Funcionario f : funcionarios) {
            System.out.println("Nome: " + f.nome);
        }

        // 3.11 – Imprimir o total dos salários dos funcionários.
        
        
        
    }
}