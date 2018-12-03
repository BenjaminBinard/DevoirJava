import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Fenetre extends JFrame implements ActionListener{

  private JButton butTraduire ;
  private JButton butEffacer;
  private JButton butQuitter;
  private JTextArea ATraduire;
  private JTextArea Traduction;
  private String texte;

  public Fenetre(int tailleX, int tailleY){
    super();
    this.setSize(tailleX,tailleY);
    this.setVisible(true);
    this.setTitle("Traducteur Javanais");
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    this.placementInterne();
  }

  public void placementInterne(){
    this.butTraduire = new JButton ("Traduire");
    this.butTraduire.addActionListener(this);
    this.butEffacer = new JButton ("Effacer");
    this.butEffacer.addActionListener(this);
    this.butQuitter = new JButton ("Quitter");
    this.butQuitter.addActionListener(this);

    this.ATraduire = new JTextArea(25,50);
    this.ATraduire.setEditable(true);

    this.Traduction = new JTextArea(25,50);
    this.Traduction.setEditable(false);

    /*JPanel bas = new JPanel();
    bas.add(this.butTraduire);
    bas.add(this.butEffacer);
    bas.add(this.butQuitter);
    getContentPane().add(bas, BorderLayout.SOUTH);

    JPanel gauche = new JPanel();
    gauche.add(this.ATraduire);
    getContentPane().add(gauche,BorderLayout.WEST);

    JPanel droite = new JPanel();
    droite.add(this.Traduction);
    //droite.add(bas);
    getContentPane().add(droite,BorderLayout.EAST);*/



    Panel panel = new Panel();
    Panel controlPanel = new Panel();
    panel.setSize(300,300);
    GridLayout layout = new GridLayout(3,2);

    panel.setLayout(layout);
    panel.add(this.butTraduire);
    panel.add(this.butEffacer);
    panel.add(this.butQuitter);
    controlPanel.add(panel);

    this.pack();
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.butTraduire) {
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
   //ClientSimple monClient = new ClientSimple("localhost","8888");
   Fenetre maFen = new Fenetre(200,400); // Chez Momo
  }

}
