package Batiment;

public class BatArcherie extends BatProdUnit
{
	//*************** Variable *******************
	private int production;
	
	//*************** Constructeur *******************
	public BatArcherie(int V[])
	{
		super("Archerie", 50, 15, 40, 1, true, V, 2);
		this.typesUnits.add(typeUnite.Archer);
		this.typesUnits.add(typeUnite.CavalierArcher);
	}
}
