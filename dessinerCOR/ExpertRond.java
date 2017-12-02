package dessinerCOR;

import java.awt.Color;

import serveur.CadreDessin;

public class ExpertRond extends dessinerCOR
{

	public ExpertRond() 
	{
		// TODO Auto-generated constructor stub
	}

	public boolean dessiner1(String requete[], CadreDessin cadre)
	{
		if(!(requete[0].equals("Rond"))){
			return false;                    
		}else {
			
		
		 String opération;
		 Color couleur;
		 int rangCouleur;
		 int x1, y1, x2, y2;
   
		 rangCouleur = Integer.parseInt(requete[1].trim());
		 couleur = this.couleurs[rangCouleur];
		 cadre.graphics.setColor(couleur);
		 
		 
		 x1 = Integer.parseInt(requete[2].trim());
		 y1 = Integer.parseInt(requete[3].trim());
		 x2 = Integer.parseInt(requete[4].trim());
		 y2 = Integer.parseInt(requete[5].trim());
		 cadre.graphics.fillOval(x1,y1,x2,y2);
		 cadre.getBufferStrategy().show();
		return true;
        }
		
	} // while
		
}
