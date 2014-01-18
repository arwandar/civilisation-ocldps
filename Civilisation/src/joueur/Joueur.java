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
import Unites.Peon;
import Unites.Personnage;

public class Joueur {
	private String nom;
	private int or, nourriture, bois, pierre, fer, os;
	private ArrayList<Batiment> batiments;
	private ArrayList<Personnage> personnages;
	private Color saCouleur;
	private Joueur[] lesJoueur;

	//*******Constructeur

	public Joueur(Color couleur, Joueur[] lesJoueur){
		this.lesJoueur = lesJoueur;
		this.nom = "inconnu";
		this.or = 500;
		this.nourriture = 100;
		this.bois = 400;
		this.pierre = 300;
		this.fer = 250;
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
			
			int i = 0;
			for (Personnage celuici : this.personnages){
				System.out.println(i+" "+celuici.getNOM() + "/"+celuici.getPositionHorizontale()+"/"+celuici.getPositionVerticale());
				i++;
			}
			
			System.out.println("Miaw"+ this.personnages.size());
			//for (Personnage celuici : this.personnages){
			for (i=this.personnages.size()-1; i>=0; i--){
				if (this.personnages.get(i).getNOM() == "Peon"){
					if (this.personnages.get(i).getPositionHorizontale() == V[0] && this.personnages.get(i).getPositionVerticale() == V[1]){
						this.personnages.get(i).destructionUnite(M, this);

					}
				}
			}
			i=0;
			for (Personnage celuici : this.personnages){
				System.out.println(i+" "+celuici.getNOM() + "/"+celuici.getPositionHorizontale()+"/"+celuici.getPositionVerticale());
				i++;
			}
			new BatMur(V, M, this);
			for (Batiment celuila : this.batiments){
				System.out.println(celuila.getNOM());
			}
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
			new BatProdRes("mine", V, typeRessource.or, M, this);
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
			new BatProdRes("mine", V, typeRessource.fer, M, this);
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
			new BatProdRes("mine", V, typeRessource.pierre, M, this);
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
			new BatProdRes("mine", V, typeRessource.bois, M, this);
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
			new BatProdRes("mine", V, typeRessource.nourriture, M, this);
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
		if(this.getBois()>=150 && this.getOr()>=75 && this.getFer()>=50 && this.getPierre()>=150)
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
}
