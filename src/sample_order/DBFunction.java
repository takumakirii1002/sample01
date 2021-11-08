package sample_order;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBFunction {
	//db操作
	private Connection con;
	Input input;


	public DBFunction(DBConnection db) {
		this.con=db.getConnect();
		input =new Input();
	}

	//全検索
	public ArrayList<Guest> findAllGuest(){
		Guest guest=new Guest();
		ArrayList<Guest> list = new ArrayList<Guest>();
		String sql ="SELECT * FROM Guests";
		try {
			PreparedStatement stmt =con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				guest=getGuest(rs);
				list.add(guest);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public ArrayList<Guest> findGuestById(int value){
		Guest guest=new Guest();
		ArrayList<Guest> list = new ArrayList<Guest>();
		String sql ="SELECT * FROM Guests WHERE guestId = ?";
		try {
			PreparedStatement stmt =con.prepareStatement(sql);
			stmt.setInt(1, value);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				guest=getGuest(rs);
				list.add(guest);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public Guest findGuest(int i){
		Guest g=new Guest();
		String sql="SELECT * FROM Guests WHERE guestId = ?";

		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, i);

			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				g=getGuest(rs);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return g;
	}
	public ArrayList<Guest> findGuestByName(String value){
		Guest guest=new Guest();
		ArrayList<Guest> list = new ArrayList<Guest>();
		String sql ="SELECT * FROM Guests WHERE name = ?";
		try {
			PreparedStatement stmt =con.prepareStatement(sql);
			stmt.setString(1, value);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				guest=getGuest(rs);
				list.add(guest);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public ArrayList<Guest> findGuestByAge(int value){
		Guest guest=new Guest();
		ArrayList<Guest> list = new ArrayList<Guest>();
		String sql ="SELECT * FROM Guests WHERE age = ?";
		try {
			PreparedStatement stmt =con.prepareStatement(sql);
			stmt.setInt(1, value);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				guest=getGuest(rs);
				list.add(guest);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public ArrayList<Guest> findGuestBySex(String value){
		Guest guest=new Guest();
		ArrayList<Guest> list = new ArrayList<Guest>();
		String sql ="SELECT * FROM Guests WHERE sex = ?";
		try {
			PreparedStatement stmt =con.prepareStatement(sql);
			stmt.setString(1, value);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				guest=getGuest(rs);
				list.add(guest);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public boolean registGuest(Guest g){
		boolean judge=false;
		String sql="INSERT INTO Guests (name,age,sex,memo) VALUES (?,?,?,?)";


		String name=g.getName();
		int age=g.getAge();
		String sex=g.getSex();
		String memo=g.getMemo();

		try {
			PreparedStatement stmt=con.prepareStatement(sql);

			stmt.setString(1,name);
			stmt.setInt(2, age);
			stmt.setString(3, sex);
			stmt.setString(4, memo);

			int count=stmt.executeUpdate();

			if(count==1) {
				judge=true;
				System.out.println("顧客情報の追加");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return judge;
	}
	public boolean deleteGuest(Guest g) {
		boolean judge=false;
		int count=0;
		String sql="DELETE FROM Guests WHERE guestId = ?";
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, g.getId());
			count=stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		if(count==1)judge=true;
		return judge;
	}
	public boolean updateGuest(Guest g) {
		boolean judge=false;
		int count=0;
		String sql="UPDATE Guests SET name = ? , age = ?, sex = ? , memo = ? WHERE guestId = ?";
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, g.getName());
			stmt.setInt(2, g.getAge());
			stmt.setString(3, g.getSex());
			stmt.setString(4, g.getMemo());
			stmt.setInt(5, g.getId());

			count=stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		if(count==1) judge=true;
		return judge;
	}





	public ArrayList<Drink> findAllDrink(){
		Drink drink=new Drink();
		ArrayList<Drink> list = new ArrayList<Drink>();
		String sql="SELECT * FROM Drinks";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				drink=getDrink(rs);
				list.add(drink);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}

		return list;
	}

	public ArrayList<Drink> findDrinkById(int value){
		Drink drink=new Drink();
		ArrayList<Drink> list = new ArrayList<Drink>();
		String sql="SELECT * FROM Drinks WHERE drinkId = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,value);
			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				drink=getDrink(rs);
				list.add(drink);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public ArrayList<Drink> findDrinkByName(String value){
		Drink drink=new Drink();
		ArrayList<Drink> list = new ArrayList<Drink>();
		String sql="SELECT * FROM Drinks WHERE name = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,value);
			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				drink=getDrink(rs);
				list.add(drink);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public ArrayList<Drink> findDrinkByPrice(int value){
		Drink drink=new Drink();
		ArrayList<Drink> list = new ArrayList<Drink>();
		String sql="SELECT * FROM Drinks WHERE price = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,value);
			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				drink=getDrink(rs);
				list.add(drink);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public ArrayList<Drink> findDrinkByBase(int value){
		Drink drink=new Drink();
		ArrayList<Drink> list = new ArrayList<Drink>();
		String sql="SELECT * FROM Drinks WHERE base = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,value);
			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				drink=getDrink(rs);
				list.add(drink);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public ArrayList<Drink> findDrinkByMate1(int value){
		Drink drink=new Drink();
		ArrayList<Drink> list = new ArrayList<Drink>();
		String sql="SELECT * FROM Drinks WHERE mate1 = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,value);
			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				drink=getDrink(rs);
				list.add(drink);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public ArrayList<Drink> findDrinkByMate2(int value){
		Drink drink=new Drink();
		ArrayList<Drink> list = new ArrayList<Drink>();
		String sql="SELECT * FROM Drinks WHERE mate2 = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,value);
			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				drink=getDrink(rs);
				list.add(drink);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public ArrayList<Drink> findDrinkByMate3(int value){
		Drink drink=new Drink();
		ArrayList<Drink> list = new ArrayList<Drink>();
		String sql="SELECT * FROM Drinks WHERE mate3 = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,value);
			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				drink=getDrink(rs);
				list.add(drink);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public ArrayList<Drink> findDrinkByStyle(String value){
		Drink drink=new Drink();
		ArrayList<Drink> list = new ArrayList<Drink>();
		String sql="SELECT * FROM Drinks WHERE style = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,value);
			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				drink=getDrink(rs);
				list.add(drink);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public ArrayList<Drink> findDrinkByGlass(String value){
		Drink drink=new Drink();
		ArrayList<Drink> list = new ArrayList<Drink>();
		String sql="SELECT * FROM Drinks WHERE glass = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,value);
			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				drink=getDrink(rs);
				list.add(drink);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public Drink findDrink(int t){
		Drink drink=new Drink();
		String sql="SELECT * FROM Drinks WHERE drinkId = ?";
		try {
			PreparedStatement stmt=con.prepareStatement(sql);

			stmt.setInt(1, t);
			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				drink=getDrink(rs);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return drink;
	}




	public boolean registDrink(Drink d) {
		boolean judge=false;
		String sql="INSERT INTO Drinks (name,price,base,mate1,mate2,mate3,memo,style,glass) VALUES(?,?,?,?,?,?,?,?,?)";

		String name=d.getName();
		int price=d.getPrice();
		int base=d.getBase();
		int mate1=d.getMate1();
		int mate2=d.getMate2();
		int mate3=d.getMate3();
		String style=d.getStyle();
		String glass=d.getGlass();
		String memo=d.getMemo();

		try {
			PreparedStatement stmt=this.con.prepareStatement(sql);

			stmt.setString(1,name);
			stmt.setInt(2, price);
			stmt.setInt(3, base);
			stmt.setInt(4, mate1);
			stmt.setInt(5,mate2);
			stmt.setInt(6, mate3);
			stmt.setString(7, style);
			stmt.setString(8, glass);
			stmt.setString(9, memo);

			int count=stmt.executeUpdate();
			if(count==1) {
				judge=true;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return judge;
	}



	public ArrayList<Material> findAllMaterial(){
		ArrayList<Material> list=new ArrayList<Material>();
		String sql="SELECT * FROM Materials";

		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				int id=rs.getInt("materialId");
				String name=rs.getString("name");
				String type=rs.getString("type");

				Material material=new Material(id,name,type);
				list.add(material);
			}
		}catch(SQLException e) {
				System.out.println(e.getMessage());
		}
		return list;
	}
	public Material findMaterial(int t){
		Material mate=new Material();
		String sql="SELECT * FROM Materials WHERE materialId = ?";
		try {
			PreparedStatement stmt=con.prepareStatement(sql);

			stmt.setInt(1, t);
			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				mate=getMaterial(rs);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return mate;
	}
//どちらか不要　　した二つ
	public boolean registMaterial(String name,String type) {
		boolean judge=false;
		String sql="INSERT INTO Materials (name,type) VALUES(?,?)";
		int count=0;

		try {
			PreparedStatement stmt=con.prepareStatement(sql);

			stmt.setString(1, name);
			stmt.setString(2,type);

			count=stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		if(count==1)judge=true;
		return judge;
	}
	public boolean registMaterial(Material m) {
		boolean judge=false;
		String sql="INSERT INTO Materials (name,type) VALUES (?,?)";


		try {
			PreparedStatement stmt=con.prepareStatement(sql);

			stmt.setString(1, m.getName());
			stmt.setString(2, m.getType());

			int count=stmt.executeUpdate();

			if(count==1) {
				judge=true;
				System.out.println("材料情報の追加");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return judge;
	}
	public boolean updateMaterial(Material material) {
		boolean judge=false;
		int count=0;
		String sql="UPDATE Materials SET name = ?,type = ? WHERE materialId = ?";

		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, material.getName());
			stmt.setString(2, material.getType());
			stmt.setInt(3, material.getId());

			count=stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		if(count==1)judge=true;
		return judge;
	}






	public Material lastMaterial() {
		Material m=new Material();
		String sql="SELECT * FROM Materials ORDER BY materialId DESC LIMIT 1";

		try {
			PreparedStatement stmt=con.prepareStatement(sql);

			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				m.setId(rs.getInt("materialId"));
				m.setName(rs.getString("name"));
				m.setType(rs.getString("type"));
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return m;
	}

	public ArrayList<Material> findSpiritsMaterial(){
		Material mate=new Material();
		ArrayList<Material> list=new ArrayList<Material>();
		String sql="SELECT * FROM Materials WHERE type = 'spirit'";

		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				mate=getMaterial(rs);
				list.add(mate);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public ArrayList<Material> findLiqoursMaterial(){
		Material mate=new Material();
		ArrayList<Material> list=new ArrayList<Material>();
		String sql="SELECT * FROM Materials WHERE type = 'liqour'";

		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				mate=getMaterial(rs);
				list.add(mate);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public ArrayList<Material> findSoftdrinksMaterial(){
		Material mate=new Material();
		ArrayList<Material> list=new ArrayList<Material>();
		String sql="SELECT * FROM Materials WHERE type = 'softDrink'";

		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				mate=getMaterial(rs);
				list.add(mate);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public ArrayList<Material> findOtherMaterial(){
		Material mate=new Material();
		ArrayList<Material> list=new ArrayList<Material>();
		String sql="SELECT * FROM Materials WHERE type = 'other'";

		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				mate=getMaterial(rs);
				list.add(mate);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}







	public ArrayList<History> findAllHistory(){
		ArrayList<History> list=new ArrayList<History>();
		String sql="SELECT * FROM Histories";

		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {

				History history=getHistory(rs);
				list.add(history);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}

		return list;
	}
	public ArrayList<History> findNotSettledHistoryByAsc(){
		History history=new History();
		ArrayList<History> list=new ArrayList<History>();
		String sql="SELECT * FROM Histories WHERE isSettled = 0 ORDER BY guestId ASC";
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				history=getHistory(rs);
				list.add(history);
			}

		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	public ArrayList<History> findHistoryByGuestId(int guestId) {
		History history=new History();
		ArrayList<History> list=new ArrayList<History>();
		String sql="SELECT * FROM Histories WHERE historyId = ?";
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, guestId);
			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				history=getHistory(rs);
				list.add(history);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	public ArrayList<History> findNotSettledHistoryByGuestId(int guestId) {
		History history=new History();
		ArrayList<History> list=new ArrayList<History>();
		String sql="SELECT * FROM Histories WHERE isSettled = 0 && guestId = ? ";
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, guestId);
			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				history=getHistory(rs);
				list.add(history);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public boolean accountHistory(int id) {
		boolean result=false;
		int count=0;
		String sql="UPDATE Histories SET isSettled = 1 WHERE historyId = ?";

		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,id);

			count=stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		if(count==1) {
			result=true;
		}
		return result;
	}

	public boolean registHistory(int g,int d) {
		boolean judge=false;
		String sql="INSERT INTO Histories (guestId,drinkId) VALUES(?,?)";
		int count = 0;
		int guestId=g;
		int drinkId=d;
		try {
			PreparedStatement stmt=con.prepareStatement(sql);

			stmt.setInt(1, guestId);
			stmt.setInt(2, drinkId);
			count=stmt.executeUpdate();

		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		if(count==1)judge=true;
		return judge;

	}




	public Guest lastGuest() {
		Guest g=new Guest();
		String sql="SELECT * FROM Guests ORDER BY guestId DESC LIMIT 1";

		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();

			rs.next();
			g=getGuest(rs);
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return g;
	}
	public Drink lastDrink() {
		Drink d=new Drink();
		String sql="SELECT * FROM Drinks ORDER BY drinkId DESC LIMIT 1";
		try {
			PreparedStatement stmt=con.prepareStatement(sql);

			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				d=getDrink(rs);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return d;
	}
	public History lastHistory() {
		History h=new History();
		String sql="SELECT * FROM Histories ORDER BY historyId DESC LIMIT 1";
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				h=getHistory(rs);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return h;
	}
	public Guest getGuest(ResultSet rs) throws SQLException{
		Guest g=new Guest();
		int id=rs.getInt("guestId");
		String name=rs.getString("name");
		int age=rs.getInt("age");
		String sex=rs.getString("sex");
		String memo=rs.getString("memo");

		g.setId(id);
		g.setName(name);
		g.setAge(age);
		g.setSex(sex);
		g.setMemo(memo);

		return g;
	}
	public Drink getDrink(ResultSet rs) throws SQLException{
		int id=rs.getInt("drinkId");
		String name=rs.getString("name");
		int price=rs.getInt("price");
		int base=rs.getInt("base");
		int mate1=rs.getInt("mate1");
		int mate2=rs.getInt("mate2");
		int mate3=rs.getInt("mate3");
		String memo=rs.getString("memo");
		String style=rs.getString("style");
		String glass=rs.getString("glass");

		Drink drink=new Drink(id,name,price,base,mate1,mate2,mate3,style,glass,memo);

		return drink;
	}
	public Material getMaterial(ResultSet rs) throws SQLException{
		int id=rs.getInt("materialId");
		String name=rs.getString("name");
		String type=rs.getString("type");

		Material mate=new Material(id,name,type);
		return mate;
	}
	public History getHistory(ResultSet rs) throws SQLException{
		History history=new History();
		int historyId=rs.getInt("historyId");
		int guestId=rs.getInt("guestId");
		int drinkId=rs.getInt("drinkId");
		Date created_at=rs.getDate("created_at");
		boolean isSettled=rs.getBoolean("isSettled");

		history.setHistoryId(historyId);
		history.setGuestId(guestId);
		history.setDrinkId(drinkId);
		history.setTime(created_at);
		history.setIsSettled(isSettled);

		return history;
	}





	public boolean guestIsExist() {
		boolean result=false;
		int count=0;
		String sql="SELECT * FROM Guests";
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				count++;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		if(count==0) {
			result=false;
		}else {
			result=true;
		}
		return result;
	}
	public boolean drinkIsExist() {
		boolean result=false;
		int count=0;
		String sql="SELECT * FROM Drinks";
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				count++;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		if(count==0) {
			result=false;
		}else {
			result=true;
		}
		return result;
	}
	public boolean materialIsExist() {
		boolean result=false;
		int count=0;
		String sql="SELECT * FROM Materials";
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				count++;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		if(count==0) {
			result=false;
		}else {
			result=true;
		}
		return result;
	}
	public boolean historyIsExist() {
		boolean result=false;
		int count=0;
		String sql="SELECT * FROM Histories";
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();

			while(rs.next()) {
				count++;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		if(count==0) {
			result=false;
		}else {
			result=true;
		}
		return result;
	}
}








