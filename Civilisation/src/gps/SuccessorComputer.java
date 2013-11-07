package gps;  
  
import java.util.Collection;  
  
/** 
 * Interface destin�e � faire le calcul de qui est le successeur du noeud 
 * courant 
 * 
 * @author Moloch 
 * @since 1.0 
 * @version 1.0 
 * @param <T> 
 *            le type de l'index dont on veut le successeur 
 */  
public interface SuccessorComputer<T> {  
  
    /** 
     * Renvoit une collection des index successeurs du noeuds pass�s en 
     * param�tres. Attention, les successeurs ne doivent pas etre parmi les 
     * parents du noeud param�tre 
     * 
     * @param node 
     *            le noeud dont on veut les successeurs 
     * @return la liste des successeurs du noeuds 
     */  
    Collection<T> computeSuccessor(Node<T> node);  
  
}  