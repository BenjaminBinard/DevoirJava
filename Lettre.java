import java.util.*;

public class Lettre {

 private Character valeur;
 private boolean minuscule;

 private static Character[] voyelles = {'a', '�', '�', 'e', '�', '�', '�', '�', 'i', '�', '�', 'o',
'�', 'u', '�', '�', '�', 'y', '�'};
/**
* Le constructeur de la classe Lettre.
*
* @param char Le caract�re concern�
*/
public Lettre(char x) {
 if (Character.isLowerCase(x)) {
 this.minuscule = true;
 this.valeur = new Character(x);
 }
 else {
 this.minuscule = false;
 this.valeur = new Character(Character.toLowerCase(x));
 }
 }

/**
* Cette m�thode permet de savoir si la lettre est une voyelle.
*
* @return boolean Vrai si voyelle, faux sinon
*/
 public boolean estVoyelle() {
 List<Character> list = Arrays.asList(voyelles);
 if (list.contains(this.valeur)) {
 return(true);
 }
 else {
 return(false);
 }
 }

/**
* Cette m�thode permet de savoir si la lettre est un y.
*
* @return boolean Vrai si y, faux sinon
*/
 public boolean estY() {
 if ( (this.valeur=='y') || (this.valeur=='�') ) {
 return(true);
 }
 else {
 return(false);
 }
 }

 public boolean estV() {
 if ( (this.valeur=='v') ) {
 return(true);
 }
 else {
 return(false);
 }
 }

 public boolean estA() {
 if ( (this.valeur=='a') || (this.valeur=='�') || (this.valeur=='�') )
 {
 return(true);
 }
 else {
 return(false);
 }
 }

/**
* Cette m�thode retourne une repr�sentation de l'objet
* sous forme de cha�ne de caract�res.
*
* @return String Cha�ne de caract�res
*/
 public String toString() {
 char x = this.valeur.charValue();
 if (this.minuscule) {
 return new Character(x).toString();
 }
 else {
 return new Character(Character.toUpperCase(x)).toString();
 }
 }

}
