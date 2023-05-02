import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import java.util.Arrays;

import FactoryClassEnumerationBased.*;

public class FactoryClassEnumerationBasedTest {

	@Test
	public void testStudentAndGetTuition() {

		Student s1 = StudentFactory.createInStateStudent(1000f,"John Smith","153 Mary st,Boston,MA",15,StudentStatus.INSTATE);
		Student s2 = StudentFactory.createOutStateStudent(2000f,"Mary","63 Berry st,New York,NY",11,StudentStatus.OUTSTATE);
		Student s3 = StudentFactory.createIntlStateStudent(3000f,"Lin Wang",41269231,"23 Baker st,Boston,MA",15,"115 Binhe st,Beijing,China",StudentStatus.INTL);
		assertThat(s1.getTuition(), is(1000f));
		assertThat(s2.getTuition(), is(2000f));
		assertThat(s3.getTuition(), is(3000f));
	}

}
