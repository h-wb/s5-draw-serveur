package dessinerCOR;

import java.awt.Color;


import serveur.CadreDessin;

public abstract class dessinerCOR implements dessiner
{
	dessiner suivant;
	Color[] couleurs;
	
	public dessinerCOR() 
	{
		couleurs[0] = new Color(Integer.parseInt("blue"));
		couleurs[1] = new Color(Integer.parseInt("black"));
		couleurs[2] = new Color(Integer.parseInt("white"));
		couleurs[3] = new Color(Integer.parseInt("red"));
		couleurs[4] = new Color(Integer.parseInt("yellow"));
		couleurs[5] = new Color(Integer.parseInt("green"));
		couleurs[6] = new Color(Integer.parseInt("grey"));
		couleurs[7] = new Color(Integer.parseInt("orange"));
	}

	
	
	public dessinerCOR(dessinerCOR expert1) 
	{
		this.suivant=expert1;
		couleurs[0] = new Color(Integer.parseInt("blue"));
		couleurs[1] = new Color(Integer.parseInt("black"));
		couleurs[2] = new Color(Integer.parseInt("white"));
		couleurs[3] = new Color(Integer.parseInt("red"));
		couleurs[4] = new Color(Integer.parseInt("yellow"));
		couleurs[5] = new Color(Integer.parseInt("green"));
		couleurs[6] = new Color(Integer.parseInt("grey"));
		couleurs[7] = new Color(Integer.parseInt("orange"));
	}
	
	
	public dessiner getSuivant() 
	{
		return suivant;
	}



	public void setSuivant(dessiner suivant) 
	{
		this.suivant = suivant;
	}



	public void dessiner(String requete, CadreDessin cadre) 
	{
		if(this.dessiner1(requete, cadre))
		{
			
		}
		else if(this.suivant!=null)
		{
			this.suivant.dessiner(requete, cadre);
		}
	}
	
	
	public abstract boolean dessiner1(String requete, CadreDessin cadre); 
}




