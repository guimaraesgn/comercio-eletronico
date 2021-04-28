package acessobd_manha;

// Bibliotecas de classes para uso da classe
import java.awt.Dimension;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author sicsu
 */
public class TelaProduto extends javax.swing.JFrame {

  // Criação de um objeto Acesso para uso em todos os métodos
  AcessoBD acesso = new AcessoBD();
  // Criação de um RecordSet para receber os registros das consultas
  ResultSet rs;

  public TelaProduto() {
    // Construtor da janela com definição de liberação dos componentes
    initComponents();
    // Para centralizar a tela:
    // Verifica o tamanho da tela (Altura e largura)
    Dimension dim = this.getToolkit().getScreenSize();
    // define a posição horizontal x com a metade da largura que sobra ao se descontar a lagura da janela
    int x = (int) (dim.width - this.getSize().width) / 2;
    // define a posição vertical y com a metade da altura que sobra ao se descontar a altura da janela
    int y = (int) (dim.height - this.getSize().height) / 2;
    this.setLocation(x, y);
    // Configura os componentes que serão liberados ou restringidos
    // Os identificadores destes componentes tiveram seus nomes alterados
    // para facilitar o desenvolvimento
    // Verifica se a aplicação conseguiu conectar ao banco
    
    //
    if (acesso.conectar()) {
      System.out.println("Banco Conectado através do método Construtor!");
    } else {
      System.out.println("Banco NÃO Conectado através do método Construtor!");
    }
  }

  /**
   * O conteúdo a seguir foi gerado pelo NetBeans na criação da tela e não pode
   * ser alterado.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        btSair = new javax.swing.JButton();
        btIncluir = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btListar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        lista.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        lista.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lista);

        btSair.setText("Retornar");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        btIncluir.setText("Incluir");
        btIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncluirActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btListar.setText("Gerar Listagem");
        btListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListarActionPerformed(evt);
            }
        });

        jLabel1.setText("CONTROLE DE ALUNOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btIncluir)
                                .addGap(18, 18, 18)
                                .addComponent(btAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btListar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btListar)
                    .addComponent(btExcluir)
                    .addComponent(btAlterar)
                    .addComponent(btIncluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 // método do botão de saída da aplicação
    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
      // encerra a execução de uma janela
      if (acesso.desconectar()) {
        System.out.println("Banco Desconecta através do botão de retorno!");
        // Se desconectou, retorna a tela principal
        this.dispose();
      }
    }//GEN-LAST:event_btSairActionPerformed

 // Método do botão de inclusão
    private void btIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIncluirActionPerformed
      // Executa a janela de preenchimento de dados em modo inclusão
      // 1o parâmetro = 1 - Inclusão e 2o parâmetro = 0 (zero) sem id 
      TelaDadosProduto tdadosproduto = new TelaDadosProduto(1, 0);
      tdadosproduto.setVisible(true);
    }//GEN-LAST:event_btIncluirActionPerformed
  // Método do botão de Alteração
    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
      // A primeira linha possui o título e não um registro válido
      // Verifica se a linha de título está selecionada, índice = 0
      // o trim() é necessário para eliminar os espaços na conversão
      if (lista.getSelectedIndex() != 0) {
        String id = lista.getSelectedValue().substring(0, 3);
        if (Integer.parseInt(id.trim()) <= 0) {
          String mensagem = "Opção inválida!";
          JOptionPane.showMessageDialog(null, mensagem);
        }
        // Executa a janela de preenchimento de dados em modo alteração
        // 1o parâmetro = 2 - Alteração e 2o parâmetro = id do registro 
        // o trim() é necessário para eliminar os espaços na conversão
        TelaDadosProduto tdadosproduto = new TelaDadosProduto(2, Integer.parseInt(id.trim()));
        tdadosproduto.setVisible(true);
      } // Verificação de segurança
      else {
        String mensagem = "Opção inválida!";
        JOptionPane.showMessageDialog(null, mensagem);
      }
    }//GEN-LAST:event_btAlterarActionPerformed
  // Método do botão de Exclusão
    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
      // A primeira linha possui o título e não um registro válido
      // Verifica se a linha de título está selecionada, índice = 0
      // o trim() é necessário para eliminar os espaços na conversão
      if (lista.getSelectedIndex() != 0) {
        String id = lista.getSelectedValue().substring(0, 3);
        if (Integer.parseInt(id.trim()) <= 0) {
          String mensagem = "Opção inválida!";
          JOptionPane.showMessageDialog(null, mensagem);
        }
        // Executa a janela de preenchimento de dados em modo exclusão
        // 1o parâmetro = 3 - Exclusão e 2o parâmetro = id do registro 
        // o trim() é necessário para eliminar os espaços na conversão
        TelaDadosProduto tdadosproduto = new TelaDadosProduto(3, Integer.parseInt(id.trim()));
        tdadosproduto.setVisible(true);
      } // Verificação de segurança
      else {
        String mensagem = "Opção inválida!";
        JOptionPane.showMessageDialog(null, mensagem);
      }
    }//GEN-LAST:event_btExcluirActionPerformed
  // Método do botão de listar registros
    private void btListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListarActionPerformed
      // Cria um objeto ALunoDAO para acesso aos métodos de acesso
      // ao banco do Objeto Aluno
      ProdutoDAO ad = new ProdutoDAO();
      // Verifica se a listagem foi gerada
      if (!ad.listarProdutos()) {
        String mensagem = "Listagem Não Gerada!";
        JOptionPane.showMessageDialog(null, mensagem);
      }
    }//GEN-LAST:event_btListarActionPerformed

  private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
    // TODO add your handling code here:
    // Como o método atualizar a lista usava um JOptionPane, o foco retornava a janela
    // tornando a chamada do método formWindowGainedFocus recursivo ( quando um 
    // método chama a ele mesmo.
    // Desta forma as mensagens estão sendo exibidas na saída em modo texto.
      if (preencherLista()) {
        System.out.println("Lista atualizada quando a janela retoma o foco!");
      }
  }//GEN-LAST:event_formWindowGainedFocus
  // Método auxiliar da Janela de controle para preenchimento do
  // componente JList
  // Retorna o status da operação 

  public boolean preencherLista() {
    // Tratamento de Exceções
    try {
      // Determina a consulta a ser realizada
      String consulta = "select * from produtos";
      // Cria um objeto e prepara para realização da consulta
      PreparedStatement stm = acesso.con.prepareStatement(consulta);
      // Executa a consulta ao Banco
      rs = stm.executeQuery();
      // Cria um ArrayList para receber os registros da consulta e
      // preencher a lista
      ArrayList<String> ar = new ArrayList();
      // Formata a linha de título do JList
      String linha = String.format("%3s|%-15s|%10s",
              "Id", "Nome", "Preco");
      // Adiciona a linha ao ArrayList
      ar.add(linha);
      // Enquanto houver registros
      while (rs.next()) {
        // Formata a linha de registros da lista
        linha = String.format("%3s|%-15s|%10s", rs.getString("id"),
                rs.getString("nome"),
                rs.getString("preco"));
        // Adiciona a linha ao ArrayList
        ar.add(linha);
      }
      // Vetor para preparação dos elementos da lista
      String vet[] = new String[ar.size()];
      // Carrega todos os elementos do ArrayList no vetor
      for (int i = 0; i < ar.size(); i++) {
        vet[i] = ar.get(i);
      }
      // Prepara o JList para exibir os dados com fonte plena,
      // Evita que os dados fiquem fora de ordem
      lista.setFont(new Font("Courier New", Font.PLAIN, 11));
      // Inclui os elemento do vetor no JList
      lista.setListData(vet);
      // Seleciona um elemento da lista (o primeiro) para 
      // evitar que o usuário utlize a alteração ou exclusão
      // sem nenhuma escolha
      lista.setSelectedIndex(1);
      // confirma a execução com sucesso
      return true;
      //lista.add(dlm);    
    } catch (Exception e) { // Tratamento de exceção
        String mensagem = "Exceção! Lista não preenchida!";
      JOptionPane.showMessageDialog(null, mensagem);
      // Retorna que a execução não obteve sucesso
      return false;
    }

  }

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new TelaProduto().setVisible(true);
      }
    });
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btIncluir;
    private javax.swing.JButton btListar;
    private javax.swing.JButton btSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lista;
    // End of variables declaration//GEN-END:variables
}
