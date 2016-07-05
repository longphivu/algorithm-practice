package Colidity.PrefixSum;

public class GenomicRangeQuery {
	public int[] solution(String S, int[] P, int[] Q) {
		int len = S.length();
		int[][] lastSeen = new int[4][len];
		for (int i = 0; i < len; i++) {
			int nucleo;
			if (S.charAt(i) == 'A')
				nucleo = 0;
			else if (S.charAt(i) == 'C')
				nucleo = 1;
			else if (S.charAt(i) == 'G')
				nucleo = 2;
			else
				nucleo = 3;
			markSeenHelper(lastSeen, nucleo, i);
		}

		int from, to = -1;
		int[] solution = new int[P.length];
		for (int i = 0; i < P.length; i++) {
			from = P[i];
			to = Q[i];
			if (lastSeen[0][to] >= from)
				solution[i] = 1;
			else if (lastSeen[1][to] >= from)
				solution[i] = 2;
			else if (lastSeen[2][to] >= from)
				solution[i] = 3;
			else
				solution[i] = 4;
		}

		return solution;
	}

	public void markSeenHelper(int[][] lastSeen, int nucleo, int idx) {
		for (int i = 0; i < 4; i++) {
			if (nucleo - 1 == i) {
				lastSeen[i][idx] = idx;
			} else {
				lastSeen[i][idx] = (idx == 0) ? -1 : lastSeen[i][idx - 1];
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
