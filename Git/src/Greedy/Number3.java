package Greedy;

public class Number3 {

	public static void main(String[] args) {
		System.out.println(solution("JCAAAC"));

	}
	public static int solution(String name) {
		 // 1. ��, �Ʒ� �ּ� �̵�!
        int ans = 0;
        for(int i = 0 ; i < name.length() ; i++) {
            if(name.charAt(i)!= 'A') {
                int up = name.charAt(i) - 'A';
                int down = 1 + 'Z' - name.charAt(i);
                ans += (up < down)? up : down;
            }
        }
        
        // 2. A �ƴ� ��� ���ڸ� �鸱 �� �ִ� �ּ� �¿� �̵� 
        // ��� ��ġ���� ������ ���ư��� ��� �ּҸ� ã�´�. 
        int minMove = name.length() - 1;
        for(int i = 0 ; i < name.length() ; i++) {
            if(name.charAt(i) != 'A') {
                int next = i+1;
                while(next < name.length() && name.charAt(next) == 'A') {
                    next++;
                }
                int move = 2 * i + name.length() - next;
                minMove = Math.min(move, minMove);
            }
        }
        
        return ans + minMove;
    }

}
