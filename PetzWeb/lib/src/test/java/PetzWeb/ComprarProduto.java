package PetzWeb;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.Home;
import pages.Lista;
import pages.Produto;

public class ComprarProduto {
	
	String url; 
	WebDriver driver; 
	
	Home home; //objeto home herdando a classe Home
	Lista lista; //objeto lista herdando a classe Lista
	Produto produto; //objeto produto herdando a classe Produto
	
	@Before
	public void iniciar() {
		url = "https://www.petz.com.br";
		
		System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS); 
		
		home = new Home(driver); //instanciar (ligar) a página(classe) Home.
		lista = new Lista(driver); //instanciar (ligar) a página(classe) Lista.
		produto = new Produto(driver); //instanciar (ligar) a página(classe) Produto.
	}
	
	@After 
	public void finalizar() {
		driver.quit();
	}

	@Dado("que acesso o site Petz")
	public void que_acesso_o_site_petz() {
	    driver.get(url); //Abre o site da Petz
	}

	@Quando("busco por {string} e pressiono enter")
	public void busco_por_e_pressiono_enter(String produto) {
	    home.buscarProdutoComEnter(produto);
	}

	@Entao("exibe uma lista de produtos relacionados com {string}")
	public void exibe_uma_lista_de_produtos_relacionados_com(String produto) {
		assertEquals("Resultados para \"" + produto + "\"",lista.lerCabecalhoResultados());
	}

	@Quando("escolho {string}")
	public void escolho(String produto) {
		lista.clicarProduto(produto);
	}

	@Entao("exibe para o {string} o preço de {string}")
	public void exibe_para_o_o_preço_de(String tamanho, String preco) {
	    assertEquals(""+ tamanho +"", produto.lerTamanhoProduto());
	    assertEquals(""+ preco +"", produto.lerPrecoProduto());
	}
	
	@Entao("clico no botão Adicionar ao Carrinho")
	public void clico_no_botão_adicionar_ao_carrinho() {
		produto.adicionarCarrinho();
	}


	
}
