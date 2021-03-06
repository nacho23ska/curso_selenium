package ExamenNivelInicial;

import C13_Factories_y_Waits.DocusignFactoryTest;
import org.testng.annotations.Factory;

public class testFactory {

    @Factory
    public Object[] factoryMethod(){
        return new Object[] {
                new prueba_mailchimp(),
                new prueba_mailchimp()
        };
    }

}
