package test;


public interface Job {
	public void work(); 
	public default void getMoney(int money) {
		
	}
	public static void main(String[] args) {
		System.out.println("한글이 깨져요!");
		System.out.println("한글이 깨져요!");
	}
}
