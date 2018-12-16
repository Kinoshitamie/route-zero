package rpgif;

/*
 * class Mob
 */
public class Mob implements Movable {
	static String name;
	protected boolean win_low;

	Mob() {
		name = "王様";
		System.out.println("私は" + name + "だ!");
	}

	@Override
	public boolean move(Character tagert) { 
		Dignity(tagert);
		return true;
	}

	public void Dignity(Character tagert) {
		System.out.println("王様は" + tagert.getName() + "を威圧した！が何も起こらなかった！");
	}

}
