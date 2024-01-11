package br.edu.unifei.bd.bleach.swing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.unifei.bd.bleach.Habilidade;

public class HabilidadeFormAlterar extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome, txtDescricao;
	private EntityManagerFactory emf=
	Persistence.createEntityManagerFactory("projetoBleach");
	private EntityManager em = 
		emf.createEntityManager();
	private Habilidade habilidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HabilidadeFormAlterar frame = new HabilidadeFormAlterar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HabilidadeFormAlterar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInserir = new JLabel("Alterar uma habilidade:");
		lblInserir.setBounds(10, 11, 200, 14);
		contentPane.add(lblInserir);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 36, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblGasto = new JLabel("Gasto:");
		lblGasto.setBounds(10, 60, 46, 14);
		contentPane.add(lblGasto);
		
		JLabel lblEfeito = new JLabel("Efeito:");
		lblEfeito.setBounds(10, 85, 69, 14);
		contentPane.add(lblEfeito);
		
		JLabel lblDescricao = new JLabel("Descricao:");
		lblDescricao.setBounds(10, 105, 69, 14);
		contentPane.add(lblDescricao);
		
		txtNome = new JTextField();
		txtNome.setBounds(87, 33, 151, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(20);
		
		final JSpinner spnGasto = new JSpinner();
		spnGasto.setBounds(87, 57, 151, 20);
		contentPane.add(spnGasto);
		
		final JSpinner spnEfeito = new JSpinner();
		spnEfeito.setBounds(87, 81, 151, 20);
		contentPane.add(spnEfeito);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(87, 105, 151, 20);
		contentPane.add(txtDescricao);
		txtNome.setColumns(50);
		
		final JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilidade.setDescricao(txtDescricao.getText());
				txtDescricao.setEnabled(false);
				habilidade.setGasto((Integer)spnGasto.getValue());
				spnGasto.setEnabled(false);
				habilidade.setEfeito((Integer)spnEfeito.getValue());
				spnEfeito.setEnabled(false);
				btnAlterar.setEnabled(false);
				txtNome.setEnabled(true);
				em.getTransaction().begin();
				em.merge(habilidade);
				em.getTransaction().commit();			
			}
		});
		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(85, 130, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilidade=em.find(Habilidade.class, 
						txtNome.getText());
				if(habilidade!=null) {
					txtNome.setEnabled(false);
					txtDescricao.setEnabled(true);
					txtDescricao.setText(habilidade.getDescricao());
					spnGasto.setEnabled(true);
					spnGasto.setValue(habilidade.getGasto());
					spnEfeito.setEnabled(true);
					spnEfeito.setValue(habilidade.getEfeito());
					btnAlterar.setEnabled(true);
				}else {
					JOptionPane.showMessageDialog(null, "Habilidade não existe");
				}
			}
		});
		btnBuscar.setBounds(240, 33, 80, 20);
		contentPane.add(btnBuscar);
		
	}

}
