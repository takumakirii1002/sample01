package sample_order;

import java.util.ArrayList;
import java.util.Arrays;


public class HistoryController {
	DBFunction func;
	Input scan;
	Drink drink;
	Guest guest;


	public HistoryController(DBFunction func) {
		this.func=func;
		scan=new Input();
		drink=new Drink();
		guest=new Guest();
	}
	public void outHistoryList(ArrayList<History> list) {
		int count=0;
		for(History h:list) {
			guest=func.findGuest(h.getGuestId());
			drink=func.findDrink(h.getDrinkId());
			System.out.println(h.getHistoryId()+" :  ("+guest.getId()+":"+guest.getName()+") / "+drink.getName()+"  "+h.getTimeFormat()+" "+drink.getPrice()+"/"+h.getIsSettledString());
			count++;
		}
		System.out.println("");
		System.out.println(count+" 件");
	}
	public void outHistoryPerGuest(int guestId) {

		outHistoryList(func.findHistoryByGuestId(guestId));

	}
	public void account(Guest g) {
		int ga=0;
		boolean accounted=false;
		guest=g;
		for(History h:func.findNotSettledHistoryByGuestId(g.getId())) {
			drink=func.findDrink(h.getDrinkId());
			ga += drink.getPrice();
		}
		System.out.println(guest.getName()+" の未会計履歴 ¥　"+ga+"　[1:精算する　２：やめる]");
		int decide=scan.inputInt(2);
		if(decide==1) {
			for(History h:func.findNotSettledHistoryByGuestId(g.getId())) {
				accounted=func.accountHistory(h.getHistoryId());
			}
			if(accounted==true) {
				System.out.println("正常に処理しました");
			}else {
				System.out.println("処理に失敗しました");
			}
		}
	}
	public void ranking(ArrayList<History> historyList) {
		int count=func.lastDrink().getId();
		int[] idList=new int[count];


		for(History h:historyList) {
			System.out.println(h.getDrinkId());
			idList[h.getDrinkId()-1]++;
		}
		int[] shuffledList=Arrays.copyOf(idList, count);
		int temp;
		for(int i=0;i<count;i++) {
			for(int j=0;j<shuffledList.length-i-1;j++) {
				if(shuffledList[j]<shuffledList[j+1]) {
					temp=shuffledList[j];
					shuffledList[j]=shuffledList[j+1];
					shuffledList[j+1]=temp;
				}
			}
		}

		int[] rank5;
		if(count<5) {
			rank5=new int[count];
		}else {
			rank5=new int[5];
		}
		System.out.println("idList");
		for(int num:idList) {
			System.out.print(num);
		}
		System.out.println();
		System.out.println("suffledList");
		for(int numk:shuffledList) {
			System.out.print(numk);
		}
		System.out.println("");
		for(int i=0;i<rank5.length;i++) {
			int stop=0;
			for(int j=0;j<count;j++) {
				if(idList[j]==shuffledList[i]&&stop==0) {
					rank5[i]=j+1;
					idList[j]=0;
					stop++;
				}

			}
				if(shuffledList[i]>0) {
					Drink d=func.findDrink(rank5[i]);
					System.out.println(i+1+"/  "+"ID "+d.getId()+":"+d.getName()+"("+shuffledList[i]+")");
				}



		}



	}




}
