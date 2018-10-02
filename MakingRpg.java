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

		Justice[] hero = new Justice[3];

		hero[0] = new Justice("ゆうたろう", 50, "Hero");
		hero[1] = new Justice("らいあん", 50, "Warrior");
		hero[2] = new Justice("そうりょ子", 40, "Monk", 10);

		Monster[] goblin = new Monster[3];
		goblin[0] = new Monster("ごぶりん男", 70);
		goblin[1] = new Monster("ごぶりん子", 60);
		goblin[2] = new Monster("ギガンテス", 60);

		System.out.println("・・・・・・・・・！");
		goblin[0].appear();
		goblin[1].appear();
		goblin[2].appear();

		System.out.println("  戦闘開始  ");
		justiceHP = 0;
		for (int i = 0; i < hero.length; i++) {
			justiceHP += hero[i].getHp();
		}
		monsterHP = 0;
		for (int i = 0; i < goblin.length; i++) {
			monsterHP += goblin[i].getHp();
		}

		while (true) {
			System.out.println(turn + " ターン");
			System.out.println("monsterPartyHP" + monsterHP + "JusticePartyHP" + justiceHP);
			// ☆ Hero Stage
			do {
				if (hero[whichHero].getHp() <= 0) {
					System.out.println(hero[whichHero].getName() + "は動けない");
					break;
				}
				do {
					seed = new Random().nextInt(3);
				} while (goblin[seed].getHp() < 0);

				if (whichHero == 2) {
					hero[2].heal(hero, seed);
					break;
				}
			} while (!hero[whichHero].attack(hero, whichHero, goblin, seed));

			monsterHP = 0;
			for (int i = 0; i < goblin.length; i++) {
				monsterHP += goblin[i].getHp();
			}
			if (monsterHP <= 0) {
				break;
			}
			// ★Monster Stage
			do {
				if (goblin[whichMon].getHp() <= 0) {
					System.out.println(goblin[whichMon].getName() + "は動かない");
					break;
				}
				do {
					seed = new Random().nextInt(3);
				} while (hero[seed].getHp() < 0);

			} while (!goblin[whichMon].attack(goblin, whichMon, hero, seed));
			justiceHP = 0;
			for (int i = 0; i < hero.length; i++) {// 相手パーティーの合計ＨＰが0だったらGAMEOVER
				justiceHP += hero[i].getHp();
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
