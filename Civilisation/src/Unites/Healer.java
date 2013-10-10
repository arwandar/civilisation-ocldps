package Unites;
import Comportement.*;


public class Healer extends Personnage {
	public Healer(){
		this.soin= new Soigneur();
		this.PV=30;
		
		this.tempsProduction=2;
		this.coutNourriture=40;
		this.coutOr=50;
	}
}
