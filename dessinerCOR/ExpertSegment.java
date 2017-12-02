package dessinerCOR;

import java.awt.Color;

import serveur.CadreDessin;

public class ExpertSegment extends dessinerCOR
{

	public ExpertSegment() 
	{
		// TODO Auto-generated constructor stub
	}

	public boolean dessiner1(String requete[], CadreDessin cadre)
	{
		if(!(requete[0].equals("Segment"))){
			return false;
		}
		else {


			System.out.println(requete);

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
			cadre.graphics.drawLine(x1,y1,x2,y2);
			
			cadre.getBufferStrategy().show();
			return true;
		} 

	}
}
