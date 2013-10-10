package Batiment;
import java.util.ArrayList;

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
	public BatProdUnit(String name, int p, int a, int d, int c, boolean ioe, int V[], int prod, Case M[][])
	{
		super(name, p, a, d, c, ioe, V, prod, M);
	}
	
	//*************** Accesseur *******************
	public ArrayList<typeUnite> getTYPESUNITS()
	{
		return this.typesUnits;
	}
}
