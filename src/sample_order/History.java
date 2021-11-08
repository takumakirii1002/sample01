package sample_order;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class History {
	private int historyId;
	private int drinkId;
	private int guestId;
	private Date time;
	private boolean isSettled;


	public History() {

	}
	public History(int historyId,int drinkId,int guestId,Date created_at,boolean isSettled) {

		this.historyId=historyId;
		this.drinkId=drinkId;
		this.guestId=guestId;
		this.time=created_at;
		this.isSettled=isSettled;
	}
	public int getHistoryId() {
		return historyId;
	}
	public void setHistoryId(int id) {
		historyId=id;
	}
	public int getDrinkId() {
		return drinkId;
	}
	public void setDrinkId(int drinkId) {
		this.drinkId=drinkId;
	}
	public int getGuestId() {
		return guestId;
	}
	public void setGuestId(int guestId) {
		this.guestId=guestId;
	}
	public String getTimeFormat() {
		DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd ");
		return dateFormat.format(time);
	}
	public Date getTime() {
		return time;
	}

	public void setTime(Date dateTime) {
		time=dateTime;
	}
	public boolean getIsSettled() {
		return isSettled;
	}
	public String getIsSettledString() {
		String result=null;
		if(isSettled==true) {
			result="会計済";
		}else {
			result="未会計";
		}
		return result;
	}
	public void setIsSettled(boolean isSettled) {
		this.isSettled=isSettled;
	}

}