package acessobd_manha;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author sicsu
 */
// Classe de controle da manipução das operações no 
// Banco de dados da classe 

public class ProdutoDAO {
  // Método para realizar a busca na Tabela Alunos dos dados do registro
  // do aluno identificado pelo id

  public Produto buscarProduto(int id) {
    // Cria um objeto de Conexão com o Banco de Dados
    AcessoBD acesso = new AcessoBD();
    // Cria um objeto Aluno para retornar os dados do registro
    Produto produto = new Produto();
    // Cria um ResultSet para armazenar o resultado da pesquisa
    ResultSet rs;
    // Tenta realizar a conexão com o banco de Dados para realizar a operação
    if (acesso.conectar()) {
      // Tramento de exceções
      try {
        // Define a consulta na tabela Alunos através do id
        String consulta = "select * from produtos where id="
                + String.valueOf(id).trim();
        // Cria um objeto para realizar a consulta
        PreparedStatement stm = acesso.con.prepareStatement(consulta);
        // Executa a consulta
        rs = stm.executeQuery();
        // Existindo resultado os valores dos campos são transferidos
        // para o objeto Aluno
        if (rs.next()) {
          if (Integer.parseInt(rs.getString("id")) > 0) {
            produto.setId(Integer.parseInt(rs.getString("id")));
            produto.setNome(rs.getString("nome"));
            produto.setPreco(Double.valueOf(rs.getString("preco")));
          }
        }
      } catch (Exception e) {
        // Informa caso a operação não tenha obtido sucesso
        e.printStackTrace();
        String mensagem = "Produto não Encontrado!";
        JOptionPane.showMessageDialog(null, mensagem);
        return null;
      }
    }
    // Desconecta com o Banco após realizar a operação
    acesso.desconectar();
    // Retorna um objeto Aluno com os dados do registro da tabela
    return produto;
  }

  // Método para realizar a inclusão de um no registro na Tabela Alunos
  public boolean inserir(Produto produto) {
    // Cria o objeto para a conexão
    AcessoBD acesso = new AcessoBD();
    // Tenta realizar a conexão com o banco de Dados para realizar a operação
    if (acesso.conectar()) {
      // Tramento de exceções
      try {
        // Define a consulta de inclusão na tabela Alunos 
        String consulta = "INSERT into Produtos ( nome, preco) "
                + "VALUES('" 
                + produto.getNome() + "','" + produto.getPreco() + "')";
        // Cria um objeto para realizar a consulta
        Statement st = acesso.con.createStatement();
        // Executa a consulta
        st.executeUpdate(consulta);
      } catch (Exception e) {
        // Informa caso a operação não tenha obtido sucesso
        e.printStackTrace();
        String mensagem = "Produto não Incluído!";
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

  public boolean alterar(Produto produto) {
    // cria o objeto para a conexão
    AcessoBD acesso = new AcessoBD();
    // Tenta realizar a conexão com o banco de Dados para realizar a operação
    if (acesso.conectar()) {
      // Tramento de exceções
      try {
        // Define a consulta de alteração na tabela Alunos 
        String consulta = "UPDATE Produtos SET nome='"
                + produto.getNome() + "',  preco='" + produto.getPreco()
                + "' WHERE id=" + produto.getId();
        // Cria um objeto para realizar a consulta
        Statement st = acesso.con.createStatement();
        // Executa a consulta
        st.executeUpdate(consulta);
      } catch (Exception e) {
        // Informa caso a operação não tenha obtido sucesso
        e.printStackTrace();
        String mensagem = "Produto não Alterado!";
        JOptionPane.showMessageDialog(null, mensagem);
        return false;
      }
    }
    // Desconecta com o Banco após realizar a operação
    acesso.desconectar();
    // Informa que a operação obteve sucesso
    return true;
  }

  public boolean excluir(Produto produto) {
    // cria o objeto para a conexão
    AcessoBD acesso = new AcessoBD();
    // Tenta realizar a conexão com o banco de Dados para realizar a operação
    if (acesso.conectar()) {
      // Tramento de exceções
      try {
        // Define a consulta de exclusão na tabela Alunos 
        String consulta = "DELETE from Produtos WHERE id=" + produto.getId();
        // Cria um objeto para realizar a consulta
        Statement st = acesso.con.createStatement();
        // Executa a consulta
        st.executeUpdate(consulta);
      } catch (Exception e) {
        // Informa caso a operação não tenha obtido sucesso
        e.printStackTrace();
        String mensagem = "Produto não Excluído!";
        JOptionPane.showMessageDialog(null, mensagem);
        return false;
      }
    }
    // Desconecta com o Banco após realizar a operação
    acesso.desconectar();
    // Informa que a operação obteve sucesso
    return true;
  }

  public boolean listarProdutos() {
    // cria o objeto para a conexão
    AcessoBD acesso = new AcessoBD();
    // Cria um objeto Aluno armazenar os dados de cada registro da tabela
    Produto produto = new Produto();
    // Cria um ResultaSet para armazenar os registros resultantes da consulta
    ResultSet rs;
    // Tenta realizar a conexão com o banco de Dados para realizar a operação
    if (acesso.conectar()) {
      // Tramento de exceções
      try {
        String mensagem = "O resultado será exibido no ambiente de execução em modo texto!";
        JOptionPane.showMessageDialog(null, mensagem);
        // Define a consulta de busca dos registros na tabela Alunos 
        String consulta = "select * from produtos";
        // Cria um objeto para realizar a consulta
        PreparedStatement stm = acesso.con.prepareStatement(consulta);
        // Executa a consulta ao Banco e armazena o resultado no ResultSet
        rs = stm.executeQuery();
        // Formata o título do relatório
        String linha = String.format("%3s|%-15s|%10s",
                "Id", "Nome", "Preco");
        // Exibe o título do relatório
        System.out.println(linha);
        // Enquanto houver registros, o objeto Aluno recebe os dados 
        // de cada registro da tabela
        while (rs.next()) {
          if (Integer.parseInt(rs.getString("id")) > 0) {
            produto.setId(Integer.parseInt(rs.getString("id")));
            
            produto.setNome(rs.getString("nome"));
            produto.setPreco(Double.valueOf(rs.getString("preco")));
            // Formata a linha de conteúdo do relatório
            linha = String.format("%3s|%-15s|%10s", rs.getString("id"),
                    rs.getString("nome"),
                    rs.getString("preco"));
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
