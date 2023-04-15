package s1t3n2exercici1;

import java.util.HashSet;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		//Creem el HashSet
		HashSet<Restaurant> restaurants = new HashSet<Restaurant>();
		
		//Preguntem per si es vol afegir un restaurant
		while (afegir()) {
			
			// Afegim restaurants
			Restaurant nou = plus();
			
			//Comprovem si est� al HashSet
			if (comprovar(nou, restaurants)) {
				restaurants.add(nou);
				System.out.println("S'ha afegit el restaurant \"" + nou.getNom() + "\" amb la puntuaci� \"" + nou.getPuntuacio() + "\"");
				
			} else {
				System.out.println("No s'ha afegit el restaurant perqu� ja hi estava");
			}			
		}
		//Imprimim els restaurants
		imprimir(restaurants);		
	}
	
	//Creem un m�tode add que verificar� si hi ha restaurants id�ntics
	public static boolean afegir() {
		
		String res = JOptionPane.showInputDialog("Si vols afegir restaurants, introdueix \"si\" ");
		
		if (res.equalsIgnoreCase("si")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static Restaurant plus() {
		
		String nom = JOptionPane.showInputDialog("Nom del restaurant: ");
		int puntuacio = Integer.parseInt(JOptionPane.showInputDialog("Puntuaci� del restaurant "));
		
		Restaurant nou = new Restaurant(nom, puntuacio);
		return nou;
	}
	
	public static boolean comprovar(Restaurant r, HashSet<Restaurant> res){
		
		for (Restaurant i: res) {
			if (r.getNom().equals(i.getNom()) && r.getPuntuacio() == (i.getPuntuacio())) {
				return false;
			}
		}
		return true;
	}
	
	public static void imprimir(HashSet<Restaurant> res) {
		
		System.out.println("Els restaurants afegits son: ");
		
		for (Restaurant r : res) {
			System.out.println("El restaurant \"" + r.getNom() + "\" amb la puntuaci� \"" + r.getPuntuacio() + "\"");
		}
	}
}