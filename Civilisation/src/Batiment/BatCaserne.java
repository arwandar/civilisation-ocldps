package Batiment;

import civ.Case;

public class BatCaserne extends BatProdUnit
{
	//*************** Constructeur *******************
	public BatCaserne(int V[], Case M)
	{
		super("Caserne", 50, 15, 40, 1, true, V, 2, M);
		this.typesUnits.add(typeUnite.Milicien);
	}
}