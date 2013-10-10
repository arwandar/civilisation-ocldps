package Batiment;

import civ.Case;

public class BatArcherie extends BatProdUnit
{
	//*************** Constructeur *******************
	public BatArcherie(int V[], Case M[][])
	{
		super("Archerie", 50, 15, 40, 1, true, V, 2, M);
		this.typesUnits.add(typeUnite.Archer);
		this.typesUnits.add(typeUnite.CavalierArcher);
	}
}