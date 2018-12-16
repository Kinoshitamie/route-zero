package rpgif;

public class Dancer implements Movable {

	static String name;
	static String Job_name = "Dancer";
	static int power = 2;
	protected

	static int hp;

	Dancer(String name, int hp) {
		Dancer.name = name;
		Dancer.hp = hp;
		introduce();
	}

	@Override
	public boolean move(Character target) { // なにをかえす？？
		dance(target);
		return true;
	}

	public void dance(Character target) {
		System.out.println(name + "は、" + target.name + "にぱふぱふした！");
		target.hp = target.hp + power;
		System.out.println(target.name + "は、なんか元気になった！");
	}

	public void introduce() {
		System.out.println("私は" + name + "！" + Job_name + "よん!");
	}

}
