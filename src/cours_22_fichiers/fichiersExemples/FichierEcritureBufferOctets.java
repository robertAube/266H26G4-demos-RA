package cours_22_fichiers.fichiersExemples;

import javax.swing.*;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FichierEcritureBufferOctets
{
	private static boolean ecrireTableauOctets(byte[] paramTab,
			String paramNomFichier)
	{
		boolean ecritureOk = true;
		FileOutputStream fosTemp = null;
		BufferedOutputStream bosTemp = null;

		try
		{
			fosTemp = new FileOutputStream(paramNomFichier);
			bosTemp = new BufferedOutputStream(fosTemp);
			// ou
			// bosTemp = new BufferedOutputStream(new FileOutputStream(paramNomFichier));

			try
			{
				// Plus besoin de la boucle
				// Écrit dans le fichier les paramTab.length premiers octets
				// du tableau paramTab
				bosTemp.write(paramTab, 0, paramTab.length);
			}
			catch (IOException e)
			{
				//Échec à l'écriture
				JOptionPane.showMessageDialog(null,
						"Erreur lors de l'écriture dans le fichier",
						"Erreur E/S", JOptionPane.ERROR_MESSAGE);

				ecritureOk = false;
			}
			//Vider le buffer et fermer le fichier
			bosTemp.flush();
			bosTemp.close();
		}
		catch (FileNotFoundException e)
		{
			//Échec à l'ouverture
			JOptionPane.showMessageDialog(null, "Erreur lors de l'ouverture",
					"Erreur E/S", JOptionPane.ERROR_MESSAGE);

			ecritureOk = false;
		}
		catch (IOException e)
		{
			//Échec à la fermeture
			JOptionPane.showMessageDialog(null, "Erreur lors de la fermeture",
					"Erreur E/S", JOptionPane.ERROR_MESSAGE);

			ecritureOk = false;
		}
		return ecritureOk;
	}

	public static void main(String[] args)
	{
		byte[] tabOctets = { 34, 56, 4, 7, 8, 108, 5, 45, 14, 124 };
		String nomFichier = "FichierOctet.bin";

		if (ecrireTableauOctets(tabOctets, nomFichier))
		{
			JOptionPane.showMessageDialog(null,
					"C'est ok pour l'écriture dans le fichier",
					"Information E/S", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null,
					"Il y a eu un problème lors de l'écriture dans "
							+ "le fichier", "Information E/S",
					JOptionPane.INFORMATION_MESSAGE);
		}

		System.exit(0);
	}
}
