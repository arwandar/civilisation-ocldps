package Batiment;
import java.util.ArrayList;
import java.util.Vector;

public class BatTourDesMages extends BatProdUnit
{
	//*************** Variable *******************
	private int production;
	
	//*************** Constructeur *******************
	public BatTourDesMages(String name, int p, int a, int d, int c, int prod, Vector V)
	{
		super(name, p, a, d, c, true, V, prod);
		this.typesUnits.add(typeUnite.Magicien);
		this.typesUnits.add(typeUnite.Healer);
	}
}