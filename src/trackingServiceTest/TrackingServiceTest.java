package trackingServiceTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import trackingService.InvalidGoalException;
import trackingService.TrackingService;

import static org.junit.Assert.assertEquals;


public class TrackingServiceTest {

	private TrackingService service = new TrackingService();
	private String testName;

	@BeforeClass
	public static void before() {
		System.out.println("BeforeClass ");
	}

	@AfterClass
	public static void after() {
		System.out.println("AfterClass ");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Before");
		service = new TrackingService();
	}

	@After
	public void tearDown() throws Exception {
		
		System.out.println("After");
		System.out.println(testName);
	}

	@Test
	@Category(GoodTestCategory.class)
	public void addCaloriesTotalCheck() {
		// TODO Check Totals and check that History is created

		TrackingService service = new TrackingService();
		service.addCalories(10);
		assertEquals(10, service.getTotal());
		assertEquals(1, service.getHistory().size());
		System.out.println(service.getHistory());
		
//		Assertions.assertAll("Test Assert All",
//		()-> assertEquals(10, service.getHistory().get(0).getAmount()),
//		()-> assertEquals(10, service.getHistory().get(0).getTotal()),
//		()-> assertEquals("add", service.getHistory().get(0).getOperation()));
		
		
		assertEquals(10, service.getHistory().get(0).getAmount());
		assertEquals(10, service.getHistory().get(0).getTotal());
		assertEquals("add", service.getHistory().get(0).getOperation());
		service.addCalories(20);
		assertEquals(30, service.getTotal());
		assertEquals(2, service.getHistory().size());
		testName = new Object() {
		}.getClass().getEnclosingMethod().getName();

	}

	@Test
	public void newTrackingServiceTotalIsZero() {
		TrackingService service = new TrackingService();
		assertEquals("Total is not 0", 0, service.getTotal());
		testName = new Object() {
		}.getClass().getEnclosingMethod().getName();
	}

	@Test
	@Category(GoodTestCategory.class)
	public void removeCaloriesTotalCheck() {
		TrackingService service = new TrackingService();
		testName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		// TODO Check Totals and check that History is created
		// TODO Add check that Total could not be less than 0
	}

	@Test
	@Category(GoodTestCategory.class)
	public void goalIsMeet() {
		//TODO
		testName = new Object() {
		}.getClass().getEnclosingMethod().getName();

	}

	@Test(expected = InvalidGoalException.class)
	@Category(BadTestCategory.class)
	public void whenGoalIsSetToNegative() throws InvalidGoalException {
    service.setGoal(-10);
	}
	
	@Test(timeout = 200)
	@Category(BadTestCategory.class)
	public void BadTest()  {
	   for (int i = 0; i < 10000000; i++)
		service.addCalories(10);;
		}
	
	

}
