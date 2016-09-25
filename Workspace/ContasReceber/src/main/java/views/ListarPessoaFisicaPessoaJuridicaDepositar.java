/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.PessoaFisicaCollection;
import controllers.PessoaJuridicaCollection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Util;


/**
 *
 * @author eduardocorreadesa
 */
public class ListarPessoaFisicaPessoaJuridicaDepositar extends javax.swing.JFrame {
    /**
     * Creates new form ListarPessoaFisicaPessoaJuridica
     */
    public ListarPessoaFisicaPessoaJuridicaDepositar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPessoaFisicaPessoaJuridica = new javax.swing.JTable();
        btnListar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Listagem Pessoa Fisica e Juridica");

        tabelaPessoaFisicaPessoaJuridica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "CPF/CNPJ", "Nome"
            }
        ));
        tabelaPessoaFisicaPessoaJuridica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPessoaFisicaPessoaJuridicaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaPessoaFisicaPessoaJuridica);

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 93, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(95, 95, 95))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnListar)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btnListar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        try {
			DefaultTableModel model = (DefaultTableModel) tabelaPessoaFisicaPessoaJuridica.getModel();
			model.setNumRows(0); 


			PessoaFisicaCollection  listPessoa = new PessoaFisicaCollection();


			ArrayList<PessoaFisica> cnts = listPessoa.getPessoaFisica();


			for (PessoaFisica c : cnts) {              
				//aqui vc colaca os valores que vc quer capturar da lista de contatos
				model.addRow(new Object[]{c.getCpf(), c.getNome()});           
			} 

			PessoaJuridicaCollection  listPessoaJuridica = new PessoaJuridicaCollection();
			ArrayList<PessoaJuridica> juridica = listPessoaJuridica.getPessoaJuridica();

			for (PessoaJuridica c : juridica) {              
				model.addRow(new Object[]{c.getCnpj(), c.getNomeFantasia()});           
			}




		} catch (Exception ex) {
			Logger.getLogger(ListarPessoaFisica.class.getName()).log(Level.SEVERE, null, ex);
		}
    }//GEN-LAST:event_btnListarActionPerformed

    private void tabelaPessoaFisicaPessoaJuridicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPessoaFisicaPessoaJuridicaMouseClicked
     
    int row = tabelaPessoaFisicaPessoaJuridica.getSelectedRow();
    int column = tabelaPessoaFisicaPessoaJuridica.getColumnCount();
//    System.out.println(tabelaPessoaFisicaPessoaJuridica.getValueAt(row, 0).toString());

//    cpfCnpj.setCpfCnpj(tabelaPessoaFisicaPessoaJuridica.getValueAt(row, 0).toString());

    Util.CPFCNPJ = tabelaPessoaFisicaPessoaJuridica.getValueAt(row, 0).toString();
    Util.NOME = tabelaPessoaFisicaPessoaJuridica.getValueAt(row, 1).toString();

   System.out.println("Passei pela listagem: "+Util.CPFCNPJ);
                JFrame janela = new Depositar();
		janela.setVisible(true);
    
    this.dispose();
   
//    for(int i = 0; i < column; i++) {
//     System.out.println(tabelaPessoaFisicaPessoaJuridica.getValueAt(row, i).toString());
//    } 
    }//GEN-LAST:event_tabelaPessoaFisicaPessoaJuridicaMouseClicked
    
  
    
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
            java.util.logging.Logger.getLogger(ListarPessoaFisicaPessoaJuridicaDepositar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarPessoaFisicaPessoaJuridicaDepositar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarPessoaFisicaPessoaJuridicaDepositar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarPessoaFisicaPessoaJuridicaDepositar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarPessoaFisicaPessoaJuridicaDepositar().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaPessoaFisicaPessoaJuridica;
    // End of variables declaration//GEN-END:variables
}
