package assignment;

public interface Job {
	public void work();

	public default void getMoney(int money) {
		System.out.println(money + "원을 받음");
	}
}