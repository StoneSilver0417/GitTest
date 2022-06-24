
public interface Job {
	public void work(); 
	public default void getMoney(int money) {
		System.out.println("한글이 깨져요!");
	}

}
