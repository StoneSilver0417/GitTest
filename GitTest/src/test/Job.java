package test;


public interface Job {
	public void work(); 
	public default void getMoney(int money) {
		
	}
	public static void main(String[] args) {
		System.out.println("�ѱ��� ������!");
		System.out.println("�ѱ��� ������!");
	}
}
