package Batiment;
import java.util.Vector;

public class BatTourDesMages extends BatProdUnit
{	
	//*************** Constructeur *******************
	public BatTourDesMages(Vector V)
	{
		super("Tour des mages", 50, 15, 40, 1, true, V, 2);
		this.typesUnits.add(typeUnite.Magicien);
		this.typesUnits.add(typeUnite.Healer);
	}
}