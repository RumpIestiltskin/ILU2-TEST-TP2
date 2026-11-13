package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String nomVendeur) {
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}

	
	public String[] trouverNomsVendeursProduit(String produit) {
		Gaulois[] vendeursProduit = village.rechercherVendeursProduit(produit);
		if (vendeursProduit == null) {
			return null;
		}
		String[] nomsVendeursProduit = new String[vendeursProduit.length];
		for (int i=0; i<vendeursProduit.length; i++) {
			nomsVendeursProduit[i] = vendeursProduit[i].getNom();
		}
		return nomsVendeursProduit;
	}
	
	public int acheterProduit(String nomVendeur, int quantiteVoulue) {
		Etal etalVendeur = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return etalVendeur.acheterProduit(quantiteVoulue);
	}
}
