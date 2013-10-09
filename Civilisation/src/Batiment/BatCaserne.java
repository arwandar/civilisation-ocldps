package Batiment;

public class BatCaserne extends BatProdUnit
{
	//*************** Variable *******************
	private int production;
	
	//*************** Constructeur *******************
	public BatCaserne(int V[])
	{
		super("Caserne", 50, 15, 40, 1, true, V, 2);
		this.typesUnits.add(typeUnite.Milicien);
	}
}