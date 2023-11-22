package BasicException;

public class bookException {
	String Author;
	String Title;
	int Pages;

	bookException(String Author, String Title, int Pages) throws ZeroOrNegetiveNumber {
		setAuthor(Author);
		setTitle(Title);
		setPages(Pages);
	}

	public void setAuthor(String Author) {
		this.Author = Author;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}

	public void setPages(int Pages) throws ZeroOrNegetiveNumber {
		if (Pages <= 0) {

			throw new ZeroOrNegetiveNumber();
		}
		this.Pages = Pages;
	}

	public String getAuthor() {
		return Author;
	}

	public String getTitle() {
		return Title;
	}

	public int getPages() {
		return Pages;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("the Author of the book :" + getAuthor());
		sb.append("\nthe Title of the book :" + getTitle());
		sb.append("\nthe number of pages in the book :" + getPages());

		return sb.toString();
	}
}
