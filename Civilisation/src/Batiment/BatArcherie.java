package Batiment;
import java.util.Vector;

public class BatArcherie extends BatProdUnit
{
	//*************** Variable *******************
	private int production;
	
	//*************** Constructeur *******************
	public BatArcherie(String name, int p, int a, int d, int c, int prod, Vector V)
	{
		super(name, p, a, d, c, true, V, prod);
		this.typesUnits.add(typeUnite.Archer);
		this.typesUnits.add(typeUnite.CavalierArcher);
	}
}
