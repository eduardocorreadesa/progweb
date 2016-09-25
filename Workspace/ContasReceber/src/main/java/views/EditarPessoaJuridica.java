/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

import controllers.PessoaJuridicaCollection;
import model.PessoaJuridica;

/**
 *
 * @author eduardocorreadesa
 */
public class EditarPessoaJuridica extends javax.swing.JFrame {
	String cnpj = null;
	/**
	 * Creates new form EditarPessoaFisica
	 */
	public EditarPessoaJuridica() {
		initComponents();
		this.setLocationRelativeTo(null);
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
		tabelaPessoaJuridica = new javax.swing.JTable();
		jLabel2 = new javax.swing.JLabel();
		inputNome = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		inputAgencia = new javax.swing.JTextField();
		inputConta = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		inputLimite = new javax.swing.JTextField();
		btnSalvar = new javax.swing.JButton();
		btnVoltarCancelar = new javax.swing.JButton();
		btnPesquisar = new javax.swing.JButton();
		btnExcluir = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("Editar Pessoa Juridica");

		tabelaPessoaJuridica.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null}
				},
				new String [] {
						"Nome", "CNPJ", "Agencia", "Conta", "Limite R$"
				}
				));
		tabelaPessoaJuridica.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tabelaPessoaJuridicaMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(tabelaPessoaJuridica);

		jLabel2.setText("Nome:");

		jLabel6.setText("Agencia:");

		jLabel7.setText("Conta:");

		inputConta.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				inputContaActionPerformed(evt);
			}
		});

		jLabel8.setText("Limite R$:");

		inputLimite.setToolTipText("");

		btnSalvar.setText("Salvar");
		btnSalvar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSalvarActionPerformed(evt);
			}
		});

		btnVoltarCancelar.setText("Voltar/ Cancelar");
		btnVoltarCancelar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnVoltarCancelarActionPerformed(evt);
			}
		});

		btnPesquisar.setText("Pesquisar");
		btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPesquisarActionPerformed(evt);
			}
		});

		btnExcluir.setText("Excluir");
		btnExcluir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnExcluirActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jLabel2)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(119, 119, 119)
										.addComponent(inputAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE)))
						.addContainerGap())
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(btnExcluir)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnPesquisar))
								.addGroup(layout.createSequentialGroup()
										.addGap(0, 0, Short.MAX_VALUE)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(jLabel6)
												.addComponent(jLabel7)
												.addComponent(jLabel8))))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(btnVoltarCancelar)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnSalvar))
								.addComponent(inputConta, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(inputLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addGroup(layout.createSequentialGroup()
						.addGap(196, 196, 196)
						.addComponent(jLabel1)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2)
								.addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel6)
								.addComponent(inputAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel7)
												.addComponent(inputConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel8)
												.addComponent(inputLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(btnSalvar)
												.addComponent(btnVoltarCancelar)
												.addComponent(btnPesquisar)))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnExcluir)
										.addContainerGap())))
				);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btnVoltarCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarCancelarActionPerformed
		this.dispose();

	}//GEN-LAST:event_btnVoltarCancelarActionPerformed

	private void inputContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputContaActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_inputContaActionPerformed

	private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

		inputNome.setText("");
		inputAgencia.setText("");
		inputConta.setText("");
		inputLimite.setText("");
		try {

			DefaultTableModel model = (DefaultTableModel) tabelaPessoaJuridica.getModel();
			model.setNumRows(0); 


			PessoaJuridicaCollection  listPessoa = new PessoaJuridicaCollection();


			ArrayList<PessoaJuridica> cnts = listPessoa.getPessoaJuridica();


			for (PessoaJuridica c : cnts) {              
				//aqui vc colaca os valores que vc quer capturar da lista de contatos
				model.addRow(new Object[]{c.getNomeFantasia(), c.getCnpj(), c.getAgencia(), c.getConta(), c.getLimite()});           
			}       


		} catch (Exception ex) {
			Logger.getLogger(ListarPessoaJuridica.class.getName()).log(Level.SEVERE, null, ex);
		}
	}//GEN-LAST:event_btnPesquisarActionPerformed

	private void tabelaPessoaJuridicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPessoaJuridicaMouseClicked

		int row = tabelaPessoaJuridica.getSelectedRow();
		cnpj  = tabelaPessoaJuridica.getValueAt(row, 1).toString();
		PessoaJuridica juridica = null;
		try {
			juridica = PessoaJuridicaCollection.getPessoaJuridicaPorCNPJ(cnpj);
		} catch (UnknownHostException ex) {
			Logger.getLogger(EditarPessoaJuridica.class.getName()).log(Level.SEVERE, null, ex);
		}

		inputNome.setText(juridica.getNomeFantasia());
		inputAgencia.setText(juridica.getAgencia());
		inputConta.setText(juridica.getConta());
		inputLimite.setText(juridica.getLimite());

	}//GEN-LAST:event_tabelaPessoaJuridicaMouseClicked

	private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed


		try {
			model.PessoaJuridica juridica = new PessoaJuridica();

			juridica.setNomeFantasia(inputNome.getText());
			juridica.setAgencia(inputAgencia.getText());
			juridica.setConta(inputConta.getText());
			juridica.setLimite(inputLimite.getText());


			controllers.PessoaJuridicaCollection pessoaJuridica = new controllers.PessoaJuridicaCollection();
			inputNome.setText("");
			inputAgencia.setText("");
			inputConta.setText("");		
			inputLimite.setText("");


			pessoaJuridica.updatePessoaJuridicaPorCNPJ(cnpj, juridica);

		} catch (UnknownHostException ex) {
			Logger.getLogger(CadastrarPessoaFisica.class.getName()).log(Level.SEVERE, null, ex);
		}

		btnPesquisarActionPerformed(evt);

	}//GEN-LAST:event_btnSalvarActionPerformed

	private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

		try {
			model.PessoaJuridica juridica = new PessoaJuridica();

			juridica.setNomeFantasia(inputNome.getText());
			juridica.setAgencia(inputAgencia.getText());
			juridica.setConta(inputConta.getText());
			juridica.setLimite(inputLimite.getText());


			controllers.PessoaJuridicaCollection pessoaJuridica = new controllers.PessoaJuridicaCollection();
			inputNome.setText("");
			inputAgencia.setText("");
			inputConta.setText("");		
			inputLimite.setText("");


			pessoaJuridica.removePessoaJuridicaPorCNPJ(cnpj, juridica);

		} catch (UnknownHostException ex) {
			Logger.getLogger(CadastrarPessoaFisica.class.getName()).log(Level.SEVERE, null, ex);
		}

		btnPesquisarActionPerformed(evt);
	}//GEN-LAST:event_btnExcluirActionPerformed

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
			java.util.logging.Logger.getLogger(EditarPessoaJuridica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(EditarPessoaJuridica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(EditarPessoaJuridica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(EditarPessoaJuridica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new EditarPessoaJuridica().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnExcluir;
	private javax.swing.JButton btnPesquisar;
	private javax.swing.JButton btnSalvar;
	private javax.swing.JButton btnVoltarCancelar;
	private javax.swing.JTextField inputAgencia;
	private javax.swing.JTextField inputConta;
	private javax.swing.JTextField inputLimite;
	private javax.swing.JTextField inputNome;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable tabelaPessoaJuridica;
	// End of variables declaration//GEN-END:variables
}
