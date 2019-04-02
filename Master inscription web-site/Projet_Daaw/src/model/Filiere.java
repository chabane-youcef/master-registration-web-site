// CREATE BY : CHABANE YOUCEF EL AMINE & BOUFAR TAREK
package model;

public class Filiere {
	private int id;
	private int id_univ;
	private String filiere;
	
	
	
	public Filiere(int id, int id_univ, String filiere) {
		this.id = id;
		this.id_univ = id_univ;
		this.filiere = filiere;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	public Filiere(int id, String filiere) {
		this.id = id;
	
		this.filiere = filiere;
	}
	public int getId_univ() {
		return id_univ;
	}
	public void setId_univ(int id_univ) {
		this.id_univ = id_univ;
	}
	
	
}
