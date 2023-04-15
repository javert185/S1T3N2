package s1t3n2exercici1;

import java.util.HashSet;
import java.util.*;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		//Creem el HashSet
		HashSet<Restaurant> restaurants = new HashSet<Restaurant>();
		
		//Preguntem per si es vol afegir un restaurant
		while (afegir()) {
			
			// Afegim restaurants
			Restaurant nou = plus();
			
			//Comprovem si està al HashSet
			if (comprovar(nou, restaurants)) {
				restaurants.add(nou);
				System.out.println("S'ha afegit el restaurant \"" + nou.getNom() + "\" amb la puntuació \"" + nou.getPuntuacio() + "\"");
				
			} else {
				System.out.println("No s'ha afegit el restaurant perquè ja hi estava");
			}			
		}
		//Imprimim els restaurants
		imprimir(restaurants);		
	}
	
	//Creem un mètode add que verificarà si hi ha restaurants idèntics
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
		int puntuacio = Integer.parseInt(JOptionPane.showInputDialog("Puntuació del restaurant "));
		
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
		
		//Els imprimim en ordre ascendent
		List<Restaurant> list_restaurants = new ArrayList<Restaurant>();
		
		for (Restaurant r: res) {
			list_restaurants.add(r);			
		}
		
		list_restaurants.sort(Comparator.comparing(Restaurant::getNom).thenComparing(Restaurant::getPuntuacio, Comparator.reverseOrder()));
		
		for (Restaurant i : list_restaurants) {
			System.out.println("S'ha afegit el restaurant \"" + i.getNom() + "\" amb la puntuació \"" + i.getPuntuacio() + "\"");			
		}		
	}
}