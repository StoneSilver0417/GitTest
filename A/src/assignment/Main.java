package assignment;

public class Main {
	public static void main(String[] args) {
		Job job = new FireFighter();
		work(job);

		job = new Police();
		work(job);

		job = new Nurse();
		work(job);
	}

	private static void work(Job job) {
		job.work();

		if (job instanceof FireFighter) {
			FireFighter ff = (FireFighter) job;
			ff.getMoney(ff.money);
		} else if (job instanceof Police) {
			Police ff = (Police) job;
			ff.getMoney(ff.money);
			ff.work2();
		} else if (job instanceof Nurse) {
			Nurse ff = (Nurse) job;
			ff.getMoney(ff.money);
			ff.shot();
		}
	}
}
