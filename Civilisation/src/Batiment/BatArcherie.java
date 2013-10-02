package Batiment;
import java.util.Vector;

public class BatArcherie extends BatProdUnit
{
	//*************** Variable *******************
	private int production;
	
	//*************** Constructeur *******************
	public BatArcherie(Vector V)
	{
		super("Archerie", 50, 15, 40, 1, true, V, 2);
		this.typesUnits.add(typeUnite.Archer);
		this.typesUnits.add(typeUnite.CavalierArcher);
	}
}
