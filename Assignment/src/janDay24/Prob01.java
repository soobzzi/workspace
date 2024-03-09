package janDay24;

public class Prob01 {


		public String leftPad(String str, int size, char padChar) {
		
				int length = str.length();
				int s = size;
				StringBuilder result = new StringBuilder();
				// 이거 생각하는게 어려웠음... 나오는 논리와놀자는 만들었는데 리턴값을 어떻게 표현해야할지 몰라서 
				// StringBuilder 와 toString 을 사용해서 가져옴!
				
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

