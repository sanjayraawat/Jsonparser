package com.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
public class JsonParserTest {
	public static void main(String[] args) throws IOException {
		String data = new String(Files.readAllBytes(Paths.get("C:/json.txt"))); 
		JsonElement jsonElement = JsonParser.parseString(data);
		JsonObject json = jsonElement.getAsJsonObject();
		System.out.println(json.get("userId"));
		System.out.println(json.get("id"));
		System.out.println(json.get("title"));
		System.out.println(json.get("completed"));
	}
}
