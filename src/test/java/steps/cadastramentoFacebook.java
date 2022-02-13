
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class TestandoFaceookComBdd {

    WebDriver robozinho;

    @Before
    public void Master(){

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        robozinho = new ChromeDriver();
        robozinho.manage().window().maximize();
        robozinho.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Dado("o usuario estará na pagina de cadastro da conta do facebook")
    public void oUsuarioEstaráNaPaginaDeCadastroDaContaDoFacebook() {
        robozinho.get("https://pt-br.facebook.com/");
    }

    @Quando("o mesmo irá colocar seus dados pessoais {string}")
    public void o_mesmo_irá_colocar_seus_dados_pessoais(String titulo_esperado) {

        robozinho.findElement(By.linkText("Criar nova conta")).click();
        robozinho.findElement(By.name("firstname")).sendKeys("Eric Maciel");
        robozinho.findElement(By.name("lastname")).sendKeys("Ferreira");
        robozinho.findElement(By.name("reg_email__")).sendKeys("ericmaciel173@gmail.com");
        robozinho.findElement(By.name("reg_email_confirmation__")).sendKeys("ericmaciel173@gmail.com");
        robozinho.findElement(By.name("reg_passwd__")).sendKeys("5616541%$#");

        new Select(robozinho.findElement(By.id("day"))).selectByVisibleText("10");
        robozinho.findElement(By.id("day")).click();
        new Select(robozinho.findElement(By.id("month"))).selectByVisibleText("Jul");
        robozinho.findElement(By.id("month")).click();
        new Select(robozinho.findElement(By.id("year"))).selectByVisibleText("2000");
        robozinho.findElement(By.id("year")).click();

        robozinho.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[2]/label")).click();
        robozinho.findElement(By.name("websubmit")).click();
        
       }

       @Entao("o usuario irá realizar o cadastro com {string}")
       public void o_usuario_irá_realizar_o_cadastro_com(String titulo_esperado){

           Assert.assertEquals(titulo_esperado, robozinho.getTitle());
       }

    }

