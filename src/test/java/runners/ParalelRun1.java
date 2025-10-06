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

@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME,value = "@paralel1")

@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME,value = "false")

//@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, html:target/cucumber-report/HtmlReport1.html")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, json:target/json-reports/cucumberRapor1.json")
//@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, junit:target/xml-report/cucumber1.xml")



public class ParalelRun1 {

    /*
        Cucumber'da toplu calistirmayi Runner class'ından yapiyoruz

        Paralel olarak birden fazla browser'i calistirması icin
        birden fazla Runner class hazırlamaliyiz

        Birden fazla Runner class'i oldugunda, hepsini birlikte
        manuel olarak calistirmamiz MÜMKÜn olmadıgından
        Termina'den bu Runner class'lari calistirabilecegmiz
        bir yapi olusturmaliyiz

        Terminalden Runner class calistirmak icin
        1-MAven'i sistem degiskenlerine eklemeliyiz
        2-pom.xml'e terminalden calistirmayi saglayacak
        ve bize güzel html raporlar olusturacak
        bazı pluginleri eklemeliyiz
        3- ekledigimiz plugin'lerde
           calisacak Runner adedi ve
           calisacak Runner'larin bulundugu yer
           ve isimlerindeki ortak bolumu guncellememiz gerekir
        4- Terminal'den mvn clean verify yazarak
           pluginler uzerinden istenen Runner Class'lar calistirilabilir

     */



}
