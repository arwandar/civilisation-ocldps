package Batiment;
import java.util.Vector;

public class BatAtelierDeSiege extends BatProdUnit
{
	//*************** Variable *******************
	private int production;
	
	//*************** Constructeur *******************
	public BatAtelierDeSiege(Vector V)
	{
		super("atelier de siège", 75, 15, 40, 1, true, V, 3);
		this.typesUnits.add(typeUnite.Catapulte);
	}
}