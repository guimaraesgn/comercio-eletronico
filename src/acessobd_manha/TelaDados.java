package acessobd_manha;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JOptionPane;

/**
 *
 * @author sicsu
 */
public class TelaDados extends javax.swing.JFrame {

  // Atributos da clsses para ficarem disponíveis para todos os métodos
  int operacao;
  int id;

  // Construtor da janela alterado para receber o tipo de operação (1, 2 ou 3)
  // e o id do registro no banco, se id = 0 é uma inclusão
  public TelaDados(int operacao, int id) {
    initComponents();
    // Para centralizar a tela:
    // Verifica o tamanho da tela (Altura e largura)
    Dimension dim = this.getToolkit().getScreenSize();
    // define a posição horizontal x com a metade da largura que sobra ao se descontar a lagura da janela
    int x = (int) (dim.width - this.getSize().width) / 2;
    // define a posição vertical y com a metade da altura que sobra ao se descontar a altura da janela
    int y = (int) (dim.height - this.getSize().height) / 2;
    this.setLocation(x, y);
    // repassa os dados recebidos para os atributos da classe
    this.operacao = operacao;
    this.id = id;
    // Limpa os conteúdos das caixas de texto
    tfCpf.setText("");
    tfNome.setText("");
    tfTelefone.setText("");
    tfCep.setText("");
    tfRua.setText("");
    tfNum.setText("");
    
    
    // Altera a fonte do Label de Título da janela
    lb1.setFont(new Font("Times Roman", Font.PLAIN, 14));
    if (operacao == 1) {
      // Determina o título da janela para uma inclusão
      lb1.setText("Inclusão");
    }
    if (operacao == 2) {
      // Determina o título da janela para uma alteração
      lb1.setText("Alteração");
      Cliente al = new Cliente();

      ClienteDAO ad = new ClienteDAO();

      al = ad.buscarCliente(id);
      tfCpf.setText(String.valueOf(al.getCpf()));
      tfNome.setText(al.getNome());
      tfTelefone.setText(al.getTelefone());
      tfCep.setText(al.getId_endereco().getCep());
      tfRua.setText(al.getId_endereco().getRua());
      tfNum.setText(al.getId_endereco().getNumero());
      tfCpf.setEnabled(false);
    }
    if (operacao == 3) {
      // Determina o título da janela para uma exclusão
      lb1.setText("Exclusão");
      Cliente al = new Cliente();

      ClienteDAO ad = new ClienteDAO();
 
      al = ad.buscarCliente(id);

      tfCpf.setText(String.valueOf(al.getCpf()));
      tfNome.setText(al.getNome());
      tfTelefone.setText(al.getTelefone());
      tfCep.setText(al.getId_endereco().getCep());
      tfRua.setText(al.getId_endereco().getRua());
      tfNum.setText(al.getId_endereco().getNumero());
      tfCpf.setEnabled(false);
      tfNome.setEnabled(false);
      tfTelefone.setEnabled(false);
      tfCep.setEnabled(false);
      tfRua.setEnabled(false);
      tfNum.setEnabled(false);
    }
  }

  /**
   * O conteúdo a seguir foi gerado pelo NetBeans na criação da tela e não pode
   * ser alterado.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btConfirmar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        tfCpf = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        tfTelefone = new javax.swing.JTextField();
        lb1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfCep = new javax.swing.JTextField();
        tfRua = new javax.swing.JTextField();
        tfNum = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btConfirmar.setText("Confirmar");
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        lb2.setText("CPF:");

        lb3.setText("Nome:");

        lb4.setText("Telefone:");

        lb1.setText("Aluno");

        jLabel1.setText("CEP:");

        jLabel2.setText("Rua:");

        jLabel3.setText("Número:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lb3)
                                    .addComponent(lb2)
                                    .addComponent(lb4)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                    .addComponent(tfNome)
                                    .addComponent(tfTelefone)
                                    .addComponent(tfCep)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btConfirmar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                                .addComponent(btCancelar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfNum))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfRua))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(lb1)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lb1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb2)
                    .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb3)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb4)
                    .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btConfirmar)
                    .addComponent(btCancelar))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Método do botão de Confirmação
    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
      if (operacao == 1) { // Inclusão
     
        Cliente al = new Cliente();
    
        ClienteDAO ad = new ClienteDAO();
  
        al.setCpf(tfCpf.getText());
        al.setNome(tfNome.getText());
        al.setTelefone(tfTelefone.getText());
        
        Endereco e1 = new Endereco();               
         e1.setCep(tfCep.getText());
         e1.setRua(tfRua.getText());
         e1.setNumero(tfNum.getText());
         
        al.setId_endereco(e1);
        
        
        // Verifica se a operação de inserção obteve sucesso
        if (ad.inserir(al)) {
          String mensagem = "Cliente Inserido!";
          JOptionPane.showMessageDialog(null, mensagem);
        }
      } else if (operacao == 2) { // Alteração
        
        Cliente al = new Cliente();
     
        ClienteDAO ad = new ClienteDAO();
     
        al.setId(id);
        al.setCpf(tfCpf.getText());
        al.setNome(tfNome.getText());
        al.setTelefone(tfTelefone.getText());
        Endereco e1 = new Endereco();               
         e1.setCep(tfCep.getText());
         e1.setRua(tfRua.getText());
         e1.setNumero(tfNum.getText());
         
        al.setId_endereco(e1);


        
        // Verifica se a operação de alteração obteve sucesso
        if (ad.alterar(al)) {
          String mensagem = "Cliente Alterado!";
          JOptionPane.showMessageDialog(null, mensagem);
        }
      } else if (operacao == 3) { // Exclusão
      
        Cliente al = new Cliente();
     
        ClienteDAO ad = new ClienteDAO();
       
        al.setId(id);
        al.setCpf(tfCpf.getText());
        al.setNome(tfNome.getText());
        al.setTelefone(tfTelefone.getText());
         Endereco e1 = new Endereco();               
         e1.setCep(tfCep.getText());
         e1.setRua(tfRua.getText());
         e1.setNumero(tfNum.getText());
         
        al.setId_endereco(e1);
        
        // Verifica se a operação de exclusão obteve sucesso
        if (ad.excluir(al)) {
          String mensagem = "Cliente Excluído!";
          JOptionPane.showMessageDialog(null, mensagem);
        }
      }
      this.dispose();
    }//GEN-LAST:event_btConfirmarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
      // TODO add your handling code here:
      this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

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
      java.util.logging.Logger.getLogger(TelaDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(TelaDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(TelaDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(TelaDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      // A chamada deste método foi alterada para atender 
      // a nova assinatura do método construtor da classe da janela
      // foram usados os valores 0 e 0 apenas compatibilizar
      // a janela será criada a partir da janela principal
      public void run() {
        new TelaDados(0, 0).setVisible(true);
      }
    });
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JTextField tfCep;
    private javax.swing.JTextField tfCpf;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNum;
    private javax.swing.JTextField tfRua;
    private javax.swing.JTextField tfTelefone;
    // End of variables declaration//GEN-END:variables
}
