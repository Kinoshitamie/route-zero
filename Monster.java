package MakingRPG;

//Character subclass
public class Monster extends Character {
	//親モンスタークラスから子モンスターをつくることにする
	
	Monster(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}

	public void appear() {
		System.out.println(this.name + "が現れた！");
	}

	public void damage(Character ch) {
		this.hp -= ch.power;
		System.out.println(this.name + "のHP" + this.hp);
		
	}
}
