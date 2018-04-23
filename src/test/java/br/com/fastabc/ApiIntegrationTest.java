package br.com.fastabc;

import br.com.fastabc.model.Book;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ApiIntegrationTest {

	private static final String API_ROOT
			= "http://localhost:8081/api/books";

	@Before
	public void setUp() {
		authentication = preemptive().basic("rodimes", "123");
	}

	private Book createRandomBook() {
		Book book = new Book();
		book.setTitle(UUID.randomUUID().toString());
		book.setAuthor(UUID.randomUUID().toString());
		return book;
	}

	private String createBookAsUri(Book book) {
		Response response = given()
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.body(book)
				.post(API_ROOT);

		return API_ROOT + "/" + response.jsonPath().get("id");
	}


	@Test
	public void whenGetAllBooks_thenOK() {
		Response response = get(API_ROOT);
		assertEquals(HttpStatus.OK.value(), response.getStatusCode());
	}



	@Test
	public void whenGetBooksByTitle_thenOK() {
		Book book = createRandomBook();
		createBookAsUri(book);
		Response response = get(
				API_ROOT + "/title/" + book.getTitle());

		assertEquals(HttpStatus.OK.value(), response.getStatusCode());
		assertTrue(response.as(List.class)
				.size() > 0);
	}
}
