package Comportement;
/**
 * Définit que l'unité n'est pas capable de soigner
 * @author isen
 *
 */
public class NonSoigneur implements Soin {

	public void soigner() {
		System.out.println("Je ne soigne pas");
		
	}
}
