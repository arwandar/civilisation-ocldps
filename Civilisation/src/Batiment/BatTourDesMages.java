package Batiment;

import civ.Case;

public class BatTourDesMages extends BatProdUnit
{	
	//*************** Constructeur *******************
	public BatTourDesMages(int V[], Case M[][])
	{
		super("Tour des mages", 50, 15, 40, 1, true, V, 2, M);
		this.typesUnits.add(typeUnite.Magicien);
		this.typesUnits.add(typeUnite.Healer);
	}
}