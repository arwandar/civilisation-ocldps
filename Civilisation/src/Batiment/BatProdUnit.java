package Batiment;
import java.util.ArrayList;

import joueur.Joueur;
import Unites.Archer;
import Unites.Catapulte;
import Unites.CavalierArcher;
import Unites.Chevalier;
import Unites.Galere;
import Unites.Healer;
import Unites.Magicien;
import Unites.Milicien;
import Unites.Peon;
import Unites.Transporteur;
import civ.Case;

public abstract class BatProdUnit extends Batiment
{
	public enum typeUnite
	{
		Peon,
		
		Archer,
		CavalierArcher,
		
		Milicien,
		
		Chevalier,
		
		Magicien,
		Healer,
		
		Catapulte,
		
		Galere,
		Transporteur;
	}
	//*************** Variable *******************
	protected ArrayList<typeUnite> typesUnits = new ArrayList<typeUnite>();
	
	//*************** Constructeur *******************
	public BatProdUnit(String name, int p, int a, int d, int c, boolean ioe, int V[], int prod, Case M)
	{
		super(name, p, a, d, c, ioe, V, prod, M);
	}
	
	//*************** Accesseur *******************
	public ArrayList<typeUnite> getTYPESUNITS()
	{
		return this.typesUnits;
	}
	
	//*************** Méthodes *******************
	public void newUnit(typeUnite u, Joueur J)
	{
		switch(u)
		{
		case Peon: new Peon(J);
			break;
		case Archer: new Archer(J);
			break;
		case CavalierArcher: new CavalierArcher(J);;
			break;
		case Milicien: new Milicien(J);
			break;
		case Chevalier: new Chevalier(J);
			break;
		case Magicien: new Magicien(J);
			break;
		case Healer: new Healer(J);
			break;
		case Catapulte: new Catapulte(J);
			break;
		case Galere: new Galere(J);
			break;
		case Transporteur: new Transporteur(J);
			break;
		default: System.out.println("ce type d'unité ou ce joueur n'existe pas (newUnit)");
			break;
		}
	}
}
