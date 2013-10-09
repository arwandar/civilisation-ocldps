package Batiment;

public class BatAtelierDeSiege extends BatProdUnit
{
	//*************** Variable *******************
	private int production;
	
	//*************** Constructeur *******************
	public BatAtelierDeSiege(int V[])
	{
		super("atelier de si�ge", 75, 15, 40, 1, true, V, 3);
		this.typesUnits.add(typeUnite.Catapulte);
	}
}