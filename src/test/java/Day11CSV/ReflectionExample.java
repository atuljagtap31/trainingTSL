package Day11CSV;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.testng.annotations.Test;

public class ReflectionExample {
	@Test
	public void f() throws Exception {

		Class c1 = Class.forName("org.openqa.selenium.chrome.ChromeDriver");
		Method[] md = c1.getDeclaredMethods();

		for (Method M : md) {
			System.out.println(M.getName());
		}
		System.out.println("---------------------Parent Specific Methods");
		Method md2[] = c1.getMethods();

		for (Method M : md2) {
			System.out.println(M.getName());
		}

		System.out.println("super class name is " + c1.getSuperclass());

		System.out.println("Fields are ");
		Field[] fd = c1.getDeclaredFields();
		for (Field f : fd) {
			System.out.println(f.getName());
		}

		System.out.println("------------------parent Specific fields are ");
		Field[] parfd = c1.getFields();
		for (Field f : parfd) {
			System.out.println(f.getName());
		}

	}
}
