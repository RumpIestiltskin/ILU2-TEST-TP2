package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if (infosMarche.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard !");
		} else {
			System.out.println("Bonjour " + nomAcheteur + ", aujourd'hui, vous trouverez sur le marché :\n");
			for (int i=0; i<infosMarche.length-2; i++) {
				System.out.print("- " + infosMarche[i]);
				i++;
				System.out.print(" qui vend " + infosMarche[i]);
				i++;
				System.out.println(" " + infosMarche[i]);
			}
		}
	}
}
