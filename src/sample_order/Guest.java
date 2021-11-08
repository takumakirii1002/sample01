package sample_order;

public class Guest implements Cloneable {
	private int id;
	private String name;
	private int age;
	private String sex;
	private String memo;

	public Guest() {}

	public Guest(String name,int age,String sex,String memo) {
		this.name=name;
		this.age=age;
		this.sex=sex;
		this.memo=memo;
	}
	public Guest(int id,String name,int age,String sex,String memo) {
		this.id =id;
		this.name=name;
		this.age=age;
		this.sex=sex;
		this.memo=memo;
	}
	public void setId(int id) {
		this.id=id;
	}
	public int getId() {
		return this.id;
	}
	public void setName(String name) {
		this.name =name;
	}
	public String getName() {
		return this.name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public int getAge() {
		return this.age;
	}
	public void setSex(String sex) {
		this.sex= sex;
	}
	public String getSex() {
		return this.sex;
	}
	public void setMemo(String memo) {
		this.memo=memo;
	}
	public String getMemo() {
		return this.memo;
	}
	public Guest clone() throws CloneNotSupportedException{
		Guest clone=(Guest) super.clone();
		return clone;
	}


}
