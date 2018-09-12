package MakingRPG;

import java.util.Scanner;

public class MakeingRpg {

	public static void main(String[] args) {
		boolean flg = true;
		
		Hero hero = new Hero("ゆうたろう", 150, "Hero");	
		Wizard wizard = new Wizard("そーにゃ", 100, 80, "Wizard");
		System.out.println("チームの所持金" + Character.money + "です");
		System.out.println("・・・・・・・・・！");
		Monster monster = new Monster("ごぶりん", 50);

		monster.appear();
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("どうしますか?");
			System.out.println("1：たたかう 2：まもる 3：逃げる");
			int action = scan.nextInt();
			switch (action) {
			case 1:
				hero.attack(monster);
				monster.damage(hero);
				wizard.magic(monster);
				monster.damage(wizard);
				flg = false;
				break;
			case 2:
				System.out.println(hero.name + "達は身を守った!");
				flg = false;
				break;
			case 3:
				System.out.println(hero.name + "達は逃げ出した!");
				flg = false;
				break;
			default:
				System.out.println("1～3で入力して");
			}

		} while (flg);
		// Shopping static 変数
		System.out.println("・・・・・・・・・！");
		hero.shopping(hero);
		System.out.println(hero.name + "はお買い物をしたので所持金が" + hero.money + "に！");//?hero.moneyであってる？
		wizard.shopping(wizard);
		System.out.println(wizard.name + "はお買い物をしたので所持金が" + wizard.money + "に！");
		// end
		System.out.println("ひとまずend");
		scan.close();

	}

}
