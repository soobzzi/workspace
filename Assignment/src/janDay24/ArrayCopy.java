package janDay24;


import java.util.Vector;

public class ArrayCopy {
	
		public Vector<String> moveToVector(String[] datas){
		
			Vector<String> v = new Vector<String>();
			
			for(int x = datas.length-1 ; x>=0 ; x--) {
				v.add(datas[x]);
				//v.addElement(datas[x]);
			//v의 첫번째에는 datas[4]가 들어와야되고 차례대로 집어넣는다 0까지
							
			}
			return v;//거꾸로 출력됨
					
		}
	
	public static void main(String args[]) {
		
		
		ArrayCopy ac = new ArrayCopy();
		String datas[]= {"1","2","3","4","5"};
		System.out.println(ac.moveToVector(datas));
			
			
		}
	}

