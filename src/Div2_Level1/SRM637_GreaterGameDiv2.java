package Div2_Level1;

public class SRM637_GreaterGameDiv2 {
	public int calc(int[] snuke, int[] sothe) {
		int result = 0;
		for (int digitIndex = 0; digitIndex < sothe.length; digitIndex++) {
			if(snuke[digitIndex] > sothe[digitIndex]) {
				result++;
			}
		}
		return result;
	}
}
