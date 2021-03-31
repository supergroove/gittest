import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodingTest {

	private void test1() {
//		String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa" };
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
//		String[] completion = { "josipa", "filipa", "marina", "nikola" };
		String[] completion = { "stanko", "ana", "mislav" };

		String answer = "";
//        String temp = "";
//        
//        Arrays.sort(participant);
//        Arrays.sort(completion);
//        
//        int i = 0;
//        
//        while(i < completion.length){
//            if(!completion[i].equals(participant[i])){
//                temp = participant[i];
//                break;
//            }else{
//                i++;
//            }
//        }
//        
//        if(!temp.equals("")){
//            answer = temp;
//        }else{
//            answer = participant[participant.length-1];
//        }
		
		
		
		HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) {
        	System.out.println(hm.getOrDefault(player, 0) + 1);
            hm.put(player, hm.getOrDefault(player, 0) + 1);
        }
        for (String player : completion) {
        	System.out.println("# : "+hm.get(player));
            hm.put(player, hm.get(player) - 1);
        }
        for (String key : hm.keySet()) {
        	System.out.println("> : "+key + " : " + hm.get(key));
        	if (hm.get(key) != 0){
                answer = key;
            }
        }
        
        System.out.println(answer);
	}
	
	private void test2() {
		String[] phone_book = { "123","456","789" };
		boolean answer = true;
		
		for(String phone : phone_book) {
			for(String phoneStart : phone_book) {
				if(!phone.equals(phoneStart)) {
					if(phoneStart.startsWith(phone)) {
						answer =  false;
					}
				} 
			}
		}
		System.out.println(answer);
	}
	
	private void test3() {
		String[][] clothes = {
				{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}
		}; 
		
		Map<String, Integer> map = new HashMap<String, Integer> ();
		for(int i = 0; i < clothes.length; i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
		}
		for(String key : map.keySet()) {
			
		}
	}
	
	
	private void id() {
		String new_id = "...!@123BaT#*..y._ab-cdefghijklm";
		String answer = "";
		
		answer = new_id.toLowerCase().replaceAll("[^a-z\\d\\-_.]*", "").replaceAll("[^\\w\\-_.]*", "");
		System.out.println("### : "+answer);
		
		String tmpId = new_id.toLowerCase();
		
		Pattern p = Pattern.compile("[^a-z0-9\\._-]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(tmpId);
		String result = m.replaceAll("").replaceAll("\\.{2,}",  ".").replaceAll("^[.]|[.]$", "");
		
		if(result.length() >= 16)
		{
			result = result.substring(0, 15);
			
			result = result.replaceAll("[.]$", "");
		}
		System.out.println(result);
	}
	
	private void level1_1() {
//		int[] numbers = {2,1,3,4,1};
		int[] numbers = {5,0,2,7};
		
		List<Integer> list = new ArrayList<Integer> ();
		
		for(int i = 0; i < numbers.length; i++) {
			for(int j = i + 1; j < numbers.length; j++) {
				if(!list.contains(numbers[i] + numbers[j]))
					list.add(numbers[i] + numbers[j]);
			}
		}
			
		Collections.sort(list);
		
		for(int n : list) {
			System.out.println(n);
		}
//		Arrays.copyOfRange
//		String[] array = list.toArray(new int[list.size()]);
		int[] array = list.stream().mapToInt(i->i).toArray();

	}
	
	private void level1_2() {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		
		int answer = 0;
		
		Stack<Integer> basket = new Stack<Integer> ();
		for(int m : moves) {
			for(int i = 0; i < board.length; i++) {
				if(board[i][m - 1] == 0) {
					continue;
				} else {
					if(!basket.isEmpty() && board[i][m - 1] == basket.peek()) {
						answer += 2;
						basket.pop();
					} else {
						basket.add(board[i][m - 1]);
					}
					board[i][m - 1] = 0;
					break;
				}
			}
		}
		
		
//		List<Integer> outList = new ArrayList<Integer> ();
		
//		for(int i = 0; i < moves.length; i++) {
//			for(int j = board.length; j >= 0; j--) {
//				
//				int col = moves[i];
//				
//				System.out.println(i + ":" + j);
//				outList.add(board[j - 1][col]);
//				
////				if(outList.size() == 0) {
////					outList.add(board[i]);
////				} else {
////					
////				}
//			} 
//		}
//		
//		System.out.println(outList.toString());
		
//		int cols = board.length;
//		int rows = board[0].length;
//		
//		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>> (); 
//		
		List<Integer> inList = null;
		
		for(int i = 0; i < board.length; i++) {
			inList = new ArrayList<Integer> ();
			for(int j = 0; j < board[0].length; j++) {
				
			}
		}
		
		
		
		
		
//		for(int i = 0; i < board.length; i++) {
//			for(int j = 0; j < board[i].length; j++) {
//				
//			}
//		}
//		
//		System.out.println(cols + ":" + rows);
	}
	
	private void level1_5() {
		int[] answer = {};
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		List<Integer> tmp = null;
		List<Integer> result = new ArrayList<Integer> ();
		
		for(int i = 0; i < commands.length; i++) {
			tmp = new ArrayList<Integer> ();
			for(int j = commands[i][0] - 1; j <= commands[i][1] - 1; j++) {
				tmp.add(array[j]);
			}
			Collections.sort(tmp);
			result.add(tmp.get(commands[i][2] - 1));
		}
		
		answer = result.stream().mapToInt(i->i).toArray();
	}
	

	public static void main(String[] args) {
		CodingTest code = new CodingTest();
//		code.test1();
//		code.test2();
//		code.test3();
//		code.id();
		
//		code.level1_2();
		code.level1_5();
	}

}
