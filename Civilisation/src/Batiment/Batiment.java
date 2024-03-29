package Batiment;

import joueur.Joueur;
import civ.Case;
import civ.Texture;

public abstract class Batiment
{
	//*************** Variables *******************
	protected String nom;
	protected int pv;
	protected double def;
	protected int att;
	protected int coeffDefBonus;
	protected int production;
	protected boolean isOnEarth;
	protected int[] position = {0,0};
 protected int coutOr;
protected int coutFer;
protected int coutPierre;
	protected int coutBois;
	protected Joueur joueur;
	protected boolean isConstructible = true;
	protected int portee;
	protected boolean isUsed = false;
	
	//*************** Constructeur *******************
	public Batiment(String name, int p, int a, double d, int c, boolean ioe, int V[], int prod, Case M) //le vecteur position sera � remplacer par une case
	{
		this.isConstructible = true;
			
		if(ioe && M.getTexture() != Texture.eau && M.getTexture() != Texture.montagne) //Si le b�timent est constructible sur terre et que la case n'est pas de l'eau ni de la montagne
		{
			int[] tmp = {V[0], V[1]};
			this.setNOM(name);
			this.setPV(p);
			this.setATT(a);
			this.setDEF(d);
			this.setCOEFF(c);
			this.setIsOnEarth(ioe);
			this.production = prod;
			this.position = tmp;
			M.setBatimentsurcase(true);//remplacer par occuper case
		}
		else if( !ioe && M.getTexture() == Texture.eau ) //Si le b�timent est constructible sur l'eau et que la case est maritime
		{
			this.setNOM(name);
			this.setPV(p);
			this.setATT(a);
			this.setDEF(d);
			this.setCOEFF(c);
			this.setIsOnEarth(ioe);
			this.production = prod;
			this.setPOSITION(V);
			M.setBatimentsurcase(true);
		}
		else
		{
			System.out.println("Wrong place to build it!!");
			this.isConstructible = false;
		}
	}
	
	//*************** Accesseurs *******************
	public String getNOM()
	{
		return this.nom;
	}
	
	public Joueur getJoueur()
	{
		return this.joueur;
	}
	
	public int getPV()
	{
		return this.pv;
	}
	
	public int getPortee()
	{
		return this.portee;
	}
	
	public boolean getIsUsed()
	{
		return this.isUsed;
	}
	
	public double getDEF()
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
	
	public int[] getPOSITION()
	{
		return this.position;
	}
	
	public int getPOSITION(int i)
	{
		return this.position[i];
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
	
	public void setPortee(int por)
	{
		this.portee = por;
	}
	
	public void setIsUsed(boolean IU)
	{
		this.isUsed = IU;
	}
	
	public void setDEF(double d)
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

	
	public void setPOSITION(int P[])
	{
		this.position = P;
	}
	
	public void setPOSITION(int P, int i)
	{
		this.position[i] = P;
	}
	
	//*************** M�thodes *******************
	public void destructionBatiment()
	{
		
	}

	public void destructionBatiment(Case M, Joueur J)
	{
		
	}
	

}










