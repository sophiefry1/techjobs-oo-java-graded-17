package org.launchcode.techjobs.oo;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class JobTest {
    @Test
    public void testSettingJobId() {
        Job firstJob = new Job();
        Job secondJob = new Job();
        assertNotEquals(firstJob.getId(), secondJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(job.getName(), "Product tester");
        assertTrue(job.getName() instanceof String);

        assertEquals(job.getEmployer().getValue(), "ACME");
        assertTrue(job.getEmployer() instanceof Employer);

        assertEquals(job.getLocation().getValue(), "Desert");
        assertTrue(job.getLocation() instanceof Location);

        assertEquals(job.getPositionType().getValue(), "Quality control");
        assertTrue(job.getPositionType() instanceof PositionType);

        assertEquals(job.getCoreCompetency().getValue(), "Persistence");
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

    }
       @Test
       public void testJobsForEquality(){
           Job firstJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
           Job secondJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
           assertFalse(firstJob.equals(secondJob));
       }

}