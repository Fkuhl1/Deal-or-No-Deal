import java.util.*;

public class MainLoop {

	public static void main(String[] args) {
		ArrayList<String> ungeoffneteKoffer = new ArrayList<>();
		ArrayList<String> geoffneteKoffer = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int runden = 1;

		// 26 Koffer initialisieren
		for (int i = 1; i < 27; i++) {
			ungeoffneteKoffer.add("Koffer" + i);
		}
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

		while (ungeoffneteKoffer.size() > 1) {

			System.out.println("Runde " + runden);
			for (int i = 0; i < anzahlKofferZiehungen; i++) {

				System.out.println("Ungeöffnete Koffer: " + ungeoffneteKoffer);

				System.out.print("Welchen Koffer möchten Sie öffnen? ");
				String eingabe = scanner.nextLine();

				if (ungeoffneteKoffer.contains(eingabe)) {
					ungeoffneteKoffer.remove(eingabe);
					geoffneteKoffer.add(eingabe);
				} else {
					System.out.println("Dieser Koffer existiert nicht oder wurde bereits geöffnet.");
					i--;
				}

				System.out.println("Geöffnete Koffer: " + geoffneteKoffer);
			}

			runden++;

		}

	}

}
