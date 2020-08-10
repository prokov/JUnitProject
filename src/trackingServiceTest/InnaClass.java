package trackingServiceTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import trackingService.InvalidGoalException;
import trackingService.TrackingService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InnaClass {
    TrackingService trackingService ;

  @Before
  public void setUp(){
      trackingService = new TrackingService();
  }

   @BeforeClass
   public static void init(){
       // trackingService = new TrackingService();
   }


    @Test
    @Ignore
    public void test1_AddCalories(){
        int amount = 100;
        trackingService.addCalories(amount);
        Assert.assertEquals("add fail",100, trackingService.getTotal());
    }
    @Test
    public void test2_AddCalories_returnsSum(){
        trackingService.addCalories(100);
        trackingService.addCalories(100);
        trackingService.addCalories(100);
        Assert.assertEquals("add fail",300, trackingService.getTotal());
    }
    @Test
    public void testRemoveCalories(){
        trackingService.addCalories(1000);
        trackingService.removeCalories(100);
        Assert.assertEquals("remove fail",900, trackingService.getTotal());
    }
    @Test
    public void testRemoveCalories_returnsO(){
        trackingService.addCalories(1000);
        trackingService.removeCalories(1100);
        Assert.assertEquals("remove fail",0, trackingService.getTotal());
    }
    @Test
    public void testIsGoalMet_goalMet() throws InvalidGoalException {
        trackingService.setGoal(1000);
        trackingService.addCalories(1100);
        Assert.assertTrue(trackingService.isGoalMet());
    }
    @Test
    public void testIsGoalMet_goalNotMet() throws InvalidGoalException {
        trackingService.setGoal(1000);
        trackingService.addCalories(900);
        Assert.assertFalse(trackingService.isGoalMet());
    }
    @Test
    public void testIsGoalMet_goalNotMet_1() throws InvalidGoalException {
        trackingService.setGoal(1000);
        trackingService.addCalories(1100);
        trackingService.removeCalories(200);
        Assert.assertFalse(trackingService.isGoalMet());
    }
}
