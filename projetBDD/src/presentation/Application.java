package presentation;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import data.CC;
import data.Enseignant;
import factory.CCFactory;
import factory.ConnectionFactory;
import factory.EnseignantFactory;

public class Application extends JFrame implements ActionListener {

	private JPanel panelPrincipal;
	private JComboBox cbCC;
	
	private String nomEnseignant;
	private List<CC> listeCC;
	
	public Application() {
		panelPrincipal = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				ConnectionFactory.getInstance().close();
				System.exit(0);
			}
		});
		
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		
		cbCC = new JComboBox();
		cbCC.setMaximumSize(new Dimension(200,25));
		alimenterListeCC();
		
		panelPrincipal.add(cbCC);
		
		cbCC.addActionListener(this);
		
		this.getContentPane().add(panelPrincipal);
		this.setSize(800, 600);
		this.setVisible(true);
	}
	
	public void alimenterListeCC(){
		listeCC = CCFactory.getInstance().listerCC();
		for(CC cc : listeCC){
			cbCC.addItem(cc.getIdCC());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(cbCC)){
			nomEnseignant = JOptionPane.showInputDialog(this, "Nom de l'enseignant ?", null);
			List<Enseignant> listeEnseignant = EnseignantFactory.getInstance().rechercherEnseignantsParCC(listeCC.get(cbCC.getSelectedIndex()).getIdCC());
			for(Enseignant ens : listeEnseignant){
				if(ens.getNom().equals(nomEnseignant)){
					JOptionPane.showMessageDialog(this, "ok");
				}
			}
			
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Application app = new Application();
	}

}
