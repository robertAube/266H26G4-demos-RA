package cours_22_fichiers.fichiersExemples;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FichierEcritureOctets
{

	private static boolean ecrireTableauOctets(byte[] paramTab,
									 	    String paramNomFichier)
	{
		boolean ecritureOk = true;		
		FileOutputStream fosTemp = null;
		
		try
		{
			//Ouverture du fichier (ou création si inexistant)
			fosTemp = new FileOutputStream(paramNomFichier);
			
			try
			{
				//Écrire chaque octet du tableau dans le fichier
				for (int i = 0; i < paramTab.length; i++)
				{
					fosTemp.write(paramTab[i]);
				}
			}
			catch(IOException e)
			{
				//Échec de l'écriture
				JOptionPane.showMessageDialog(null,
										 "Erreur lors de l'écriture dans le fichier",
										 "Erreur E/S",
										 JOptionPane.ERROR_MESSAGE);
				ecritureOk = false;
			}
			
			//Fermeture du fichier
			fosTemp.close();
		}
		catch(FileNotFoundException e)
		{
			//Échec à l'ouverture
			JOptionPane.showMessageDialog(null,
									"Erreur lors de l'ouverture",
									"Erreur E/S",
									JOptionPane.ERROR_MESSAGE);
			ecritureOk = false;
		}
		catch(IOException e)
		{
			//Échec à la fermeture
			JOptionPane.showMessageDialog(null,
									"Erreur lors de la fermeture",
									"Erreur E/S",
									JOptionPane.ERROR_MESSAGE);
			ecritureOk = false;
		}
		
		return ecritureOk;
	}

	public static void main(String[] args)
	{		
		byte[] tabOctets = {34, 56, 4, 7, 8, 108, 5, 45, 14, 124};

		String nomFichier = "FichierOctet.bin";
		
		if (ecrireTableauOctets(tabOctets, nomFichier))
		{
			JOptionPane.showMessageDialog(null,
								  "C'est ok pour l'écriture dans le fichier",
								  "Information E/S",
								  JOptionPane.INFORMATION_MESSAGE );
		}
		else
		{
			JOptionPane.showMessageDialog(null,
								"Il y a eu un problème lors de l'écriture dans "+
								"le fichier",
								"Information E/S",
								JOptionPane.INFORMATION_MESSAGE );
		}
		
		System.exit(0);
	}
}
