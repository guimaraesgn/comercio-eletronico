/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acessobd_manha;

/**
 *
 * @author caroline
 */
public class Pessoa implements IDados {
    
    private String cpf;
    private String nome;

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
    
    
    @Override
    public String recuperaDados(){
        String dados = this.nome + " - " + this.cpf;
        return dados;
    }
}



