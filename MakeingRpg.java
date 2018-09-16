package rpg3;

import java.util.*;

public class MakeingRpg {

	public static void main(String[] args) {
		int justiceHP;
		int monsterHP;
		int turn = 1;
		int whichHero = 0;
		int whichMon = 0;
		int seed;
		
		Justice[] hero = new Justice[2];
		hero[0] = new Justice("ゆうたろう", 50, "Hero");
		hero[1] = new Justice("らいあん", 50, "Warrior");

		Monster[] goblin = new Monster[2];
		goblin[0] = new Monster("ごぶりん男", 70);
		goblin[1] = new Monster("ごぶりん子", 60);

		System.out.println("・・・・・・・・・！");
		goblin[0].appear();
		goblin[1].appear();
		System.out.println("  戦闘開始  ");
		justiceHP = hero[0].getHp() + hero[1].getHp();
		monsterHP = goblin[0].getHp() + goblin[1].getHp();
		
		do {
			System.out.println(turn + "ターン");

			// Hero Stage
			do {
				seed = new Random().nextInt(2);			
				if (goblin[seed].getHp() >0) {
					break;
				}
			} while (goblin[seed].getHp() <= 0);

			if (!(hero[whichHero].getHp() <= 0)) {
				hero[whichHero].attack(goblin[seed]);
				System.out.println(hero[whichHero].getName() + "の攻撃！！");
				System.out.println(goblin[seed].getName() + "は" + hero[whichHero].getPower() + "のダメージを受けた（残りHP "+goblin[seed].getHp()+")");
			} else {
				System.out.println(hero[whichHero].getName() + "は動けない！");
			}
			monsterHP = goblin[0].getHp() + goblin[1].getHp();
			if (monsterHP <= 0) {
				break;
			}
			// Monster Stage
			do {
				seed = new Random().nextInt(2);
				if (hero[seed].getHp() > 0) {
					break;
				}
			} while (hero[seed].getHp() <= 0);

			if (!(goblin[whichMon].getHp() <= 0)) {
				goblin[whichMon].attack(hero[seed]);
				System.out.println(goblin[whichMon].getName() + "の攻撃！！");
				System.out.println(hero[seed].getName() + "は" + goblin[whichMon].getPower() + "のダメージを受けた（残りHP "+hero[seed].getHp()+")");
			} else {
				System.out.println(goblin[whichMon].getName() + "　は動けない！");
			}

			justiceHP = hero[0].getHp() + hero[1].getHp();
			if (justiceHP <= 0) {
				break;
			}

			//　   順番交代
			whichHero += 1;
			if (whichHero > 1) {
				whichHero = 0;
			}
			whichMon += 1;
			if (whichMon > 1) {
				whichMon = 0;
			}
			turn++;
		} while (justiceHP > 0 || monsterHP > 0);

		if (justiceHP < monsterHP) {
			System.out.println("勇者達は全滅した");
		} else {
			System.out.println("モンスター達をやっつけた！");

		}
	}

}
