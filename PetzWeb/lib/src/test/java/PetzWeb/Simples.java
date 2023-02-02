//1 - Nome do pacote
package PetzWeb;

//2 - Bibliotecas Importadas
import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//3 - Classe
public class Simples {
	//3.1 - Atributos
	String url; //endereço do site
	WebDriver driver; //Esse daqui é o Selenium, o objeto do Selenium WebDriver
	
	//3.2 - Métodos ou Funções
	@Before //Antes do teste
	public void iniciar() {
		url = "https://www.petz.com.br";
		
		System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS); //Espera implícita de 30 segundos
	}
	
	@After //Depois do teste
	public void finalizar() {
		driver.quit();
	}
	
	@Test //O teste
	public void abrirPagina() {
		driver.get(url); //Vai abrir a página da Petz
		assertEquals("Pet Shop: Petz o maior pet shop do Brasil.", driver.getTitle()); //Validação da mensagem do título.
	}
}
