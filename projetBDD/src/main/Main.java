package main;

import java.util.List;

import data.CC;
import factory.CCFactory;
import factory.EnseignantFactory;


public class Main {

	public Main() {
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*MetierCC metierCC = new MetierCC();
		Scanner sc = new Scanner(System.in);
		Integer idcc = sc.nextInt();
		CC cc = metierCC.rechercherCC(idcc);
		
		if(cc != null){
			System.out.println("ok");
		}
		*/
		
		/*List<CC> liste = CCFactory.getInstance().listerCC();
		for(CC cc : liste)
			System.out.println(cc.getIdCC());*/
		
		EnseignantFactory.getInstance().rechercherEnseignantsParCC(1);
		System.out.println("fin");
	}

}
