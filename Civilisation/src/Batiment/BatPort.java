package Batiment;
import java.util.ArrayList;
import java.util.Vector;

public class BatPort extends BatProdUnit
{
	//*************** Variable *******************
	private int production;
	
	//*************** Constructeur *******************
	public BatPort(String name, int p, int a, int d, int c, int prod, Vector V)// il faudrait pouvoir construire le port QUE si une des 4 cases adjacente est maritime.
	{
		super(name, p, a, d, c, true, V, prod);
		this.typesUnits.add(typeUnite.Galere);
		this.typesUnits.add(typeUnite.Transporteur);
	}
}