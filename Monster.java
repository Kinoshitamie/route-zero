package MakingRPG;

//Character subclass
public class Monster extends Character {
	Monster(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}

	public void appear() {
		System.out.println(this.name + "�����ꂽ�I");
	}

	public void damage(Character ch) {
		this.hp -= ch.power;
		System.out.println(this.name + "��HP" + this.hp);
		System.out.println(this.name+"�͓����o����");
	}
}
