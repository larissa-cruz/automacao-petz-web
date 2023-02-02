package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Lista extends PageObject {

	//@FindBy(xpath = "//h3[@itemprop='name'][contains(.,'Coleira Zee.Dog Ella para Cães')]")
	//private WebElement produtoDesejado;
	
	@FindBy(xpath = "//h1[contains(text(),'Resultados para \"coleira\"')]")
	private WebElement cabecalhoResultado;

	public Lista(WebDriver driver) {
		super(driver);
	}
	
	public String lerCabecalhoResultados() {
		
		//WebElement cabecalhoResultado = driver.findElement(By.xpath("//h1[contains(text(),'Resultados para \"coleira\"')]"));
		
		return cabecalhoResultado.getText();
		
	}
	
	public void clicarProduto(String produto) {
		//produtoDesejado.click();
		WebElement produtoDesejado = driver.findElement(By.xpath("//h3[@itemprop='name'][contains(.,'" + produto + "')]"));
		//acima é uma forma de fazer a busca do produto com nome genérico por parâmetro,
		//não fiz isso com o FindBy lá em cima, pois o FindBy não aceita parâmetro.
		//Essa forma sempre buscará o texto que está dentro das "" no arquivo .feature
		produtoDesejado.click();
	}
	
	
}