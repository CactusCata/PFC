public class GonFrieks{

    public static String tirage(){
        String choixOrdi = "";
        int nb = (int)(Math.random() * 3);
        if(nb==1){
            choixOrdi = "Pierre";
        }
        else if(nb==2){
            choixOrdi ="Papier";
        }
        else{
            choixOrdi = "Ciseaux";
        }
        return choixOrdi;
    }

    public static String tirageJoueur(){
        String choixJoueur = System.console().readLine();
        return choixJoueur;
    }

    public static String test(){
        String resultat = "";
        if(tirageJoueur().equals("Pierre")&&tirage().equals("Papier")){
            resultat = "Ordi gagne";
            System.out.println(resultat);
        }
        else if(tirageJoueur().equals("Pierre")&&tirage().equals("Ciseaux")){
            resultat = "Joueur gagne";
            System.out.println(resultat);
        }
        else if(tirageJoueur().equals("Papier")&&tirage().equals("Ciseaux")){
            resultat = "Ordi gagne";
            System.out.println(resultat);
        }
        else if(tirageJoueur().equals("Papier")&&tirage().equals("Pierre")){
            resultat = "Joueur gagne";
            System.out.println(resultat);
        }
        else if(tirageJoueur().equals("Ciseaux")&&tirage().equals("Pierre")){
            resultat = "Ordi gagne";
            System.out.println(resultat);
        }
        else if(tirageJoueur().equals("Ciseaux")&&tirage().equals("Papier")){
            resultat = "Joueur gagne";
            System.out.println(resultat);
        }
        else{
            resultat="Egalite";
            System.out.println(resultat);
        }
        return resultat;
    }

    public static void main(String[] args) {
        tirageJoueur();
        System.out.println(tirage());
        test();
    }
}