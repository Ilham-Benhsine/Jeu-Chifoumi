import java.util.Random;
import java.util.Scanner;

public class Chifoumi {

	static Random rnd = new Random();

	public static void main(String[] args) {
		/*
		 * Le jeu de Chifoumi s'appelle aussi Caillou-Ciseaux-Papier. Le joueur va
		 * choisir soit un caillou, soit des ciseaux, soit un papier � l'aide d'un menu.
		 * Le joueur affronte le syst�me. On donne un nombre de points � atteindre au
		 * d�but du programme (3 ou 5 par exemple) et le premier joueur qui a atteint ce
		 * nombre de points a gagn�.
		 */

		Scanner sc = new Scanner(System.in);
		int nbPointsMachine = 0, nbPointsJoueur = 0;

		// D�finir le nombre de points � atteindre pour gagner
		System.out.println("How much does it take to win the game ?");
		final int NB_POINTS = sc.nextInt();

		do {
			// Le joueur choisit ce qu'il va jou�
			System.out.println("Souhaitez vous jouer caillou, ciseaux ou papier ?");
			String reponse = sc.next();

			// Le syst�me joue al�atoirement
			String choixMachine = showChoiceMachine();

			// Comparer les r�ponses
			if (reponse.equals("caillou") && choixMachine.equals("ciseaux")) {
				nbPointsJoueur++;
			} else if (reponse.equals("caillou") && choixMachine.equals("papier")) {
				nbPointsMachine++;
			} else if (reponse.equals("ciseaux") && choixMachine.equals("papier")) {
				nbPointsJoueur++;
			} else if (reponse.equals("ciseaux") && choixMachine.equals("caillou")) {
				nbPointsMachine++;
			} else if (reponse.equals("papier") && choixMachine.equals("caillou")) {
				nbPointsJoueur++;
			} else if (reponse.equals("papier") && choixMachine.equals("ciseaux")) {
				nbPointsMachine++;
			}
		} while (nbPointsJoueur != NB_POINTS && nbPointsMachine != NB_POINTS);

		if (nbPointsJoueur == NB_POINTS) {
			System.out.println("F�licitations, vous avez gang� la partie.\nAvec un score de :" + nbPointsJoueur
					+ " contre " + nbPointsMachine);
		} else if (nbPointsMachine == NB_POINTS) {
			System.out.println("Dommage, vous avez perdu contre une machine.\nAvec un score de :" + nbPointsJoueur
					+ " contre " + nbPointsMachine);
		}
		sc.close();
	}

	private static String showChoiceMachine() {
		// Choix al�atoire de la machine
		String chars = "csp"; // c pour caillou, s pour ciseaux et p pour papier
		char cMachine = chars.charAt(rnd.nextInt(chars.length()));
		// Traduction du choix en String
		String choixMachine;
		switch (cMachine) {
		case 'c':
			choixMachine = "caillou";
			break;
		case 's':
			choixMachine = "ciseaux";
			break;
		case 'p':
			choixMachine = "papier";
			break;
		default:
			choixMachine = "";
			break;
		}
		System.out.println("La machine a jou� :" + choixMachine + ".");
		return choixMachine;
	}
}