package RunOperators;

import Elements.PrElement;
import Utility.BaseDriverMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestCase4_2 extends BaseDriverMethod {
    @Test
    @Parameters("elements")
    public void US_04_TabMenu2(String element){
        PrElement pr=new PrElement();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));

        for (int i = 0; i < pr.listheader.size(); i++) {
            WebElement tabMenu = pr.listheader.get(i);
            System.out.println(tabMenu.getText());

        }
        pr.elementfindersText(pr.computers);
        pr.elementfindersText(pr.electronics);
        pr.elementfindersText(pr.apparel);



        pr.search.sendKeys(element, Keys.ENTER);

        // random bir ürün seçildi .

        int randomSelect = NoopElement.randomGenerator(pr.productTitle.size());
        wait.until(ExpectedConditions.urlContains(element));

        List<String> stringList = new ArrayList<>();
        for (WebElement element : pr.productTitle) {
            stringList.add(element.getText());
        }
        new Actions(driver).scrollByAmount(200,0);
        pr.productTitle.get(randomSelect).click();

        Assert.assertTrue(stringList.contains(pr.productName.getText()),"Bulunamadı");

    }
}
