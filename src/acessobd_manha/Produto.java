package acessobd_manha;

/**
 *
 * @author sicsu
 */
// Classe Aluno para atender às caracteríticas do objeto
public class Produto {
  // Definição dos Atributos do Objeto

  private int id;
  private String nome;
  private double preco;
  // Métodos de Acesso

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }
  // Métodos Construtores

  public Produto() {
  }
  
  
  public Produto(int id, String nome, double preco) {
    this.id = id;
    this.nome = nome;
    this.preco = preco;
    
           
  }
}
