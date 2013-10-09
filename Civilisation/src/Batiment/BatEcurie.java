package Batiment;

public class BatEcurie extends BatProdUnit
{	
	//*************** Variables *******************
	private int production;
		
	//*************** Constructeur *******************
	public BatEcurie(int V[])
	{
		super("Ecurie", 50, 15, 45, 1, true, V, 3);
		this.typesUnits.add(typeUnite.Chevalier);
	}
	
	//*************** Accesseurs *******************
	public int getPRODUCTION()
	{
		return this.production;
	}
	
	//*************** Mutateurs *******************
	public void setPRODUCTION(int p)
	{
		this.production = p;
	}
}