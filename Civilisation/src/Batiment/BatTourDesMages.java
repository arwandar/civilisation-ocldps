package Batiment;

public class BatTourDesMages extends BatProdUnit
{	
	//*************** Constructeur *******************
	public BatTourDesMages(int V[])
	{
		super("Tour des mages", 50, 15, 40, 1, true, V, 2);
		this.typesUnits.add(typeUnite.Magicien);
		this.typesUnits.add(typeUnite.Healer);
	}
}