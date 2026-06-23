import java.util.*;
import java.io.*;

public class DealOrNoDeal {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<String> ungeoffneteKoffer = new ArrayList<>();
	static ArrayList<String> geoffneteKoffer = new ArrayList<>();
	static int runden = 1;

	public static void main(String[] args) throws IOException {
		Menue menue = new Menue();
		System.out.println(menue.begruessung);
		menue.playerInput();

	}

	public static void HauptSpiel() {

		InitialisiereKoffer();
		PrivaterKofferAuswahl();
		KofferZiehungen();
	}

	private static void PrivaterKofferAuswahl() {
		System.out.println("Ungeöffnete Koffer: " + ungeoffneteKoffer);

		System.out.print("Wähle deinen Speziellen Koffer aus: ");
		String spielerKoffer = scan.nextLine();

		if (ungeoffneteKoffer.contains(spielerKoffer)) {
			ungeoffneteKoffer.remove(spielerKoffer);
			System.out.print("\u001B[42m" + "Dein Spezieller Koffer:" + spielerKoffer + "\u001B[0m ");
		}
	}

	private static void InitialisiereKoffer() {
		// 26 Koffer initialisieren
		for (int i = 1; i < 27; i++) {
			ungeoffneteKoffer.add("Koffer" + i);
		}
	}

	private static void KofferZiehungen() {
		while (ungeoffneteKoffer.size() > 1) {
			// Definition von runden und der jeweiligen Kofferziehung
			int anzahlKofferZiehungen = 0;
			switch (runden) {
			case 1:
				anzahlKofferZiehungen = 6;
				break;
			case 2:
				anzahlKofferZiehungen = 5;
				break;
			case 3:
				anzahlKofferZiehungen = 4;
				break;
			case 4:
				anzahlKofferZiehungen = 3;
				break;
			case 5:
				anzahlKofferZiehungen = 2;
				break;
			default:
				anzahlKofferZiehungen = 1;
				break;
			}

			System.out.println("\u001B[44m" + "\nRunde " + runden + "\u001B[0m ");
			for (int i = 0; i < anzahlKofferZiehungen; i++) {

				System.out.println("\u001B[46m" + "Ungeöffnete Koffer: " + ungeoffneteKoffer + "\u001B[0m ");

				System.out.print("Welchen Koffer möchten Sie öffnen? ");
				String eingabe = scan.nextLine();

				if (ungeoffneteKoffer.contains(eingabe)) {
					ungeoffneteKoffer.remove(eingabe);
					geoffneteKoffer.add(eingabe);
				} else {
					System.err.println("Dieser Koffer existiert nicht oder wurde bereits geöffnet.");
					i--;
				}

				System.out.println("\u001B[41m" + "Geöffnete Koffer: " + geoffneteKoffer + "\u001B[0m ");
			}

			runden++;

		}
	}

}
