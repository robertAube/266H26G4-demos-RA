package cours_22_fichiers.fichiersExemples;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FichierLectureBufferOctets
{
	private static boolean lectureTableauOctets(byte[] paramTab,
			String paramNomFichier)
	{
		boolean lectureOk = true;
		FileInputStream fisTemp = null;
		BufferedInputStream bisTemp = null;

		try
		{
			// Ouverture du fichier
			fisTemp = new FileInputStream(paramNomFichier);
			bisTemp = new BufferedInputStream(fisTemp);
			// ou
			// bisTemp = new BufferedInputStream(new FileInputStream(paramNomFichier));

			try
			{
				// Plus besoin de la boucle
				// Lit les paramTab.length premiers octets du fichier et les met
				// dans le tableau paramTab
				bisTemp.read(paramTab, 0, paramTab.length);
			}
			catch (IOException e)
			{
				//Échec de la lecture
				JOptionPane.showMessageDialog(null,
						"Erreur lors de la lecture dans le fichier",
						"Erreur E/S", JOptionPane.ERROR_MESSAGE);

				lectureOk = false;
			}
			//Fermeture du fichier
			bisTemp.close();
		}
		catch (FileNotFoundException e)
		{
			//Échec à l'ouverture
			JOptionPane.showMessageDialog(null, "Erreur lors de l'ouverture",
					"Erreur E/S", JOptionPane.ERROR_MESSAGE);

			lectureOk = false;
		}
		catch (IOException e)
		{
			//Échec à la fermeture
			JOptionPane.showMessageDialog(null, "Erreur lors de la fermeture",
					"Erreur E/S", JOptionPane.ERROR_MESSAGE);

			lectureOk = false;
		}

		return lectureOk;
	}

	public static void main(String[] args)
	{
		byte[] tabOctets = new byte[10];
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
					"C'est ok pour la lecture du fichier" + tabOctetsString,
					"Information E/S", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null,
					"Il y a eu un problème lors de la lecture " + "du fichier",
					"Information E/S", JOptionPane.INFORMATION_MESSAGE);
		}

		System.exit(0);
	}
}
