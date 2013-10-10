package civ;

import java.awt.Color;

import javax.swing.JButton;

public class Case extends JButton {
	Texture texture;
	boolean batimentsurcase;
	boolean unitesurcase;
	
	//GETTERS
	
	public Texture getTexture() {
		return texture;
	}

	public boolean isBatimentsurcase() {
		return batimentsurcase;
	}

	public void setBatimentsurcase(boolean batimentsurcase) {
		this.batimentsurcase = batimentsurcase;
	}

	public boolean isUnitesurcase() {
		return unitesurcase;
	}

	public void setUnitesurcase(boolean unitesurcase) {
		this.unitesurcase = unitesurcase;
	}
	
	//CONSTRUCTOR

	public Case(Texture text) {
		super();
		this.texture = text;
		this.setBackground(this.texture);
		
		this.batimentsurcase=false;
		this.unitesurcase=false;
	}

	public Case() {
		super();
		this.caseAleatoire();
		this.setBackground(this.texture);
		
		this.batimentsurcase=false;
		this.unitesurcase=false;
	}	
	
	//METHODS
	
	public void setBackground(Texture bouh) {
		switch (bouh) {
		// eau, sable, montagne, foret, terre, nondefini
			case eau:
				this.setBackground(Color.blue);
				break;
			case sable:
				this.setBackground(Color.yellow);
				break;
			case montagne:
				this.setBackground(Color.gray);
				break;
			case foret:
				this.setBackground(Color.green);
				break;
			case terre:
				this.setBackground(new Color(121, 64, 0));
				break;
			case nondefini:
				this.setBackground(Color.white);
				break;
		}
		if (this.batimentsurcase || this.unitesurcase){
			this.setBackground(Color.pink);
		}
	}
	
	public void setBackground(){
		switch (this.texture) {
			// eau, sable, montagne, foret, terre, nondefini
				case eau:
					this.setBackground(Color.blue);
					break;
				case sable:
					this.setBackground(Color.yellow);
					break;
				case montagne:
					this.setBackground(Color.gray);
					break;
				case foret:
					this.setBackground(Color.green);
					break;
				case terre:
					this.setBackground(new Color(121, 64, 0));
					break;
				case nondefini:
					this.setBackground(Color.white);
					break;
			}
			if (this.batimentsurcase || this.unitesurcase){
				this.setBackground(Color.pink);
			}
	}

	private void caseAleatoire() {
		java.util.Random rand = new java.util.Random();
		Texture[] enumText = Texture.values();
		this.texture = enumText[rand.nextInt(enumText.length)];
	}

}
