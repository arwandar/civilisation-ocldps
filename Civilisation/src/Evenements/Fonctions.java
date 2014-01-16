package Evenements;

import gps.Astar;
import gps.Node;
import gps.NodeFactory;
import gps.SuccessorComputer;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import joueur.Joueur;
import Batiment.BatArcherie;
import Batiment.BatAtelierDeSiege;
import Batiment.BatCaserne;
import Batiment.BatEcurie;
import Batiment.BatHotelDeVille;
import Batiment.BatMur;
import Batiment.BatPort;
import Batiment.BatProdRes;
import Batiment.BatProdRes.typeRessource;
import Batiment.BatProdUnit.typeUnite;
import Batiment.BatTourDesMages;
import Batiment.BatTourelle;
import Batiment.Batiment;
import Unites.Personnage;
import civ.Case;
import civ.PanelPrcpl;
import civ.Texture;



public class Fonctions {
	
	private static PanelPrcpl plateau;
	public static int distanceTest=100;

	public static String[][] matriceDeJeu=new String[30][60]; /*= new String[getPlateau().getWidth()/50][getPlateau().getHeight()/50];*/
	
	public Fonctions(PanelPrcpl plateau){
		Fonctions.setPlateau(plateau);
		
		
	}

	
	
	
	public static void creationDeLaMatrice ( ){
		
		//System.out.println(getPlateau().getWidth() + " " + getPlateau().getHeight()); //50.13
		//for (int i=0;i<getPlateau().getWidth()/50;i++){
		for (int i=0;i<30;i++){
			//for (int j=0;j<getPlateau().getHeight()/50;j++){
			for (int j=0;j<60;j++){
				//System.out.println(getPlateau().getCarte(i, j).getTexture());
				if ( getPlateau().getCarte(i,j).isBatimentsurcase() || getPlateau().getCarte(i,j).isUnitesurcase() || getPlateau().getCarte(i,j).getTexture() == Texture.eau )
					matriceDeJeu[i][j]= "|";
				else if ( getPlateau().getCarte(i,j).getTexture() == Texture.foret)
					matriceDeJeu[i][j]= "F";
				else if (getPlateau().getCarte(i,j).getTexture() == Texture.montagne)
					matriceDeJeu[i][j]= "M";
				else
					matriceDeJeu[i][j]= " ";
			}
		}
	}
	
	public static void displayMatrix(final String[][] matrix) {
		  
        for (int col = 0; col < matrix.length; ++col) {  
            for (int line = 0; line < matrix[col].length; ++line) {  
                System.out.print(matrix[col][line]+" "); 
            } 
            System.out.println(" ");
        }
    } 
	
	
	public static void testGps(Personnage perso, int arriveeX, int arriveeY){
           
            final int width = matriceDeJeu[0].length - 1;  
            final int height = matriceDeJeu.length - 1;  
              
            final SuccessorComputer<Point> successorComputer = new SuccessorComputer<Point>() {  
                /** 
                 * Doit renvoyer les points a gauche, a droite, en haut en bas du noeud passé en paramètre 
                 * en supprimant la position du noeud parent de ce noeud 
                 *  
                 * @param node le noeud dont on cherche les voisins 
                 * @return la liste des voisins du noeud diminué de la position du parent 
                 */  
                @Override  
                public Collection<Point> computeSuccessor(final Node<Point> node) {  
                    final Point index = node.getIndex();  
                    final int x = (int) index.getX();  
                    final int y = (int) index.getY();  
      
                    final List<Point> resultat = new ArrayList<Point>();  
                    if (x > 0) {  
                        resultat.add(new Point(x - 1, y));  
                    }  
                    if (x < width ) {  
                        resultat.add(new Point(x + 1, y));  
                    }  
      
                    if (y > 0) {  
                        resultat.add(new Point(x, y - 1));  
                    }  
                    if (y < height ) {  
                        resultat.add(new Point(x, y + 1));  
                    }  
                    if(node.getParent() != null) {  
                        resultat.remove(node.getParent().getIndex());  
                    }  
                    return resultat;  
                }  
            };  
              
            final NodeFactory<Point> nodeFactory = new NodeFactory<Point>() {  
                @Override  
                protected double computeReel(final Point parentIndex, final Point index) {  
                    if(parentIndex != null && parentIndex.equals(index)) {  
                        return 0;  
                    }  
                      
                    if(" ".equals(matriceDeJeu[(int) index.getY()][(int) index.getX()])) {  
                        return 1;  
                    }
                    if("F".equals(matriceDeJeu[(int) index.getY()][(int) index.getX()])) {  
                        return 2;  
                    }
                    if("M".equals(matriceDeJeu[(int) index.getY()][(int) index.getX()])) {  
                        return 3;  
                    }
                    return Double.MAX_VALUE;  
                }  
                  
                @Override  
                protected double computeTheorique(final Point index, final Point goal) {  
                    // Distance de manhattan  
                    return Math.abs(index.getX()-goal.getX()) + Math.abs(index.getY()-goal.getY());  
                }  
            };  
      
            final Astar<Point> astart = new Astar<Point>(successorComputer,  
                    nodeFactory);  
              
            final List<Point> result = astart.compute(new Point(perso.getPositionHorizontale(),perso.getPositionVerticale()), new Point(arriveeY,arriveeX));  //new Point(width,height) //c'est là qu'on modifie le départ et l'arrivée
            //On intégre le résultat dans la matrice de base, et on l'affiche
            distanceTest=0;//donne la distance la plus courte au point
            
        
            
            
            
            for(final Point point : result) {  
            	//System.out.println(distanceTest);
            	if(" ".equals(matriceDeJeu[(int) point.getY()][(int) point.getX()]) && result.get(0)!=point) {  
            		distanceTest+= 1;  
                }
                if("F".equals(matriceDeJeu[(int) point.getY()][(int) point.getX()])&& result.get(0)!=point) {  
                	distanceTest+= 2;  
                }
                if("M".equals(matriceDeJeu[(int) point.getY()][(int) point.getX()])&& result.get(0)!=point) {  
                	distanceTest+= 3;  
                }
            	matriceDeJeu[(int) point.getY()][(int) point.getX()] = "X";
            	//System.out.println(distanceTest);
            }
         
            displayMatrix(matriceDeJeu); 
	}
	
	public static void deplacementReel (Personnage perso){
		
		int mouvementRestant=perso.getMouvement();
		int[] x = {-1,0,1,0};
		int[] y = {0,-1,0,1};
		matriceDeJeu[ perso.getPositionHorizontale() ][ perso.getPositionVerticale() ]="O";
		//System.out.println("Je suis en " + perso.getPositionHorizontale() + " " +  perso.getPositionVerticale() + " et je peux bouger de " + mouvementRestant );
		
		while (mouvementRestant>0){
			for (int i=0; i<4; i++){
				int nvX = perso.getPositionHorizontale() + x[i];
				int nvY = perso.getPositionVerticale() + y[i];
				if(matriceDeJeu[ nvX ][ nvY ]=="X"){
					//System.out.println("Trouvé ! : " + nvX + " " + nvY);
					
					
					
					int coeff = TestTerrain(nvX,nvY);
					if ((mouvementRestant - coeff) >= 0){
						matriceDeJeu[ nvX ][ nvY ]="O";
						perso.setPositionHorizontale(nvX);
						perso.setPositionVerticale(nvY);
						mouvementRestant -= coeff;
						//System.out.println("Je suis en " + perso.getPositionHorizontale() + " " +  perso.getPositionVerticale() + " et je peux bouger de " + mouvementRestant );
					}
					else{
						mouvementRestant--;
					}
				}
			}	
		}
	}
	
	

	
	
	public static boolean isRange(Personnage Attaquant, Personnage Defenseur, int portee){
		int decalageHorizontal = Math.abs(Attaquant.getPositionHorizontale() - Defenseur.getPositionHorizontale());
		int decalageVertical = Math.abs(Attaquant.getPositionVerticale() - Defenseur.getPositionVerticale());
		
		if (decalageHorizontal <= portee && decalageVertical <= portee){			
			System.out.println("True");
			return true;
		}			
		else{			
			System.out.println("False");
			return false;
		}		
	}
	public static boolean isRange(Personnage Attaquant, Batiment Defenseur, int portee){
		int decalageHorizontal = Math.abs(Attaquant.getPositionHorizontale() - Defenseur.getPOSITION(0));
		int decalageVertical = Math.abs(Attaquant.getPositionVerticale() - Defenseur.getPOSITION(1));
		
		if (decalageHorizontal <= portee && decalageVertical <= portee){			
			System.out.println("True");
			return true;
		}			
		else{			
			System.out.println("False");
			return false;
		}		
	}
	
	public static void Attaquer(Personnage attaquant, Personnage defenseur){ //attaque entre deux unités
		
		if (defenseur.getT()==typeUnite.Magicien)
			defenseur.setPV(defenseur.getPV() - attaquant.getAttaque()) ; // les magiciens ignorent l'armure
		else
			defenseur.setPV(defenseur.getPV() - (attaquant.getAttaque() -  Math.round(attaquant.getAttaque() * defenseur.getDefense())));
	}
	public static void Attaquer(Personnage attaquant, Batiment defenseur){ //attaque entre une unité et un bâtiment
		defenseur.setPV((int)(defenseur.getPV()- (attaquant.getAttaque() -  Math.round(attaquant.getAttaque() * defenseur.getDEF())) ));
	}
	public static void Attaquer(Batiment attaquant, Personnage defenseur){ //attaque entre une unité et un bâtiment
		defenseur.setPV(defenseur.getPV()- (attaquant.getATT() -  Math.round(attaquant.getATT() * defenseur.getDefense())) );
	}
	
	
	
	
	public static void Creation(Personnage personnage){
		 personnage.combattre();
		 personnage.seDeplacer();
		 personnage.soigner();
		 personnage.batir();
	}
	
	public static void Chercher (Joueur J){ //recherche des ressources
				
		double x;
		x=Math.random();
		
		if (x<0.2)
			J.setNourriture(J.getNourriture() + 10);
		if(x>=0.2 && x<0.4)
			J.setBois(J.getBois() + 10);
		if(x>=0.4 && x<0.6)
			J.setPierre(J.getPierre() + 10);
		if(x>=0.6 && x<0.8)
			J.setOr(J.getOr() + 10);
		if(x>=0.8)
			J.setFer(J.getFer() + 10);
		}



	
	public static int TestTerrain (int valeurHorizontale, int valeurVerticale){ //renvoie la difficulté de franchissement du terrain
		if ( getPlateau().getCarte(valeurHorizontale,valeurVerticale).isBatimentsurcase() || getPlateau().getCarte(valeurHorizontale,valeurVerticale).isUnitesurcase())
			return 0;
		else if ( getPlateau().getCarte(valeurHorizontale,valeurVerticale).getTexture() == Texture.foret)
			return 2;
		else if (getPlateau().getCarte(valeurHorizontale,valeurVerticale).getTexture() == Texture.montagne)
			return 3;
		else
			return 1;
	}


	public static PanelPrcpl getPlateau() {
		return plateau;
	}

	public static void setPlateau(PanelPrcpl plateau) {
		Fonctions.plateau = plateau;
	}
	
	public static void construire(Joueur J,String name, int V[], Case M)
	{
		switch(name)
		{
			case "Archerie": new BatArcherie(V, M, J);
				break;
			case "atelier de siège": new BatAtelierDeSiege(V, M, J);
				break;
			case "Caserne": new BatCaserne(V, M, J);
				break;
			case "Ecurie": new BatEcurie(V, M, J);
				break;
			case "Hotel de ville" : new BatHotelDeVille(V, M, J);
				break;
			case "Mur": new BatMur(V, M, J);
				break;
			case "Port": new BatPort(V, M, J);
				break;
			case "Tour des mages": new BatTourDesMages(V, M, J);
				break;
			case "Tourelle": new BatTourelle(V, M, J);
				break;
			default: System.out.println("\nCe type de bâtiment n'éxiste pas");
		}
	}
	
	public static void construire(Joueur J, int V[], Case M, typeRessource t)
	{
		switch(t)
		{
			case or: new BatProdRes("mine", V, t, M, J);
				break;
			case fer: new BatProdRes("mine", V, t, M, J);
				break;
			case pierre: new BatProdRes("mine", V, t, M, J);
				break;
			case bois: new BatProdRes("mine", V, t, M, J);
				break;
			case nourriture: new BatProdRes("mine", V, t, M, J);
				break;
			default: System.out.println("\nCe type de bâtiment n'éxiste pas");
		}
	}
}
