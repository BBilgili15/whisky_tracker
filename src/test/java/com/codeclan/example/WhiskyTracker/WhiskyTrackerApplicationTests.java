package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@ActiveProfiles("test") //Indicates it's a test profile so will not run DataLoader
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	private WhiskyRepository whiskyRepository;
	@Autowired
	private DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskyByAge() {
		List<Whisky> foundWhiskies = whiskyRepository.findByAge(12);
		assertEquals(12, foundWhiskies.size());
	}

	@Test
	public void canFindWhiskyByRegion() {
		List<Whisky> foundWhiskies = whiskyRepository.findByDistillery_Region("Speyside");
		assertEquals(9, foundWhiskies.size());
	}

	@Test
	public void canFindWhiskyByAgeAndDistillery() {
		List<Whisky> foundWhiskies = whiskyRepository.findByAgeAndDistillery_Id(12, 1L);
		assertEquals(1, foundWhiskies.size());
	}

	@Test
	public void canFindAllWhiskyByRegion() {
		List<Distillery> foundDistilleries = distilleryRepository.findByRegion("Speyside");
		List<Whisky> allWhiskies = new ArrayList<>();
		for (Distillery distillery : foundDistilleries) {
			for (Whisky whisky : distillery.getWhiskies()) {
				allWhiskies.add(whisky);
			}
		}
		assertEquals(15, allWhiskies.size());
	}





}
