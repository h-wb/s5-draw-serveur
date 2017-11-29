package dessinerCOR;

import java.awt.Color;


import serveur.CadreDessin;

public abstract class dessinerCOR implements dessiner
{
	dessiner suivant;
	Color couleurs[]={Color.black, Color.blue, Color.red, Color.green, Color.yellow, Color.cyan};
	//bite;
	public dessinerCOR() 
	{
		
	}

	
	
	public dessinerCOR(dessinerCOR expert1) 
	{
		this.suivant=expert1;

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




