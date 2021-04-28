package acessobd_manha;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * 
 */

public class ClienteDAO {
 

  public Cliente buscarCliente(int id) {
    // Cria um objeto de Conexão com o Banco de Dados
    AcessoBD acesso = new AcessoBD();

    Cliente cliente = new Cliente();
    // Cria um ResultSet para armazenar o resultado da pesquisa
    ResultSet rs;
    // Tenta realizar a conexão com o banco de Dados para realizar a operação
    if (acesso.conectar()) {
      // Tramento de exceções
      try {
        StringBuilder sb = new StringBuilder();
        sb.append(" select c.id,c.nome, c.cpf, c.telefone ,  ");
        sb.append(" e.cep, e.rua, e.numero  ");
        sb.append(" from Clientes c , Enderecos e   ");
        sb.append(" where c.id_endereco = e.id ");
        sb.append(" and c.id = ? ");
        // Cria um objeto para realizar a consulta
        PreparedStatement stm = acesso.con.prepareStatement(sb.toString());
        stm.setInt(1, id);
        // Executa a consulta
        rs = stm.executeQuery();
        if (rs.next()) {
          if (Integer.parseInt(rs.getString("id")) > 0) {
            cliente.setId(Integer.parseInt(rs.getString("id")));
            cliente.setCpf((rs.getString("cpf")));
            cliente.setNome(rs.getString("nome"));
            cliente.setTelefone(rs.getString("telefone"));
             Endereco e1 = new Endereco();               
         e1.setCep(rs.getString("cep"));
         e1.setRua(rs.getString("rua"));
         e1.setNumero(rs.getString("numero"));
         
        cliente.setId_endereco(e1);


          }
        }
      } catch (Exception e) {
        // Informa caso a operação não tenha obtido sucesso
        e.printStackTrace();
        String mensagem = "Cliente não Encontrado!";
        JOptionPane.showMessageDialog(null, mensagem);
        return null;
      }
    }
    // Desconecta com o Banco após realizar a operação
    acesso.desconectar();
    return cliente;
  }

  public boolean inserir(Cliente cliente) {
    // Cria o objeto para a conexão
    AcessoBD acesso = new AcessoBD();
    int idEndereco = cadastroEndereco(cliente.getId_endereco());
    // Tenta realizar a conexão com o banco de Dados para realizar a operação
    if (acesso.conectar()) {
      // Tramento de exceções
      try {
        String consulta = "INSERT into Clientes (cpf, nome, telefone, id_endereco) "
                + "VALUES('" + cliente.getCpf() + "','"
                + cliente.getNome() + "','" + cliente.getTelefone() +  "','"
                + idEndereco + "')";
        // Cria um objeto para realizar a consulta
        Statement st = acesso.con.createStatement();
        // Executa a consulta
        
   
                
        st.executeUpdate(consulta);
      } catch (Exception e) {
        // Informa caso a operação não tenha obtido sucesso
        e.printStackTrace();
        String mensagem = "Cliente não Incluído!";
        JOptionPane.showMessageDialog(null, mensagem);
        // Informa que a operação NÃO obteve sucesso
        return false;
      }
    }
    // Desconecta com o Banco após realizar a operação
    acesso.desconectar();
    // Informa que a operação obteve sucesso
    return true;
  
  }

  public int cadastroEndereco(Endereco endereco){
      // Cria o objeto para a conexão
    AcessoBD acesso = new AcessoBD();
    // Tenta realizar a conexão com o banco de Dados para realizar a operação
    int idEndereco = 0;
    if (acesso.conectar()) {
      // Tramento de exceções
      try {
      
        String consulta = "INSERT into Enderecos (cep, rua, numero) "
                + "VALUES('" + endereco.getCep() + "','"
                + endereco.getRua() + "','" + endereco.getNumero() + "')";
        // Cria um objeto para realizar a consulta
    PreparedStatement prep = acesso.con.prepareStatement(consulta,Statement.RETURN_GENERATED_KEYS);
    
        // Executa a consulta
         
       prep.executeUpdate();
       ResultSet rs = prep.getGeneratedKeys();
                if(rs.next())
                {
                    idEndereco = rs.getInt(1);
                }

      } catch (Exception e) {
        // Informa caso a operação não tenha obtido sucesso
        e.printStackTrace();
        String mensagem = "Endereco não Incluído!";
        JOptionPane.showMessageDialog(null, mensagem);
        // Informa que a operação NÃO obteve sucesso
      }
    }
    // Desconecta com o Banco após realizar a operação
    acesso.desconectar();
    // Informa que a operação obteve sucesso
    if(idEndereco==0){
        
        return -1;
    }else{
        return idEndereco;
    }
  
      
  }
  public boolean alterar(Cliente cliente) {
    // cria o objeto para a conexão
    AcessoBD acesso = new AcessoBD();
    // Tenta realizar a conexão com o banco de Dados para realizar a operação
    if (acesso.conectar()) {
      // Tramento de exceções
      try {
        String consulta = "UPDATE Clientes SET cpf="
                + cliente.getCpf() + ", nome='" + cliente.getNome()
                + "', telefone='" + cliente.getTelefone() + "'"
                
                + " WHERE id=" + cliente.getId();
        // Cria um objeto para realizar a consulta
        Statement st = acesso.con.createStatement();
        // Executa a consulta
        st.executeUpdate(consulta);
      } catch (Exception e) {
        // Informa caso a operação não tenha obtido sucesso
        e.printStackTrace();
        String mensagem = "Cliente não Alterado!";
        JOptionPane.showMessageDialog(null, mensagem);
        return false;
      }
    }
    // Desconecta com o Banco após realizar a operação
    acesso.desconectar();
    // Informa que a operação obteve sucesso
    return true;
  }

  public boolean excluir(Cliente cliente) {
    // cria o objeto para a conexão
    AcessoBD acesso = new AcessoBD();
    // Tenta realizar a conexão com o banco de Dados para realizar a operação
    if (acesso.conectar()) {
      // Tramento de exceções
      try {
      
        String consulta = "DELETE from Clientes WHERE id=" + cliente.getId();
        // Cria um objeto para realizar a consulta
        Statement st = acesso.con.createStatement();
        // Executa a consulta
        st.executeUpdate(consulta);
      } catch (Exception e) {
        // Informa caso a operação não tenha obtido sucesso
        e.printStackTrace();
        String mensagem = "Cliente não Excluído!";
        JOptionPane.showMessageDialog(null, mensagem);
        return false;
      }
    }
    // Desconecta com o Banco após realizar a operação
    acesso.desconectar();
    // Informa que a operação obteve sucesso
    return true;
  }

  public boolean listarClientes() {
    // cria o objeto para a conexão
    AcessoBD acesso = new AcessoBD();
   
    Cliente cliente = new Cliente();
    // Cria um ResultaSet para armazenar os registros resultantes da consulta
    ResultSet rs;
    // Tenta realizar a conexão com o banco de Dados para realizar a operação
    if (acesso.conectar()) {
      // Tramento de exceções
      try {
        String mensagem = "O resultado será exibido no ambiente de execução em modo texto!";
        JOptionPane.showMessageDialog(null, mensagem);
        
        StringBuilder sb = new StringBuilder();
        sb.append(" select c.id,c.nome, c.cpf, c.telefone ,  ");
        sb.append(" e.cep, e.rua, e.numero  ");
        sb.append(" from Clientes c , Enderecos e   ");
        sb.append(" where c.id_endereco = e.id ");
      
        // Cria um objeto para realizar a consulta
        PreparedStatement stm = acesso.con.prepareStatement(sb.toString());
    
        // Executa a consulta ao Banco e armazena o resultado no ResultSet
        rs = stm.executeQuery();
        // Formata o título do relatório
        String linha = String.format("%3s|%-15s|%11s|%10s|%10s|%10s|%10s",
                "Id", "Nome", "Cpf", "Telefone","Cep","Rua", "Numero");
        // Exibe o título do relatório
        System.out.println(linha);
        while (rs.next()) {
          if (Integer.parseInt(rs.getString("id")) > 0) {
            cliente.setId(Integer.parseInt(rs.getString("id")));
            cliente.setCpf((rs.getString("cpf")));
            cliente.setNome(rs.getString("nome"));
            cliente.setTelefone(rs.getString("telefone"));
            Endereco e1 = new Endereco();               
         e1.setCep(rs.getString("cep"));
         e1.setRua(rs.getString("rua"));
         e1.setNumero(rs.getString("numero"));
         
        cliente.setId_endereco(e1);
            
            // Formata a linha de conteúdo do relatório
            linha = String.format("%3s|%-15s|%11s|%10s|%10s|%10s|%10s", rs.getString("id"),
                    rs.getString("nome"), rs.getString("cpf"),
                    rs.getString("telefone"),
                    rs.getString("cep"), rs.getString("rua"), rs.getString("numero"));
            // Exibe cada registro
            System.out.println(linha);
          }
        }
      } catch (Exception e) {
        // Informa caso a operação não tenha obtido sucesso
        e.printStackTrace();
        System.out.println("Lista não Gerada!");
        return false;
      }
    }
    // Desconecta com o Banco após realizar a operação
    acesso.desconectar();
    // Informa que a operação obteve sucesso
    return true;
  }
}
