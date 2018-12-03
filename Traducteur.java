import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.table.*;

public class Traducteur {

	private String texte;
	private String texte_java;
	private Lettre lettre;

	public Traducteur()
	{

	}


	public String traduction(String txt)
	{
		texte = txt;
		String txtjava = new String();

		for(int i = 0; i<txt.length(); i++)
		{
			lettre = new Lettre(txt.charAt(i));

			if(lettre.estVoyelle())
			{
				if (lettre.estY())
				{
					Lettre lettre_suiv = new Lettre(txt.charAt(i+1));
					if(lettre_suiv.estVoyelle())
						txtjava = txtjava.concat("av"+ lettre.toString());
				}
				else
					txtjava = txtjava.concat("av"+ lettre.toString());
			}
			else
				txtjava = txtjava.concat(lettre.toString());

		}

		texte_java = txtjava;
		return txtjava;
	}

	public String traductionJ(String txt)
	{
		texte = txt;
		String txtjava = new String();
		int i = 0;
		System.out.println(txt.length());

		while(i<=txt.length()-2)
		{
			System.out.println(i);

			lettre = new Lettre(txt.charAt(i));
			Lettre lettre_suiv = new Lettre(txt.charAt(i+1));
			Lettre lettre_suiv2 = new Lettre(txt.charAt(i+2));

			if(lettre_suiv.estV())
			{

				if(lettre.estA() && lettre_suiv2.estVoyelle())
					{
						txtjava = txtjava.concat(lettre_suiv2.toString());
						i = i + 2;

						if(i==txt.length()-2)
						{
							lettre = new Lettre(txt.charAt(txt.length()-1));
							txtjava = txtjava.concat(lettre.toString());
						}

					}

			}

			else
				txtjava = txtjava.concat(lettre.toString());
				i = i + 1;

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
