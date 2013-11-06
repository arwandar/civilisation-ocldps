package Unites;
import joueur.Joueur;
import Batiment.BatProdUnit.typeUnite;
import Comportement.AttitudeCombative;
import Comportement.Construire;
import Comportement.Deplacer;
import Comportement.Marcher;
import Comportement.NonConstructeur;
import Comportement.NonSoigneur;
import Comportement.Pacifiste;
import Comportement.Soin;



public abstract class Personnage implements Caracteristiques{
	
	 //Nos instances de comportement
	  protected AttitudeCombative attitudeCombative = new Pacifiste();
	  protected Construire construire = new NonConstructeur();
	  protected Soin soin = new NonSoigneur();
	  protected Deplacer deplacer = new Marcher(); 
	  
	  public int Attaque=Caracteristiques.Attaque; public double Defense=Caracteristiques.Defense; public int PV=Caracteristiques.PV;
	  int tempsProduction=Caracteristiques.tempsProduction;
	  int coutNourriture = Caracteristiques.coutNourriture; int coutOr = Caracteristiques.coutOr; int coutBois = Caracteristiques.coutBois; int coutFer = Caracteristiques.coutFer;
	  int positionHorizontale = Caracteristiques.positionHorizontale;
	  int positionVerticale = Caracteristiques.positionVerticale;
	  int portee = Caracteristiques.portee;
	  int mouvement = Caracteristiques.mouvement;
	  
	  protected Joueur joueur;
	  
	  private typeUnite t;
	     
	  //Constructeur par défaut
	  public Personnage(){
		  
	  }
	     
	  //Méthode de déplacement de personnage
	  public void seDeplacer(){
	    //On utilise les objets de déplacement de façon polymorphe
	    deplacer.deplacer(this);
	  }
	  
	//Méthode de construction de personnage
	  public void batir(){
	    //On utilise les objets de déplacement de façon polymorphe
		  construire.construire();
	  }
	 
	  // Méthode que les combattants utilisent
	  public void combattre(){
	    //On utilise les objets de déplacement de façon polymorphe
		  attitudeCombative.combat(this);
	  }
	     
	  //Méthode de soin
	  public void soigner(){
	    //On utilise les objets de déplacement de façon polymorphe
	    soin.soigner();
	  }
	  
	  
	  
	  public int getPositionHorizontale(){
		  return this.positionHorizontale;
	  }
	  public int getPositionVerticale(){
		  return this.positionVerticale;
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
	  public void setDeplacement(Deplacer deplacer) {
	    this.deplacer = deplacer;
	  }
	  

	public int getPortee() {
		return portee;
	}

	public void setPortee(int portee) {
		this.portee = portee;
	}

	public int getAttaque() {
		return Attaque;
	}

	public void setAttaque(int attaque) {
		Attaque = attaque;
	}

	public double getDefense() {
		return Defense;
	}

	public void setDefense(double defense) {
		Defense = defense;
	}

	public int getPV() {
		return PV;
	}

	public void setPV(int l) {
		PV = l;
	}

	public int getTempsProduction() {
		return tempsProduction;
	}

	public void setTempsProduction(int tempsProduction) {
		this.tempsProduction = tempsProduction;
	}

	public int getCoutNourriture() {
		return coutNourriture;
	}

	public void setCoutNourriture(int coutNourriture) {
		this.coutNourriture = coutNourriture;
	}

	public int getCoutOr() {
		return coutOr;
	}

	public void setCoutOr(int coutOr) {
		this.coutOr = coutOr;
	}

	public int getCoutBois() {
		return coutBois;
	}

	public void setCoutBois(int coutBois) {
		this.coutBois = coutBois;
	}

	public int getCoutFer() {
		return coutFer;
	}

	public void setCoutFer(int coutFer) {
		this.coutFer = coutFer;
	}

	public void setPositionHorizontale(int positionHorizontale) {
		this.positionHorizontale = positionHorizontale;
	}

	public void setPositionVerticale(int positionVerticale) {
		this.positionVerticale = positionVerticale;
	}

	public int getMouvement() {
		return mouvement;
	}

	public void setMouvement(int mouvement) {
		this.mouvement = mouvement;
	}

	public typeUnite getT() {
		return t;
	}

	public void setT(typeUnite t) {
		this.t = t;
	}

	public void setPV(long l) {
		this.PV=(int) l;// TODO Auto-generated method stub
		
	} 
}
