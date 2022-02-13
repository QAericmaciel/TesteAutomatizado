
import org.junit.Assert;
import org.junit.Test;             // Importações 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

// Classe 
public class CadastroFacebook {

// Metodo da Classe 
    @Test
    public void testefacebook(){

    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    WebDriver robozinho = new ChromeDriver();
    robozinho.manage().window().maximize();
    robozinho.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    WebDriverWait wait = new WebDriverWait(robozinho, 30);

        // Dados pessoais da sua nova conta 
        robozinho.get("https://pt-br.facebook.com/");
        robozinho.findElement(By.linkText("Criar nova conta")).click();
        robozinho.findElement(By.name("firstname")).sendKeys("Seu Nome");
        robozinho.findElement(By.name("lastname")).sendKeys("Sobrenome");
        robozinho.findElement(By.name("reg_email__")).sendKeys("Seu E-mail");
        robozinho.findElement(By.name("reg_email_confirmation__")).sendKeys("E-mail Novamente");
        robozinho.findElement(By.name("reg_passwd__")).sendKeys("Senha da Sua Conta");
        
        // Sua Data de Nascimento 
        new Select(robozinho.findElement(By.id("day"))).selectByVisibleText("10");
        robozinho.findElement(By.id("day")).click();

        new Select(robozinho.findElement(By.id("month"))).selectByVisibleText("Jul");
        robozinho.findElement(By.id("month")).click();

        new Select(robozinho.findElement(By.id("year"))).selectByVisibleText("2000");
        robozinho.findElement(By.id("year")).click();

        robozinho.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[2]/label")).click();
        robozinho.findElement(By.name("websubmit")).click();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Baixar suas informações")));
        robozinho.findElement(By.linkText("Sair")).click();
        Assert.assertEquals("facebook", robozinho.getTitle());

     }

}

