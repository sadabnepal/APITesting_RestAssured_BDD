Feature: Test Add and Delete place of google map

	@AddPlace
	Scenario: Test Add Place
	    Given User calls "AddPlaceAPI" with "POST" http request
	    Then Status code is 200
	    And "status" in response body is "OK"
	    And "scope" in response body is "APP"
	    And I retrieve the Place ID
	    
	 
	@DeletePlace
	Scenario: Test Delete Place
	    Given User calls "DeletePlaceAPI" with "POST" http request
	    Then Status code is 200
	    And "status" in response body is "OK"