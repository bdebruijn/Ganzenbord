package ganzenbord;

import java.util.Scanner;
//(DONE) Een ganzenbord creeeren met x aantal vakjes. 
//(DONE) Gebruiker instructie geven.
//(DONE) Dobbelsteen creeeren.
//(DONE) Gebruiker dobbelsteen laten gooien.
//(DONE) Gebruiker laten zien hoeveel is gegooid.
//(DONE) Gebruiker stappen laten zetten op het bord.
//(DONE) Gebruiker optie geven opnieuw te gooien.
//(DONE) Spel stoppen als x aantal vakjes zijn belopen.
//(DONE)Speciale blokjes toevoegen.

public class Ganzenbord {
	public static final int BORDGROOTTE = 63;

	public static void main(String[] args) {
		Spel spel = new Spel();
		spel.start();

	}

}

class Spel {

	boolean doorspelen = true;
	boolean spelen = true;

	Scanner scanner = new Scanner(System.in);
	static public int dobbel;

	int gegooid;
	int positieSpeler;

	public void start() {
		System.out.println("We gaan Ganzenbord spelen!");
		System.out.println("                  __        ");
		System.out.println("                ( 0 _>      ");
		System.out.println("                 |  |       ");
		System.out.println("           _____|    |      ");
		System.out.println("       ___/          |      ");
		System.out.println("      (____         |       ");
		System.out.println("           |_______|        ");
		System.out.println("              |   |         ");
		System.out.println("              |   |         ");
		System.out.println("       (Ja dit is een gans)   ");
		System.out.println(" ");

		while (doorspelen == true) {
			gooiSteen();
			gans();
			brug();
			doolhof();
			dood();
			einde();

		}

	}

	public int gooiDobbel(int dobbel) {
		dobbel = (int) (Math.random() * 6) + 1;
		return dobbel;
	}

	public void gooiSteen() {
		System.out.println("Gooi de dobbelsteen door 1 te toetsen: ");
		int value = scanner.nextInt();

		if (value == 1) {
			gegooid = gooiDobbel(dobbel);
			System.out.println("Je hebt: " + gegooid + " Gegooid.");
			totaalPositie();

		}
	}

	public void totaalPositie() {
		positieSpeler = positieSpeler + gegooid;
		System.out.println("Jouw positie is: " + positieSpeler + ".");

	}

	public void gans() {
		if (positieSpeler == 5 || positieSpeler == 9 || positieSpeler == 14 || positieSpeler == 18
				|| positieSpeler == 23 || positieSpeler == 27 || positieSpeler == 32 || positieSpeler == 36
				|| positieSpeler == 41 || positieSpeler == 45 || positieSpeler == 50 || positieSpeler == 54
				|| positieSpeler == 59) {
			positieSpeler = positieSpeler + gegooid;
			System.out.println("Je bent op de gans beland! Zet " + gegooid + " stappen extra, Jouw positie is: "
					+ positieSpeler + ".");

		}

	}

	public void brug() {
		if (positieSpeler == 6) {
			positieSpeler = 12;
			System.out.println("Je bent op de brug beland! Ga verder naar vakje 12. Jouw positie op het bord is 12.");

		}

	}

	public void doolhof() {
		if (positieSpeler == 42) {
			positieSpeler = 39;
			System.out.println("Je bent op het doolhof beland! Ga terug naar vakje 39. Jouw positie is 39.");
		}

	}

	public void dood() {
		if (positieSpeler == 58) {
			positieSpeler = 0;
			System.out.println("Je bent dood! Ga terug naar het begin. Jouw positie is 0.");
		}

	}

	public void einde() {
		if (positieSpeler >= Ganzenbord.BORDGROOTTE) {
			doorspelen = false;
			System.out.println("Gefeliciteerd! je hebt gewonnen.");
		}
	}

}
