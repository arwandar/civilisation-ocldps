package gps;  
  
/** 
 * Factory destin�e � la construction de nouveau node pour l'algorithme A* 
 * 
 * @author Moloch 
 * @since 1.0 
 * @version 1.0 
 * @param <T> 
 *            le type de l'index du noeud (sa position par exemple) 
 */  
public abstract class NodeFactory<T> {  
  
    /** 
     * Instancie avec un nouveau noeud, avec les valeurs remplies. Les distances 
     * cont calcul�es ici � l'aide des m�thodes abstraites de la classe 
     * 
     * @param parent 
     *            le noeud parent 
     * @param index 
     *            l'index du noeud � cr�er 
     * @param goal 
     *            la destination 
     * @return le nouveau noeud 
     */  
    public final Node<T> instanciateNode(final Node<T> parent, final T index, final T goal) {  
        final double g;  
        if (parent == null) {  
            g = computeReel(null, index);  
        } else {  
            g = parent.getG() + computeReel(parent.getIndex(), index);  
        }  
        final double f = g + computeTheorique(index, goal);  
        return initNode(parent, index, g, f);  
    }  
  
    /** 
     * Cr�� un nouveau node avec les param�tres indiqu�s. C'est la 
     * r�sponsabilit� de cette m�thode de positionner les param�tres 
     * correctement 
     * 
     * @param parent 
     *            le noeud parent 
     * @param index 
     *            l'index du noeud 
     * @param g 
     *            la valeur de la distance r��l � l'origine 
     * @param f 
     *            la valeur de la distance total (r��l � l'origine + th�orique � 
     *            la destination) 
     * @return le nouveau noeud 
     */  
    protected Node<T> initNode(final Node<T> parent, final T index, final double g, final double f) {  
        return new Node<T>(parent, index, g, f);  
    }  
  
    /** 
     * Renvoit la distance r�el entre les 2 index, sachant que ce sont des index 
     * consecutifs. En gros l'id�e, est que si les 2 index sont identiques , la 
     * m�thode renvoit 0 Si le 2eme index est accessible, on renvoit un chiffre 
     * repr�sentant la difficulit� d'acc�s >= 1 Si le 2emem index est 
     * inaccessible, on renvoit Double.MAX_VALUE Attention, le parentIndex peut 
     * etre null 
     * 
     * @param parentIndex 
     *            l'index du parent (peut etre null, si pas de parent) 
     * @param index 
     *            l'index de la destination 
     * 
     * @return renvoit la distance r�el 
     */  
    protected abstract double computeReel(T parentIndex, T index);  
  
    /** 
     * Renvoie le cout theorique (distance) entre l'index et le goal Une bonne 
     * fonction theorique doit toujours etre inf�rieur au reel 
     * 
     * @param index 
     *            l'origine 
     * @param goal 
     *            la destination 
     * @return la distance 
     */  
    protected abstract double computeTheorique(T index, T goal);  
}  