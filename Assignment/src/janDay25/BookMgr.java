package janDay25;

public class BookMgr {
	
		private Book[] booklist;
		
		public BookMgr() {
		}

		public BookMgr(Book[] booklist) {
			super();
			this.booklist = booklist;
		}

		public Book[] getBooklist() {
		return booklist;
		}

		public void setBooklist(Book[] booklist) {
			this.booklist = booklist;
		}



		void printTotalPrice() {
			
			int totalPrice = 0;
			
			for (int i = 0; i < booklist.length; i++) {
				
				totalPrice += booklist[i].getPrice();		
			}
				System.out.println("전체 책 가격의 합 : " + totalPrice );
					
		}
		
		void printBooklist() {
			for (int b = 0; b < booklist.length; b++) {
				
				Book book = booklist[b];
				
				System.out.println(book.getTitle());
			}
			
						}

	
	
	

}
