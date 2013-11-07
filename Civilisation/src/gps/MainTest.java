package gps;  
  
import java.awt.Point;  
import java.util.ArrayList;  
import java.util.Collection;  
import java.util.List;  
  
import gps.Astar;  
import gps.Node;  
import gps.NodeFactory;  
import gps.SuccessorComputer;  
  
/** 
 * Classe fournissant un cas de test concret pour l'algo A* 
 *  
 * On veut parcourir une matric de chaine de caractère, un espace représentant un chemin exploitable 
 * un | représentant un chemin interdit. 
 * On peut se déplacer a gauche, a droite, en haut, en bas, mais pas en diagonale 
 *  
 * @author blemoine 
 */  
public class MainTest {  
  
    public static void main(String[] args) {  
        final String[][] matrix = new String[][] {  
            { " ","|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," " },  
            { " ","|"," "," "," "," "," "," "," "," "," "," "," ","|"," "," "," "," " },  
            { " ","|","|"," "," "," "," "," "," "," "," "," "," ","|"," "," "," "," " },  
            { " "," ","|"," "," "," "," "," "," "," "," "," "," ","|"," "," "," "," " },  
            { "M"," ","|"," "," "," "," "," "," "," "," "," "," ","|"," "," "," "," " },  
            { " "," ","|"," "," "," "," "," "," "," "," "," "," "," ","|"," ","|"," " },  
            { "F","M","|","|","|","|","|","|","|"," "," "," "," "," ","|"," "," "," " },  
            { " ","M"," "," "," "," "," "," ","|"," "," "," ","|"," ","|","|"," "," " },  
            { " "," "," "," "," "," "," "," ","|"," "," "," ","|"," "," "," "," "," " },  
            { "F"," "," "," "," "," ","|"," ","|"," "," "," ","|"," "," "," "," "," " },  
            { " ","|","|","|","|","|","|"," ","|"," "," "," ","|","|","|"," ","|","|" },  
            { " ","|"," "," "," "," "," "," ","|"," "," "," ","|"," "," "," "," "," " },  
            { " ","|"," "," "," "," "," "," ","|"," ","|"," ","|"," "," "," ","|"," " },  
            { " ","|"," "," "," "," "," "," ","|","|","|"," ","|"," "," "," "," "," " },  
            { " ","|"," "," "," "," "," "," "," "," "," "," ","|"," "," "," ","|"," " },  
        };  
  
        final int width = matrix[0].length - 1;  
        final int height = matrix.length - 1;  
          
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
                  
                if(" ".equals(matrix[(int) index.getY()][(int) index.getX()])) {  
                    return 1;  
                }
                if("F".equals(matrix[(int) index.getY()][(int) index.getX()])) {  
                    return 2;  
                }
                if("M".equals(matrix[(int) index.getY()][(int) index.getX()])) {  
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
          
        final List<Point> result = astart.compute(new Point(0,0), new Point(2,1));  //new Point(width,height) //c'est là qu'on modifie le départ et l'arrivée
        //On intégre le résultat dans la matrice de base, et on l'affiche  
        for(final Point point : result) {  
            matrix[(int) point.getY()][(int) point.getX()] = "X";  
        }  
        displayMatrix(matrix);  
    }  
  
    /** 
     * Affiche la matrice dans la sortie standard 
     *  
     * @param matrix la matrice a afficher 
     */  
    public static void displayMatrix(final String[][] matrix) {  
        final StringBuilder result = new StringBuilder();  
        for (int col = 0; col < matrix[0].length; ++col) {  
            result.append("___");  
        }  
        result.append('\n');  
        for (int line = 0; line < matrix.length; ++line) {  
            for (int col = 0; col < matrix[line].length; ++col) {  
                result.append(' ');  
                result.append(matrix[line][col]);  
                result.append(' ');  
            }  
  
            result.append('\n');  
        }  
        for (int col = 0; col < matrix[0].length; ++col) {  
            result.append("___");  
        }  
        System.out.println(result);  
    }  
}  