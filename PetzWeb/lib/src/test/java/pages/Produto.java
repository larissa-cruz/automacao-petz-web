package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Produto extends PageObject{

	public Produto(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//b[contains(.,'Tamanho M')]")
	private WebElement tamanhoProduto;
	
	@FindBy(xpath = "//strong[contains(.,'R$ 59,00')]")
	private WebElement precoProduto;
	
	@FindBy(xpath = "//button[@id='adicionarAoCarrinho']")
	private WebElement botaoAdicionarCarrinho;
	
	public String lerTamanhoProduto() {
		
		return tamanhoProduto.getText();
	}
	
	public String lerPrecoProduto() {
		return precoProduto.getText();
	}
	
	public void adicionarCarrinho() {
		botaoAdicionarCarrinho.click();
	}

}
