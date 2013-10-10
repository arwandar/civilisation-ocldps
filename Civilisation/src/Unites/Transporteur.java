package Unites;
import Comportement.*;

public class Transporteur extends Personnage {
	public Transporteur(){
		this.deplacer = new Bateau();
		this.Defense=15;
		this.PV=100;
		
		this.tempsProduction=3;
		this.coutBois=125;
	}
}
