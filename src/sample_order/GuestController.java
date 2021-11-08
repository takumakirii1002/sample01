package sample_order;

public class GuestController {
	Input scan;
	DBFunction func;

	public GuestController(DBFunction func) {
		this.func=func;
		scan=new Input();
	}
	public Guest selectGuest() {
		int select=scan.inputInt("選択するゲストのID");
		Guest g=func.findGuest(select);
		return g;
	}

	public Guest postGuest() {
		boolean result;
		Guest lastGuest=new Guest();
		Guest postGuest=new Guest(scan.inputString("名前"),scan.inputInt("年齢"),scan.inputString("性別【 m or f】"),scan.inputString("メモ"));
		outGuest(postGuest);
		System.out.println("１：この内容で登録する　２：取り消す");
		int decide=scan.inputInt();
		if(decide==1) {
			result=func.registGuest(postGuest);
			if(result) {
				lastGuest=func.lastGuest();
				System.out.println(lastGuest.getId()+" : "+lastGuest.getName()+"を登録しました");
			}else {
				System.out.println("登録に失敗しました");
			}
		}else if(decide==2) {

		}

		return lastGuest;
	}
	public boolean postGuest(Guest postGuest) {
		boolean result;
		result=func.registGuest(postGuest);

	return result;
	}
	public void outGuestList() {
		int count=0;
		for(Guest g:func.findAllGuest()) {
			System.out.print(g.getId()+": "+g.getName()+"  ");
			count++;
			if(count%3==0) {
				System.out.println("");
			}
		}
		System.out.println("");
		System.out.println(count+" 件の表示");

	}
	public void outGuest(Guest g){
		System.out.println("");
		System.out.println(g.getId()+": "+g.getName()+"("+g.getAge()+") :"+g.getSex());
		System.out.println("（メモ）　"+g.getMemo());
	}
	public boolean updateGuest(Guest g) {
		int decide;
		boolean result=false;
		Guest clone;
		try {
				clone=g.clone();
			do {
				System.out.println("[１：name　２：age　３：sex　４：memo ]");
				int column=scan.inputInt("変更する項目");
				switch(column) {
					case 1:
						System.out.println("（変更前）"+g.getName());
						clone.setName(scan.inputString("(変更後)　name"));
						break;
					case 2:
						System.out.println("（変更前）"+g.getAge());
						clone.setAge(scan.inputInt("(変更後)　age"));
						break;
					case 3:
						System.out.println("(変更前)"+g.getSex());
						clone.setSex(selectSex("(変更後)　"));
						break;
					case 4:
						System.out.println("（変更前）"+g.getMemo());
						clone.setMemo(scan.inputString("（変更後）　memo"));
						break;
				}
				outGuest(clone);
				System.out.println("[1:変更を完了する　２：続けて変更する ３：変更をやめる]");
					decide=scan.inputInt();
					if(decide==1) {
						result=func.updateGuest(clone);
						if(result) {
							System.out.println("正常に処理しました");
						}else {
							System.out.println("処理に失敗しました");
						}
					}else if(decide==2){
						result=false;
					}else if(decide==3) {
						result=true;
					}

				}while(!result);
			}catch(CloneNotSupportedException e) {
					System.out.println(e.getMessage());
				}
		return result;
	}
	public String selectSex() {
		String sexString=null;
		int sexInt=0;
		boolean loop=true;
		System.out.println("[1:男性　　2:女性]");
		sexInt=scan.inputInt();
		if(sexInt==1) {
			sexString="男性";
			loop=false;
		}else if(sexInt==2) {
			sexString="女性";
			loop=false;
		}else {
			System.out.println("1か2を入力して選択してください");
			loop=true;
		}
		return sexString;
	}
	public String selectSex(String s) {
		String sexString=null;
		int sexInt=0;
		boolean loop=true;
		System.out.println(s+"[1:男性　　2:女性]");
		sexInt=scan.inputInt();
		if(sexInt==1) {
			sexString="男性";
			loop=false;
		}else if(sexInt==2) {
			sexString="女性";
			loop=false;
		}else {
			System.out.println("1か2を入力して選択してください");
			loop=true;
		}
		return sexString;
	}



}