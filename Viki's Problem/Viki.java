import java.util.Scanner;

public class Viki {

	private static final int REST_PEROID_1 = 1;
	private static final int REST_PEROID_2 = 2;
	private static final int REST_PEROID_3 = 3;

	private static final int JUMP_DISTANCE_5 = 5;
	private static final int JUMP_DISTANCE_3 = 3;
	private static final int JUMP_DISTANCE_1 = 1;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the amount of Distance(m) Viki has to travel :");

		int distance = s.nextInt();
		jump(distance);
	}

	public static void jump(int distance) {
		jump(distance, REST_PEROID_3, 0);
	}

	private static void jump(int distance, int previousRest, int timeElapsed) {

		if (distance <= 0) {
			if (distance == 0) {
				timeElapsed -= previousRest;
			}
			System.out.println("It would take " + timeElapsed + " seconds for Viki to complete the distance.");
			return;
		}

		switch (previousRest) {
			case REST_PEROID_3:
				distance -= JUMP_DISTANCE_5;
				timeElapsed += REST_PEROID_1;
				jump(distance, REST_PEROID_1, timeElapsed);
				break;
			case REST_PEROID_1:
				distance -= JUMP_DISTANCE_3;
				timeElapsed += REST_PEROID_2;
				jump(distance, REST_PEROID_2, timeElapsed);
				break;
			case REST_PEROID_2:
				distance -= JUMP_DISTANCE_1;
				timeElapsed += REST_PEROID_3;
				jump(distance, REST_PEROID_3, timeElapsed);
				break;
		}
	}
}