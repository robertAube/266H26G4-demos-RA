package cours_22_fichiers.fichiersExemples;
import javax.swing.*;
import java.io.*;

public class FichierTexteInputOutput
{
	private static boolean copierFichier(String paramNomSource,
		  String paramNomCible)
	{
		String ligneLu = "";
		boolean copieOk = true;

		try
		{
			FileReader fluxSource = new FileReader(paramNomSource);
			BufferedReader bufferSource = new BufferedReader(fluxSource);

			FileWriter fluxCible = new FileWriter(paramNomCible);
			BufferedWriter bufferCible = new BufferedWriter(fluxCible);
		
			try
			{
				ligneLu = bufferSource.readLine();
				
				while(ligneLu != null)
				{
					bufferCible.write(ligneLu, 0, ligneLu.length());
					bufferCible.newLine();
					ligneLu = bufferSource.readLine();
				}
			
			}
			catch(IOException e)
			{
				JOptionPane.showMessageDialog(null,
                                             "Erreur lors de la copie du fichier",
                                             "Erreur E/S",
                                             JOptionPane.ERROR_MESSAGE);
				copieOk = false;
			}
						
			bufferSource.close(); 
			bufferCible.close();
		}
		catch(FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null,
                                              "Erreur lors de l'ouverture",
                                              "Erreur E/S",
                                              JOptionPane.ERROR_MESSAGE);
			copieOk = false;
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null,
                                              "Erreur lors de la fermeture",
                                              "Erreur E/S",
                                              JOptionPane.ERROR_MESSAGE);
			copieOk = false;
		}
		
		return copieOk;
	}
			
	public static void main(String arguments[])
	{
		String source = "test.txt";
		String cible = "test_new.txt";

		if(copierFichier(source, cible))
		{
			JOptionPane.showMessageDialog(null,
                            "C'est ok pour la copie du fichier",
                            "Information E/S",
                            JOptionPane.INFORMATION_MESSAGE );
		}
		else
		{
			JOptionPane.showMessageDialog(null,
                            "Il y a eu un problème lors de la copie du fichier",
                            "Information E/S",
                            JOptionPane.INFORMATION_MESSAGE);
		}

		System.exit(0);
	}
}
