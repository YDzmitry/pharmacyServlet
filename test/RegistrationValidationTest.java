import com.vironit.pharmacy.exception.RegistrationValidatorException;
import com.vironit.pharmacy.validator.RegistrationValidator;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class RegistrationValidationTest {

    private RegistrationValidator registrationValidator;

    @Before
    public void beforeTestValidator(){
        registrationValidator = new RegistrationValidator();
    }

    @Test(expected = RegistrationValidatorException.class)
    public void testAllFieldsValidator() {
        String login = "123+";
        String password = "123asa";
        String passport = "123a12";
        registrationValidator.validate(login,password,passport);
    }

    @Test
    public void testWrongLoginField(){
        String login = "21";
        String password = "123as123a";
        String passport = "MP3256743";
        try {
            registrationValidator.validate(login,password,passport);
        }catch (RegistrationValidatorException ex){
            assertEquals("Логин должен состоять из букв, цифр, дефисов " +
                                     "и подчёркивания, длина пароля должна быть не меньше 3 и не больше 16 символов", ex.getErrMessageMap().get("login"));
        }
    }

    @Test
    public void testWrongPasswordField(){
        String login = "qwewsasdqw";
        String password = "2a";
        String passport = "MP3256743";
        try {
            registrationValidator.validate(login,password,passport);
        }catch (RegistrationValidatorException ex){
            assertEquals("Пароль должен состоять из букв, цифр, дефисов " +
                    "и подчёркивания, длина пароля должна быть не меньше 6 и не больше 18 символов", ex.getErrMessageMap().get("password"));
        }
    }


    @Test
    public void testWrongPassportField(){
        String login = "2rtyy1";
        String password = "123as123a";
        String passport = "MP325673";
        try {
            registrationValidator.validate(login,password,passport);
        }catch (RegistrationValidatorException ex){
            assertEquals("Паспорт должен начинаться с 2 букв латинского алфавита " +
                    "и иметь 7 цифр", ex.getErrMessageMap().get("passport"));
        }
    }

    @Test
    public void testCorrectLoginField(){
        String login = "asaswsas";
        String password = "123as123a";
        String passport = "MP3256743";
        try {
            registrationValidator.validate(login,password,passport);
        }catch (RegistrationValidatorException ex){
            assertEquals(false, ex.getErrMessageMap().containsKey("login"));
        }
    }

    @Test
    public void testCorrectPasswordField(){
        String login = "qwewsasdqw";
        String password = "2artyyyyto";
        String passport = "MP356743";
        try {
            registrationValidator.validate(login,password,passport);
        }catch (RegistrationValidatorException ex){
            assertEquals(false, ex.getErrMessageMap().containsKey("password"));
        }
    }


    @Test
    public void testCorrectPassportField(){
        String login = "2rtyy1";
        String password = "23a";
        String passport = "MP3256703";
        try {
            registrationValidator.validate(login,password,passport);
        }catch (RegistrationValidatorException ex){
            assertEquals(false, ex.getErrMessageMap().containsKey("passport"));
        }
    }



}