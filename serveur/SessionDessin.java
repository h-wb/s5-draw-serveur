package serveur;

/**
 * repr�sente la session de dessin entreprise par un client distant.
 * 
 * Effectue principalement les op�rations suivantes :
 * 
 * ouvre une fen�tre awt (Frame) pour dessiner dessus (les coordonn�es de la fen�tre sont indiqu�es par le client).
 * puis ex�cute sur la fen�tre ouverte tous les ordres de trac� du client distant.
 * 
 * fonctionne dans un thread s�par� du thread principal.
 * 
 * */
import java.net.Socket;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketException;

import dessinerCOR.dessinerCOR;
import dessinerCOR.ExpertSegment;
import dessinerCOR.ExpertRond;


public class SessionDessin extends Thread
{
Socket socket;                  // pour dialoguer avec le client distant. Peut-on se passer de cet attribut ?
BufferedReader fluxEntrant;     // flux entrant pour recevoir les requ�tes du client

/**
 * cr�e la session de dessin avec le client distant connect� sur socket
 * @throws IOException 
 * 
 * */
public SessionDessin(Socket socket) throws IOException
{
this.socket = socket;
this.fluxEntrant = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
}

@SuppressWarnings("null")
@Override
public void run()
{
	String requete;
try
    {
	requete = this.fluxEntrant.readLine();  // lit l'instruction de trac� et les 4 param�tres entiers du trac�, les arguments sont s�par�s par des ","
    System.out.println("requ�te fen�tre re�ue : " + requete);
    String arguments[] = requete.split(",");
    requete = "";
    CadreDessin cadre = new CadreDessin(arguments);
    
    while (true)
        {
    	requete = this.fluxEntrant.readLine();  // lit l'instruction de trac� et les 4 param�tres entiers du trac�, les arguments sont s�par�s par des ","
        System.out.println("requ�te re�ue : " + requete);
        String arguments2[] = requete.split(",");
        ExpertSegment expert1 = new ExpertSegment();
        ExpertRond expert2 = new ExpertRond();
        

                
        expert1.setSuivant(expert2);
        
        expert1.dessiner(arguments2, cadre);
        
        
        //Cr�er la cha�ne d'expert
        //
        //
       
        
        
        /*dessinerLigne expert1 = new dessinerLigne();
        dessinerOval expert2 = new dessinerOval();
        dessinerRectangle expert3 = new dessinerRectangle();
        dessinerRectangle expert4=null;
                
        expert1.setSuivant(expert2);
        expert2.setSuivant(expert3);
        expert3.setSuivant(expert4);
        
        expert1.dessiner(requ�te, cadreDessin);
        
        /*
        arguments = requ�te.split(",");                     
    
        String op�ration;
        int x1, y1, x2, y2;
    
        op�ration = arguments[0].trim();
        x1 = Integer.parseInt(arguments[1].trim());
        y1 = Integer.parseInt(arguments[2].trim());
        x2 = Integer.parseInt(arguments[3].trim());
        y2 = Integer.parseInt(arguments[4].trim());
    
        if (op�ration.equalsIgnoreCase("drawLine"))            
            cadreDessin.graphics.drawLine(x1,y1,x2,y2);
           
        else
            if (op�ration.equalsIgnoreCase("fillOval"))
                cadreDessin.graphics.fillOval(x1,y1,x2,y2);
               
            else
                {
                }
        cadreDessin.getBufferStrategy().show();*/
        }
    }
catch (SocketException e)
    {
    System.out.println("session de dessin termin�e par le client");
    }
catch (NumberFormatException e)
    {
    e.printStackTrace();
    }
catch (IOException e)
    {
    e.printStackTrace();
    }
catch (InterruptedException e)
    {
    e.printStackTrace();
    }
}


}

