package edu.eci.cvds.tdd.registry;

import java.util.Hashtable;

public class Registry {

	private Hashtable<Integer, Person> registered = new Hashtable<Integer, Person>();

	public RegisterResult registerVoter(Person p) {
		RegisterResult state;

		if (0 <= p.getAge() && p.getAge() <= 500) {
			if (p.isAlive()) {
				if (p.getAge() >= 18) {
					if (registered.get(p.getId()) == null) {
						registered.put(p.getId(), p);
						state = RegisterResult.VALID;
					} else {
						state = RegisterResult.DUPLICATED;
					}
				} else {
					state = RegisterResult.UNDERAGE;
				}
			} else {
				state = RegisterResult.DEAD;
			}
		} else {
			state = RegisterResult.INVALID_AGE;
		}
		return state;
	}
}