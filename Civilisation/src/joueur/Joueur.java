package joueur;

import Batiment.BatHotelDeVille;

public class Joueur {
	private String nom;
	private int or, nourriture, bois;
	
	//*******Constructeur
	
	public Joueur(){
		this.nom = "inconnu";
		this.or = 100;
		this.nourriture = 100;
		this.bois = 100;
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

	public String getNom() {
		return nom;
	}

	public BatHotelDeVille getSonHotelDeVille() {
		return sonHotelDeVille;
	}

	BatHotelDeVille sonHotelDeVille;
	

	
	
}
