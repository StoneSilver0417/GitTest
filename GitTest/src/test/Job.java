
public interface Job {
	public void work(); 
	public default void getMoney(int money) {
		System.out.println(money + "을 받음");
		System.out.println("hi");
		System.out.println("hi");
		System.out.println("hi");
		System.out.println("수정햇다");

	}

}
