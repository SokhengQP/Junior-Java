interface User {
	public void animalHead();

	public void animalTail();
}

class Cat implements User {

	@Override
	public void animalHead() {
		System.out.println("Head");
	}

	@Override
	public void animalTail() {
		System.out.println("Tail");
	}
}

public class Main {
	public static void main(String[] args) {
		Cat pet = new Cat();

		pet.animalHead();
		pet.animalTail();
	}
}
