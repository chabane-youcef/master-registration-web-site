// CREATE BY : CHABANE YOUCEF EL AMINE & BOUFAR TAREK
package model;

public class Universite {
	private int id;
	private String name;
	
	
	
	public Universite(int id, String name) {
		this.id = id;
		this.name = name;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
