package co.edu.eafit.safebuy.util;

import java.io.IOException;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class RegisterBuyerPageTest {

	@Test
	public void testTitle() {
		// Setup
		RegisterBuyerPage page = new RegisterBuyerPage();
		// Exercise
		String title = page.getTitle();
		// Verify
		Assert.assertEquals("Registrar Comprador", title);
		// Tear down
		page.close();
	}

	@Test
	public void testEmpty() {
		RegisterBuyerPage page = new RegisterBuyerPage();
		page.submit();
		String message = page.getErrorMessage();
		Assert.assertEquals("El Nombre de usuario no puede estar vacio",
				message);
		page.close();
	}

	@Test
	public void testHappyPath() {
		RegisterBuyerPage page = new RegisterBuyerPage();
		page.fillForm("svelez" + new Random().nextInt(), "Sebastian", "Velez",
				"05-05-2013", "sebasv89@gmail.com");
		page.submit();
		String message = page.getSuccessMessage();
		Assert.assertEquals("Comprador Creado", message);
		page.close();
	}

	@Test
	public void testDuplicatedUser() throws IOException {
		RegisterBuyerPage page = new RegisterBuyerPage();
		String userName = "svelez" + new Random().nextInt();
		page.fillForm(userName, "Sebastian", "Velez", "05-05-2013",
				"sebasv89@gmail.com");
		page.submit();
		page.close();

		page = new RegisterBuyerPage();
		page.fillForm(userName, "Sebastian", "Velez", "05-05-2013",
				"sebasv89@gmail.com");
		page.submit();
		String message = page.getErrorMessage();
		Assert.assertEquals("El usuario comprador ya existe: " + userName,
				message);
		// page.takeScreenshot("/Users/sebastian/Desktop/myScreenshot.png");
		page.close();
	}
}
