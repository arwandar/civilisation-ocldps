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
	     
	  //Constructeur par d�faut
	  public Personnage(){}
	     
	  //Constructeur avec param�tres
	  public Personnage(AttitudeCombative attitudeCombative, Soin soin, Deplacement deplacement, Construire construire, int Attaque, int Defense, int PV, int tempsProduction, int coutNourriture, int coutOr, int coutBois, int coutFer) {
	    this.attitudeCombative = attitudeCombative;
	    this.soin = soin;
	    this.deplacement = deplacement;
	    this.construire = construire;
	    this.Attaque=Attaque; this.Defense=Defense; this.PV=PV;
	    this.tempsProduction=tempsProduction;
	    this.coutNourriture=coutNourriture; this.coutOr=coutOr; this.coutBois=coutBois; this.coutFer=coutFer;
	  }
	     
	  //M�thode de d�placement de personnage
	  public void seDeplacer(){
	    //On utilise les objets de d�placement de fa�on polymorphe
	    deplacement.deplacer();
	  }
	  
	//M�thode de construction de personnage
	  public void batir(){
	    //On utilise les objets de d�placement de fa�on polymorphe
		  construire.construire();
	  }
	 
	  // M�thode que les combattants utilisent
	  public void combattre(){
	    //On utilise les objets de d�placement de fa�on polymorphe
		  attitudeCombative.combat();
	  }
	     
	  //M�thode de soin
	  public void soigner(){
	    //On utilise les objets de d�placement de fa�on polymorphe
	    soin.soigner();
	  }
	  
	  
	 
	  //Red�finit le comportement au combat
	  public void setEspritCombatif(AttitudeCombative attitudeCombative) {
	    this.attitudeCombative = attitudeCombative;
	  }
	  
	  //Red�finit le comportement de construction
	  public void setBatir( Construire construire) {
	    this.construire = construire;
	  }
	 
	  //Red�finit le comportement de Soin
	  public void setSoin(Soin soin) {
	    this.soin = soin;
	  }
	 
	  //Red�finit le comportement de d�placement
	  public void setDeplacement(Deplacement deplacement) {
	    this.deplacement = deplacement;
	  } 
}
