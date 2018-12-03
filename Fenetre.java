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
  private String texte;

  public Fenetre(int tailleX, int tailleY){
    super();
    this.setSize(tailleX,tailleY);
    this.setVisible(true);
    this.setTitle("Traducteur Javanais <-> Français");
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    this.placementInterne();
  }

  public void placementInterne(){
    JLabel titreATraduire = new JLabel("Texte à traduire en Javanais");
    JLabel titreTraduction = new JLabel("Texte traduis");
    int width = 50;
    int height=50;
    titreATraduire.setMinimumSize(new Dimension(width, height));
    titreATraduire.setPreferredSize(new Dimension(width, height));
    titreATraduire.setMaximumSize(new Dimension(width, height));
    titreTraduction.setMinimumSize(new Dimension(width, height));
    titreTraduction.setPreferredSize(new Dimension(width, height));
    titreTraduction.setMaximumSize(new Dimension(width, height));
    this.butTraduire = new JButton ("Traduire en Javanais");
    this.butTraduire.addActionListener(this);
    this.butTraduireFr = new JButton ("Traduire en Français");
    this.butTraduireFr.addActionListener(this);
    this.butEffacer = new JButton ("Effacer");
    this.butEffacer.addActionListener(this);
    this.butQuitter = new JButton ("Quitter");
    this.butQuitter.addActionListener(this);

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


    this.ATraduire = new JTextArea(25,50);
    this.ATraduire.setEditable(true);

    this.Traduction = new JTextArea(25,50);
    this.Traduction.setEditable(false);

    JPanel bas = new JPanel();
    bas.add(this.butEffacer);
    bas.add(this.butQuitter);

    JPanel bas2 = new JPanel();
    bas2.add(this.butTraduire);
    bas2.add(this.butTraduireFr);
    //getContentPane().add(bas, BorderLayout.WEST);
    //getContentPane().add(bas2, BorderLayout.EAST);
    /*
    JPanel gauche = new JPanel();
    gauche.add(this.ATraduire);
    getContentPane().add(gauche,BorderLayout.WEST);

    JPanel droite = new JPanel();
    droite.add(this.Traduction);
    //droite.add(bas);
    getContentPane().add(droite,BorderLayout.EAST);*/

    Panel panel = new Panel();
    panel.setSize(300,300);
    GridBagLayout gb = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(3,3,3,3);
    panel.setLayout(gb);

    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 2;
    gbc.weighty = 1;
    gbc.gridx = 1;
    gb.setConstraints(titreATraduire, gbc); // mise en forme des objets
    gb.setConstraints(this.ATraduire, gbc);
    gb.setConstraints(bas2, gbc);
    panel.add(titreATraduire);
    panel.add(this.ATraduire);
    panel.add(bas2);

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

    getContentPane().add(panel1,BorderLayout.EAST);
    getContentPane().add(panel,BorderLayout.WEST);

    this.pack();
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.butTraduire) {
      this.texte = this.ATraduire.getText();
      System.out.println(this.texte);
    }
    if (e.getSource() == this.butTraduireFr) {
      this.texte = this.ATraduire.getText();
      System.out.println(this.texte);
    }
    if (e.getSource() == this.butEffacer) {
      this.ATraduire.setText(null);
      this.Traduction.setText(null);
    }
    if (e.getSource() == this.butQuitter) {
      System.exit(0);
    }
  }

  public static void main( String [] args ) {
   Fenetre maFen = new Fenetre(200,400); // Chez Momo
  }

}
