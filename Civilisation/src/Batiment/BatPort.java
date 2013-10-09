package Batiment;

public class BatPort extends BatProdUnit
{	
	//*************** Constructeur *******************
	public BatPort(int V[])// il faudrait pouvoir construire le port QUE si une des 4 cases adjacente est maritime.
	{
		super("Port", 50, 15, 40, 1, true, V, 3);
		this.typesUnits.add(typeUnite.Galere);
		this.typesUnits.add(typeUnite.Transporteur);
	}
}