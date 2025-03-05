import java.util.Arrays;

public class EnsembleTableau {
    private static final int TAILLE = 10;

    private Ensemble []tabEnsemble;
    private int current_Index;
    

    public EnsembleTableau(Ensemble []tabEnsemble) {
        this.tabEnsemble = tabEnsemble;
        this.current_Index = 0;
        for (Ensemble ensemble : tabEnsemble) {
            this.current_Index++;
        }
    }
    public EnsembleTableau() {
        this.tabEnsemble = new Ensemble[TAILLE];
        this.current_Index = 0;
    }
    public EnsembleTableau(int taille) {
        this.tabEnsemble = new Ensemble[taille];
        this.current_Index = 0;
    }
    public Ensemble[] getTabEnsemble() {
        return tabEnsemble;
    }
    public int[] getTableauIndex(int index) {
        return this.tabEnsemble[index].getTableau();
    }
    public String toString() {
        return "EnsembleTableau{\n" +
                "tabEnsemble=" + Arrays.toString(tabEnsemble) +
                '}';
    }
    public void setTabEnsemble(Ensemble[] tabEnsemble) {
        this.tabEnsemble = tabEnsemble;
    }
    public int getCurrent_Index() {
        return current_Index;
    }
    public void setCurrent_Index(int current_Index) {
        this.current_Index = current_Index;
    }
    public void ajouter(Ensemble ensemble) {
        if (this.current_Index < TAILLE) {
            this.tabEnsemble[this.current_Index] = ensemble;
            this.current_Index++;
        } else {
            System.out.println("Tableau plein");
        }
    }
    /*
    public void afficher() {
        System.out.println("EnsembleTableau: ");

        for (Ensemble ensemble : tabEnsemble) {
            ensemble.afficher();
            System.out.println("");
        }

        for (int index = 0; index < this.current_Index; index++) {
            System.out.print(this.tabEnsemble[index] + " ");
            for (int i : this.tabEnsemble[index].getTableau()) {
                System.out.print(i + " ");
            }
        }
    }
        */
    public void afficher() {
        System.out.println("EnsembleTableau: ");
        for (int index = 0; index < this.current_Index; index++) {
            System.out.print(this.tabEnsemble[index] + " ");
            for (int i : this.tabEnsemble[index].getTableau()) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

}