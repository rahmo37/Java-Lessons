package Enum3;

import java.util.ArrayList;
import java.util.List;

public class Phone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<HTTPMethodConvertible> inherit = new ArrayList<>();
		inherit.add(LibraryEnum.FIRST);
		inherit.add(ClientEnum.GOOGLE);
		for (HTTPMethodConvertible element : inherit) {
			System.out.println(element.getHTTPMethodType());
		}

	}

	static interface HTTPMethodConvertible {
		public String getHTTPMethodType();
	}

	static enum LibraryEnum implements HTTPMethodConvertible {
		FIRST("Google Pixel"), SECOND("Huawei"), THIRD("Apple 11 Pro");

		String HTTPMethodType;

		LibraryEnum(String HTTPMethodType) {
			this.HTTPMethodType = HTTPMethodType;
		}

		public String getHTTPMethodType() {
			return HTTPMethodType;
		}

		public String hi() {
			return "Hi";
		}
	}

	static enum ClientEnum implements HTTPMethodConvertible {
		HUAWEI("HongmMing OS"), APPLE("iOS"), GOOGLE("Android");

		String HTTPMethodType;

		ClientEnum(String HTTPMethodType) {
			this.HTTPMethodType = HTTPMethodType;
		}

		public String getHTTPMethodType() {
			return HTTPMethodType;
		}

	}

}
