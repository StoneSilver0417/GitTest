
public interface Job {
	public void work(); 
	public default void getMoney(int money) {
		System.out.println(money + "À» ¹ÞÀ½");
	}

}
