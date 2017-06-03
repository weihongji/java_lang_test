package java_lang_test;

import java.lang.annotation.*;

@AnnoNormal(Str="Jesse Wei", Val = 20)
@AnnoDefault
@AnnoValue("variable name is omitted")
@AnnoMarker
@AnnoRetention("I won't be displayed in output because i'm using the default retention policy -  CLASS.")
public class AnnotationTest implements Test {

	public void test() {
		Class<? extends AnnotationTest> c = this.getClass();
		Annotation[] as = c.getAnnotations();
		if (as == null || as.length == 0) {
			System.out.println("No Annotation can be found during runtime.");
		}
		else {
			System.out.println(String.format("%d %s been found:", as.length, as.length > 1 ? "annotations have" : "annotation has"));
			for(Annotation a : as) {
				System.out.println(a);
			}	
		}
	}
}

@Retention(RetentionPolicy.RUNTIME)
@interface AnnoNormal {
	String Str();
	int Val();
}

@Retention(RetentionPolicy.RUNTIME)
@interface AnnoDefault {
	String Val() default "using default value";
}

@Retention(RetentionPolicy.RUNTIME)
@interface AnnoValue {
	String value();
}


@Retention(RetentionPolicy.RUNTIME)
@interface AnnoMarker {}


@interface AnnoRetention {
	String value();
}

