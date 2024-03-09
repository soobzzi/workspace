package janDay24;

public class Util {
	
		public int findPrimeCount(int limit) {
			
			int primecount = 0;
			boolean prime = true;
			
			for(int x = 2 ; x <= limit ; x++) {
				prime = true;
				for (int y = 2; y < x; y++) {
			
					if(x%y == 0) {
						prime = false;
						break;		
					}
				}
				
				if(prime) {
					primecount++;
				}
				
			}
			return primecount;
		}

			
		
	
		
		public int[] findPrimeReturnArray(int limit) {
			
			
			int primecount = findPrimeCount(limit);
			int[] primeA = new int[primecount];
			
			int temp = 0 ; //배열 번호 0번부터
			boolean prime = true;
			
				for(int x = 2 ; x <= limit ; x++) {
					prime = true;
					for (int y = 2; y < x; y++) {
				
						if(x%y == 0) {
							prime = false;
							break;		
						}
					}
					
				
				if(prime) {
					primeA[temp]= x;
					temp++;
					
				}
			}
				
				return primeA;
		
			}
			
			
			
			
			
			
		}





