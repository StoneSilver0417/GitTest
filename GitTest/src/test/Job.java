
public interface Job {
	public void work(); 
	public default void getMoney(int money) {
		System.out.println(money + "À» ¹ÞÀ½");

		System.out.println(money + "À» ¹ÞÀ½");
=======
		System.out.println("hi");
		System.out.println("hi");
		System.out.println("hi");
		System.out.println("¼öÁ¤ÇÞ´Ù");

>>>>>>> master
	}

}
