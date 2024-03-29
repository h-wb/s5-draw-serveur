package dessinerCOR;

import java.awt.Color;

import serveur.CadreDessin;

public class dessinerRectangle extends dessinerCOR
{

	public dessinerRectangle() 
	{
		// TODO Auto-generated constructor stub
	}

	public boolean dessiner1(String requete, CadreDessin cadre)
	{
		String[] arguments = requete.split(",");                     
	    
		 String opération;
		 Color couleur;
		 int rangCouleur;
		 int x1, y1, x2, y2;
   
		 opération = arguments[0].trim();
		 rangCouleur = Integer.parseInt(arguments[1].trim());
		 couleur = this.couleurs[rangCouleur];
		 cadre.graphics.setColor(couleur);
		 
		 
		 x1 = Integer.parseInt(arguments[2].trim());
		 y1 = Integer.parseInt(arguments[3].trim());
		 x2 = Integer.parseInt(arguments[4].trim());
		 y2 = Integer.parseInt(arguments[5].trim());
       
        
		 if (opération.equalsIgnoreCase("drawRectangle")) cadre.graphics.drawRect(x1,y1,x2,y2);
        else
        {
        	return false;
        }
		cadre.getBufferStrategy().show();
		return true;
	} // while
		
}
