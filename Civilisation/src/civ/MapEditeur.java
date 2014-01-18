package civ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.text.MaskFormatter;


public class MapEditeur extends JPanel {

	// **********VARIABLES
	int nbrCaseLargeur, nbrCaseHauteur;
	JPanel option, carte;
	JFormattedTextField dimensions;
	JLabel demandeDimensions;	
	JRadioButton[] textureSelectionnee;
	ButtonGroup listeTexture;
	JButton validationDimensions;
	
	
	// **********CONSTRUCTEURS
	public MapEditeur(FntPrcpl saF){
		this.option = new JPanel();
		
		try{
			MaskFormatter mask = new MaskFormatter("####/####");
			this.dimensions = new JFormattedTextField(mask);
			this.option.add(this.dimensions);
		}
		catch (ParseException e){
			System.out.println("problème dans l'éditeur de la map");
		}
		this.validationDimensions = new JButton();
		this.validationDimensions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		listeTexture = new ButtonGroup();
		
		Texture[] enumTextures = Texture.values();
		this.textureSelectionnee = new JRadioButton[enumTextures.length];
		for (int i=0; i< enumTextures.length; i++){
			this.textureSelectionnee[i] = new JRadioButton(enumTextures[i].toString());
			if (enumTextures[i].toString().equals("nondefini")){
				this.textureSelectionnee[i].setSelected(true);
			}
			this.listeTexture.add(this.textureSelectionnee[i]);
			this.option.add(this.textureSelectionnee[i]);
		}
		
		this.carte = new JPanel();
		
		this.add(this.option);
		this.add(this.carte);
	}

	// **********MUTATEURS

	// **********METHODES
	
	// a reecrire
	protected String finaliserLaCarte(){		
		return"bouh";
	}

}
