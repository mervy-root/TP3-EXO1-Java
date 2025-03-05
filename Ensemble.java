import java.util.Arrays;

public class Ensemble {
    private int[] tableau;
    String nomEnsemble;

    static int taille = 0;
    // index en cours d'utilisation du tableau
    private int current_Index = 0;
    // taille maximale du tableau
    private static final int TAILLE_TABLEAU = 10;

    public Ensemble(int[] tableau, String nomEnsemble) {
        int Index = getcurrent_Index(tableau); // taille reelle du tableau.
        this.tableau = tableau;
        this.current_Index = Index;
        this.nomEnsemble = nomEnsemble;
        taille++;
    }

    public Ensemble(Ensemble ensemble, String nomEnsemble) {
        this.tableau = ensemble.tableau;
        this.current_Index = ensemble.current_Index;
        this.nomEnsemble = nomEnsemble;
        taille++;
    }

    public Ensemble(int taille, String nomEnsemble) {
        if (taille < 0) {
            System.out.println("Taille du tableau incorrect");
        } else if (taille == 0) {
            this.tableau = new int[TAILLE_TABLEAU];
            this.current_Index = 0;
            this.nomEnsemble = nomEnsemble;
        } else {
            this.tableau = new int[taille];
            this.current_Index = 0;
            this.nomEnsemble = nomEnsemble;
        }
        taille++;
    }

    public Ensemble(int tailleEnsemble) {
        this(tailleEnsemble, "Ensemble " + taille);
        this.nomEnsemble = "Ensemble " + taille;
    }

    public int[] getTableau() {
        return tableau;
    }

    public void setTableau(int[] tableau) {
        int Index = getcurrent_Index(tableau); // taille reelle du tableau.
        this.tableau = tableau;
        this.current_Index = Index;
    }

    public String getNomEnsemble() {
        return nomEnsemble;
    }

    public void setNomEnsemble(String nomEnsemble) {
        this.nomEnsemble = nomEnsemble;
    }

    public int getcurrent_Index(int[] tableau) {
        int index = 0; // taille reelle du tableau.
        for (int i : tableau) {
            if (i == 0) {
                break;
            }
            index++;
        }
        return index;
    }

    public Ensemble copieEnsemble(Ensemble curr) {
        if (curr.current_Index == 0) {
            System.out.println("L'ensemble d'origine est vide");
            return null;
        }

        int tailleDest = this.current_Index + curr.current_Index + 1;
        Ensemble copieEnsemble = new Ensemble(tailleDest);
        copieEnsemble.current_Index = 0;       

        for (int j = 0; j < this.current_Index; j++) {
            if (copieEnsemble.isExiste(this.tableau[j]) == true) {
                continue; 
            }
            copieEnsemble.tableau[copieEnsemble.current_Index] = this.tableau[j];
            copieEnsemble.current_Index++;
        }

        for (int j = 0; j < curr.current_Index; j++) {
            if (copieEnsemble.isExiste(curr.tableau[j])) {
                continue; 
            }
            copieEnsemble.tableau[copieEnsemble.current_Index] = curr.tableau[j];
            copieEnsemble.current_Index++;
        }
        
        return copieEnsemble;
    }

    public int getcurrent_Index() {
        return this.current_Index;
    }

    @Override
    public String toString() {
        return nomEnsemble + "{" +
                "tableau=" + Arrays.toString(tableau) +
                '}';
    }

    public boolean isExiste(int e) {
        for (int j : this.tableau) {
            if (j == e) {
                // System.out.println("L'element " + e + " existe deja");
                return true;
            }
        }
        return false;
    }

    // boolean ajouter(int e) → ajouter un element s'il n'existe pas déjà dans
    // l'ensemble.
    public boolean ajouter(int e) {
        if (isExiste(e)) {
            System.out.println("L'element " + e + " existe deja dans l'ensemble " + this.nomEnsemble);
            return false;
        }

        tableau[current_Index] = e;
        this.current_Index++;
        return true;
    }

    // boolean supprimer(int e) → Supprime un élément s'il est présent.
    public boolean supprimer(int e) {
        boolean exist = false;
        for (int j : tableau) {
            if (j == e) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            System.out.println("L'element " + e + " n'existe pas dans l'ensemble " + this.nomEnsemble);
            return false;
        }

        // Créer un nouveau tableau avec une taille réduite
        int[] newTableau = new int[tableau.length - 1];

        int i = 0;// Index pour le nouveau tableau
        for (int j = 0; j < tableau.length; j++) {
            if (tableau[j] != e) {
                newTableau[i] = this.tableau[j];
                i++;
            }
        }

        // Mettre à jour le tableau d'origine
        this.tableau = newTableau;
        System.out.println("L'élément " + e + " a été supprimé de l'ensemble " + this.nomEnsemble);
        this.current_Index--;
        return true;
    }

    // void afficher() → Affiche les éléments de l’ensemble.
    public void afficher() {
        if (this.current_Index == 0) {
            System.out.println("Ensemble " + this.nomEnsemble + " vide");
            return;
        }
        System.out.print("Ensemble " + this.nomEnsemble + " { ");
        for (int index = 0; index < this.current_Index; index++) {
            System.out.print(this.tableau[index] + " ");
        }
        
        System.out.print("}.");
        System.out.println("");
    }

    // void union(EnsembleTableau autre) → Réunit l’ensemble courant et autre (sans doublons).
    public Ensemble union(Ensemble autre) {
        if (autre.current_Index == 0) {
            System.out.println("L'ensemble " + this.nomEnsemble + " est vide");
            return null;
            
        }
/*
        if (autre.current_Index >= autre.tableau.length) {
            System.out.println("L'ensemble " + this.nomEnsemble + " est mal configure.");
            return null;
        }
*/
        Ensemble unionEnsemble = new Ensemble(this.current_Index + autre.current_Index + 1);
        unionEnsemble = copieEnsemble(autre);
        
        //unionEnsemble.current_Index = this.current_Index + autre.current_Index;
        return unionEnsemble;
    }

    // void intersection(EnsembleTableau autre) → Donne l’intersection de l’ensemble courant et autre.
    public Ensemble intersection(Ensemble autre) {
        if (autre.current_Index == 0) {
            System.out.println("L'ensemble " + this.nomEnsemble + " est vide");
            return null;
        }

        if (autre.current_Index >= autre.tableau.length) {
            System.out.println("L'ensemble " + this.nomEnsemble + " est mal configure.");
            return null;
        }

        Ensemble intersectionEnsemble = new Ensemble(this.current_Index + autre.current_Index + 1);
        intersectionEnsemble.current_Index = 0;
/*
        int[] tableau = new int[this.current_Index + autre.current_Index + 1];
        int index = 0;

        */
        for (int j = 0; j < this.current_Index; j++) {
            if (autre.isExiste(this.tableau[j])) {
                intersectionEnsemble.tableau[intersectionEnsemble.current_Index] = this.tableau[j];
                intersectionEnsemble.current_Index++;
            }
        }
        return intersectionEnsemble;
    }

    //EnsembleTableau scinder() → Sépare l’ensemble en deux parties à peu près égales.
    public EnsembleTableau scinder() {
        if (this.current_Index == 0) {
            System.out.println("L'ensemble " + this.nomEnsemble + " est vide");
            return null;
        }

        int taille = this.current_Index;
        int taille1 = taille / 2;
        int taille2 = taille - taille1;

        Ensemble ensemble1 = new Ensemble(taille1);
        Ensemble ensemble2 = new Ensemble(taille2);

        for (int i = 0; i < taille1; i++) {
            ensemble1.tableau[i] = this.tableau[i];
            ensemble1.current_Index++;
        }
        System.out.println("Ensemble 1 : ");
        ensemble1.afficher();

        for (int i = taille1; i < taille; i++) {
            ensemble2.tableau[i - taille1] = this.tableau[i];
            ensemble2.current_Index++;
        }
        System.out.println("Ensemble 2 : ");
        ensemble2.afficher();
        EnsembleTableau ensembleTableau = new EnsembleTableau();
        ensembleTableau.getTabEnsemble()[0] = ensemble1;
        ensembleTableau.getTabEnsemble()[1] = ensemble2;     
        
        return ensembleTableau;
    }
    
}
