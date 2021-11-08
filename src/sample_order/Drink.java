package sample_order;

public class Drink implements Cloneable{
	private int id;
	private String name;
	private int price;
	private int base;
	private int mate1;
	private int mate2;
	private int mate3;
	private String style;
	private String glass;
	private String memo;

	public Drink() {
		this.id=0;
		this.name=null;
		this.price=0;
		this.base=0;
		this.mate1=0;
		this.mate2=0;
		this.mate3=0;
		this.style=null;
		this.glass=null;
		this.memo=null;
	}
	public Drink(String name,int price,int mate1,int mate2,int mate3,int mate4,String style,String glass,String memo) {
		this.name=name;
		this.price=price;
		this.base=mate1;
		this.mate1=mate2;
		this.mate2=mate3;
		this.mate3=mate4;
		this.style=style;
		this.glass=glass;
		this.memo=memo;

	}
	public Drink(int id,String name,int price,int mate1,int mate2,int mate3,int mate4,String style,String glass,String memo) {
		this.id =id;
		this.name=name;
		this.price=price;
		this.base=mate1;
		this.mate1=mate2;
		this.mate2=mate3;
		this.mate3=mate4;
		this.style=style;
		this.glass=glass;
		this.memo=memo;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int i) {
		this.id=i;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String s) {
		this.name=s;
	}
	public int getPrice() {
		return this.price;
	}
	public void setPrice(int i) {
		this.price=i;
	}
	public int getBase() {
		return this.base;
	}
	public void setBase(int i) {
		this.base=i;
	}
	public int getMate1() {
		return this.mate1;
	}
	public void setMate1(int i) {
		this.mate1=i;
	}
	public int getMate2() {
		return this.mate2;
	}
	public void setMate2(int i) {
		this.mate2=i;
	}
	public int getMate3() {
		return this.mate3;
	}
	public void setMate3(int i) {
		this.mate3=i;
	}
	public String getStyle() {
		return this.style;
	}
	public void setStyle(String s) {
		this.style=s;
	}
	public String getGlass() {
		return this.glass;
	}
	public void setGlass(String s) {
		this.glass=s;
	}
	public String getMemo() {
		return this.memo;
	}
	public void setMemo(String s) {
		this.memo=s;
	}

	public Drink clone() throws CloneNotSupportedException{
		Drink clone=(Drink) super.clone();
		return clone;
	}

}
