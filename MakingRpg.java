package rpg3;

import java.util.*;

public class MakingRpg {
	public static void main(String[] args) {
		int justiceHP;
		int monsterHP;
		int turn = 1;
		int whichHero = 0;
		int whichMon = 0;
		int seed;
		Character hero;
		Character against;

		Character[] justice_party = new Character[3];
		Character[] monster_party = new Character[3];

		Justice hero1 = new Justice("ゆうたろう", 50, "Hero");
		Justice hero2 = new Justice("らいあん", 50, "Warrior");
		Monk monk = new Monk("そうりょ子", 40, 10);

		justice_party[0] = hero1;
		justice_party[1] = hero2;
		justice_party[2] = monk;

		Monster goblin1 = new Monster("ごぶりん男", 70);
		Monster goblin2 = new Monster("ごぶりん子", 60);
		Monster goblin3 = new Monster("ギガンテス", 60);

		monster_party[0] = goblin1;
		monster_party[1] = goblin2;
		monster_party[2] = goblin3;

		System.out.println("・・・・・・・・・！");
		goblin1.appear();
		goblin2.appear();
		goblin3.appear();

		System.out.println("  戦闘開始  ");
		// パーティーごとのHP合計
		justiceHP = 0;
		for (int i = 0; i < justice_party.length; i++) {
			justiceHP += justice_party[i].getHp();
		}
		monsterHP = 0;
		for (int i = 0; i < monster_party.length; i++) {
			monsterHP += monster_party[i].getHp();
		}
		// battle
		while (justiceHP > 0 || monsterHP > 0) {
			System.out.println("  ★ " + turn + " ターン");

			// ☆ Hero Stage
			do {
				System.out.println("モンスターHP" + monsterHP + ":勇者達HP" + justiceHP);
				if (justice_party[whichHero].life_flg == false) {
					System.out.println(justice_party[whichHero].getName() + "は動けない");
					break;
				}
				// HPが0ではないCharacterをランダム
				hero = justice_party[whichHero];

				if (whichHero == 2) {
					// monkだと味方回復魔法
					do {
						seed = new Random().nextInt(3);
					} while (justice_party[seed].getHp() <= 0);
					against = justice_party[seed];
				} else {
					// それ以外の職業は敵攻撃
					do {
						seed = new Random().nextInt(3);
					} while (monster_party[seed].getHp() <= 0);
					against = monster_party[seed];
				}

			} while (!justice_party[whichHero].attack(against));

			// モンスターパーティＨＰチェック
			monsterHP = 0;
			for (int i = 0; i < monster_party.length; i++) {
				monsterHP += monster_party[i].getHp();
			}
			if (monsterHP <= 0) {
				break;
			}

			// ★Monster Stage
			do {
				if (monster_party[whichMon].life_flg == false) {
					System.out.println(monster_party[whichMon].getName() + "は動かない");
					break;
				}
				do {
					seed = new Random().nextInt(3);
				} while (justice_party[seed].getHp() <= 0);

				against = monster_party[whichMon];
				hero = justice_party[seed];

			} while (!monster_party[whichMon].attack(hero));

			// HERO Party HP Check
			justiceHP = 0;
			for (int i = 0; i < justice_party.length; i++) {
				justiceHP += justice_party[i].getHp();
			}
			if (justiceHP <= 0) {
				break;
			}

			// 順番交代
			whichHero += 1;
			if (whichHero > 2) {
				whichHero = 0;
			}
			whichMon += 1;
			if (whichMon > 2) {
				whichMon = 0;
			}
			turn++;
		}
		if (justiceHP < monsterHP) {
			System.out.println("・・・・・勇者達は全滅した");
		} else {
			System.out.println("！！モンスター達をやっつけた！！");

		}
	}
}
