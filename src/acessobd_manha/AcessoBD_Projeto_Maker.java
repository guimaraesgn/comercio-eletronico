/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acessobd_manha;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author sicsu
 */
public class AcessoBD_Projeto_Maker {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // Primeiro exemplo, só teste de conexão:
    /*
    
    // cria o objeto para a conexão
    Connection con = null;
    // Tratamento de exceção para classes de arquivo local e SQL
    try {
      // definição do driver de conexão do banco escolhido (Access)
      String driver = "jdbc:ucanaccess";
      // Nome do arquivo a ser aberto, como o arquivo está no diretório
      // base da aplicação, não é necessário indicar o caminho (Path)
      // se o arquivo estiver em outro local, será necessário indicar
      // o caminho antes do nome do arquivo. Caso o arquivo não seja
      // encontrado, será gerada uma exceção.
      String nomeArquivo = "Aula.accdb";
      // Tenta abrir o arquivo.
      File arquivo = new File(nomeArquivo);
      // Verifica se o arquivo não existe e informa caso o arquivo
      // não seja encontrado.
      if (!arquivo.exists()) {
        // .trim elimina espaços antes e depois do nome do arquivo
        System.err.println("Arquivo " + nomeArquivo.trim() + " não encontrado!");
      }

      // Definição do driver de acesso e do arquivo
      // os dois pontos e as barras são necessários para indicar o 
      // driver e o caminho do arquivo Access a ser aberto
      String database = driver + "://" + nomeArquivo.trim();

      // Executa a conexão com o banco de dados
      // Caso não consiga realizar a conexão, uma exceção será lançada
      con = DriverManager.getConnection(database);

      // Faz a leitura dos metadados do Banco de Dados
      DatabaseMetaData d = con.getMetaData();

      // Cria um objeto RasultSet para armazenar os resultados de uma
      // consulta na base de dados, é um tipo de ArrayList
      // neste caso, irá armazenar os nomes de todas as tabelas existentes
      // na base.
      ResultSet rs = d.getTables(null, null, "%", null);
      // enquanto houver elementos na lista, irá exibir o 4o parâmetro,
      // o 4o parâmetro armazena o nome da tabela.
      System.out.println("Tabelas existentes no arquivo Aula.accdb");
      while (rs.next()) {
        System.out.println(rs.getString(3));
      }
      // encerra o ResultSet
      rs.close();
      // encerra a conexão
      con.close();

    } catch (Exception e) { // trata a exceção se houver
      e.printStackTrace();
    }
    */
    // Segundo exemplo, uso do projeto:
    TelaPrincipal tp = new TelaPrincipal();
    tp.setVisible(true);


  }

}
