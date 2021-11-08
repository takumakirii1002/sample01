package sample_order;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		DBConnection db=new DBConnection();
		DBFunction func=new DBFunction(db);

		GuestController guestCont=new GuestController(func);
		DrinkController drinkCont=new DrinkController(func);
		HistoryController historyCont=new HistoryController(func);
		MaterialController materialCont=new MaterialController(func);

		String line="*********************";
		Input scan=new Input();
		boolean mainLoop=true;

		while(mainLoop) {
			System.out.println("1:新規オーダー "+"2:顧客メニュー "+"3:ドリンクメニュー "+"4:材料メニュー "+"5:履歴メニュー "+"６:閉じる");
			int i=scan.inputInt(6);
			if(i==1) {
				System.out.println("*********************");
				System.out.println("　　オーダー　");
				System.out.println("");
				Guest guest=new Guest();
				Drink drink=new Drink();
				boolean guestIsExist=func.guestIsExist();
				boolean drinkIsExist=func.drinkIsExist();
				boolean newOrderLoop=true;


				do {
					if(guestIsExist==true) {

							System.out.println("ゲストを選ぶ");
							System.out.println("");
							guestCont.outGuestList();
							boolean noGuestDate=true;
								do {
									guest=guestCont.selectGuest();
									if(guest.getName()==null) {
										System.out.println("該当するデータがない　もう一度選択");
										System.out.println("");
										noGuestDate=true;
									}else {
										noGuestDate=false;
									}
								}while(noGuestDate);

							if(drinkIsExist==true) {
								System.out.println(guest.getName()+": ドリンクを選ぶ");
								System.out.println("");
								drinkCont.outDrinkList();
								boolean noDrinkDate=true;

								do {
									drink=drinkCont.selectDrink();
									if(drink.getName()==null) {
										System.out.println("該当するデータがない　もう一度選択");
										System.out.println("");
										noDrinkDate=true;
									}else {
										noDrinkDate=false;
									}
								}while(noDrinkDate);

							}else {
								System.out.println("ドリンク情報がありません　新規登録してください");
								boolean post=drinkCont.postDrink();
								if(post) {
										drink=func.lastDrink();
										drinkCont.outDrink(func.lastDrink());
								}else{
									System.out.println("登録に失敗しました");
								}
							}
					}else {
						System.out.println("ゲストの情報がありません　新しく登録してください");
						guest=guestCont.postGuest();

						if(func.drinkIsExist()==true) {
							System.out.println(guest.getName()+"　：ドリンクを選ぶ");
							System.out.println("");
							drinkCont.outDrinkList();
							boolean noDrinkDate=true;

							do {
								drink=drinkCont.selectDrink();
								if(drink.getName()==null) {
									System.out.println("該当するデータがない　もう一度選択");
									System.out.println("");
									noDrinkDate=true;
								}else {
									noDrinkDate=false;
								}
							}while(noDrinkDate);

						}else {
							System.out.println("ドリンク情報がありません　新しく登録してください");
							boolean post=drinkCont.postDrink();
							if(post) {
								drink=func.lastDrink();
								drinkCont.outDrink(func.lastDrink());
							}
						}
					}
					System.out.println(guest.getName()+"  :  "+drink.getName()+"("+drink.getPrice()+")");
					System.out.println("１：この内容で履歴を残す　２：内容を変更する　３：履歴の登録をやめる");
					int decide=scan.inputInt(3);
					if(decide==1) {
						boolean success=func.registHistory(guest.getId(),drink.getId());
						if(success==true) {
							System.out.println("historyの登録に成功");
						}else {
							System.out.println("historyの登録に失敗");
						}
						newOrderLoop=false;
					}else if(decide==2) {
						newOrderLoop=true;
					}else if(decide==3) {
						newOrderLoop=false;
					}
				}while(newOrderLoop);



























			}else if(i==2) {
				//　顧客情報



				int menu=0;
				boolean guestLoop=true;

				do{
					System.out.println(line);
					System.out.println("（ゲストメニュー）１：追加　２：変更　３：検索　４：削除　５：メニューに戻る");
					menu=scan.inputInt(5);
					if(menu==1) {
						System.out.println("**ゲストの追加**");
						boolean postGuestLoop=true;
						do {
							Guest postGuest=new Guest(scan.inputString("名前"),scan.inputInt("年齢"),scan.inputString("性別【 m or f】"),scan.inputString("メモ"));
							guestCont.outGuest(postGuest);
							System.out.println("１：この内容で登録する　２：入力をやり直す　３：取り消して戻る");
							int decide=scan.inputInt(3);
							if(decide==1) {
								boolean success=guestCont.postGuest(postGuest);
								if(success==true) {
									System.out.println("正常に登録しました");
									System.out.println("");
									guestCont.outGuest(func.lastGuest());
									postGuestLoop=false;
								}else {
									System.out.println("登録に失敗しました。　１：入力をやり直す　２：やめる");
									int stop=scan.inputInt(2);
									if(stop==1) {
										postGuestLoop=true;
									}
								}


							}else if(decide==2) {
								postGuestLoop=true;
							}else if(decide==3) {
								postGuestLoop=false;
							}
						}while(postGuestLoop);


					}else if(menu==2){
						boolean isExist=func.guestIsExist();
						if(isExist==true) {
							System.out.println("（　顧客情報の変更　）。");

							guestCont.outGuestList();
							Guest targetGuest=guestCont.selectGuest();
							guestCont.outGuest(targetGuest);
							guestCont.updateGuest(targetGuest);
						}else {
							System.out.println("顧客情報がありません");
						}


					}else if(menu==3){

						int valueInt=0;
						String valueString=null;
						boolean searchLoop=true;

						do {
							ArrayList<Guest> list=new ArrayList<Guest>();
							System.out.println("1:条件で検索　２：一覧から検索　３：やめる");

							int search=scan.inputInt(3);
							if(search==1) {

								System.out.println("1:id 2:name　3:age 4:sex 5:戻る");
								int select=scan.inputInt("検索する項目",5);
								if(select!=5) {
									if(select==1) {
										valueInt=scan.inputInt("検索する条件");
										list=func.findGuestById(valueInt);
									}else if(select==2) {
										valueString=scan.inputString("検索する条件");
										list=func.findGuestByName(valueString);
									}else if(select==3) {
										valueInt=scan.inputInt("検索する条件");
										list=func.findGuestByAge(valueInt);
									}else if(select==4) {
										valueString=scan.inputString("検索する条件");
										list=func.findGuestBySex(valueString);
									}
									System.out.println("検索結果");

									int count=0;
									for(Guest g:list) {
										guestCont.outGuest(g);
										count++;
									}
									System.out.println(count+"件の表示");
								}
							}else if(search==2) {

								guestCont.outGuestList();
								Guest targetGuest=guestCont.selectGuest();
								guestCont.outGuest(targetGuest);
							}else if(search==3) {
								searchLoop=false;
							}
						}while(searchLoop);

					}else if(menu==4){
						//call delete
						guestCont.outGuestList();
						System.out.println("");
						Guest toDelete=guestCont.selectGuest();
						guestCont.outGuest(toDelete);
						System.out.println("削除してしまうと復元できません");
						System.out.println("１：削除　２：やめる");
						int decide=scan.inputInt();
						if(decide==1) {
							func.deleteGuest(toDelete);
						}
					}else if(menu==5){
						System.out.println("メニューに戻ります　");
						guestLoop=false;
					}else{
						System.out.println("正しく入力してください");
					}


				}while(guestLoop);

			}else if(i==3) {
				System.out.println(line);
				boolean drinkLoop=true;
				int drinkMenu=0;
				do {
					System.out.println("（ドリンクメニュー）１：追加　　２：変更　　３：検索  ４：削除　　５：メニューに戻る");
					drinkMenu=scan.inputInt(5);
					switch(drinkMenu) {
					case 1:
						Drink lastDrink=new Drink();
						boolean hasPosted=drinkCont.postDrink();
						if(hasPosted) {
							lastDrink=func.lastDrink();
							System.out.println(lastDrink.getId()+" : "+lastDrink.getName()+"を登録しました");
						}else {
							System.out.println("登録に失敗しました");
						}

//ドリンク追加再考↓

						drinkCont.outDrink(func.lastDrink());
						break;
					case 2:
						System.out.println("(　ドリンク情報の変更　)");

						drinkCont.outDrinkList();
						Drink targetDrink=drinkCont.selectDrink();
						drinkCont.outDrink(targetDrink);
						drinkCont.updateDrink(targetDrink);

						break;
					case 3:
						System.out.println("（　ドリンク情報の検索　）");
						boolean searchLoop=true;

						do {
							int valueInt=0;
							String valueString=null;
							int search=0;
							ArrayList<Drink> list=new ArrayList<Drink>();


							System.out.println("1:条件で検索　2:一覧から検索　3；やめる");
							search=scan.inputInt(3);
							if(search==1) {
								System.out.println("1:id 2:名前 3:価格 4:ベース 5:材料１ 6:材料２ 7:材料３ 8:スタイル 9:グラス 10:もどる");
								int select=scan.inputInt("検索する項目",10);
								if(select!=10) {
									switch(select) {
										case 1:
											valueInt=scan.inputInt("検索する条件を");
											list=func.findDrinkById(valueInt);
											break;
										case 2:
											valueString=scan.inputString("検索する条件を");
											list=func.findDrinkByName(valueString);
											break;
										case 3:
											valueInt=scan.inputInt("検索する条件");
											list=func.findDrinkByPrice(valueInt);
											break;
										case 4:
											valueInt=scan.inputInt("検索する条件");
											list=func.findDrinkByBase(valueInt);
											break;
										case 5:
											valueInt=scan.inputInt("検索する条件");
											list=func.findDrinkByMate1(valueInt);
											break;
										case 6:
											valueInt=scan.inputInt("検索する条件");
											list=func.findDrinkByMate2(valueInt);
											break;
										case 7:
											valueInt=scan.inputInt("検索する条件");
											list=func.findDrinkByMate3(valueInt);
											break;
										case 8:
											valueString=scan.inputString("検索する条件を");
											list=func.findDrinkByStyle(valueString);
											break;
										case 9:
											valueString=scan.inputString("検索する条件を");
											list=func.findDrinkByGlass(valueString);
											break;
									}
									System.out.println("　　検索結果　　");
									int count=0;
									for(Drink drink:list) {
										drinkCont.outDrink(drink);
										count++;
									}
									System.out.println(count+"件の表示");
								}

							}else if(search==2) {
								drinkCont.outDrinkList();
								Drink toSearchDrink=drinkCont.selectDrink();
								System.out.println("　　検索結果　　");
								System.out.println("");
								drinkCont.outDrink(toSearchDrink);

							}else if(search==3) {
								searchLoop=false;
							}

						}while(searchLoop);
					break;
					case 4:
						System.out.println("削除はできない");
						break;
					case 5:
						drinkLoop=false;
					}
				}while(drinkLoop);


			}else if(i==4) {
				System.out.println(line);
				boolean materialLoop=false;
				int materialMenu=0;
				do {
					System.out.println("（　材料メニュー　）１：追加　　２：変更　　３：検索  ４：メニューに戻る");
					materialMenu=scan.inputInt(4);
					switch(materialMenu) {
					case 1:
						System.out.println("**材料情報の追加**");
						boolean post=materialCont.postMaterial();
						if(post) {
							System.out.println("正常に登録しました");
							materialCont.outMaterial(func.lastMaterial());
//postでループもできる。
						}else {
							System.out.println("登録に失敗しました");
						}
						break;
					case 2:
						System.out.println("**材料情報の変更**");
						boolean updateLoop=false;
						Material clone=new Material();
						materialCont.outMaterialList();
						Material targetMaterial=materialCont.selectMaterial();
						materialCont.outMaterial(targetMaterial);
						try {
							clone=targetMaterial.clone();
							do {
								System.out.println("1:name 2:type 3:やめる");
								int column=scan.inputInt("変更する項目",3);
								if(column!=3) {
									if(column==1) {
										System.out.println("変更前："+targetMaterial.getName());
										clone.setName(scan.inputString("変更後の名前"));
									}else if(column==2) {
										System.out.println("変更前："+targetMaterial.getType());
										clone.setType(materialCont.selectTypeToSet());
									}
									materialCont.outMaterial(clone);
									System.out.println("[1:変更を完了する　２：別の項目も変更する ３：変更をやめる]");
									int decide=scan.inputInt(3);
									if(decide==1) {
										boolean result=func.updateMaterial(clone);
										if(result) {
											System.out.println("正常に処理しました");
											materialCont.outMaterial(func.findMaterial(targetMaterial.getId()));
											updateLoop=false;
										}else {
											System.out.println("処理に失敗しました");
											updateLoop=true;
										}
									}else if(decide==2) {
										updateLoop=true;
									}else if(decide==3) {
										updateLoop=false;
									}
								}else {
									updateLoop=false;
								}
							}while(updateLoop);
						}catch(CloneNotSupportedException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 3:
						//材料情報検索
						//type分け：一覧から検索：名前で検索　の三つ

						break;
					case 4:
						materialLoop=false;
						break;
					}
				}while(materialLoop);

			}else if(i==5) {
				boolean historyLoop=true;
				do {
					System.out.println("（historyメニュー）　　１：会計　２:historyを検索　３：一覧表示　4：rannking 5:もどる");
					int historyMenu=scan.inputInt(5);
					if(historyMenu==1) {
						Guest g;
						System.out.println("(　会計　) guestを指定");
						historyCont.outHistoryList(func.findNotSettledHistoryByAsc());
						g=guestCont.selectGuest();
						historyCont.account(g);
					}else if(historyMenu==2) {

						System.out.println("1:ゲストを選んで検索　２:未会計のhistoryをすべて検索");
						int searchMenu=scan.inputInt(2);
						if(searchMenu==1) {
							guestCont.outGuestList();
							Guest selectGuest=guestCont.selectGuest();
							historyCont.outHistoryList(func.findHistoryByGuestId(selectGuest.getId()));
						}else if(searchMenu==2) {
							//絞り込み設定２の内容
							//未会計のhistory選択表示
							historyCont.outHistoryList(func.findNotSettledHistoryByAsc());

						}

					}else if(historyMenu==3) {
						//検索以外のhistoryメニュー拡張用
						//とりあえず一覧表示かな
						historyCont.outHistoryList(func.findAllHistory());

					}else if(historyMenu==4) {
						historyCont.ranking(func.findAllHistory());

					}else if(historyMenu==5) {
						historyLoop=false;
					}

				}while(historyLoop);


			}else if(i==6) {
				System.out.println("終了します");
				mainLoop=false;
				scan.close();
			}
		}
	}

}
