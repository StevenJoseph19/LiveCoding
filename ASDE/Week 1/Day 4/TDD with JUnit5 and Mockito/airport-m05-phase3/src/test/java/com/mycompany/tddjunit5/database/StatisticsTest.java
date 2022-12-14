package com.mycompany.tddjunit5.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import com.mycompany.tddjunit5.MockitoExtension;
import com.mycompany.tddjunit5.airport.Flight;
import static com.mycompany.tddjunit5.database.DatabaseUtil.buildFlightsList;;

@ExtendWith(MockitoExtension.class)
public class StatisticsTest {

//	@Mock
	@Spy
	Database database;

	private List<List<String>> queriedData;
	private List<Flight> flightsList;

	@BeforeEach
	void before() {
		queriedData = new ArrayList<>();
		List<String> row1 = Arrays.asList("1", "e", "Mike", "false", "349");
		List<String> row2 = Arrays.asList("2", "b", "John", "true", "278");
		List<String> row3 = Arrays.asList("3", "e", "Mike", "false", "319");
		List<String> row4 = Arrays.asList("4", "pO", "John", "true", "817");
		List<String> row5 = Arrays.asList("5", "e", "Mike", "false", "623");
		List<String> row6 = Arrays.asList("6", "e", "John", "true", "978");

		queriedData.add(row1);
		queriedData.add(row2);
		queriedData.add(row3);
		queriedData.add(row4);
		queriedData.add(row5);
		queriedData.add(row6);
	}

	@Test
	void testQueriedData() {

		when(database.queryFlightsDatabase()).thenReturn(queriedData);
		flightsList = buildFlightsList(queriedData);

		assertEquals(6, database.queryFlightsDatabase().size());
		assertEquals(6, flightsList.size());
		assertEquals(560.666, database.averageDistance(flightsList), 0.001);
		assertEquals(278, database.minimumDistance(flightsList));
		assertEquals(978, database.maximumDistance(flightsList));

	}
}
