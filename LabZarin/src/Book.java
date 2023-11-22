
public class Book {
	private int ISBN;
	private String bookTitle;
	private int numberOfPages;
	static int count;

	Book(int ISBN, String bookTitle, int numberOfPages) {
		this.ISBN = ISBN;
		this.bookTitle = bookTitle;
		this.numberOfPages = numberOfPages;
		count++;
	}

	Book() {
		count++;
	}

	public String toString() {
		return "Book Isbn: " + this.ISBN + "\nBook Name: " + this.bookTitle + "\nNumber of pages in the book: "
				+ this.numberOfPages;
	}

	public int compareFrom(Book book) {
		if (getNumberOfPages() > book.getNumberOfPages()) {
			return getNumberOfPages();
		} else {
			return book.getNumberOfPages();
		}
	}

	public static int getCount() {
		return count;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public static void main(String[] args) {
		Book b1 = new Book(1259277283, "Traditions & Encounters: A Brief Global History Volume 2", 556);
		Book b2 = new Book(1780077503, "Traditions & Encounters: A Global Perspective on the Past, Vol.2", 561);
		Book b3 = new Book(1778997503, "Learn Java, Vol.2", 784);
		Book b4 = new Book();
		System.out.println(b1.compareFrom(b2));
		System.out.println(Book.getCount());
	}
}
