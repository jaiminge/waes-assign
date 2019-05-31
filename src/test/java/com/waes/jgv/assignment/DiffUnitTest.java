package com.waes.jgv.assignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.waes.jgv.assignment.domain.model.diff.Diff;
import com.waes.jgv.assignment.domain.model.diff.DiffException;
import com.waes.jgv.assignment.dto.DiffDTO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AssignmentWaesApplicationTests.class})
public class DiffUnitTest extends DiffTest{
	
	private Diff diff;
	String jaime = createJSON("Jaime",37);
	String barbara = createJSON("barbara", 39);
	String barby = createJSON("barby", 39);
	String barb = createJSON("barb", 39);
	
	@After
	public void after(){
		diff = null;
	}
	
	@Test
	public void isEquals(){
		DiffDTO diffDTO = new DiffDTO(1L, jaime, jaime); 
		diff = new Diff(diffDTO);
		Diff diffCompare = new Diff(diffDTO);
		Assert.assertTrue(diff.equals(diffCompare));
		Assert.assertTrue(diff.hashCode() == diffCompare.hashCode());
		
	}	
	
	@Test
	public void isSameValues(){
		DiffDTO diffDTO = new DiffDTO(1L, jaime, jaime); 
		diff = new Diff(diffDTO);
		Assert.assertTrue(diff.isSameValues());
		
	}
	
	@Test
	public void isNotSameValues(){
		DiffDTO diffDTO = new DiffDTO(1L, jaime, barbara); 
		diff = new Diff(diffDTO);
		Assert.assertFalse(diff.isSameValues());
		
	}	
	
	@Test
	public void isSameEncoded() throws DiffException{
		DiffDTO diffDTO = new DiffDTO(1L, jaime, jaime); 
		diff = new Diff(diffDTO);
		Assert.assertTrue(diff.isSameEncoded());
		
	}
	
	@Test
	public void isNotSameEncoded() throws DiffException{
		DiffDTO diffDTO = new DiffDTO(1L, jaime, barby); 
		diff = new Diff(diffDTO);
		Assert.assertFalse(diff.isSameEncoded());
	}
	
	@Test(expected=DiffException.class)
	public void isSameEncodedException() throws DiffException{
		DiffDTO diffDTO = new DiffDTO(1L, null, barby); 
		diff = new Diff(diffDTO);
		diff.isSameEncoded();
	}		
	
	@Test
	public void isSameSize() throws DiffException{
		DiffDTO diffDTO = new DiffDTO(1L, jaime, barb); 
		diff = new Diff(diffDTO);
		Assert.assertTrue(diff.isSameSize());
		
	}		
	
	@Test
	public void isNotSameSize() throws DiffException{
		DiffDTO diffDTO = new DiffDTO(1L, jaime, barbara); 
		diff = new Diff(diffDTO);
		Assert.assertFalse(diff.isSameSize());
		
	}		
	
	
	@Test
	public void isValidStates() throws DiffException{
		DiffDTO diffDTO = new DiffDTO(1L, jaime, barb); 
		diff = new Diff(diffDTO);
		diff.validateConditionsToInsight();
	}		
	
	@Test(expected=DiffException.class)
	public void isNotValidStateLeft() throws DiffException{
		DiffDTO diffDTO = new DiffDTO(1L, null, barb); 
		diff = new Diff(diffDTO);
		diff.validateConditionsToInsight();
	}		
	
	@Test(expected=DiffException.class)
	public void isNotValidStateRight() throws DiffException{
		DiffDTO diffDTO = new DiffDTO(1L, jaime, null); 
		diff = new Diff(diffDTO);
		diff.validateConditionsToInsight();
	}		

	@Test(expected=DiffException.class)
	public void isNotValidState() throws DiffException{
		DiffDTO diffDTO = new DiffDTO(1L, jaime, jaime); 
		diff = new Diff(diffDTO);
		diff.validateConditionsToInsight();
	}		
	
	@Test
	public void getInsight() throws DiffException{
		DiffDTO diffDTO = new DiffDTO(1L, jaime, barb); 
		diff = new Diff(diffDTO);
		String insight = diff.getInsight();
		Assert.assertTrue(!insight.isEmpty());
		
	}		

}
