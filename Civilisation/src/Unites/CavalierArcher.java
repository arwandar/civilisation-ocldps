package Unites;
import Comportement.*;

public class CavalierArcher extends Personnage {
	public CavalierArcher(){
		this.attitudeCombative= new CombatArc();
		this.deplacer = new Cheval();
		this.Attaque=12;
		this.Defense=20;
		this.PV=50;
		
		this.tempsProduction=2;
		this.coutOr=70;
		this.coutBois=40;
		
	}
}
