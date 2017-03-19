/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gitprojetoreaquecimento;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Fagner_Scheibel
 */
public class Banco {

    /**
     * @param args the command line arguments
     */
    private String nome;
    private int idade;
    Cliente cliente;
    
    ArrayList<Cliente> ArrayListCliente = new ArrayList<Cliente>();
    ArrayList<Cliente> ArrayListClienteChamadaPreferencial = new ArrayList<Cliente>();
    
   public void chegada(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
         
        cliente = new Cliente( nome, idade);
        adicionaCliente(cliente);
    }
    
    public void adicionaCliente(Cliente cliente){
        ArrayListCliente.add(cliente);
    }
    
    public void chamadaPreferencial(){
        //Ordena por idade do cliente
        int cont = 0;
        for (int i = 0; i <ArrayListCliente.size(); i++) {
            if (cont <= 0) {
                if (ArrayListCliente.get(i).getClienteIdade() >= 65){
                    ArrayListClienteChamadaPreferencial.add(ArrayListCliente.get(i));
                    ArrayListCliente.remove(i);
                    cont++;
                }
            }
        }
    }
    
    public int imprimeProximoCliente(){
        System.out.println("Chamada Normal\n");
        if (ArrayListCliente.size() == 0) {
            System.out.println("### Lista Vazia ###\n");
        }
        else{
            for (int i = 0; i < 1; i++) {
                System.out.println("" + ArrayListCliente.get(i).toString());
                ArrayListCliente.remove(i);
            }
        }
        return 0;
    }
    
    public int imprimeProximoClientePreferencial(){
        System.out.println("Chamada Preferencial\n");
        if (ArrayListClienteChamadaPreferencial.size() == 0) {
            System.out.println("### Lista Vazia ###\n");
            imprimeProximoCliente();
        }
        if(ArrayListClienteChamadaPreferencial.size() > 0){
            for (int i = 0; i < 1; i++) {
                System.out.println("" + ArrayListClienteChamadaPreferencial.get(i).toString());
                ArrayListClienteChamadaPreferencial.remove(i);
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    Banco b1 = new Banco();
        int caixa = 0;
        int opcao = 0;
        do{
        System.out.println("*************** Opções do Menu ***************\n\n"
                + "          0 - Sair do sistema\n"
                + "          1 - Caixa solicita próximo cliente\n"
                + "          2 - Cliente registra chegada\n\n"
                + "**********************************************\n");

            Scanner scanner1 = new Scanner(System.in);
            opcao = scanner1.nextInt();

            switch (opcao) {
                case 0:
                    // Sair do sistema
                    break;
                case 1:
                    System.out.println("Opções de chamada\n"
                    + "1 - Caixa de 1 a 5 ( Atendimento Preferencial)\n"
                    + "2 - Caixa 6 em diante ( Atendimento Nomral)\n");
                    Scanner scanner2 = new Scanner(System.in);
                    caixa = scanner2.nextInt();
                    switch (caixa) {
                         case 1:
                            // Caixa solicita próximo cliente
                            //System.out.println("Chamada Preferencial \n");
                            b1.chamadaPreferencial();
                            b1.imprimeProximoClientePreferencial();
                            break;
                         case 2:    
                            //System.out.println("Chamada Normal Caixa 6 em diante \n");
                            b1.imprimeProximoCliente();
                            //b1.imprimeListaClientesChamadaPreferencial();
                    }
                    break;
                case 2:
                    // Cliente registra chegada
                    System.out.print(" Digite o seu nome: ");
                    Scanner scanner3 = new Scanner(System.in);
                    String nomeCliente = scanner3.nextLine();
                    //System.out.println("Nome do Cliente é:  " + nomeCliente);

                    System.out.print(" Digite a sua idade: ");
                    Scanner scanner4 = new Scanner(System.in);
                    int idade = scanner4.nextInt();
                    //System.out.println("Idade do Cliente é: " + idade);
                    b1.chegada(nomeCliente, idade);
                    System.out.println("\n");
                    break;
                
                default:
                    // Usuário digitou opção inválida
                    System.out.println("***** Opção Inválida! *****\n");
                    break;
            } 
        } while (opcao != 0);
       }
}
