package janDay24;

public class StringUtil {

	private static String replaceString(String[] arr) {
	
			
		int maxCount = 0;
		String maxCountstr = "";
		
		for(String p : arr) {//arr�� �� ��ҵ��� p�����
			int count = 0; //count �ʱ�ȭ
			
			for(int i = 0 ; i<p.length() ;i++) {
				char charAt = p.charAt(i);
					
				if(charAt == 'a') {
					count++; //n���ǹ迭�� a�� ī��Ʈ ����
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
		System.out.println("����� ���ڿ� : "+result);
		
	}
}

			
	
		
		
		
		
		
		
		
		
		
		
		
//		for(int a = 0 ; a<arr.length ;a++) { //arr�� ����ŭ ������
//				int count = 0; //count �ʱ�ȭ
//		
//			for(int b = 0; b<=arr[a].length() ; b++) { //arr[a]s �ȿ��� a�� ã������ for�� ������
//				if(arr[a].charAt(b) == 'a') {// arr[a]�ȿ��� 'a'ã��  ������...?
//					arr[a]=arr[a].replace('a','A');
//					
//					
//					count++; //ã���� �ϳ��� �÷����� count
//				}
//			}
//		}

				
				

		
		
//		if(charAt = 'a') {
//			result = arr.replace('a','A');
//			
//		
//		return result;

