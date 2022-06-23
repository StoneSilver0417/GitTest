package assignment;

public class Police implements Job {
	final int money = 20000;

	@Override
	public void work() {
		System.out.println("범인을 잡음");
	}

	public void work2() {
		System.out.println("교통 정리");
	}
}