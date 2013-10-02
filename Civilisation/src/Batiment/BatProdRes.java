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
	public BatProdRes(String name,Vector V, typeRessource t)
	{	
		super(name, 50, 0, 20, 0, true, V, 1);
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
