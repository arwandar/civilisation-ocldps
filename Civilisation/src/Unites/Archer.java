package Unites;
import joueur.Joueur;
import Comportement.CombatArc;

public class Archer extends Personnage {
	public Archer(Joueur J){
		
		super(J);
		
		this.attitudeCombative= new CombatArc();
		this.Attaque=8;
		this.PV=30;
		
		this.tempsProduction=1;
		this.coutOr=45;
		this.coutBois=25;
	}
}
