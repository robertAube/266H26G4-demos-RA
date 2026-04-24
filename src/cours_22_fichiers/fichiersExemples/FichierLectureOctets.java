package cours_22_fichiers.fichiersExemples;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FichierLectureOctets
{
	
	private static boolean lectureTableauOctets(byte[] paramTab,
									 	     String paramNomFichier)
	{
		boolean lectureOk = true;
		byte octetLu = 0;
		int compteurOctet = 0;
		
		FileInputStream fisTemp = null;
		
		try
		{
			//Ouverture du fichier
			fisTemp = new FileInputStream(paramNomFichier);
		try
			{				
				compteurOctet = 0;
				
				//Lire premier octet du fichier
				octetLu = (byte) fisTemp.read();
				
				// tant que pas eof
				while(octetLu != -1)
				{
					//Mettre l'octet lu dans le tableau et lire le suivant
					paramTab[compteurOctet++] = octetLu;
					octetLu = (byte) fisTemp.read();
				}
			}
			catch(IOException e)
			{
				//Échec de la lecture
				JOptionPane.showMessageDialog(null,
										"Erreur lors de la lecture dans le fichier",
										"Erreur E/S",
										JOptionPane.ERROR_MESSAGE);
				lectureOk = false;
			}
			//Fermeture du fichier
			fisTemp.close();
		}
		catch(FileNotFoundException e)
		{
			//Échec à l'ouverture
			JOptionPane.showMessageDialog(null,
									"Erreur lors de l'ouverture",
									"Erreur E/S",
									JOptionPane.ERROR_MESSAGE);
			lectureOk = false;
		}
		catch(IOException e)
		{
			//Échec à la fermeture
			JOptionPane.showMessageDialog(null,
									"Erreur lors de la fermeture",
									"Erreur E/S",
									JOptionPane.ERROR_MESSAGE);
			lectureOk = false;
		}
		
		return lectureOk;
	}
	public static void main(String[] args)
	{		
		byte[] tabOctets = new byte[20];
		String nomFichier = "FichierOctet.bin";
		String tabOctetsString = "";
		
		if (lectureTableauOctets(tabOctets, nomFichier))
		{
			tabOctetsString = " ";
			for (int i = 0; i < tabOctets.length; i++)
			{
				tabOctetsString += tabOctets[i] + ", ";	
			}
			
			JOptionPane.showMessageDialog(null,
							"C'est ok pour la lecture du fichier" + 
							tabOctetsString,
							"Information E/S",
							JOptionPane.INFORMATION_MESSAGE );      
		}
		else
		{
			JOptionPane.showMessageDialog(null,
									"Il y a eu un problème lors de la lecture " + 
									"du fichier",
									"Information E/S",
									JOptionPane.INFORMATION_MESSAGE);
		}
		
		System.exit(0);
	}
}
