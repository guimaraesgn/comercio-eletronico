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
public class Endereco {
    
    private int id;
    private String cep;
    private String rua;
    private String numero;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    
    
    public Endereco(){
        
    }

}

