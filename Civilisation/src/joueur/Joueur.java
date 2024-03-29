package joueur;

import java.awt.Color;
import java.util.ArrayList;

import civ.Case;
import Batiment.BatArcherie;
import Batiment.BatAtelierDeSiege;
import Batiment.BatCaserne;
import Batiment.BatEcurie;
import Batiment.BatHotelDeVille;
import Batiment.BatMur;
import Batiment.BatPort;
import Batiment.BatProdRes;
import Batiment.BatProdRes.typeRessource;
import Batiment.BatTourDesMages;
import Batiment.BatTourelle;
import Batiment.Batiment;
import Evenements.Fonctions;
import Unites.Archer;
import Unites.Catapulte;
import Unites.CavalierArcher;
import Unites.Chevalier;
import Unites.Galere;
import Unites.Healer;
import Unites.Magicien;
import Unites.Milicien;
import Unites.Peon;
import Unites.Personnage;
import Unites.SuperMouton;
import Unites.Transporteur;

public class Joueur {
	private String nom;
	private int or, nourriture, bois, pierre, fer, os;
	private ArrayList<Batiment> batiments;
	private ArrayList<Personnage> personnages;
	private Color saCouleur;
	private Joueur[] lesJoueur;

	//*******Constructeur

	public Joueur(Color couleur, Joueur[] lesJoueur, String name){
		this.lesJoueur = lesJoueur;
		this.nom = name;
		this.or = 300*2;
		this.nourriture = 300*2;
		this.bois = 400*2;
		this.pierre = 300*2;
		this.fer = 250*2;
		this.os = 0;
		this.batiments = new ArrayList<Batiment>();
		this.personnages = new ArrayList<Personnage>();
		this.saCouleur = couleur;
	}
	//******Mutateur
	public int getOr() {
		return or;
	}

	public void setOr(int or) {
		this.or = or;
	}

	public int getNourriture() {
		return nourriture;
	}

	public void setNourriture(int nourriture) {
		this.nourriture = nourriture;
	}

	public int getBois() {
		return bois;
	}

	public void setBois(int bois) {
		this.bois = bois;
	}

	public int getPierre() {
		return pierre;
	}

	public void setPierre(int pierre) {
		this.pierre = pierre;
	}

	public int getFer() {
		return fer;
	}

	public void setFer(int fer) {
		this.fer = fer;
	}

	public int getOs() {
		return os;
	}

	public void setOs(int os) {
		this.os = os;
	}

	public ArrayList<Batiment> getBatiments() {
		return this.batiments;
	}

	public void setBatiments(ArrayList<Batiment> b) {
		this.batiments = b;
	}

	public ArrayList<Personnage> getPersonnages() {
		return this.personnages;
	}

	public void setPersonnages(ArrayList<Personnage> p) {
		this.personnages = p;
	}

	public Color getSaCouleur() {
		return saCouleur;
	}
	public String getNom() {
		return nom;
	}

	public BatHotelDeVille getSonHotelDeVille() {
		return sonHotelDeVille;
	}

	BatHotelDeVille sonHotelDeVille;

	//*************** Méthodes *******************
	public boolean CanPlayerProduce()
	{
		boolean cpp = true;

		/*
		 // si les os représentent 75% des ressources du joueur, il ne peut plus produire
		 if((this.os/(this.or + this.nourriture + this.bois + this.pierre + this.fer + this.os)) >= 0.75)
		{
			cpp = false;
			//le joueur peut utiliser tous ses os pour lancer le truc un peu cheat
		}*/

		return cpp;
	}

	public static boolean isPeonUsed (Joueur J, int V[])
	{
		ArrayList<Personnage> PersonnagePossible = J.getPersonnages();
		for (Personnage celuiLa : PersonnagePossible)
		{ 
			if (celuiLa.getNOM() == "Peon" && celuiLa.getPositionHorizontale()==V[0] && celuiLa.getPositionVerticale()==V[1] && celuiLa.isUsed()==false)
			{
				return false;
			}
		}
		return true;
	}

	public boolean isHotelDeVilleConstructed(int V[], Case M)
	{
		if(this.getBois()>=300 && this.getOr()>=200 && this.getFer()>=150 && this.getPierre()>=200 && Joueur.isPeonUsed(this, V)==false)
		{
			for (int i=this.personnages.size()-1; i>=0; i--)
			{
				if (this.personnages.get(i).getNOM() == "Peon")
				{
					if (this.personnages.get(i).getPositionHorizontale() == V[0] && this.personnages.get(i).getPositionVerticale() == V[1])
					{
						this.personnages.get(i).destructionUnite(this);
					}
				}
			}
			
			new BatHotelDeVille(V, M, this);
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean isArcherieConstructed(int V[], Case M)
	{
		if(this.getBois()>=100 && this.getOr()>=50 && this.getFer()>=50 && this.getPierre()>=150 && Joueur.isPeonUsed(this, V)==false)
		{
			for (int i=this.personnages.size()-1; i>=0; i--)
			{
				if (this.personnages.get(i).getNOM() == "Peon")
				{
					if (this.personnages.get(i).getPositionHorizontale() == V[0] && this.personnages.get(i).getPositionVerticale() == V[1])
					{
						this.personnages.get(i).destructionUnite(this);
					}
				}
			}
			
			new BatArcherie(V, M, this);
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean isAtelierDeSiegeConstructed(int V[], Case M)
	{
		if(this.getBois()>=300 && this.getOr()>=200 && this.getFer()>=150 && this.getPierre()>=450 && Joueur.isPeonUsed(this, V)==false)
		{
			for (int i=this.personnages.size()-1; i>=0; i--)
			{
				if (this.personnages.get(i).getNOM() == "Peon")
				{
					if (this.personnages.get(i).getPositionHorizontale() == V[0] && this.personnages.get(i).getPositionVerticale() == V[1])
					{
						this.personnages.get(i).destructionUnite(this);
					}
				}
			}
			
			new BatAtelierDeSiege(V, M, this);
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean isCaserneConstructed(int V[], Case M)
	{
		if(this.getBois()>=75 && this.getOr()>=50 && this.getFer()>=35 && this.getPierre()>=110 && Joueur.isPeonUsed(this, V)==false)
		{
			for (int i=this.personnages.size()-1; i>=0; i--)
			{
				if (this.personnages.get(i).getNOM() == "Peon")
				{
					if (this.personnages.get(i).getPositionHorizontale() == V[0] && this.personnages.get(i).getPositionVerticale() == V[1])
					{
						this.personnages.get(i).destructionUnite(this);
					}
				}
			}
			
			new BatCaserne(V, M, this);
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean isEcurieConstructed(int V[], Case M)
	{
		if(this.getBois()>=200 && this.getOr()>=150 && this.getFer()>=100 && this.getPierre()>=300 && Joueur.isPeonUsed(this, V)==false)
		{
			for (int i=this.personnages.size()-1; i>=0; i--)
			{
				if (this.personnages.get(i).getNOM() == "Peon")
				{
					if (this.personnages.get(i).getPositionHorizontale() == V[0] && this.personnages.get(i).getPositionVerticale() == V[1])
					{
						this.personnages.get(i).destructionUnite(this);
					}
				}
			}
			
			new BatEcurie(V, M, this);
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean isMurConstructed(int V[], Case M)	
	{
		if(this.getBois()>=30 && this.getOr()>=10 && this.getFer()>=5 && this.getPierre()>=50 && Joueur.isPeonUsed(this, V)==false)
		{			
			for (int i=this.personnages.size()-1; i>=0; i--)
			{
				if (this.personnages.get(i).getNOM() == "Peon")
				{
					if (this.personnages.get(i).getPositionHorizontale() == V[0] && this.personnages.get(i).getPositionVerticale() == V[1])
					{
						this.personnages.get(i).destructionUnite(this);
					}
				}
			}
			
			new BatMur(V, M, this);
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean isPortConstructed(int V[], Case M)
	{
		if(this.getBois()>=300 && this.getOr()>=75 && this.getFer()>=50 && this.getPierre()>=100 && Joueur.isPeonUsed(this, V)==false)
		{
			for (int i=this.personnages.size()-1; i>=0; i--)
			{
				if (this.personnages.get(i).getNOM() == "Peon")
				{
					if (this.personnages.get(i).getPositionHorizontale() == V[0] && this.personnages.get(i).getPositionVerticale() == V[1])
					{
						this.personnages.get(i).destructionUnite(this);
					}
				}
			}
			
			new BatPort(V, M, this);
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean isMineOrConstructed(int V[], Case M)
	{
		if(this.getBois()>=10 && this.getOr()>=20 && this.getFer()>=5 && this.getPierre()>=30 && Joueur.isPeonUsed(this, V)==false)
		{
			for (int i=this.personnages.size()-1; i>=0; i--)
			{
				if (this.personnages.get(i).getNOM() == "Peon")
				{
					if (this.personnages.get(i).getPositionHorizontale() == V[0] && this.personnages.get(i).getPositionVerticale() == V[1])
					{
						this.personnages.get(i).destructionUnite(this);
					}
				}
			}
			
			new BatProdRes(V, typeRessource.or, M, this);
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean isMineFerConstructed(int V[], Case M)
	{
		if(this.getBois()>=10 && this.getOr()>=20 && this.getFer()>=5 && this.getPierre()>=30 && Joueur.isPeonUsed(this, V)==false)
		{
			for (int i=this.personnages.size()-1; i>=0; i--)
			{
				if (this.personnages.get(i).getNOM() == "Peon")
				{
					if (this.personnages.get(i).getPositionHorizontale() == V[0] && this.personnages.get(i).getPositionVerticale() == V[1])
					{
						this.personnages.get(i).destructionUnite(this);
					}
				}
			}
			
			new BatProdRes(V, typeRessource.fer, M, this);
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean isMinePierreConstructed(int V[], Case M)
	{
		if(this.getBois()>=10 && this.getOr()>=20 && this.getFer()>=5 && this.getPierre()>=30 && Joueur.isPeonUsed(this, V)==false)
		{
			for (int i=this.personnages.size()-1; i>=0; i--)
			{
				if (this.personnages.get(i).getNOM() == "Peon")
				{
					if (this.personnages.get(i).getPositionHorizontale() == V[0] && this.personnages.get(i).getPositionVerticale() == V[1])
					{
						this.personnages.get(i).destructionUnite(this);
					}
				}
			}
			
			new BatProdRes(V, typeRessource.pierre, M, this);
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean isMineBoisConstructed(int V[], Case M)
	{
		if(this.getBois()>=10 && this.getOr()>=20 && this.getFer()>=5 && this.getPierre()>=30 && Joueur.isPeonUsed(this, V)==false)
		{
			for (int i=this.personnages.size()-1; i>=0; i--)
			{
				if (this.personnages.get(i).getNOM() == "Peon")
				{
					if (this.personnages.get(i).getPositionHorizontale() == V[0] && this.personnages.get(i).getPositionVerticale() == V[1])
					{
						this.personnages.get(i).destructionUnite(this);
					}
				}
			}
			
			new BatProdRes(V, typeRessource.bois, M, this);
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean isMineNourritureConstructed(int V[], Case M)
	{
		if(this.getBois()>=10 && this.getOr()>=20 && this.getFer()>=5 && this.getPierre()>=30 && Joueur.isPeonUsed(this, V)==false)
		{
			for (int i=this.personnages.size()-1; i>=0; i--)
			{
				if (this.personnages.get(i).getNOM() == "Peon")
				{
					if (this.personnages.get(i).getPositionHorizontale() == V[0] && this.personnages.get(i).getPositionVerticale() == V[1])
					{
						this.personnages.get(i).destructionUnite(this);
					}
				}
			}
			
			new BatProdRes(V, typeRessource.nourriture, M, this);
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean isTourDesMagesConstructed(int V[], Case M)
	{
		if(this.getBois()>=150 && this.getOr()>=75 && this.getFer()>=50 && this.getPierre()>=150 && Joueur.isPeonUsed(this, V)==false)
		{
			for (int i=this.personnages.size()-1; i>=0; i--)
			{
				if (this.personnages.get(i).getNOM() == "Peon")
				{
					if (this.personnages.get(i).getPositionHorizontale() == V[0] && this.personnages.get(i).getPositionVerticale() == V[1])
					{
						this.personnages.get(i).destructionUnite(this);
					}
				}
			}
			
			new BatTourDesMages(V, M, this);
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean isTourelleConstructed(int V[], Case M)
	{
		if(this.getBois()>=300 && this.getOr()>=100 && this.getFer()>=50 && this.getPierre()>=500 && Joueur.isPeonUsed(this, V)==false)
		{
			for (int i=this.personnages.size()-1; i>=0; i--)
			{
				if (this.personnages.get(i).getNOM() == "Peon")
				{
					if (this.personnages.get(i).getPositionHorizontale() == V[0] && this.personnages.get(i).getPositionVerticale() == V[1])
					{
						this.personnages.get(i).destructionUnite(this);
					}
				}
			}
			
			new BatTourelle(V, M, this);
			return true;
		}
		else
		{
			return false;
		}
	}

	private boolean caseOccupee (int i, int j){
		int[] V = {i,j};
		for (Joueur ceJoueur : this.lesJoueur) {
			ArrayList<Batiment> batimentPossible = ceJoueur.getBatiments();
			for (Batiment celuiLa : batimentPossible) {
				if (celuiLa.getPOSITION(0) == V[0] && celuiLa.getPOSITION(1) == V[1]) {
					return true;
				}
			}
			ArrayList<Personnage> personnagePossible = ceJoueur.getPersonnages();
			for (Personnage celuici : personnagePossible){
				if (celuici.getPositionHorizontale() == V[0] && celuici.getPositionVerticale()==V[1]){
					return true;
				}
			}
		}
		return false;

	}

	public boolean isArcherCreated(int v[])
	{
		if(this.getOr()>=45 && this.getBois()>=25)
		{
			int i = v[0];
			int j = v[1];
			int nbrCaseHauteur = 30;
			int nbrCaseLarge = 60;
			
			if (!caseOccupee(i-1, j-1) && (i-1)>=0 && (j-1)>0)
			{
				this.getPersonnages().add(new Archer(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if(!caseOccupee(i-1, j) && (i-1)>=0)
			{
				this.getPersonnages().add(new Archer(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j);
				return true;
			}
			else if (!caseOccupee(i-1, j+1) && (i-1)>=0 && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new Archer(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
			else if (!caseOccupee(i, j-1) && (j-1)>=0)
			{
				this.getPersonnages().add(new Archer(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if (!caseOccupee(i+1, j-1) && (i+1)<=nbrCaseLarge && (j-1)>=0)
			{
				this.getPersonnages().add(new Archer(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if (!caseOccupee(i+1, j) && (i+1)<=nbrCaseLarge)
			{
				this.getPersonnages().add(new Archer(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j);
				return true;
			}
			else if (!caseOccupee(i+1, j+1) && (i+1)<=nbrCaseLarge && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new Archer(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
			else if (!caseOccupee(i, j+1) && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new Archer(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
		}
		return false;
	}
	
	public boolean isPeonCreated(int v[])
	{
		if(this.getNourriture()>=50)
		{
			int i = v[0];
			int j = v[1];
			int nbrCaseHauteur = 30;
			int nbrCaseLarge = 60;
			
			if (!caseOccupee(i-1, j-1) && (i-1)>=0 && (j-1)>0)
			{
				this.getPersonnages().add(new Peon(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if(!caseOccupee(i-1, j) && (i-1)>=0)
			{
				this.getPersonnages().add(new Peon(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j);
				return true;
			}
			else if (!caseOccupee(i-1, j+1) && (i-1)>=0 && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new Peon(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
			else if (!caseOccupee(i, j-1) && (j-1)>=0)
			{
				this.getPersonnages().add(new Peon(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if (!caseOccupee(i+1, j-1) && (i+1)<=nbrCaseLarge && (j-1)>=0)
			{
				this.getPersonnages().add(new Peon(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if (!caseOccupee(i+1, j) && (i+1)<=nbrCaseLarge)
			{
				this.getPersonnages().add(new Peon(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j);
				return true;
			}
			else if (!caseOccupee(i+1, j+1) && (i+1)<=nbrCaseLarge && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new Peon(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
			else if (!caseOccupee(i, j+1) && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new Peon(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
		}
		return false;
	}
	
	public boolean isCatapulteCreated(int v[])
	{
		if(this.getOr()>=135 && this.getBois()>=160)
		{
			int i = v[0];
			int j = v[1];
			int nbrCaseHauteur = 30;
			int nbrCaseLarge = 60;
			
			if (!caseOccupee(i-1, j-1) && (i-1)>=0 && (j-1)>0)
			{
				this.getPersonnages().add(new Catapulte(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if(!caseOccupee(i-1, j) && (i-1)>=0)
			{
				this.getPersonnages().add(new Catapulte(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j);
				return true;
			}
			else if (!caseOccupee(i-1, j+1) && (i-1)>=0 && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new Catapulte(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
			else if (!caseOccupee(i, j-1) && (j-1)>=0)
			{
				this.getPersonnages().add(new Catapulte(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if (!caseOccupee(i+1, j-1) && (i+1)<=nbrCaseLarge && (j-1)>=0)
			{
				this.getPersonnages().add(new Catapulte(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if (!caseOccupee(i+1, j) && (i+1)<=nbrCaseLarge)
			{
				this.getPersonnages().add(new Catapulte(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j);
				return true;
			}
			else if (!caseOccupee(i+1, j+1) && (i+1)<=nbrCaseLarge && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new Catapulte(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
			else if (!caseOccupee(i, j+1) && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new Catapulte(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
		}
		return false;
	}
	
	public boolean isCavalierArcherCreated(int v[])
	{
		if(this.getOr()>=70 && this.getBois()>=40)
		{
			int i = v[0];
			int j = v[1];
			int nbrCaseHauteur = 30;
			int nbrCaseLarge = 60;
			
			if (!caseOccupee(i-1, j-1) && (i-1)>=0 && (j-1)>0)
			{
				this.getPersonnages().add(new CavalierArcher(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if(!caseOccupee(i-1, j) && (i-1)>=0)
			{
				this.getPersonnages().add(new CavalierArcher(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j);
				return true;
			}
			else if (!caseOccupee(i-1, j+1) && (i-1)>=0 && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new CavalierArcher(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
			else if (!caseOccupee(i, j-1) && (j-1)>=0)
			{
				this.getPersonnages().add(new CavalierArcher(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if (!caseOccupee(i+1, j-1) && (i+1)<=nbrCaseLarge && (j-1)>=0)
			{
				this.getPersonnages().add(new CavalierArcher(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if (!caseOccupee(i+1, j) && (i+1)<=nbrCaseLarge)
			{
				this.getPersonnages().add(new CavalierArcher(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j);
				return true;
			}
			else if (!caseOccupee(i+1, j+1) && (i+1)<=nbrCaseLarge && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new CavalierArcher(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
			else if (!caseOccupee(i, j+1) && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new CavalierArcher(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
		}
		return false;
	}
	
	public boolean isChevalierCreated(int v[])
	{
		if(this.getNourriture()>=60 && this.getBois()>=50)
		{
			int i = v[0];
			int j = v[1];
			int nbrCaseHauteur = 30;
			int nbrCaseLarge = 60;
			
			if (!caseOccupee(i-1, j-1) && (i-1)>=0 && (j-1)>0)
			{
				this.getPersonnages().add(new Chevalier(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if(!caseOccupee(i-1, j) && (i-1)>=0)
			{
				this.getPersonnages().add(new Chevalier(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j);
				return true;
			}
			else if (!caseOccupee(i-1, j+1) && (i-1)>=0 && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new Chevalier(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
			else if (!caseOccupee(i, j-1) && (j-1)>=0)
			{
				this.getPersonnages().add(new Chevalier(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if (!caseOccupee(i+1, j-1) && (i+1)<=nbrCaseLarge && (j-1)>=0)
			{
				this.getPersonnages().add(new Chevalier(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if (!caseOccupee(i+1, j) && (i+1)<=nbrCaseLarge)
			{
				this.getPersonnages().add(new Chevalier(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j);
				return true;
			}
			else if (!caseOccupee(i+1, j+1) && (i+1)<=nbrCaseLarge && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new Chevalier(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
			else if (!caseOccupee(i, j+1) && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new Chevalier(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
		}
		return false;
	}
	
	public boolean isGalereCreated(int v[])
	{
		if(this.getOr()>=30 && this.getBois()>=90)
		{
			int i = v[0];
			int j = v[1];
			int nbrCaseHauteur = 30;
			int nbrCaseLarge = 60;
			
			if (!caseOccupee(i-1, j-1) && (i-1)>=0 && (j-1)>0)
			{
				this.getPersonnages().add(new Galere(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if(!caseOccupee(i-1, j) && (i-1)>=0)
			{
				this.getPersonnages().add(new Galere(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j);
				return true;
			}
			else if (!caseOccupee(i-1, j+1) && (i-1)>=0 && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new Galere(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
			else if (!caseOccupee(i, j-1) && (j-1)>=0)
			{
				this.getPersonnages().add(new Galere(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if (!caseOccupee(i+1, j-1) && (i+1)<=nbrCaseLarge && (j-1)>=0)
			{
				this.getPersonnages().add(new Galere(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if (!caseOccupee(i+1, j) && (i+1)<=nbrCaseLarge)
			{
				this.getPersonnages().add(new Galere(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j);
				return true;
			}
			else if (!caseOccupee(i+1, j+1) && (i+1)<=nbrCaseLarge && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new Galere(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
			else if (!caseOccupee(i, j+1) && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new Galere(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
		}
		return false;
	}
	
	public boolean isHealerCreated(int v[])
	{
		if(this.getOr()>=50 && this.getNourriture()>=40)
		{
			int i = v[0];
			int j = v[1];
			int nbrCaseHauteur = 30;
			int nbrCaseLarge = 60;
			
			if (!caseOccupee(i-1, j-1) && (i-1)>=0 && (j-1)>0)
			{
				this.getPersonnages().add(new Healer(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if(!caseOccupee(i-1, j) && (i-1)>=0)
			{
				this.getPersonnages().add(new Healer(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j);
				return true;
			}
			else if (!caseOccupee(i-1, j+1) && (i-1)>=0 && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new Healer(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
			else if (!caseOccupee(i, j-1) && (j-1)>=0)
			{
				this.getPersonnages().add(new Healer(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if (!caseOccupee(i+1, j-1) && (i+1)<=nbrCaseLarge && (j-1)>=0)
			{
				this.getPersonnages().add(new Healer(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if (!caseOccupee(i+1, j) && (i+1)<=nbrCaseLarge)
			{
				this.getPersonnages().add(new Healer(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j);
				return true;
			}
			else if (!caseOccupee(i+1, j+1) && (i+1)<=nbrCaseLarge && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new Healer(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
			else if (!caseOccupee(i, j+1) && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new Healer(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
		}
		return false;
	}
	
	public boolean isMagicirnrCreated(int v[])
	{
		if(this.getOr()>=40 && this.getNourriture()>=50)
		{
			int i = v[0];
			int j = v[1];
			int nbrCaseHauteur = 30;
			int nbrCaseLarge = 60;
			
			if (!caseOccupee(i-1, j-1) && (i-1)>=0 && (j-1)>0)
			{
				this.getPersonnages().add(new Magicien(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if(!caseOccupee(i-1, j) && (i-1)>=0)
			{
				this.getPersonnages().add(new Magicien(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j);
				return true;
			}
			else if (!caseOccupee(i-1, j+1) && (i-1)>=0 && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new Magicien(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
			else if (!caseOccupee(i, j-1) && (j-1)>=0)
			{
				this.getPersonnages().add(new Magicien(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if (!caseOccupee(i+1, j-1) && (i+1)<=nbrCaseLarge && (j-1)>=0)
			{
				this.getPersonnages().add(new Magicien(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if (!caseOccupee(i+1, j) && (i+1)<=nbrCaseLarge)
			{
				this.getPersonnages().add(new Magicien(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j);
				return true;
			}
			else if (!caseOccupee(i+1, j+1) && (i+1)<=nbrCaseLarge && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new Magicien(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
			else if (!caseOccupee(i, j+1) && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new Magicien(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
		}
		return false;
	}
	
	public boolean isMilicienCreated(int v[])
	{
		if(this.getOr()>=20 && this.getNourriture()>=60)
		{
			int i = v[0];
			int j = v[1];
			int nbrCaseHauteur = 30;
			int nbrCaseLarge = 60;
			
			if (!caseOccupee(i-1, j-1) && (i-1)>=0 && (j-1)>0)
			{
				this.getPersonnages().add(new Milicien(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if(!caseOccupee(i-1, j) && (i-1)>=0)
			{
				this.getPersonnages().add(new Milicien(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j);
				return true;
			}
			else if (!caseOccupee(i-1, j+1) && (i-1)>=0 && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new Milicien(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
			else if (!caseOccupee(i, j-1) && (j-1)>=0)
			{
				this.getPersonnages().add(new Milicien(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if (!caseOccupee(i+1, j-1) && (i+1)<=nbrCaseLarge && (j-1)>=0)
			{
				this.getPersonnages().add(new Milicien(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if (!caseOccupee(i+1, j) && (i+1)<=nbrCaseLarge)
			{
				this.getPersonnages().add(new Milicien(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j);
				return true;
			}
			else if (!caseOccupee(i+1, j+1) && (i+1)<=nbrCaseLarge && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new Milicien(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
			else if (!caseOccupee(i, j+1) && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new Milicien(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
		}
		return false;
	}
	
	public boolean isTransporteurCreated(int v[])
	{
		if(this.getBois()>=125)
		{
			int i = v[0];
			int j = v[1];
			int nbrCaseHauteur = 30;
			int nbrCaseLarge = 60;
			
			if (!caseOccupee(i-1, j-1) && (i-1)>=0 && (j-1)>0)
			{
				this.getPersonnages().add(new Transporteur(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if(!caseOccupee(i-1, j) && (i-1)>=0)
			{
				this.getPersonnages().add(new Transporteur(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j);
				return true;
			}
			else if (!caseOccupee(i-1, j+1) && (i-1)>=0 && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new Transporteur(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
			else if (!caseOccupee(i, j-1) && (j-1)>=0)
			{
				this.getPersonnages().add(new Transporteur(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if (!caseOccupee(i+1, j-1) && (i+1)<=nbrCaseLarge && (j-1)>=0)
			{
				this.getPersonnages().add(new Transporteur(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if (!caseOccupee(i+1, j) && (i+1)<=nbrCaseLarge)
			{
				this.getPersonnages().add(new Transporteur(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j);
				return true;
			}
			else if (!caseOccupee(i+1, j+1) && (i+1)<=nbrCaseLarge && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new Transporteur(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
			else if (!caseOccupee(i, j+1) && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new Transporteur(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
		}
		return false;
	}
	
	public boolean IsSuperMoutonCreated(int v[])
	{
		if(this.getNourriture()>=10)
		{
			int i = v[0];
			int j = v[1];
			int nbrCaseHauteur = 30;
			int nbrCaseLarge = 60;
			
			if (!caseOccupee(i-1, j-1) && (i-1)>=0 && (j-1)>0)
			{
				this.getPersonnages().add(new SuperMouton(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if(!caseOccupee(i-1, j) && (i-1)>=0)
			{
				this.getPersonnages().add(new SuperMouton(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j);
				return true;
			}
			else if (!caseOccupee(i-1, j+1) && (i-1)>=0 && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new SuperMouton(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i-1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
			else if (!caseOccupee(i, j-1) && (j-1)>=0)
			{
				this.getPersonnages().add(new SuperMouton(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if (!caseOccupee(i+1, j-1) && (i+1)<=nbrCaseLarge && (j-1)>=0)
			{
				this.getPersonnages().add(new SuperMouton(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j-1);
				return true;
			}
			else if (!caseOccupee(i+1, j) && (i+1)<=nbrCaseLarge)
			{
				this.getPersonnages().add(new SuperMouton(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j);
				return true;
			}
			else if (!caseOccupee(i+1, j+1) && (i+1)<=nbrCaseLarge && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new SuperMouton(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i+1);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
			else if (!caseOccupee(i, j+1) && (j+1)<=nbrCaseHauteur)
			{
				this.getPersonnages().add(new SuperMouton(this));
				Fonctions.Creation(this.getPersonnages().get(this.getPersonnages().size()-1));
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionHorizontale(i);
				this.getPersonnages().get(this.getPersonnages().size()-1).setPositionVerticale(j+1);
				return true;
			}
		}
		return false;
	}
}
