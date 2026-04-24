package solutionsFormatifs.Formatif1_sol.animaux;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CrocodileTest {
	public final static double EPSILON = 0.000001;

	@BeforeEach
	public void resetCompteurCrocodile(){
		Crocodile.reinitialiseCompteur();
	}

	@Test
	public void testDefaultConstructor() {
		Crocodile croc = new Crocodile();
		assertEquals(croc.ESPECE_DEFAUT, croc.getEspece());
		assertEquals(croc.NOMBRE_DE_DENTS_DEFAUT, croc.getNombreDeDents());
		assertEquals(croc.NOMBRE_REPAS_DEFAUT, croc.getNombreDeRepas());
		assertEquals(croc.TAILLE_DEFAUT, croc.getTaille());
	}



	@Test
	public void testConstructorAvecParametres() {
		// si le test ne passe pas il y aura des erreurs qui seront attrapées
		// par Junit
		Crocodile croc = new Crocodile(1, 1.1);
		Crocodile croc2 = new Crocodile(220,  4.99);
	}

	@Test
	public void testConstructorAvecParametres0Dents() {
		// si le test ne passe pas il y aura des erreurs qui seront attrapées
		// par Junit
		try {
			Crocodile croc = new Crocodile(0, 1.1);
			fail();
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void testConstructorAvecParametres200Dents() {
		// si le test ne passe pas il y aura des erreurs qui seront attrapées
		// par Junit
		try {
			Crocodile croc = new Crocodile(200,  1.1);
			fail();
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testConstructorAvecParametresNonNull() {
		// si le test ne passe pas il y aura des erreurs qui seront attrapées
		// par Junit
		try {
			Crocodile croc = new Crocodile(50,  1.1);
			fail();
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void testConstructorAvecParametresTropPetit() {
		// si le test ne passe pas il y aura des erreurs qui seront attrapées
		// par Junit
		try {
			Crocodile croc = new Crocodile(50,  0.99);
			fail();
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void testConstructorAvecParametresTropGrand() {
		// si le test ne passe pas il y aura des erreurs qui seront attrapées
		// par Junit
		try {
			Crocodile croc = new Crocodile(250, 4.5);
			fail();
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void toStringTest() {
		Crocodile croc = new Crocodile();
		assertEquals("Crocodile [nombreDeDents=100, espece=Crocodile_0, taille=1.0, nombreDeRepas=0]",
				croc.toString());
	}


	@Test
	public void combattreTest() {
		// Acteurs
		Crocodile croco1 = new Crocodile(100,  1);// force 100
		Crocodile croco2 = new Crocodile(120, 1);// force 120
		Crocodile croco3 = new Crocodile(50,  2);// force 100
		Crocodile croco4 = new Crocodile(200,  1);// force 200
		Crocodile croco5 = new Crocodile(30, 4.1);// force 120

		// Actions
		Crocodile perdant1 = croco2.combattre(croco5); // pas assez fort
		Crocodile perdant2 = croco1.combattre(croco3); //  pas assez fort
		Crocodile perdant3 = croco1.combattre(croco2); // croco1 perdant
		Crocodile perdant4 = croco4.combattre(croco5); // croco

		// Assertions
			//les bons vainqueurs
		assertNull(perdant1);
		assertNull(perdant2);
		assertEquals(croco1, perdant3);
		assertEquals(croco5, perdant4);



	}

	public void combattreLuiMemeTest() {
		// Acteurs
		Crocodile croco1 = new Crocodile(100,  1);// force 100

		// Actions
		try{
			croco1.combattre(croco1);
			// Assertion
			fail();
		}catch(AssertionError ae){
			//ok
		}

	}

	@Test
	public void testCreeDentierDefi() {
		Crocodile croc = new Crocodile(100,  3);
		croc.creeDentierDefi();
		int[] dents = croc.getDents();
		int nombreDents = 0;
		for (double longueur : dents) {
			if (longueur > 0) {
				nombreDents++;
			}
		}
		assertEquals(100, nombreDents);

		double plusLongue = 0;
		for (int i = 0; i < 50; i++) {
			assertEquals(0, dents[i]);
		}
		for (int i = 50; i < 150; i++) {
			assert (dents[i] > 0.001);
			if (dents[i] > plusLongue) {
				plusLongue = dents[i];
			}
		}
		for (int i = 150; i < 200; i++) {
			assertEquals(0, dents[i]);
		}
		// symétrie
		for (int i = 0; i < 50; i++) {
			assertEquals(dents[i+50], dents[150 - i-1], EPSILON);
		}
		assertEquals(dents[95], plusLongue,EPSILON);
		assertEquals(dents[104], plusLongue,EPSILON);

	}

}
