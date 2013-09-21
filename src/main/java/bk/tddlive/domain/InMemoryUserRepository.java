package bk.tddlive.domain;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository { // implements UserRepository {
	private Map<String, User> userMap = new HashMap<>();

	public InMemoryUserRepository(String data) {
		String[] lines = StringUtils.tokenizeToStringArray(data, "\n");
		for (String line : lines)
			addUser(line);
	}

	private void addUser(String data) {
		String[] userData = StringUtils.tokenizeToStringArray(data, "=");
		userMap.put(userData[0], new User(userData[0], userData[1]));
	}

	//@Override
	public User findById(String userId) {
		return userMap.get(userId);
	}
	
}
