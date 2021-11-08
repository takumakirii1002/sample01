package sample_order;

public class Material implements Cloneable{
	private int id;
	private String name;
	private String type;

	public Material() {
		this.id=0;
		this.name=null;
		this.type=null;
	}
	public Material(int id,String name,String type) {
		this.id=id;
		this.name=name;
		this.type=type;
	}
	public void setId(int id) {
		this.id=id;
	}
	public int getId() {
		return this.id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	public void setType(String type) {
		this.type=type;
	}
	public String getType() {
		return this.type;
	}
	public Material clone() throws CloneNotSupportedException{
		Material clone=(Material) super.clone();
		return clone;
	}

}
