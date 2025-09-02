package runners;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("src/test/java")
@ConfigurationParameter(key = Constants.FEATURES_PROPERTY_NAME,value = "src/test/resources/features")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME,value = "stepdefinitions")
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME,value = "@smoke")
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME,value = "false")

//@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, html:target/cucumber-report/HtmlReport.html")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, json:target/json-reports/cucumberRapor.json")
//@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, junit:target/xml-report/cucumber.xml")




public class Runner {


    /*
        Cucumber'daki Runner Class'i icinde hicbir kod yazilmaz

        Gorevi TestNG'deki .xml dosyalari gibi
        toplu calistirmayi saglamaktir.

        Runner class'i gorevini
        kullanacagimiz notasyon'lar ile gerceklestirir.
     */
    /*
        @IncludeEngines("cucumber") : Class'in cucumber ile calimasini sağlar
        @SelectClasspathResource("src/test/java") : Java class'larini bulacagi dosya yolu



       Constants.FEATURES_PROPERTY_NAME  : "src/test/resources/features"
       calisrilacak feature dosyalarinin yerini gosterir

       Constants.GLUE_PROPERTY_NAME : "stepdefinitions"
       belirlenen feature dosyalarini calistirmak icin
       kullanilacak stepdefinationlarin bulunduğu  package'in dosya yolu

       EGER sadce bu notasyonlari kullanirsak,
       features klasoru icindeki tum feature'leri calistirir

       istedigimiz feature'lari calistirmak icin
       cucumber 2 altarnatif sunar
       1- istedigimiz feature'lari bir klasor icine koyup
       sadce o klasoru calistirmasini isteyebilirsiniz
       2-istediginiz Feature veya senaryolari bir tag ile belirleyip,
       Constants.FILTER_TAGS_PROPERTY_NAME:  "@smoke"

       EGER Runner dosyası ile calistirdigimiz feature dosyalarini
       SADECE eksik stepdefination'lari bulmak ve method'larini olusturmak icin
        calistiriyorsak

       Constants.EXECUTION_DRY_RUN_PROPERTY_NAME  :  "true" yapariz

       dryRun degeri true iken Runner SADECE eksik adim kontrolu yapar
       Feature veya Scenario'lari calistirmaz
       eksik adim varsa failed deyip eksik adimlari verir
       eksik adim yoksa passed deyip calismayi bitirir








     */
}
