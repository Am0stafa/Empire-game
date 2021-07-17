package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;

import buildings.ArcheryRange;
import buildings.Barracks;
import buildings.Building;
import buildings.EconomicBuilding;
import buildings.Farm;
import buildings.Market;
import buildings.MilitaryBuilding;
import buildings.Stable;
import engine.City;
import engine.Distance;
import engine.Game;
import engine.Player;
import exceptions.FriendlyFireException;
import exceptions.MaxCapacityException;
import exceptions.BuildingInCoolDownException;
import exceptions.EmpireException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import exceptions.NotEnoughGoldException;
import exceptions.MaxLevelException;
import units.Archer;
import units.Army;
import units.Cavalry;
import units.Scout;
import units.Infantry;
import units.Status;
import units.Unit;

@SuppressWarnings({ "rawtypes", "unchecked","unused" })
public class Q2V5 {
	
	@Test(timeout = 100)
	public void testHealMethodExists() {
		Method[] methods = Scout.class.getDeclaredMethods();
		
		assertTrue("Class Doctor should contain a method named heal.", containsMethodName(methods, "Hire"));
	}
	
	@Test(timeout = 1000)
	public void testHireMethodLogicArcherV1(){
		
		Unit scouter = new Scout(1,0,0,0,0);
		Army scouted = new Army("Here");
		int unitsCountAfter = scouted.getMaxToHold() - scouted.getMaxToHold()/2 + 2;
		for(int i = 0; i < scouted.getMaxToHold() - scouted.getMaxToHold()/2 + 1; i++)
		{
			scouted.getUnits().add(new Scout(1,0,0,0,0));
		}
		try {
				Method m = Scout.class.getDeclaredMethod("Hire",Army.class);
				m.invoke(scouter,scouted);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(
				"The Scouted Army's Current Unit Count should be "+unitsCountAfter+" but was " + scouted.getUnits().size(),
				unitsCountAfter, scouted.getUnits().size());
		Unit expectedHired = new Archer(1, 60, 0.4, 0.5, 0.6);
		Unit actualHired = scouted.getUnits().get(scouted.getUnits().size()-1);
		assertTrue("Hired unit should be of type Archer", actualHired instanceof Archer);
		compareUnits(expectedHired, actualHired);
	}
	
	@Test(timeout = 1000)
	public void testHireMethodLogicArcherV2(){
		
		Unit scouter = new Scout(2,0,0,0,0);
		Army scouted = new Army("Here");
		int unitsCountAfter = scouted.getMaxToHold() - scouted.getMaxToHold()/2 + 2;
		for(int i = 0; i < scouted.getMaxToHold() - scouted.getMaxToHold()/2 + 1; i++)
		{
			scouted.getUnits().add(new Scout(1,0,0,0,0));
		}
		try {
				Method m = Scout.class.getDeclaredMethod("Hire",Army.class);
				m.invoke(scouter,scouted);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(
				"The Scouted Army's Current Unit Count should be "+unitsCountAfter+" but was " + scouted.getUnits().size(),
				unitsCountAfter, scouted.getUnits().size());
		Unit expectedHired = new Archer(2, 60, 0.4, 0.5, 0.6);
		Unit actualHired = scouted.getUnits().get(scouted.getUnits().size()-1);
		assertTrue("Hired unit should be of type Archer", actualHired instanceof Archer);
		compareUnits(expectedHired, actualHired);
	}
	

	
	@Test(timeout = 1000)
	public void testHireMethodLogicCavalryV1(){
		
		Unit scouter = new Scout(1,0,0,0,0);
		Army scouted = new Army("Here");
		int unitsCountAfter = scouted.getMaxToHold() - scouted.getMaxToHold()/2;
		for(int i = 0; i < scouted.getMaxToHold() - scouted.getMaxToHold()/2 - 1; i++)
		{
			scouted.getUnits().add(new Scout(1,0,0,0,0));
		}
		try {
				Method m = Scout.class.getDeclaredMethod("Hire",Army.class);
				m.invoke(scouter,scouted);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(
				"The Scouted Army's Current Unit Count should be "+unitsCountAfter+" but was " + scouted.getUnits().size(),
				unitsCountAfter, scouted.getUnits().size());
		Unit expectedHired = new Cavalry(1, 50, 0.5, 0.6, 0.7);
		Unit actualHired = scouted.getUnits().get(scouted.getUnits().size()-1);
		assertTrue("Hired unit should be of type Cavalry", actualHired instanceof Cavalry);
		compareUnits(expectedHired, actualHired);
	}
	@Test(timeout = 1000)
	public void testHireMethodLogicCavalryV2(){
		
		Unit scouter = new Scout(2,0,0,0,0);
		Army scouted = new Army("Here");
		int unitsCountAfter = scouted.getMaxToHold() - scouted.getMaxToHold()/2;
		for(int i = 0; i < scouted.getMaxToHold() - scouted.getMaxToHold()/2 - 1; i++)
		{
			scouted.getUnits().add(new Scout(1,0,0,0,0));
		}
		try {
				Method m = Scout.class.getDeclaredMethod("Hire",Army.class);
				m.invoke(scouter,scouted);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(
				"The Scouted Army's Current Unit Count should be "+unitsCountAfter+" but was " + scouted.getUnits().size(),
				unitsCountAfter, scouted.getUnits().size());
		Unit expectedHired = new Cavalry(2, 50, 0.5, 0.6, 0.7);
		Unit actualHired = scouted.getUnits().get(scouted.getUnits().size()-1);
		assertTrue("Hired unit should be of type Cavalry", actualHired instanceof Cavalry);
		compareUnits(expectedHired, actualHired);
	}
	@Test(timeout = 1000)
	public void testHireMethodLogicCavalryV3(){
		
		Unit scouter = new Scout(3,0,0,0,0);
		Army scouted = new Army("Here");
		int unitsCountAfter = scouted.getMaxToHold() - scouted.getMaxToHold()/2;
		for(int i = 0; i < scouted.getMaxToHold() - scouted.getMaxToHold()/2 - 1; i++)
		{
			scouted.getUnits().add(new Scout(1,0,0,0,0));
		}
		try {
				Method m = Scout.class.getDeclaredMethod("Hire",Army.class);
				m.invoke(scouter,scouted);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(
				"The Scouted Army's Current Unit Count should be "+unitsCountAfter+" but was " + scouted.getUnits().size(),
				unitsCountAfter, scouted.getUnits().size());
		Unit expectedHired = new Cavalry(3, 60, 0.6, 0.7, 0.8);
		Unit actualHired = scouted.getUnits().get(scouted.getUnits().size()-1);
		assertTrue("Hired unit should be of type Cavalry", actualHired instanceof Cavalry);
		compareUnits(expectedHired, actualHired);
	}
	
	@Test(timeout = 1000)
	public void testHireMethodLogicWhenMarching(){
		
		Unit scouter = new Scout(1,0,0,0,0);
		Army scouted = new Army("Here");
		scouted.setCurrentStatus(Status.MARCHING);
		int unitsCountAfter = scouted.getMaxToHold() - 5;
		for(int i = 0; i < scouted.getMaxToHold() - 5; i++)
		{
			scouted.getUnits().add(new Scout(1,0,0,0,0));
		}
		try {
				Method m = Scout.class.getDeclaredMethod("Hire",Army.class);
				m.invoke(scouter,scouted);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(
				"The Scouted Army's Current Unit Count should be "+unitsCountAfter+" but was " + scouted.getUnits().size(),
				unitsCountAfter, scouted.getUnits().size());
	}
	

	
	@Test(timeout = 1000, expected = MaxCapacityException.class)
	public void testHealMethodLogicWithMaxSoldierCount() throws Throwable{
		
		Unit scouter = new Scout(1,0,0,0,0);
		Army scouted = new Army("Here");
		int unitsCountAfter = scouted.getMaxToHold();
		for(int i = 0; i < scouted.getMaxToHold(); i++)
		{
			scouted.getUnits().add(new Scout(1,0,0,0,0));
		}
		try {

			Method m = Scout.class.getDeclaredMethod("Hire",Army.class);
			m.invoke(scouter,scouted);
			
		} catch (InvocationTargetException e) {
			if(e.getCause() instanceof MaxCapacityException){
				throw e.getCause();
				
			}else{
				throw e;
			}
		}
		assertEquals(
				"The Scouted Army's Current Unit Count should be "+unitsCountAfter+" but was " + scouted.getUnits().size(),
				unitsCountAfter, scouted.getUnits().size());
	}
	
//////////////////////////////////////////////////////////////////////////////
	private static boolean containsMethodName(Method[] methods, String name) {
		for (Method method : methods) {
			if (method.getName().equals(name))
				return true;
			}
			return false;
		}
	
	@SuppressWarnings("deprecation")
	private static void compareUnits(Unit expected, Unit actual)
	{
		assertEquals(
				"The Hired Unit's level should be "+expected.getLevel()+" but was " + actual.getLevel(),
				expected.getLevel(), actual.getLevel());
		assertEquals(
				"The Hired Unit's maxSoldierCount should be "+expected.getMaxSoldierCount()+" but was " + actual.getMaxSoldierCount(),
				expected.getMaxSoldierCount(), actual.getMaxSoldierCount(), 0.01);
		assertEquals(
				"The Hired Unit's idleUpkeep should be "+expected.getIdleUpkeep()+" but was " + actual.getIdleUpkeep(),
				expected.getIdleUpkeep(), actual.getIdleUpkeep(), 0.01);
		assertEquals(
				"The Hired Unit's marchingUpkeep should be "+expected.getMarchingUpkeep()+" but was " + actual.getMarchingUpkeep(),
				expected.getMarchingUpkeep(), actual.getMarchingUpkeep(), 0.01);
		assertEquals(
				"The Hired Unit's siegeUpkeep should be "+expected.getSiegeUpkeep()+" but was " + actual.getSiegeUpkeep(),
				expected.getSiegeUpkeep(), actual.getSiegeUpkeep(), 0.01);
	}
}
