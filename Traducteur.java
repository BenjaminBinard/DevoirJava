import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.table.*;

public class Traducteur {

	private String texte;
	private String texte_java;
	private Lettre lettre;

	public Traducteur(){

	}

	// Traduction Français vers Javanais
	public String traduction(String txt){
		texte = txt;
		String txtjava = new String();

		// Traitement lettre par lettre
		for(int i = 0; i<txt.length(); i++){
			// Récupération de la lettre
			lettre = new Lettre(txt.charAt(i));

			// Si la lettre est une voyelle
			if(lettre.estVoyelle()){
				if (lettre.estY()){
					Lettre lettre_suiv = new Lettre(txt.charAt(i+1)); // On regarde la lettre suivante
					if(lettre_suiv.estVoyelle()) // Si celle-ci est une voyelle
						txtjava = txtjava.concat("av"+ lettre.toString());// Alors on ajoute "av"
				}
				else
					txtjava = txtjava.concat("av"+ lettre.toString());
			}
			else
				txtjava = txtjava.concat(lettre.toString());

		}

		texte_java = txtjava;
		// On renvoie le texte une fois la conversion terminée
		return txtjava;
	}

	// Traduction Javanais vers Français
	public String traductionJ(String txt){
		texte = txt;
		String txtjava = new String();
		int i = 0;

		while(i<=txt.length()-1){

			lettre = new Lettre(txt.charAt(i));
			if(i<txt.length()-2){
				Lettre lettre_suiv = new Lettre(txt.charAt(i+1));
				Lettre lettre_suiv2 = new Lettre(txt.charAt(i+2));
				if(lettre_suiv.estV()){
					if(lettre.estA() && lettre_suiv2.estVoyelle()){
						txtjava = txtjava.concat(lettre_suiv2.toString());
						i = i + 2;
						if(i==txt.length()-2){
							lettre = new Lettre(txt.charAt(txt.length()-1));
							txtjava = txtjava.concat(lettre.toString());
						}
					}
				}
				else
				txtjava = txtjava.concat(lettre.toString());
				i = i + 1;
			}else{
				txtjava = txtjava.concat(lettre.toString());
				i = i + 1;
			}
		}
		texte_java = txtjava;
		return txtjava;
	}

/*
	public static void main(String[] args) {

		Traducteur javanais = new Traducteur();
		String mot = javanais.traductionJ("Braviavan avis avin thave kavitchaven");
		System.out.println(mot);

	}
*/
}
