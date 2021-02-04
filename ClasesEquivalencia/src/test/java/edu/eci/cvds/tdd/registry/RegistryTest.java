package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

	private Registry registry = new Registry();

	@Test
	public void validateRegistryResult() {
		Person person = new Person();
		RegisterResult result = registry.registerVoter(person);
		Assert.assertEquals(RegisterResult.VALID, result);
	}

	@Test
	public void ValidateAliveVoter() {
		Person person = new Person();
		RegisterResult result = registry.registerVoter(person);
		Assert.assertTrue(result != RegisterResult.DEAD);
	}

	@Test
	public void validateValidAge() {
		Person person = new Person();
		RegisterResult result = registry.registerVoter(person);
		Assert.assertTrue(result != RegisterResult.INVALID_AGE);
	}

	@Test
	public void validateAdult() {
		Person person = new Person();
		RegisterResult result = registry.registerVoter(person);
		Assert.assertTrue(result != RegisterResult.UNDERAGE);
	}

	@Test
	public void validateSingleVote() {
		Person person = new Person();
		RegisterResult result = registry.registerVoter(person);
		Assert.assertTrue(result != RegisterResult.DUPLICATED);
	}
}