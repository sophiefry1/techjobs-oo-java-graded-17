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
       @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String description = job.toString();

        assertEquals(description.substring(0, 1), System.lineSeparator());
        assertEquals(description.substring(description.length() - 1), System.lineSeparator());
       }
       @Test
    public void testToStringContainsCorrectLabelsAndData(){
           Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

           String description = job.toString();


           assertTrue(description.contains("ID: 7" + System.lineSeparator()));
           assertTrue(description.contains("Name: Product tester" + System.lineSeparator()));
           assertTrue(description.contains("Employer: ACME" + System.lineSeparator()));
           assertTrue(description.contains("Location: Desert" + System.lineSeparator()));
           assertTrue(description.contains("Position Type: Quality control" + System.lineSeparator()));
           assertTrue(description.contains("Core Competency: Persistence" + System.lineSeparator()));
       }

       @Test
       public void testToStringHandlesEmptyField(){
        Job job = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String description = job.toString();

        assertTrue(description.contains("Name: Data not available" + System.lineSeparator()));
    }
    @Test
    public void testEmptyJob(){
        Job job = new Job();

        String description = job.toString();

        assertEquals(description, "OOPS! This job does not seem to exist.");
    }
}