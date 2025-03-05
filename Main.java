import java.util.Scanner;

public class Main {
    static Scanner clavier = new Scanner(System.in);

    static EnsembleTableau ensembleTableau = new EnsembleTableau();
    public static void main(String[] args) {

        application();

    }

    public static void separateur() {
        System.out.println("-----------------------ææ----------------------------");
    }

    public static int choixMenu(){
        int choix;
        do{
            System.out.println("*********************************************************************");
            System.out.println("*******************************Menu**********************************");
            System.out.println("1- Initialiser un ensemble");
            System.out.println("2- Ajouter un element de l'ensemble");
            System.out.println("3- Supprimer un element de l' ensemble");
            System.out.println("4- Afficher l'ensemble");
            System.out.println("5- Union de deux ensembles");
            System.out.println("6- Intersection de deux ensembles");
            System.out.println("7- Scinder un ensemble");
            System.out.println("8- Quitter");
            System.out.println("*********************************************************************");
            System.out.println("Entrez votre choix : ");
            choix = clavier.nextInt();
        }while(choix < 1 || choix > 8);
        return choix;        
    }

    public static void application(){
        Scanner Clavier = new Scanner(System.in);

        int choix = choixMenu();
        
        switch (choix) {
            case 1:
                System.out.println("1- Initialiser un ensemble");
                
                System.out.println("Entrer la taille de l'ensemble : ");
                int taille = Clavier.nextInt();
                Ensemble ensemble = new Ensemble(taille);
                ensembleTableau.ajouter(ensemble);
                System.out.println(ensemble);
                break;
            case 2:
                System.out.println("2- Ajouter un element de l'ensemble");
                System.out.println("Entrer l'indice de l'ensemble : ");
                int indice = Clavier.nextInt();
                ensemble = ensembleTableau.getTabEnsemble()[indice];
                System.out.println("Entrer l'element a ajouter dans l'" + ensemble.getNomEnsemble() + " : ");
                int element = Clavier.nextInt();
                ensemble.ajouter(element);
                System.out.println(ensemble);
                break;
            case 3:
                System.out.println("3- Supprimer un element de l' ensemble");
                System.out.println("Entrer l'indice de l'ensemble : ");
                indice = Clavier.nextInt();
                ensemble = ensembleTableau.getTabEnsemble()[indice];
                System.out.println("Entrer l'element a supprimer dans l' " + ensemble.getNomEnsemble() + " : ");
                int elementSupprimer = Clavier.nextInt();
                ensemble.supprimer(elementSupprimer);
                System.out.println(ensemble);
                break;
            case 4:
                System.out.println("4- Afficher les ensembles");
                ensembleTableau.afficher();
                break;
            case 5:
                System.out.println("5- Union de deux ensembles");

                System.out.println("Entrer l'indice de l'ensemble 1 : ");
                int indice1 = Clavier.nextInt();
                Ensemble ensemble1 = ensembleTableau.getTabEnsemble()[indice1];

                System.out.println("Entrer l'indice de l'ensemble 2 : ");
                int indice2 = Clavier.nextInt();
                Ensemble ensemble2 = ensembleTableau.getTabEnsemble()[indice2];

                Ensemble unionEnsemble = ensemble1.union(ensemble2);
                System.out.println(unionEnsemble);
                break;
            case 6:
                System.out.println("6- Intersection de deux ensembles");

                System.out.println("Entrer l'indice de l'ensemble 1 : ");
                indice1 = Clavier.nextInt();
                ensemble1 = ensembleTableau.getTabEnsemble()[indice1];

                System.out.println("Entrer l'indice de l'ensemble 2 : ");
                indice2 = Clavier.nextInt();
                ensemble2 = ensembleTableau.getTabEnsemble()[indice2];

                Ensemble intersectEnsemble = ensemble1.intersection(ensemble2);
                System.out.println(intersectEnsemble);
                break;
            case 7:
                System.out.println("7- Scinder un ensemble");

                System.out.println("Entrer l'indice de l'ensemble : ");
                indice = Clavier.nextInt();
                ensemble = ensembleTableau.getTabEnsemble()[indice];

                EnsembleTableau ensembleTableau2 = ensemble.scinder();
                System.out.println(ensembleTableau2);
                break;
            case 8:
                System.out.println("Thank you for using my app.");
                System.exit(0);
                break;
            default:
                break;
        }

        do {
            System.out.println("Voulez vous continuer ? 1 = oui et 0 = non");
            choix = Clavier.nextInt();
        } while (choix != 0 && choix != 1);

        if (choix == 0) {
            System.out.println("Thank you for using my app.");
            Clavier.close();
            System.exit(0);
        }
        else if (choix == 1) {
            application();
        }
    }
}
