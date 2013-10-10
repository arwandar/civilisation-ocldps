package Batiment;

import civ.Case;


public class BatMur extends Batiment
{
	//*************** Constructeur *******************
		public BatMur(int V[], Case M[][])
		{
			super("Mur", 200, 0, 75, 0, true, V, 2, M);
		}
}
