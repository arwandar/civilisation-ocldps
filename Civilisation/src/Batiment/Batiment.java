package Batiment;
import java.util.ArrayList;
import java.util.Vector;

import Batiment.BatProdUnit.typeUnite;
import civ.Texture;

public abstract class Batiment
{
	//*************** Variables *******************
	protected String nom;
	protected int pv;
	protected int def;
	protected int att;
	protected int coeffDefBonus;
	protected int production;
	protected boolean isOnEarth;
	protected Vector position;
	
	//*************** Constructeur *******************
	public Batiment(String name, int p, int a, int d, int c, boolean ioe, Vector V, int prod) //le vecteur position sera à remplacer par une case
	{
		/*if( ioe && Case.texture != Texture.eau && Case.texture != Texture.montagne ) //Si le bâtiment est constructible sur terre et que la case n'est pas de l'eau ni de la montagne
		{*/
			this.setNOM(name);
			this.setPV(p);
			this.setATT(a);
			this.setDEF(d);
			this.setCOEFF(c);
			this.setIsOnEarth(ioe);
			this.production = prod;
			this.setPOSITION(V);
		/*}
		else if( !ioe && Case.texture == Texture.eau ) //Si le bâtiment est constructible sur l'eau et que la case est maritime
		{
			this.setNOM(name);
			this.setPV(p);
			this.setATT(a);
			this.setDEF(d);
			this.setCOEFF(c);
			this.setIsOnEarth(ioe);
			this.setPOSITION(V);
		}
		else
		{
			System.out.println("Wrong place to build it!!");
		}*/
	}
	
	//*************** Accesseurs *******************
	public String getNOM()
	{
		return this.nom;
	}
	
	public int getPV()
	{
		return this.pv;
	}
	
	public int getDEF()
	{
		return this.def;
	}
	
	public int getATT()
	{
		return this.att;
	}
	
	public int getCOEFF()
	{
		return this.coeffDefBonus;
	}
	
	public int getPRODUCTION()
	{
		return this.production;
	}
		
	public boolean getIsOnEarth()
	{
		return this.isOnEarth;
	}
	
	public Vector getPOSITION()
	{
		return this.position;
	}
	
	//*************** Mutateurs *******************
	public void setNOM(String n)
	{
		this.nom = n;
	}
	
	public void setPV(int p)
	{
		this.pv = p;
	}
	
	public void setDEF(int d)
	{
		this.def = d;
	}
	
	public void setATT(int a)
	{
		this.att = a;
	}
	
	public void setCOEFF(int c)
	{
		this.coeffDefBonus = c;
	}
	
	public void setIsOnEarth(boolean ioe)
	{
		this.isOnEarth = ioe;
	}
	
	public void setPRODUCTION(int prod)
	{
		this.production = prod;
	}

	
	public void setPOSITION(Vector P)
	{
		this.position = P;
	}
}










