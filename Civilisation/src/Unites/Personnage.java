package Unites;
import Comportement.*;



public abstract class Personnage implements Caracteristiques{
	
	 //Nos instances de comportement
	  protected AttitudeCombative attitudeCombative = new Pacifiste();
	  protected Construire construire = new NonConstructeur();
	  protected Soin soin = new NonSoigneur();
	  protected Deplacement deplacement = new Marcher(); 
	  int Attaque=Caracteristiques.Attaque; int Defense=Caracteristiques.Defense; int PV=Caracteristiques.PV;
	  int tempsProduction=Caracteristiques.tempsProduction;
	  int coutNourriture = Caracteristiques.coutNourriture; int coutOr = Caracteristiques.coutOr; int coutBois = Caracteristiques.coutBois; int coutFer = Caracteristiques.coutFer;
	     
	  //Constructeur par défaut
	  public Personnage(){}
	     
	  //Constructeur avec paramètres
	  public Personnage(AttitudeCombative attitudeCombative, Soin soin, Deplacement deplacement, Construire construire, int Attaque, int Defense, int PV, int tempsProduction, int coutNourriture, int coutOr, int coutBois, int coutFer) {
	    this.attitudeCombative = attitudeCombative;
	    this.soin = soin;
	    this.deplacement = deplacement;
	    this.construire = construire;
	    this.Attaque=Attaque; this.Defense=Defense; this.PV=PV;
	    this.tempsProduction=tempsProduction;
	    this.coutNourriture=coutNourriture; this.coutOr=coutOr; this.coutBois=coutBois; this.coutFer=coutFer;
	  }
	     
	  //Méthode de déplacement de personnage
	  public void seDeplacer(){
	    //On utilise les objets de déplacement de façon polymorphe
	    deplacement.deplacer();
	  }
	  
	//Méthode de construction de personnage
	  public void batir(){
	    //On utilise les objets de déplacement de façon polymorphe
		  construire.construire();
	  }
	 
	  // Méthode que les combattants utilisent
	  public void combattre(){
	    //On utilise les objets de déplacement de façon polymorphe
		  attitudeCombative.combat();
	  }
	     
	  //Méthode de soin
	  public void soigner(){
	    //On utilise les objets de déplacement de façon polymorphe
	    soin.soigner();
	  }
	  
	  
	 
	  //Redéfinit le comportement au combat
	  public void setEspritCombatif(AttitudeCombative attitudeCombative) {
	    this.attitudeCombative = attitudeCombative;
	  }
	  
	  //Redéfinit le comportement de construction
	  public void setBatir( Construire construire) {
	    this.construire = construire;
	  }
	 
	  //Redéfinit le comportement de Soin
	  public void setSoin(Soin soin) {
	    this.soin = soin;
	  }
	 
	  //Redéfinit le comportement de déplacement
	  public void setDeplacement(Deplacement deplacement) {
	    this.deplacement = deplacement;
	  } 
}
