package Unites;
import joueur.Joueur;
import Comportement.Bateau;
import Comportement.CombatArc;

public class Galere extends Personnage {
	public Galere(Joueur J){
		
		super(J);
		
		this.attitudeCombative= new CombatArc();
		this.deplacer = new Bateau();
		this.Attaque=12;
		this.Defense=20;
		this.PV=120;
		
		this.tempsProduction=3;
		this.coutOr=30;
		this.coutBois=90;
	}
}
