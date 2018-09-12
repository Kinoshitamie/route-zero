package MakingRPG;

//Character subclass
public class Monster extends Character {
	Monster(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}

	public void appear() {
		System.out.println(this.name + "‚ªŒ»‚ê‚½I");
	}

	public void damage(Character ch) {
		this.hp -= ch.power;
		System.out.println(this.name + "‚ÌHP" + this.hp);
		System.out.println(this.name+"‚Í“¦‚°o‚µ‚½");
	}
}
