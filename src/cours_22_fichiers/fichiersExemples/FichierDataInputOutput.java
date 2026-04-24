package cours_22_fichiers.fichiersExemples;

import javax.swing.*;
import java.io.*;

public class FichierDataInputOutput
{
	private static final int NOMBRE_GENERER = 100;

	private static final String[] vecPrenom =
	{ "Pierre", "Paul", "Mathieu", "Gilles", "François", "Réjean", "Serge",
			"William", "Éric", "Carole", "Luc", "Julie", "Anne" };

	private static String genererNo(int paramLongueur)
	{
		String chaineTemp = "";

		for (int i = 0; i < paramLongueur; i++)
		{
			chaineTemp += Long.toString(Math.round(Math.random() * 10) % 10);
		}
		return chaineTemp;
	}

	private static String genererPrenom()
	{
		return vecPrenom[(int) (Math.round(Math.random()
				* NOMBRE_GENERER) % vecPrenom.length)];
	}

	private static char genererSexe()
	{
		char sexeTemp = ' ';

		if ((Math.round(Math.random() * 10) % 2) == 0)
		{
			sexeTemp = 'F';
		}
		else
		{
			sexeTemp = 'M';
		}
		return sexeTemp;
	}

	private static boolean genererBoolean()
	{

		return ((Math.round(Math.random() * 10) % 2) == 0);
	}

	private static int genererInt(int paramBaseDix)
	{
		return (int) Math.round(Math.random() * Math.pow(10, paramBaseDix));
	}

	private static float genererFloat(int paramBaseDix)
	{

		return (float) (Math.random() * Math.pow(10, paramBaseDix));
	}

	private static boolean remplirFichierBinaire(String paramNomFichier)
	{
		boolean ecritureOk = true;
		String prenom = "";
		int age = 0;
		float salaire = 0f;
		char sexe = ' ';
		boolean fumeur = false;

		FileOutputStream fileTest = null;
		BufferedOutputStream bufferTest = null;
		DataOutputStream dataTest = null;

		try
		{
			// Avec tampon et orientée data (type primaire)
			fileTest = new FileOutputStream(paramNomFichier);
			bufferTest = new BufferedOutputStream(fileTest);
			dataTest = new DataOutputStream(bufferTest);

			try
			{
				for (int i = 0; i < NOMBRE_GENERER; i++)
				{
					// Générer des données aléatoirement
					prenom = genererPrenom();
					age = (genererInt(2) % 100);
					salaire = genererFloat(5);
					sexe = genererSexe();
					fumeur = genererBoolean();

					// Ici on aurait aussi pu écrire des objets personnes ou
					// livres ou camions...
					dataTest.writeUTF(prenom);
					dataTest.writeInt(age);
					dataTest.writeFloat(salaire);
					dataTest.writeChar(sexe);
					dataTest.writeBoolean(fumeur);
				}
			}
			catch (IOException e)
			{
				JOptionPane.showMessageDialog(null,
						"Erreur lors de l'écriture dans le fichier",
						"Erreur E/S", JOptionPane.ERROR_MESSAGE);
				
				ecritureOk = false;
			}

			dataTest.close();
		}
		catch (FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "Erreur lors de l'ouverture",
					"Erreur E/S", JOptionPane.ERROR_MESSAGE);
			ecritureOk = false;
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "Erreur lors de la fermeture",
					"Erreur E/S", JOptionPane.ERROR_MESSAGE);
			ecritureOk = false;
		}

		return ecritureOk;
	}

	private static boolean lireFichierBinaire(String paramNomFichier)
	{
		boolean ecritureOk = true;
		String prenom = "";
		int age = 0;
		float salaire = 0f;
		char sexe = ' ';
		boolean fumeur = false;
		
		FileInputStream fileTest = null;
		BufferedInputStream bufferTest = null;
		DataInputStream dataTest = null;

		try
		{
			fileTest = new FileInputStream(paramNomFichier);
			bufferTest = new BufferedInputStream(fileTest);
			dataTest = new DataInputStream(bufferTest);

			try
			{
				do
				{
					// C'est très important de lire les données dans le même ordre
					// qu'elles ont été écrites
					prenom = dataTest.readUTF();
					age = dataTest.readInt();
					salaire = dataTest.readFloat();
					sexe = dataTest.readChar();
					fumeur = dataTest.readBoolean();
					
					
					System.out.println();
					System.out.println("Prenom: " + prenom);
					System.out.println("Age: " + age);
					System.out.println("Salaire: " + salaire);
					System.out.println("Sexe: " + sexe);
					System.out.println("Fumeur: " + fumeur);
				}
				while (true);
			}
			catch (EOFException e)
			{
				dataTest.close();
			}
			catch (IOException e)
			{
				JOptionPane.showMessageDialog(null,
						"Erreur lors de la lecture du fichier", "Erreur E/S",
						JOptionPane.ERROR_MESSAGE);
				ecritureOk = false;
			}

		}
		catch (FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "Erreur lors de l'ouverture",
					"Erreur E/S", JOptionPane.ERROR_MESSAGE);
			ecritureOk = false;
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "Erreur lors de la fermeture",
					"Erreur E/S", JOptionPane.ERROR_MESSAGE);
			ecritureOk = false;
		}

		return ecritureOk;
	}

	public static void main(String[] paramArgs)
	{
		String nomFichier = "FichierBinaire.bin";

		if (remplirFichierBinaire(nomFichier))
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

		if (lireFichierBinaire(nomFichier))
		{
			JOptionPane.showMessageDialog(null,
					"C'est ok pour la lecture du fichier", "Information E/S",
					JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null,
					"Il y a eu un problème lors de la lecture du fichier",
					"Information E/S", JOptionPane.INFORMATION_MESSAGE);
		}

		System.exit(0);
	}
}
