package Batiment;
import java.util.Vector;

public class BatEcurie extends BatProdUnit
{	
	//*************** Constructeur *******************
	public BatEcurie(Vector V)
	{
		super("Ecurie", 50, 15, 45, 1, true, V, 3);
		this.typesUnits.add(typeUnite.Chevalier);
	}
}