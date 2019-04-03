import java.util.Random;
import java.util.Scanner;

public class PFC {

	public static void main(String[] args) {

		// Bon ca on s'en fous, �a permettra de lire du texte entr� comme tu le
		// faisais avec ton System.console().readLine();
		Scanner sc = new Scanner(System.in);

		// Les actions, soit pierre, feuille ou ciseaux
		Action actionPlayer = Action.getRandom();
		Action actionBot = Action.getRandom();

		// Choix du pseudo de la premiere entit�, dans ton cas, "joueur".
		say("Joueur 1, choisis un pseudo: ");
		Entity player = new Entity(sc.nextLine(), actionPlayer);

		// Choix du pseudo de la premi�re entit�, dans ton cas "Bot".
		say("Joueur 2, choisis un pseudo: ");
		Entity bot = new Entity(sc.nextLine(), actionBot);

		// S�l�ctionne ta vainqueur (pour toi c'est ta m�thode test).
		Entity winner = Action.getWinner(player, bot);

		/*
		 * enfaite qlqchose de la forme (condition ? condition v�rifi� alors
		 * fait �a : sinon, fais �a), c'est �quivalent � un if(condition) {
		 * condition v�rifi� alors fait �a } else { fais �a } mais c'est plus
		 * rapide
		 */
		System.out.println(winner == null ? "Egalit� !" : "Le gagnant est : " + winner.name);

		// Cette ligne l� tu t'en fous
		sc.close();

	}

	public static void say(String text) {
		System.out.println("PFC: " + text);
	}

	private static enum Action {
		PIERRE, CISEAUX, FEUILLE;

		private static final Random random = new Random();

		/**
		 * Donne l'une des trois trois actions choisis al�atoirement.
		 * 
		 * Enfaite tu peux te dire que dans mon �num�ration, PIERRE -> 1ere
		 * valeur, CISEAUX -> 2eme, etc et on peut les r�cuperer, par exemple,
		 * Action.values()[0] me donnera la premiere valeur du l'�num�ration,
		 * ici PIERRE. Donc ce que je fais c'est que je choisi une valeur
		 * al�aoire entre 0 et le nombre d'�l�ments pr�sent, ici 3 (0, 1, 2 -->
		 * ca fais trois valeur).
		 * 
		 * @return une action
		 */
		public static Action getRandom() {
			return Action.values()[random.nextInt(Action.values().length)];
		}

		/**
		 * Permet de savoir laquelle des deux entit� (dans ton cas joueur et
		 * robot) gagne.
		 * 
		 * @param premiere
		 *            entit�
		 * @param seconde
		 *            entit�
		 * @return l'entit� gagnante, ou null si il y a �galit�, je traite
		 *         ensuite la valeur nulle plus haut
		 */
		public static Entity getWinner(Entity player, Entity bot) {
			Action actionPlayer = player.action;
			Action actionBot = bot.action;

			switch (actionPlayer) {
				case PIERRE :
					if (actionBot == Action.CISEAUX) return player;
					if (actionBot == Action.FEUILLE) return bot;
					break;
				case CISEAUX :
					if (actionBot == Action.FEUILLE) return player;
					if (actionBot == Action.PIERRE) return bot;
					break;
				case FEUILLE :
					if (actionBot == Action.PIERRE) return player;
					if (actionBot == Action.CISEAUX) return bot;
					break;
			}
			return null;
		}
	}

	/**
	 * Objet entit�, avec comme informations son nom et son action associ�e
	 *
	 */
	private static class Entity {
		private final String name;
		private final Action action;

		private Entity(String name, Action action) {
			this.name = name;
			this.action = action;
		}
	}
}
