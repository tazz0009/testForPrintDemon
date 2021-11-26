package com.tazz009.test;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@SpringBootApplication
@RestController
@CrossOrigin(origins="*")
public class TestForPrintDemonApplication {

	@ResponseBody
	@GetMapping("/getPrintStatus")
	public String greeting() {
		JsonObject obj =new JsonObject();

	    obj.addProperty("canPrint", true);
	    obj.addProperty("content", "테스트3 내용");

	    JsonArray printData = new JsonArray();

	    printData.add("1234567890");

	    obj.add("printData", printData);

	    return obj.toString();
	}

	@ResponseBody
	@PostMapping("/postPrintList")
	public String postPrintList(
			@RequestParam(required = false, value = "arr[]") List<Integer> arr,
			@RequestParam(required = false, value = "name") String name
			) {
		JsonObject obj =new JsonObject();
		obj.addProperty("name", name);
		JsonArray printData = new JsonArray();
		for (int i = 0; i < arr.size(); i++) {
			Integer num = arr.get(i);
			printData.add(num);
		}
	    obj.add("printData", printData);
		return obj.toString();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TestForPrintDemonApplication.class, args);
	}

}
