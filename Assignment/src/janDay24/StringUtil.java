package janDay24;

public class StringUtil {

	private static String replaceString(String[] arr) {
	
			
		int maxCount = 0;
		String maxCountstr = "";
		
		for(String p : arr) {//arr의 각 요소들을 p라고함
			int count = 0; //count 초기화
			
			for(int i = 0 ; i<p.length() ;i++) {
				char charAt = p.charAt(i);
					
				if(charAt == 'a') {
					count++; //n번의배열의 a의 카운트 갯수
				}				
			}
			p = p.replace('a','A');
			
		
			if(maxCount<count) {
				maxCount = count;
				maxCountstr = p;
				
			}
		}
		return maxCountstr;
	}
	
	public static void main(String[] args) {

		String[] arr = {"java program","array","java program area","append"};
		String result = StringUtil.replaceString(arr);
		System.out.println("변경된 문자열 : "+result);
		
	}
}

			
	
		
		
		
		
		
		
		
		
		
		
		
//		for(int a = 0 ; a<arr.length ;a++) { //arr의 수만큼 돌리기
//				int count = 0; //count 초기화
//		
//			for(int b = 0; b<=arr[a].length() ; b++) { //arr[a]s 안에서 a를 찾기위해 for문 돌리기
//				if(arr[a].charAt(b) == 'a') {// arr[a]안에서 'a'찾기  갯수는...?
//					arr[a]=arr[a].replace('a','A');
//					
//					
//					count++; //찾으면 하나씩 늘려가는 count
//				}
//			}
//		}

				
				

		
		
//		if(charAt = 'a') {
//			result = arr.replace('a','A');
//			
//		
//		return result;

