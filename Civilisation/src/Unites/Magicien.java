package Unites;
import joueur.Joueur;
import Comportement.CombatMagie;


public class Magicien extends Personnage {
	public Magicien(Joueur J){
		
		super(J);
		
		this.attitudeCombative= new CombatMagie();
		this.Attaque=14;
		this.PV=30;
		
		this.tempsProduction=2;
		this.coutNourriture=50;
		this.coutOr=40;
	}
}
