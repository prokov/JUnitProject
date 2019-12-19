package trackingServiceTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.fail;

public class HelloJUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	@Category(BadTestCategory.class)
	public void test() {
		fail("Not yet implemented");
	}

}
