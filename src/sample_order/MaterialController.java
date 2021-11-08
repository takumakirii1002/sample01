package sample_order;

import java.util.ArrayList;

public class MaterialController {

	Input scan;
	DBFunction func;

	public MaterialController(DBFunction func) {
		scan=new Input();
		this.func=func;
	}
	public Material selectMaterial() {
		Material mate=new Material();
		int materialCount=outMaterialList();

		if(materialCount!=0){
			System.out.println("");
			int select = scan.inputInt();
			mate = func.findMaterial(select);
		}
		return mate;
	}
	public int outMaterialList() {
		int count=0;
		ArrayList<Material> list=new ArrayList<Material>();

		int select=selectTypeToOut();
		switch(select) {
		case 1:
			list=func.findAllMaterial();
			break;
		case 2:
			list=func.findSpiritsMaterial();
			break;
		case 3:
			list=func.findLiqoursMaterial();
			break;
		case 4:
			list=func.findSoftdrinksMaterial();
			break;
		case 5:
			list=func.findOtherMaterial();
			break;
		}
		for(Material mate:list) {
			outMaterial(mate);
			count++;
		}
		System.out.println(count+"　件の表示");

		return count;
	}
	public void outMaterial(Material mate) {
		System.out.println(mate.getId()+" : "+mate.getName()+" ("+mate.getType()+")");
	}

	public int selectTypeToOut() {
		System.out.println("１：すべて表示する　２：spirit　３：liquor ４：softdrink 5:other");
		int select=scan.inputInt(5);
		return select;
	}
	public String selectTypeToSet() {
		String selectedType=null;
		String[] typeList= {"spirit","liqour","softdrink","other"};
		for(int i=1;i<=typeList.length;i++) {
			System.out.print(i+":"+typeList[i-1]+" ");
		}
		int select=scan.inputInt("type",typeList.length);
		selectedType=typeList[select];
		return selectedType;

	}
	public boolean postMaterial() {
		boolean result=false;
		Material postMate=new Material();

		System.out.println("材料情報の登録");
		postMate.setName(scan.inputString("名前"));
		postMate.setType(selectTypeToSet());
		System.out.println("");
		System.out.println("名前 :"+postMate.getName()+" / "+"type :"+postMate.getType());
		System.out.println("１：この内容で登録する　２：キャンセル");
		int decide=scan.inputInt();
		if(decide==1) {
			result=func.registMaterial(postMate);
		}
		return result;
	}


}
