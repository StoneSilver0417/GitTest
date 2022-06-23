package assignment;

public class Nurse implements Job {
	final int money = 100000;

	@Override
	public void work() {
		System.out.println("치료함");
	}

	public void shot() {
		System.out.println("주사를 놓음");
	}
}