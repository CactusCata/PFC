import java.util.Random;
import java.util.Scanner;

public class PFC {

	public static void main(String[] args) {

		// Bon ca on s'en fous, ça permettra de lire du texte entré comme tu le
		// faisais avec ton System.console().readLine();
		Scanner sc = new Scanner(System.in);

		// Les actions, soit pierre, feuille ou ciseaux
		Action actionPlayer = Action.getRandom();
		Action actionBot = Action.getRandom();

		// Choix du pseudo de la premiere entité, dans ton cas, "joueur".
		say("Joueur 1, choisis un pseudo: ");
		Entity player = new Entity(sc.nextLine(), actionPlayer);

		// Choix du pseudo de la première entité, dans ton cas "Bot".
		say("Joueur 2, choisis un pseudo: ");
		Entity bot = new Entity(sc.nextLine(), actionBot);

		// Séléctionne ta vainqueur (pour toi c'est ta méthode test).
		Entity winner = Action.getWinner(player, bot);

		/*
		 * enfaite qlqchose de la forme (condition ? condition vérifié alors
		 * fait ça : sinon, fais ça), c'est équivalent à un if(condition) {
		 * condition vérifié alors fait ça } else { fais ça } mais c'est plus
		 * rapide
		 */
		System.out.println(winner == null ? "Egalité !" : "Le gagnant est : " + winner.name);

		// Cette ligne là tu t'en fous
		sc.close();

	}

	public static void say(String text) {
		System.out.println("PFC: " + text);
	}

	private static enum Action {
		PIERRE, CISEAUX, FEUILLE;

		private static final Random random = new Random();

		/**
		 * Donne l'une des trois trois actions choisis aléatoirement.
		 * 
		 * Enfaite tu peux te dire que dans mon énumération, PIERRE -> 1ere
		 * valeur, CISEAUX -> 2eme, etc et on peut les récuperer, par exemple,
		 * Action.values()[0] me donnera la premiere valeur du l'énumération,
		 * ici PIERRE. Donc ce que je fais c'est que je choisi une valeur
		 * aléaoire entre 0 et le nombre d'éléments présent, ici 3 (0, 1, 2 -->
		 * ca fais trois valeur).
		 * 
		 * @return une action
		 */
		public static Action getRandom() {
			return Action.values()[random.nextInt(Action.values().length)];
		}

		/**
		 * Permet de savoir laquelle des deux entité (dans ton cas joueur et
		 * robot) gagne.
		 * 
		 * @param premiere
		 *            entité
		 * @param seconde
		 *            entité
		 * @return l'entité gagnante, ou null si il y a égalité, je traite
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
	 * Objet entité, avec comme informations son nom et son action associée
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
