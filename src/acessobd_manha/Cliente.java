package acessobd_manha;

/**
 *
 * @author sicsu
 */
public class Cliente extends Pessoa{
  // Definição dos Atributos do Objeto

  private int id;
  private Endereco id_endereco;
  private String telefone;
  
  // Métodos de Acesso

  public int getId() {
    return id;
  }

  public void setId(int id) {
   this.id = id;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

    public Endereco getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(Endereco id_endereco) {
        this.id_endereco = id_endereco;
    }
  
  
  
  
  
  // Métodos Construtores

  @Override
  public String recuperaDados(){
      
      String dados = getNome() + " - " + getCpf() + " - " + this.telefone;
        return dados;
      
  }
  
  
  public Cliente() {
  }

  public Cliente(int id, String telefone) {
    this.id = id;
  
    this.telefone = telefone;
  }
}
