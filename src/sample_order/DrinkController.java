package sample_order;

public class DrinkController {
	DBFunction func;
	Input scan;

	public DrinkController(DBFunction func) {
		this.func=func;
		scan=new Input();
	}
	public Drink selectDrink() {
		int select=scan.inputInt("選択するドリンク");
		Drink d=func.findDrink(select);
		return d;
	}
	public boolean postDrink() {
		boolean result=false;
		MaterialController materialCont =new MaterialController(func);
		//未未　　材料リスト表示してインプットさせて配列に格納、材料の引数はそれを使う　未
		Drink postDrink=new Drink();
		postDrink.setName(scan.inputString("name"));
		postDrink.setPrice(scan.inputInt("price"));
		System.out.println("base選択");
		postDrink.setBase(materialCont.selectMaterial().getId());
		System.out.println("材料選択（１つ目）");
		postDrink.setMate1(materialCont.selectMaterial().getId());
		System.out.println("材料選択（２つ目）");
		postDrink.setMate2(materialCont.selectMaterial().getId());
		System.out.println("材料選択（３つ目）");
		postDrink.setMate3(materialCont.selectMaterial().getId());
		System.out.println("style選択");
		postDrink.setStyle(selectStyle());
		System.out.println("glass選択");
		postDrink.setGlass(selectGlass());
		System.out.println("memo");
		postDrink.setMemo(scan.inputString("メモ"));
		outDrink(postDrink);
		int decide=scan.inputInt("1:この内容で登録する　２：やめておく");
		if(decide==1) {
			result=func.registDrink(postDrink);
		}else {
			result=false;
		}

		return result;
	}
	public boolean postDrink(Drink d) {
		boolean result=false;
		Drink postDrink=d;
		result=func.registDrink(postDrink);

		return result;
	}
	public void outDrinkList() {
		int count=0;
		for(Drink d:func.findAllDrink()) {
			System.out.print(d.getId()+" : "+d.getName()+"  ");
			count++;
			if(count%3==0) {
				System.out.println("");
			}
		}
		System.out.println("");
		System.out.println(count+" 件");
	}
	public void outDrink(Drink d) {
		System.out.println(d.getId()+" : "+d.getName()+" ¥"+d.getPrice()+"");
		System.out.println("ベース："+d.getBase()+" 他：①"+d.getMate1()+"　②"+d.getMate2()+"　③"+d.getMate3()+"　（スタイル）"+d.getStyle()+"　（glass）"+d.getGlass());
		System.out.println("(メモ)："+d.getMemo());
	}

	public boolean updateDrink(Drink d) {
		boolean result=false;
		Drink clone;
		try {
			clone=d.clone();
			do {
				System.out.println("[1:name 2:price 3:base 4:mate1 5:mate2 6:mate3 7:style 8:glass 9:memo]");
				int column=scan.inputInt("変更する項目",9);
				switch(column) {
				case 1:
					System.out.println("（変更前）"+d.getName());
					clone.setName(scan.inputString("変更後のname"));
					break;
				case 2:
					System.out.println("（変更前）"+d.getPrice());
					clone.setPrice(scan.inputInt("変更後のprice"));
					break;
				case 3:
					System.out.println("(変更前)"+d.getBase());
					clone.setBase(scan.inputInt("変更後のベース"));
					break;
				case 4:
					System.out.println("（変更前）"+d.getMate1());
					clone.setMate1(scan.inputInt("変更後の材料１"));
					break;
				case 5:
					System.out.println("（変更前）"+d.getMate2());
					clone.setMate2(scan.inputInt("変更後の材料２"));
					break;
				case 6:
					System.out.println("（変更前）"+d.getMate3());
					clone.setMate3(scan.inputInt("変更後の材料３"));
					break;
				case 7:
					System.out.println("（変更前）"+d.getStyle());
					clone.setStyle(selectStyle());
					break;
				case 8:
					System.out.println("（変更前）"+d.getGlass());
					clone.setStyle(selectGlass());
					break;
				case 9:
					System.out.println("（変更前）"+d.getMemo());
					clone.setMemo(scan.inputString("変更後のメモ"));
					break;
			}

			}while(result);
		}catch(CloneNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	public String selectStyle() {
		String selectedStyle=null;
		String[] styleList= {"シェイク","ステア","ミキシング","ビルド","ロック"};
		for(int i=1;i<=styleList.length;i++) {
			System.out.print(i+":"+styleList[i-1]);
		}
		int select=scan.inputInt("スタイル",styleList.length);
		selectedStyle=styleList[select];
		return selectedStyle;
	}

	public String selectGlass() {
		String selectedGlass=null;
		String[] glassList= {"コリンズ","カクテル","ロック","タンブラー","ショット、ワイングラスなど"};
		for(int i=1;i<=glassList.length;i++) {
			System.out.print(i+":"+glassList[i-1]+" ");
		}
		int select=scan.inputInt("使用するグラス",glassList.length);
		selectedGlass=glassList[select];
		return selectedGlass;
	}
}