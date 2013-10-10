package joueur;

import java.util.ArrayList;

import Batiment.BatHotelDeVille;
import Batiment.Batiment;
import Unites.Personnage;

public class Joueur {
	private String nom;
	private int or, nourriture, bois, pierre, fer, os;
	private ArrayList<Batiment> batiments;
	private ArrayList<Personnage> personnages;
	
	//*******Constructeur
	
	public Joueur(){
		this.nom = "inconnu";
		this.or = 100;
		this.nourriture = 100;
		this.bois = 100;
		this.pierre = 100;
		this.fer = 100;
		this.os = 0;
		this.personnages = new ArrayList<Personnage>();
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

	public String getNom() {
		return nom;
	}

	public BatHotelDeVille getSonHotelDeVille() {
		return sonHotelDeVille;
	}

	BatHotelDeVille sonHotelDeVille;
	

	
	
}
