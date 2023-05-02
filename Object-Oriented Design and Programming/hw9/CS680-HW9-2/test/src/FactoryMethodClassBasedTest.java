import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import java.util.Arrays;

import FactoryMethodClassBased.*;

public class FactoryMethodClassBasedTest {

	@Test
	public void testStudentAndGetTuition() {

		Student s1 = Student.createInStateStudent(1000f,"John Smith","153 Mary st,Boston,MA",15,new InState(1000f));
		Student s2 = Student.createOutStateStudent(2000f,"Mary","63 Berry st,New York,NY",11,new OutState(2000f));
		Student s3 = Student.createIntlStateStudent(3000f,"Lin Wang",41269231,"23 Baker st,Boston,MA",15,"115 Binhe st,Beijing,China",new Intl(3000f));
		assertThat(s1.getTuition(), is(1000f));
		assertThat(s2.getTuition(), is(2000f));
		assertThat(s3.getTuition(), is(3000f));
	}

}
