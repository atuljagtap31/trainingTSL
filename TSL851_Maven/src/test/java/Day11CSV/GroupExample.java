package Day11CSV;

import org.testng.annotations.Test;

public class GroupExample {
	@Test(groups = { "smoke" })
	public void f1() {
		System.out.println("In smoke Test");
	}

	@Test(groups = { "smoke", "reg" })
	public void f2() {
		System.out.println("In smoke and Regretion Test");
	}

	@Test(groups = { "reg", "sanity" })
	public void f3() {
		System.out.println("In Regretion and sanity Test");
	}
	
	@Test(groups = { "reg"})
	public void f4() {
		System.out.println("In Regretion Test");
	}
	
	@Test(groups = { "sanity" })
	public void f5() {
		System.out.println("In sanity Test");
	}
}
