/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gitprojetoreaquecimento;

import java.util.ArrayList;

/**
 *
 * @author Fagner_Scheibel
 */
public class Cliente {
    
    private String nome;
    private int idade;
    
    public Cliente(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }
    
    public String getClienteNome(){
        return nome;
    }
    
    public int getClienteIdade(){
        return idade;
    }
    
    public String toString(){
        return "Nome: " + nome + 
                "\nIdade: " + idade +
                "\n";
    }
}
