package api;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.CoreMatchers.*;

public class RestApiTests {
    private String baseUrl = "https://swapi.co/api/people";

    @Test
    public void checkWhoIsTheFirstPerson() {
        given().when().get(baseUrl + "/1").then().
                body("name", equalTo("Luke Skywalker"));
    }

    @Test
    public void checkThatPersonFromAppropriatePlanet() {
        String response = get(baseUrl + "/1").asString();
        String planetUrl = from(response).getString("homeworld");
        given().when().get(planetUrl).then().body("name", equalTo ("Tatooine"));
    }

    @Test
    public void checkPopulationInPersonsPlanet() {
        String response = get(baseUrl + "/1").asString();
        String planetUrl = from(response).getString("homeworld");
        given().when().get(planetUrl).then().body("population", equalTo ("200000"));
    }

    @Test
    public void checkTheTitleOfFirstFilmInPlanet(){
        String responseFromFirstPeople = get(baseUrl + "/1").asString();
        String planetUrl = from(responseFromFirstPeople).getString("homeworld");
        String  responseFromPlanet = get(planetUrl).asString();
        String filmUrl = from(responseFromPlanet).getString("films[0]");
        given().when().get(filmUrl).then().
                body("title", equalTo ("Attack of the Clones"));
    }

    @Test
    public void checkThePeopleAndPlanetPresenceInTheFilm(){
        String responseFromFirstPeople = get(baseUrl + "/1").asString();
        String planetUrl = from(responseFromFirstPeople).getString("homeworld");
        String  responseFromPlanet = get(planetUrl).asString();
        String filmUrl = from(responseFromPlanet).getString("films[0]");
        given().when().get(filmUrl).then().
                body("characters", not(hasItem(baseUrl + "/1"))).
                body("planets", hasItems(planetUrl));
    }
}



