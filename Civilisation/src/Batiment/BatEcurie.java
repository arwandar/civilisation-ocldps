package Batiment;

import civ.Case;

public class BatEcurie extends BatProdUnit
{
	//*************** Constructeur *******************
	public BatEcurie(int V[], Case M[][])
	{
		super("Ecurie", 50, 15, 45, 1, true, V, 3, M);
		this.typesUnits.add(typeUnite.Chevalier);
	}
}