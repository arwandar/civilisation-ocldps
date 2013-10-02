package Batiment;
import java.util.Vector;

public class BatProdRes extends Batiment
{
	public enum typeRessource
	{
		or,
		fer,
		bois,
		nourriture;
	}
	
	//*************** Variables *******************
	private typeRessource typeres;
	
	//*************** Constructeur *******************
	public BatProdRes(String name, int p, int a, int d, int c,Vector V, typeRessource t)
	{	
		super(name, p, a, d, c, true, V);
		this.setRESSOURCE(t);
	}
	
	//*************** Accesseurs *******************
	public typeRessource getRESSOURCE()
	{
		return this.typeres;
	}
	
	//*************** Accesseurs *******************
	public void setRESSOURCE(typeRessource t)
	{
		this.typeres = t;
	}
}
