package joueur;

import java.awt.Color;
import java.util.ArrayList;

import Batiment.BatHotelDeVille;
import Batiment.Batiment;
import Unites.Personnage;

public class Joueur {
	private String nom;
	private int or, nourriture, bois, pierre, fer, os;
	private ArrayList<Batiment> batiments;
	private ArrayList<Personnage> personnages;
	private Color saCouleur;
	
	//*******Constructeur
	
	public Joueur(Color couleur){
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
}
