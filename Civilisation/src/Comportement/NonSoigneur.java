package Comportement;
/**
 * D�finit que l'unit� n'est pas capable de soigner
 * @author isen
 *
 */
public class NonSoigneur implements Soin {

	public void soigner() {
		System.out.println("Je ne soigne pas");
		
	}
}
