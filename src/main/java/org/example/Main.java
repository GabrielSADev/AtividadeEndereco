package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Pessoa> pessoas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int  loop = 0;

        while (loop != 1) {

            System.out.println("\n SEJA MUITO BEM VINDO A ATIVIDADE!!");
            System.out.println("1 - Cadastro de pessoas");
            System.out.println("2 - Buscar por pessoas");
            System.out.println("3 - Sair");

            int opc = scanner.nextInt();

            switch (opc){

                case 1:
                    System.out.println("=== DIGITE O NÚMERO DE PESSOAS A SEREM CADASTRADAS ===");
                    int cad = scanner.nextInt();

                    for (int i = 0; i < cad; i++) {
                        List<Endereco> enderecos = new ArrayList<>();

                        System.out.println("Digite um nome: ");
                        String nome = scanner.next();
                        System.out.println("Digite uma idade: ");
                        int idade = scanner.nextInt();
                        System.out.println("Digite a quantidade de endereços para esse usuário: ");
                        int qtdEndereco = scanner.nextInt();
                        for (int j = 0; j < qtdEndereco; j++) {
                            System.out.println("Digite o nome da rua e logo em seguida o número da casa:");
                            enderecos.add(new Endereco(scanner.next(), scanner.nextInt()));
                        }
                        pessoas.add(new Pessoa(nome, idade, enderecos));

                    }
                    for (int i = 0; i < pessoas.size(); i++) {
                        System.out.println("===================== \n");
                        System.out.println("Nome do proprietário: " + pessoas.get(i).getNome());
                        System.out.println("Idade: " + pessoas.get(i).getIdade());
                    }

                    break;
                case 2:
                    System.out.println("\n=== BUSCAR PESSOA PELO NOME ===");
                    System.out.println("Digite o nome da pessoa que deseja buscar: ");
                    String nomeBusca = scanner.next();


                    for (Pessoa pessoa : pessoas) {
                        if (pessoa.getNome().equalsIgnoreCase(nomeBusca)) {
                            System.out.println("===================== \n");
                            System.out.println("Nome do proprietário: " + pessoa.getNome());
                            System.out.println("Idade: " + pessoa.getIdade());
                            for (Endereco endereco : pessoa.getEnderecos()) {
                                System.out.println("Nome da Rua: " + endereco.getRua());
                                System.out.println("Número do endereço: " + endereco.getNumero());
                            }
                            break;
                        }
                    }

                    break;

                case 3:
                    System.out.println("Até breve!!!");
                    loop = 1;
                    break;
                default:
                    System.out.println("Número não encontrado!");
                    break;
            }

        }
    }
}