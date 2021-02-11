package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

	private Registry registry = new Registry();

	// @Test
	public void validateRegistryResult() {
		Person person = new Person();
		RegisterResult result = registry.registerVoter(person);
		Assert.assertEquals(RegisterResult.VALID, result);
	}

	// @Test
	public void ValidateAliveVoter() {
		Person person = new Person();
		RegisterResult result = registry.registerVoter(person);
		Assert.assertTrue(result != RegisterResult.DEAD);
	}

	// @Test
	public void validateValidAge() {
		Person person = new Person();
		RegisterResult result = registry.registerVoter(person);
		Assert.assertTrue(result != RegisterResult.INVALID_AGE);
	}

	// @Test
	public void validateAdult() {
		Person person = new Person();
		RegisterResult result = registry.registerVoter(person);
		Assert.assertTrue(result != RegisterResult.UNDERAGE);
	}

	// @Test
	public void validateSingleVote() {
		Person person = new Person();
		RegisterResult result = registry.registerVoter(person);
		Assert.assertTrue(result != RegisterResult.DUPLICATED);
	}

	// Tests for Equivalence Class
	@Test
	public void shouldDetectInvalidAge() {
		Person p1 = new Person("Levi Ackerman", 56091345, -30, Gender.MALE, true);
		Person p2 = new Person("Julius Novachrono", 67834214, -42, Gender.MALE, true);
		RegisterResult result1 = registry.registerVoter(p1);
		RegisterResult result2 = registry.registerVoter(p2);
		Assert.assertEquals(RegisterResult.INVALID_AGE, result1);
		Assert.assertEquals(RegisterResult.INVALID_AGE, result2);
	}

	@Test
	public void shouldValidateIfAPersonIsDead() {
		Person p1 = new Person("Light Yagami", 38109003, 23, Gender.MALE, false);
		Person p2 = new Person("Neji Hyuga", 34289720, 18, Gender.MALE, false);
		RegisterResult result1 = registry.registerVoter(p1);
		RegisterResult result2 = registry.registerVoter(p2);
		Assert.assertEquals(RegisterResult.DEAD, result1);
		Assert.assertEquals(RegisterResult.DEAD, result2);
	}

	@Test
	public void shouldValidateTheAge() {
		Person p1 = new Person("Gon Freecs", 90348932, 14, Gender.MALE, true);
		Person p2 = new Person("Gabi Braun", 46918379, 12, Gender.FEMALE, true);
		RegisterResult result1 = registry.registerVoter(p1);
		RegisterResult result2 = registry.registerVoter(p2);
		Assert.assertEquals(RegisterResult.UNDERAGE, result1);
		Assert.assertEquals(RegisterResult.UNDERAGE, result2);
	}

	@Test
	public void shouldRegisterVote() {
		Person p1 = new Person("Hisoka Morow", 84732954, 28, Gender.MALE, true);
		Person p2 = new Person("Yami Sukehiro", 61067341, 29, Gender.MALE, true);
		RegisterResult result1 = registry.registerVoter(p1);
		RegisterResult result2 = registry.registerVoter(p2);
		Assert.assertEquals(RegisterResult.VALID, result1);
		Assert.assertEquals(RegisterResult.VALID, result2);
	}

	@Test
	public void shouldDetectIfAPersonHasAlreadyVoted() {
		Person p1 = new Person("Hisoka Morow", 84732954, 28, Gender.MALE, true);
		Person p2 = new Person("Yami Sukehiro", 61067341, 29, Gender.MALE, true);
		// Valid registration
		registry.registerVoter(p1);
		registry.registerVoter(p2);
		// Duplicate
		RegisterResult result1 = registry.registerVoter(p1);
		RegisterResult result2 = registry.registerVoter(p2);
		Assert.assertEquals(RegisterResult.DUPLICATED, result1);
		Assert.assertEquals(RegisterResult.DUPLICATED, result2);
	}
}