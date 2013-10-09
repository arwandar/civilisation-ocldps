package Batiment;

public class BatHotelDeVille extends BatProdUnit
{
	//*************** Variable *******************
	private int production;
	
	//*************** Constructeur *******************
	public BatHotelDeVille(int V[])
	{
		super("Hotel de ville", 100, 10, 50, 1, true, V, 5);
		this.typesUnits.add(typeUnite.Peon);
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