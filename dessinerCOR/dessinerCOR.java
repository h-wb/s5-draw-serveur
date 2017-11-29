package dessinerCOR;

import serveur.CadreDessin;

public abstract class dessinerCOR implements dessiner
{
	dessiner suivant;
	
	public dessinerCOR() 
	{
		// TODO Auto-generated constructor stub
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




