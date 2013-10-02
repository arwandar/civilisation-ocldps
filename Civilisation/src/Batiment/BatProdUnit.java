package Batiment;
import java.util.ArrayList;
import java.util.Vector;

public abstract class BatProdUnit extends Batiment
{
	public enum typeUnite
	{
		Peon,
		
		Archer,
		CavalierArcher,
		
		Milicien,
		
		Chevalier,
		
		Magicien,
		Healer,
		
		Catapulte,
		
		Galere,
		Transporteur;
	}
	//*************** Variable *******************
	private int production;
	protected ArrayList<typeUnite> typesUnits = new ArrayList<typeUnite>();
	
	//*************** Constructeur *******************
	public BatProdUnit(String name, int p, int a, int d, int c, boolean ioe, Vector V, int prod)
	{
		super(name, p, a, d, c, ioe, V);
		this.production = prod;
	}
	
	//*************** Accesseurs *******************
	public int getPRODUCTION()
	{
		return this.production;
	}
	
	public ArrayList<typeUnite> getTYPESUNITS()
	{
		return this.typesUnits;
	}
	
	//*************** Accesseurs *******************
	public void setPRODUCTION(int prod)
	{
		this.production = prod;
	}
}
