package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Désolée " + nomAcheteur + " mais il faut être un habitant du village pour commercer ici...");
		} else {
			String produit = Clavier.entrerChaine("Quel produit souhaitez-vous acheter ?");
			String[] nomsVendeursProduit = controlAcheterProduit.trouverNomsVendeursProduit(produit);
			if (nomsVendeursProduit == null) {
				System.out.println("Personne ne vend de " + produit + " au marché aujourd'hui.");
			} else {
				for (int i=0; i<nomsVendeursProduit.length; i++) {
					System.out.println((i+1) + " - " + nomsVendeursProduit[i]);
				}
				int indiceChoisi = Clavier.entrerEntier("Chez quel commerçant voulez-vous acheter des " + produit + " ?");
				String nomVendeur = nomsVendeursProduit[indiceChoisi-1];
				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal de " + nomVendeur + ".");
				int quantiteVoulue = Clavier.entrerEntier("Combien de " + produit + "souhaitez-vous acheter ?");
				int quantiteAchetee = controlAcheterProduit.acheterProduit(nomVendeur, quantiteVoulue);
				if (quantiteAchetee == 0) {
					System.out.println(nomAcheteur + " veut acheter " + quantiteVoulue + " " + produit
							+ ", malheureusement il n'y en a plus du tout à l'étal de " + nomVendeur + "...");
				} else if (quantiteAchetee < quantiteVoulue) {
					System.out.println(
							nomAcheteur + " veut acheter " + quantiteVoulue + " " + produit + ", malheureusement " + nomVendeur
									+ " n'en a plus que " + quantiteAchetee + ". " + nomAcheteur + " achète tout le stock !");
				} else {
					System.out.println(nomAcheteur + " achète " + quantiteAchetee + " " + produit + " à " + nomVendeur + ".");
				}
			}
		}
	}
}
