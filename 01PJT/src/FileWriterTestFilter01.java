//package jp03.part05;

import java.io.*;

	public class FileWriterTestFilter01{

		public static void main(String[] args)throws IOException{

			BufferedReader br = null;
			BufferedWriter bw = null;
			String fileName = "";
			String copyFileName = "";

			int readCount = 0 ;

				System.out.print("copy할 file이름을 입력하세요");
				fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();

				br = new BufferedReader(new FileReader(fileName));
				copyFileName = fileName + "_copy";
				bw = new BufferedWriter(new FileWriter(copyFileName));

				String source = null;

				while((source = br.readLine())!= null){//밖에서하면 안에도해줘야함
					bw.write(source);	
					readCount++;
				}

				bw.flush();


				bw.close();
				br.close();

				System.out.println("\n\n ========");
				System.out.println("--> read count : "+readCount);
				System.out.println("\n\n ========");
		}
	}

				