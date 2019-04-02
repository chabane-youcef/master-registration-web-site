// CREATE BY : CHABANE YOUCEF EL AMINE & BOUFAR TAREK
package model;

public class specialite {
	private int id;
	private int id_fil;
	private String name;
	private int nbr_places;
	
	
	
	public specialite(int id,int id_fil, String name) {
		this.id = id;
		this.id_fil = id_fil;
		this.name = name;
	}

	public specialite(int id, String name) {
		this.id = id;
		this.name = name;
	
	}

	public specialite(int id, int id_fil, String name, int nbr_places) {
		this.id = id;
		this.id_fil = id_fil;
		this.name = name;
		this.nbr_places = nbr_places;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_fil() {
		return id_fil;
	}

	public void setId_fil(int id_fil) {
		this.id_fil = id_fil;
	}

	public int getNbr_places() {
		return nbr_places;
	}

	public void setNbr_places(int nbr_places) {
		this.nbr_places = nbr_places;
	}
	
	
}
