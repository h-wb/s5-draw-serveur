package dessinerCOR;

import java.awt.Color;

import serveur.CadreDessin;

public class dessinerOval extends dessinerCOR
{

	public dessinerOval() 
	{
		// TODO Auto-generated constructor stub
	}

	public boolean dessiner1(String requete, CadreDessin cadre)
	{
		String[] arguments = requete.split(",");                     
	    
		 String opération;
		 Color couleur;
		 int x1, y1, x2, y2;
   
		 opération = arguments[0].trim();
		 couleur = new Color(Integer.parseInt(arguments[1].trim()));
		 cadre.graphics.setColor(couleur);
		 
		 x1 = Integer.parseInt(arguments[2].trim());
		 y1 = Integer.parseInt(arguments[3].trim());
		 x2 = Integer.parseInt(arguments[4].trim());
		 y2 = Integer.parseInt(arguments[5].trim());
       
		 if (opération.equalsIgnoreCase("fillOval")) cadre.graphics.fillOval(x1,y1,x2,y2);
        else
        {
        	return false;
        }
		cadre.getBufferStrategy().show();
		return true;
	} // while
		
}
