package trackingServiceTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ErrorCollector;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import trackingService.InvalidGoalException;
import trackingService.TrackingService;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrackingServiceTest {

    private static TrackingService service = new TrackingService();
    //private String testName;

    @Rule
    public TestName testName = new TestName();
    @Rule
    public ErrorCollector collector = new ErrorCollector();

//	@BeforeClass
//	public static void before() {
//		System.out.println("BeforeClass ");
//		service = new TrackingService();
//	}

    @AfterClass
    public static void after() {
        System.out.println("AfterClass ");
    }

    @Before
    public void setUp() {


        //	System.out.println("Before every test");

    }


    @After
    public void tearDown() throws Exception {

//		System.out.println("After");
//		System.out.println(testName);
        System.out.println(testName.getMethodName());
    }

    @Test
    @Category(GoodTestCategory.class)
    public void test1_addCaloriesTotalCheck() {

        System.out.println("Initial total " + service.getTotal());

        // TODO Check Totals and check that History is created

        service.addCalories(10);

        //	if (service.getTotal()!=20) fail ("Add  method failed");

        try {
            assertEquals(0, service.getTotal());
        } catch (AssertionError error) {
            collector.addError(error);
        }

        try {
            assertEquals(1, service.getHistory().size());
        } catch (AssertionError error) {
            collector.addError(error);
        }


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
//		testName = new Object() {
//		}.getClass().getEnclosingMethod().getName();

    }


    @Test(expected = NumberFormatException.class)
    public void test2() {

        service.removeCalories(-10);

    }

    @Test
    public void test3_newTrackingServiceTotalIsZero() {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username");
        String userName = myObj.nextLine();  // Read user input

        assertEquals("Total is not 0", 0, service.getTotal());
//		testName = new Object() {
//		}.getClass().getEnclosingMethod().getName();
    }

    @Test
    @Category(GoodTestCategory.class)
    public void test4_removeCaloriesTotalCheck() {

        System.out.println("Initial total " + service.getTotal());

//		testName = new Object() {
//		}.getClass().getEnclosingMethod().getName();
        // TODO Check Totals and check that History is created
        // TODO Add check that Total could not be less than 0


        service.removeCalories(20);
        assertEquals(-20, service.getTotal());


    }

    @Test
    @Category(GoodTestCategory.class)
    public void test5_goalIsMeet() {
        //TODO
//		testName = new Object() {
//		}.getClass().getEnclosingMethod().getName();

    }

    @Test(expected = InvalidGoalException.class)
    @Category(BadTestCategory.class)
    public void test6_whenGoalIsSetToNegative() throws InvalidGoalException {
        service.setGoal(-10);
    }

    @Test(timeout = 200)
    @Category(BadTestCategory.class)
    public void test7_badTest() {
        for (int i = 0; i < 10000000; i++)
            service.addCalories(10);
        ;
    }


}


	


