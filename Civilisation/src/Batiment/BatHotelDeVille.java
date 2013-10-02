package Batiment;
import java.util.Vector;

public class BatHotelDeVille extends BatProdUnit
{
	//*************** Variable *******************
	private int production;
	
	//*************** Constructeur *******************
	public BatHotelDeVille(Vector V)
	{
		super("Hotel de ville", 100, 10, 50, 1, true, V, 5);
		this.typesUnits.add(typeUnite.Peon);
	}
}