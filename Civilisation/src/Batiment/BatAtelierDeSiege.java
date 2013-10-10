package Batiment;

import civ.Case;

public class BatAtelierDeSiege extends BatProdUnit
{
	
	//*************** Constructeur *******************
	public BatAtelierDeSiege(int V[], Case M[][])
	{
		super("atelier de siège", 75, 15, 40, 1, true, V, 3, M);
		this.typesUnits.add(typeUnite.Catapulte);
	}
}