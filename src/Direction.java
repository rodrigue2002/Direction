import java.util.*;
import java.text.SimpleDateFormat;
public class Direction{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int counter = 0;
        List<Secretaire> secretaires = new ArrayList<>(); 
        List<Double>  salairesSecretaire =  new ArrayList<>();
        List<Enseignant> enseignants = new ArrayList<>();
        List<Double> salairesEnseignants = new ArrayList<>();
        List<EtudiantRegulier> etudiantReguliers = new ArrayList<>();
        List<EtudiantDechange> etudiantDechange = new ArrayList<>();
        List<Integer> anneeMoyenne = new ArrayList<>();
        String a = "oui";
        

        while(a.equals("oui")){
            String g = " ";
            System.out.println();
            if(counter < 1){
                System.out.println("quelquun veut il senregistrer ?(oui/non):");
                a = sc.nextLine();
                a = a.toLowerCase();
                while(!a.equals("non") && !a.equals("oui")){
                    System.out.println("veuillez sil vous plait entrer oui(si vous vous voulez vous enregistrer) ou non(au cas contraire) :");
                    a = sc.nextLine();
                    a = a.toLowerCase();
                }
            }
            if(counter >= 1){
                System.out.println("quelquun dautre veut il senregistrer ?(oui/non):");
                a = sc.nextLine();
                a = a.toLowerCase();
                while(!a.equals("non") && !a.equals("oui")){
                    System.out.println("veuillez sil vous plait entrer oui(si vous vous voulez vous enregistrer) ou non(au cas contraire) :");
                    a = sc.nextLine();
                    a = a.toLowerCase();
                }
            }

            if(a.equals("oui")){
                System.out.println("es tu secretaire, enseignant, etudiant regulier ou etudiant dechange?: ");
                 g= sc.nextLine();
            }
            g = g.toLowerCase();
    
            if(a.equals("oui")){
                while(!g.equals("secretaire")  && !g.equals("enseignant") && !g.equals("etudiant regulier") && !g.equals("etudiant dechange") ){
                    System.out.print("veuillez sil vous plait bien entrer votre statut sans faire derreur sur lorthographe. \n\nes tu secretaire, enseignant, etudiant regulier ou etudiant dechange? : ");
                    g= sc.nextLine();
                }
            }
           
            g = g.toLowerCase();

            if(a.equals("oui")){
                counter++;
            }

            if (g.equals("secretaire")){
                System.out.print("entrez votre nom: ");
                String o = sc.nextLine();
                System.out.print("entrez votre Annee dentree a EPFL: ");
                int h = sc.nextInt();
                System.out.print("entrez le nom de votre laboratoire: ");
                sc.nextLine();
                String Labo = sc.nextLine();
                System.out.print("entrez votre salaire: ");
                double salaire = sc.nextDouble();
                Secretaire mama = new Secretaire(o, h, Labo);
                System.out.println();
                secretaires.add(mama);
                salairesSecretaire.add(salaire);
                anneeMoyenne.add(h);
                sc.nextLine();
            }

            if(g.equals("enseignant")){
                System.out.print("entrez votre nom: ");
                String o = sc.nextLine();
                System.out.print("entrez votre Annee dentree a EPFL: ");
                int h = sc.nextInt();
                System.out.print("entrez le nom de votre laboratoire: ");
                sc.nextLine();
                String Labo = sc.nextLine();
                System.out.print("entrez le nom de votre section enseignement: ");
                //sc.nextLine();
                String s = sc.nextLine();
                System.out.print("entrez votre salaire: ");
                double salaire = sc.nextDouble();
                Enseignant papa = new Enseignant(o, h, Labo, s);
                enseignants.add(papa);
                salairesEnseignants.add(salaire);
                anneeMoyenne.add(h);
                sc.nextLine();

            }

            if(g.equals("etudiant regulier")){
                System.out.print("entrez votre nom: ");
                String o = sc.nextLine();
                System.out.print("entrez votre Annee dentree a EPFL: ");
                int h = sc.nextInt();
                System.out.print("entrez le nom de votre section : ");
                sc.nextLine();
                String s = sc.nextLine();
                System.out.print("entrez votre note moyenne : ");
                double p = sc.nextDouble();
                EtudiantRegulier petit = new EtudiantRegulier(o, h, s, p);
                anneeMoyenne.add(h);
                etudiantReguliers.add(petit);
                sc.nextLine();

            }

            if(g.equals("etudiant dechange")){
                System.out.print("entrez votre nom: ");
                String o = sc.nextLine();
                System.out.print("entrez votre Annee dentree a EPFL: ");
                int h = sc.nextInt();
                System.out.print("entrez le nom de votre section : ");
                sc.nextLine();
                String s = sc.nextLine();
                System.out.print("entrez votre Universite dorigine : ");
                String p = sc.nextLine();
                EtudiantDechange cadet = new EtudiantDechange(o, h, s, p);
                anneeMoyenne.add(h);
                etudiantDechange.add(cadet);
                
            }

            
        } 
        if(counter>=1) {
            int counterEtudiants = etudiantDechange.size() + etudiantReguliers.size();
            double anMoyen = 0;
            for(int i = 0; i< anneeMoyenne.size(); i++){
               anMoyen += anneeMoyenne.get(i);
            }
            anMoyen /= anneeMoyenne.size(); 
            int anneMinimale = anneeMoyenne.get(0);
            for(int i = 1; i< anneeMoyenne.size(); i++){
                if(anneeMoyenne.get(i) < anneMinimale ) anneMinimale = anneeMoyenne.get(i);

             }
            anMoyen -= anneMinimale;
            Date dateCourante = new Date();
            SimpleDateFormat formatage = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("\n================================ \n" + formatage.format(dateCourante));
            System.out.println("\nparmis les " + counter + " EPFLiens, " + counterEtudiants + " sont des etudiants.\n ils sont a EPLFL depuis en moyenne " + anMoyen + " ans.");
            System.out.println("\n Liste des EPFLiens: ");

            for(int i = 0; i< secretaires.size(); i++){
                System.out.println("\nSecretaire : ");
                secretaires.get(i).donneesSecretaires();
                System.out.println("\tSalaire : " + salairesSecretaire.get(i) +" euro");   
            }

            for(int i = 0; i < enseignants.size(); i++){
                System.out.println("\nEnseignant : ");
                enseignants.get(i).donneesEnseignants();
                System.out.println("\tSalaire : " + salairesEnseignants.get(i) +" euro");   
            
            }

            for(int i = 0; i < etudiantReguliers.size(); i++){
                System.out.println("\nEtudiant regulier : ");
                etudiantReguliers.get(i).donneesEtudiantRegulier();
            }

            for(int i = 0; i < etudiantDechange.size(); i++){
                System.out.println("\nEtudiant dechange : ");
                etudiantDechange.get(i).donneesEtudiantDechange();
            }
        }
        if(counter<1 && a.equals("non")) {
            Date dateCourante = new Date();
            SimpleDateFormat formatage = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("\n================================ \n" + formatage.format(dateCourante));
            System.out.println("personne ne sest enregistre aujourdhui\n ");
        }

    }
}

class  Secretaire{
    private String nom;
    private int anneeDarrive;
    private String nomLabo;

    public Secretaire(String nom, int anneeDarrive, String nomLabo){
        this.anneeDarrive = anneeDarrive;
        this.nom = nom;
        this.nomLabo = nomLabo;
    }

    public String getNomLabo(){
        return this.nomLabo;
    }

    public String getNom(){
        return this.nom;
    }

    public int getAnneeDarrive(){
        return this.anneeDarrive;
    }

    public void donneesSecretaires(){
        System.out.println("\tNom : " + this.getNom());
        System.out.println("\tAnnee : " + this.getAnneeDarrive());
        System.out.println("\tLaboratoire : " + this.getNomLabo());
    }

}
class Enseignant extends Secretaire{
    private String nomSection;

    public Enseignant(String nom, int anneeDarrive, String nomLabo, String nomSection){
        super(nom, anneeDarrive, nomLabo);
        this.nomSection = nomSection;
    }

    public String getNomSection(){
        return this.nomSection;
    }
    public void donneesEnseignants(){
        System.out.println("\tNom : " + this.getNom());
        System.out.println("\tAnnee : " + this.getAnneeDarrive());
        System.out.println("\tLaboratoire : " + this.getNomLabo());
        System.out.println("\tsection denseignement: " + this.getNomSection());
    }
       
}

class EtudiantDechange{
    private String nom;
    private int anneeDarrive;
    private String nomSection;
    private String nomUni;

    public EtudiantDechange(String nom, int anneeDarrive, String nomSection, String nomUni){
        this.nom = nom;
        this.anneeDarrive = anneeDarrive;
        this.nomSection = nomSection;
        this.nomUni = nomUni;
    }

    public String getNom(){
        return nom;
    }

    public int getAnneeDarrive(){
        return anneeDarrive;
    }

    public String getNomSection(){
        return nomSection;
    }

    public String getNomUni(){
        return nomUni;
    }

    public void donneesEtudiantDechange(){
        System.out.println("\tNom : " + this.getNom());
        System.out.println("\tAnnee : " + this.getAnneeDarrive());
        System.out.println("\tsection : " + this.getNomSection());
        System.out.println("\tUni dorigine : " + this.getNomUni());
    }
 
}

class EtudiantRegulier{
    private String nom;
    private int anneeDarrive;
    private String nomSection;
    private double noteMoyenne;

    public EtudiantRegulier(String nom, int anneeDarrive, String nomSection, double noteMoyenne){
        this.nom = nom;
        this.anneeDarrive = anneeDarrive;
        this.nomSection = nomSection;
        this.noteMoyenne = noteMoyenne;
    }

    public String getNom(){
        return nom;
    }

    public int getAnneeDarrive(){
        return anneeDarrive;
    }

    public String getNomSection(){
        return nomSection;
    }

    public double getMoyenne(){
        return noteMoyenne;
    }

    public void donneesEtudiantRegulier(){
        System.out.println("\tNom : " + this.getNom());
        System.out.println("\tAnnee : " + this.getAnneeDarrive());
        System.out.println("\tsection : " + this.getNomSection());
        System.out.println("\tmoyenne: " + this.getMoyenne());
    }
}
