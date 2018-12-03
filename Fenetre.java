import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;

public class Fenetre extends JFrame implements ActionListener{

  private JButton butTraduire;
  private JButton butTraduireFr;
  private JButton butEffacer;
  private JButton butQuitter;
  private JTextArea ATraduire;
  private JTextArea Traduction;
  private Traducteur Translator;
  private String texte;

  public Fenetre(int tailleX, int tailleY){
    super();
    Translator = new Traducteur(); // Création d'un objet de traduction
    this.setSize(tailleX,tailleY);
    this.setVisible(true);
    this.setTitle("Traducteur Javanais <-> Français");
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    this.placementInterne();
  }

  public void placementInterne(){
    // Gestion des sous titres
    JLabel titreATraduire = new JLabel("Texte à traduire");
    JLabel titreTraduction = new JLabel("Texte traduit");
    int width = 50;
    int height=50;
    titreATraduire.setPreferredSize(new Dimension(width, height));
    titreTraduction.setPreferredSize(new Dimension(width, height));

    // Gestion des boutons
    this.butTraduire = new JButton ("Traduire en Javanais");
    this.butTraduire.addActionListener(this);
    this.butTraduireFr = new JButton ("Traduire en Français");
    this.butTraduireFr.addActionListener(this);
    this.butEffacer = new JButton ("Effacer");
    this.butEffacer.addActionListener(this);
    this.butQuitter = new JButton ("Quitter");
    this.butQuitter.addActionListener(this);

    // Gestion de la couleur des boutons
    Color c = new Color(82, 79, 117);
    Color c1 = new Color(75, 121, 94);
    this.butTraduire.setForeground(Color.WHITE);
		this.butTraduire.setBackground(c);
    this.butTraduireFr.setForeground(Color.WHITE);
		this.butTraduireFr.setBackground(c);
    this.butEffacer.setForeground(Color.WHITE);
		this.butEffacer.setBackground(c);
    this.butQuitter.setForeground(Color.WHITE);
		this.butQuitter.setBackground(c);

    // Gestion des zone de texte
    this.ATraduire = new JTextArea(25,50);
    this.ATraduire.setEditable(true);

    this.Traduction = new JTextArea(25,50);
    this.Traduction.setEditable(false); // En lecture seule

    // Gestion du panel de boutons
    JPanel bas = new JPanel();
    bas.add(this.butEffacer);
    bas.add(this.butQuitter);

    // Gestion du deuxième panel de boutons
    JPanel bas2 = new JPanel();
    bas2.add(this.butTraduire);
    bas2.add(this.butTraduireFr);

    // Gestion de la colonne de gauche
    Panel panel = new Panel();
    panel.setSize(300,300);
    // Création des GridBagLayout via le site https://www.tutorialspoint.com/awt/awt_gridbaglayout.htm
    GridBagLayout gb = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(3,3,3,3);
    panel.setLayout(gb);

    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 2;
    gbc.weighty = 1;
    gbc.gridx = 1;
    gb.setConstraints(titreATraduire, gbc);
    gb.setConstraints(this.ATraduire, gbc);
    gb.setConstraints(bas2, gbc);
    panel.add(titreATraduire);
    panel.add(this.ATraduire);
    panel.add(bas2);

    // Gestion de la colonne de droite
    Panel panel1 = new Panel();
    panel1.setSize(300,300);
    GridBagLayout gb1 = new GridBagLayout();
    GridBagConstraints gbc1 = new GridBagConstraints();
    gbc1.insets = new Insets(3,3,3,3);
    panel1.setLayout(gb1);

    gbc1.fill = GridBagConstraints.BOTH;
    gbc1.weightx = 2;
    gbc1.weighty = 1;
    gbc1.gridx = 1;
    gb1.setConstraints(titreTraduction, gbc1);
    gb1.setConstraints(this.Traduction, gbc1);
    gb1.setConstraints(bas, gbc1);
    panel1.add(titreTraduction);
    panel1.add(this.Traduction);
    panel1.add(bas);

    // Mise des colonnes à gauche et à droite
    getContentPane().add(panel1,BorderLayout.EAST);
    getContentPane().add(panel,BorderLayout.WEST);

    this.pack();
  }

  public void actionPerformed(ActionEvent e) {
    // Action clic bouton de traduction Français vers Javanais
    if (e.getSource() == this.butTraduire) {
      this.texte = this.ATraduire.getText();
      System.out.println(this.texte);
      this.Traduction.setText(Translator.traduction(this.texte));
    }
    // Action clic bouton de traduction Javanais vers Français
    if (e.getSource() == this.butTraduireFr) {
      this.texte = this.ATraduire.getText();
      System.out.println(this.texte);
      this.Traduction.setText(Translator.traductionJ(this.texte));
    }
    // Action clic bouton effacer
    if (e.getSource() == this.butEffacer) {
      this.ATraduire.setText(null);
      this.Traduction.setText(null);
    }
    // Action clic bouton quitter
    if (e.getSource() == this.butQuitter) {
      System.exit(0);
    }
  }

}
