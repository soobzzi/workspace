package janDay24;

public class Prob01 {


		public String leftPad(String str, int size, char padChar) {
		
				int length = str.length();
				int s = size;
				StringBuilder result = new StringBuilder();
				// �̰� �����ϴ°� �������... ������ ���ͳ��ڴ� ������µ� ���ϰ��� ��� ǥ���ؾ����� ���� 
				// StringBuilder �� toString �� ����ؼ� ������!
				
				if(length<=size) {
										
						for(int a = 1 ; a<= s - length ; a++) {	
							
							result.append(padChar);	
						}					
							
							result.append(" " + str);
						
					}else{
						
						return str;
					}
				
						return result.toString();
		}
		
		public static void main(String[] args) {
	
			Prob01 prob3 = new Prob01();
	
			System.out.println(prob3.leftPad("ABC", 6, '#'));
			System.out.println(prob3.leftPad("ABC", 5, '$'));
			System.out.println(prob3.leftPad("ABC", 2, '&'));
	
		}	
			}

