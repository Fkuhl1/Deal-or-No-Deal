import java.util.*;
import java.io.*;

public class Menue {
	public String begruessung = "";
	private String playerName = "";
	public int eingabe;

	Menue() {
		begruessung = "Herzlich Willkommen, bei Deal or No Deal!\nBitte geben Sie ihren namen ein: ";

	}

	void playerInput() throws IOException{
		Scanner scan = new Scanner(System.in);
		playerName = scan.nextLine();
		System.out.println("Hallo " + "\u001B[33m" + playerName + "\u001B[0m" + "!\n" + "\nWähle aus: \nRegeln&Spielstart(1)\nSpielstart(2)");

		while (true) {
			try {
				eingabe = Integer.parseInt(scan.nextLine());

				if (eingabe == 1 || eingabe == 2) {
					break;
				}

				System.err.println("Bitte nur 1 oder 2 eingeben.");

			} catch (Exception e) {
				System.err.println("Ungültige Eingabe! Bitte eine Zahl eingeben.");
			}
		}

		switch (eingabe) {
		case 1:
			System.out.println(
					"Regeln : Sie haben 26 Koffer und jeder dieser Koffer hat einen Wert von 0.01€ bis zu 1.000.000€!\n"
							+ "\n" + "Runde 1: 6 Koffer werden ausgewählt.\n" + "Runde 2: 5 Koffer werden ausgewählt.\n"
							+ "Runde 3: 4 Koffer werden ausgewählt.\n" + "Runde 4: 3 Koffer werden ausgewählt.\n"
							+ "Runde 5: 2 Koffer werden ausgewählt.\n"
							+ "Danach wird jeweils 1 Koffer pro Runde ausgewählt.\n" + "\n"
							+ "Außerdem haben sie die Möglichkeit einen Speziellen Koffer auszuwählen den sie bis zum Ende des Spiels haben.\n");
			DealOrNoDeal.HauptSpiel();
			break;
		case 2:
			DealOrNoDeal.HauptSpiel();
			break;
		}
		scan.close();
	}
}
