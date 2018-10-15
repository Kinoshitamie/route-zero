package rpgif;

/*
 * Main
 */
import java.util.*;

public class MakingRpg {
	public static void main(String[] args) {
		int justiceHP;
		int monsterHP;
		int turn = 1;
		int whichHero = 0;
		int whichMon = 0;

		int seed;
		int party_people = 3; // partyの人数のこと

		Movable hero;
		Movable against;

		Movable[] justice_party = new Movable[party_people];
		Movable[] monster_party = new Movable[party_people];

		Justice hero1 = new Justice("ゆうたろう", 50, "Hero");
		Justice hero2 = new Justice("らいあん", 50, "Warrior");
		Monk monk = new Monk("そうりょ子", 40, 10);
		Dancer dancer = new Dancer("まーにゃ", 30);
		Mob mob = new Mob(); // 王様も参加

		justice_party[0] = hero1;
		justice_party[1] = hero2;
		justice_party[2] = monk;

		Monster goblin1 = new Monster("ごぶりん男", 70);
		Monster goblin2 = new Monster("ごぶりん子", 60);
		Monster goblin3 = new Monster("ギガンテス", 60);
		//Monster goblin4 = new Monster("さぼてんだー", 20);待機

		monster_party[0] = goblin1;
		monster_party[1] = goblin2;
		monster_party[2] = goblin3;
		//monster_party[3] = goblin4;

		System.out.println("・・・・・・・・・！");
		goblin1.appear();
		goblin2.appear();
		goblin3.appear();
	//	goblin4.appear();

		System.out.println("  戦闘開始  ");
		// 各パーティーHP合計( 王様、Dancerはのぞく)
		justiceHP = 0;
		for (int i = 0; i < justice_party.length; i++) {
			justiceHP += ((Character) justice_party[i]).getHp(); // キャスト
		}
		monsterHP = 0;
		for (int i = 0; i < monster_party.length; i++) {
			monsterHP += ((Character) monster_party[i]).getHp();
		}

		// battle
		while (justiceHP > 0 || monsterHP > 0) {
			System.out.println("  ★ " + turn + " ターン");

			// ☆ Hero Stage
			do {
				System.out.println("MONSTER-HP" + monsterHP + ":HERO-HP" + justiceHP);
				if (((Character) justice_party[whichHero]).life_flg == false) { // キャスト
					System.out.println(((Character) justice_party[whichHero]).getName() + "は動けない");
					break;
				}
				// HPが0ではないCharacterをランダム
				hero = justice_party[whichHero];

				if (whichHero == 2) {
					// monkだと味方回復魔法
					do {
						seed = new Random().nextInt(party_people);
					} while (((Character) justice_party[seed]).getHp() <= 0);
					against = justice_party[seed];

				} else {
					// それ以外の職業は敵攻撃
					do {
						seed = new Random().nextInt(party_people);
					} while (((Character) monster_party[seed]).getHp() <= 0);

					against = monster_party[seed];

				}
				hero = justice_party[whichHero];
				if (turn % 2 == 1) {
					dancer.move((Character) hero);
				} else {

					mob.move((Character) against);
				}
			} while (!hero.move((Character) against));

			// モンスターパーティＨＰチェック
			monsterHP = 0;
			for (int i = 0; i < monster_party.length; i++) {
				monsterHP += ((Character) monster_party[i]).getHp();
			}
			if (monsterHP <= 0) {
				break;
			}

			// ★Monster Stage
			do {
				if (((Character) monster_party[whichMon]).life_flg == false) {
					System.out.println(((Character) monster_party[whichMon]).getName() + "は動かない");
					break;
				}
				do {
					seed = new Random().nextInt(party_people);

				} while (((Character) justice_party[seed]).getHp() <= 0);

				against = monster_party[whichMon];

				hero = justice_party[seed];

			} while (!against.move((Character) hero));

			// HERO Party HP Check
			justiceHP = 0;
			for (int i = 0; i < justice_party.length; i++) {
				justiceHP += ((Character) justice_party[i]).getHp(); // キャスト
			}
			if (justiceHP <= 0) {
				break;
			}

			// 順番交代
			whichHero += 1;
			if (whichHero > party_people - 1) {
				whichHero = 0;
			}
			whichMon += 1;
			if (whichMon > party_people-1) {
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
