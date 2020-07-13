import java.io.IOException;
import java.util.ArrayList;

public class testMain {

	public static void main(String[] args) throws IOException {

		dataDriver data = new dataDriver();
		ArrayList d = data.getData("Add Profile");
		System.out.println(d.get(0));
		System.out.println(d.get(1));
		System.out.println(d.get(2));
		System.out.println(d.get(3));
		System.out.println("hii");

	}

}


