package Batiment;

import civ.Case;

public class BatHotelDeVille extends BatProdUnit
{
	//*************** Constructeur *******************
	public BatHotelDeVille(int V[], Case M[][])
	{
		super("Hotel de ville", 100, 10, 50, 1, true, V, 5, M);
		this.typesUnits.add(typeUnite.Peon);
	}
}