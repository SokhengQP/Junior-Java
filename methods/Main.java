public class Main {
	// private fields
	private final int id;
	private final String nickname;

	public Main(int id, String nickname) {
		this.id = id;
		this.nickname = nickname;
		// System.out.println(id + "\n" + nickname);
	}

	public int getId() {
		return id;
	}

	public String getNickname() {
		return nickname;
	}

	public void Spring() {

	}

	public static void main(String[] args) {
		Main info = new Main(2022378, "Zeng Nui");
		System.out.println("Nickname: " + info.getNickname());
		System.out.println("ID: " + info.getId());
	}
}
