package dessinerCOR;

import java.awt.Graphics;

import serveur.CadreDessin;

public class dessinerCOR implements dessiner
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

	
	
	public void dessiner(String requete, CadreDessin cadre) 
	{
		if(this.dessiner1(requete, cadre)==true)
		{
			
		}
		else if(this.suivant!=null)
		{
			this.suivant.dessiner(requete, cadre);
		}
	}
	
	public boolean dessiner1(String requete, CadreDessin cadre)
	{
		 String[] arguments = requete.split(",");                     
		    
		 String op�ration;
		 int x1, y1, x2, y2;
    
		 op�ration = arguments[0].trim();
		 x1 = Integer.parseInt(arguments[1].trim());
		 y1 = Integer.parseInt(arguments[2].trim());
		 x2 = Integer.parseInt(arguments[3].trim());
		 y2 = Integer.parseInt(arguments[4].trim());
        
		 if (op�ration.equalsIgnoreCase("drawLine"))             // if-else � �liminer par l'utilisation du Design Pattern "Chain Of Responsibility" 
	            cadre.graphics.drawLine(x1,y1,x2,y2);
	           
        else if (op�ration.equalsIgnoreCase("fillOval"))
        {
        	cadre.graphics.fillOval(x1,y1,x2,y2);
        }
        else if(op�ration.equalsIgnoreCase("drawOval"))
        {
        	cadre.graphics.drawOval(x1,y1,x2,y2);
        }
        else
        {
        	return false;
        }
		cadre.getBufferStrategy().show();
		return true;
	} // while
		
}




