package dessinerCOR;

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
		    
		 String op�ration;
		 int x1, y1, x2, y2;
    
		 op�ration = arguments[0].trim();
		 x1 = Integer.parseInt(arguments[1].trim());
		 y1 = Integer.parseInt(arguments[2].trim());
		 x2 = Integer.parseInt(arguments[3].trim());
		 y2 = Integer.parseInt(arguments[4].trim());
        
		 if (op�ration.equalsIgnoreCase("drawOval")) cadre.graphics.drawOval(x1,y1,x2,y2);
        else
        {
        	return false;
        }
		cadre.getBufferStrategy().show();
		return true;
	} // while
		
}
