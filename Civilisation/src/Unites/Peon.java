package Unites;
import Comportement.*;

public class Peon extends Personnage {
	public Peon(){
		this.construire = new Constructeur();
		this.PV=25;
		
		this.tempsProduction=1;
		this.coutNourriture=50;
	}
}