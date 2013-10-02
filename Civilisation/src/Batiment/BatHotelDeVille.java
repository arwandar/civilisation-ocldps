package Batiment;
import java.util.Vector;

public class BatHotelDeVille extends BatProdUnit
{
	//*************** Variable *******************
	private int production;
	
	//*************** Constructeur *******************
	public BatHotelDeVille(String name, int p, int a, int d, int c, int prod, Vector V)
	{
		super(name, p, a, d, c, true, V, prod);
		this.typesUnits.add(typeUnite.Peon);
	}
}