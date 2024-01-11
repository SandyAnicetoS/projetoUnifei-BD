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
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.unifei.bd.bleach.Habilidade;

public class HabilidadeFormInserir extends JFrame {

	private EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("projetoBleach");
	private EntityManager em = emf.createEntityManager();
	private Habilidade habilidade;

	private JPanel contentPane;
	private JTextField txtNome, txtDescricao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HabilidadeFormInserir frame = new HabilidadeFormInserir();
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
	public HabilidadeFormInserir() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInserir = new JLabel("Inserir uma nova habilidade:");
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
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilidade = new Habilidade();
				habilidade.setNome(txtNome.getText());
				habilidade.setGasto((Integer)spnGasto.getValue());
				habilidade.setEfeito((Integer)spnEfeito.getValue());
				habilidade.setDescricao(txtDescricao.getText());
				em.getTransaction().begin();
				em.persist(habilidade);
				em.getTransaction().commit();
			}
		});
		btnInserir.setBounds(85, 130, 89, 23);
		contentPane.add(btnInserir);
	}
}
