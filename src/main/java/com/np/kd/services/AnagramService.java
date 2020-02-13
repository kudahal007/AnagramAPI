package com.np.kd.services;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.np.kd.model.Response;

@Service
public class AnagramService {

	public Response checkAnagram(String string1, String string2) {
		return new Response(check(string1, string2));

	}

	boolean check(String string1, String string2) {
		if (StringUtils.isEmpty(string1) || StringUtils.isEmpty(string2)) {
			return false;
		}

		String str1 = string1.replaceAll("\\s", "").toUpperCase();
		String str2 = string2.replaceAll("\\s", "").toUpperCase();

		if (str1.length() != str2.length()) {
			return false;
		}

		HashMap<Character, Integer> hashMap = new HashMap<>();
		for (char c : str1.toCharArray()) {
			if (!hashMap.containsKey(c)) {
				hashMap.put(c, 1);
			} else {
				hashMap.put(c, hashMap.get(c) + 1);
			}
		}

		for (char c : str2.toCharArray()) {
			if (!hashMap.containsKey(c)) {
				return false;
			} else {
				hashMap.put(c, hashMap.get(c) - 1);
			}
			if (hashMap.get(c) == 0) {
				hashMap.remove(c);
			}
		}
		return hashMap.isEmpty();
	}

}
