package java_lang_test;

public class InnerClassTest implements Test {
	public void test() {
		Outer o = new Outer();
		System.out.println(o);
		
		Outer.Inner i = o.new Inner();
		i.method1();
	}
}

class Outer {
	private String outer_v = "O";

	public String toString() {
		Inner o = new Inner();
		return o.toString();
	}
	
	public class Inner {
		private String inner_v = "I";
		
		public void method1() {
				System.out.println("method1() is called from Inner.");
		}
		
		public String toString() {
			return String.format("Inner: %s, Outer: %s", inner_v, outer_v);
		}
	}
}