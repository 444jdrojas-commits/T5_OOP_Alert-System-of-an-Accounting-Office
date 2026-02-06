package ec.espe.edu.alertsystem.view;

import static com.mongodb.assertions.Assertions.assertNotNull;
import ec.edu.espe.alertsystem.view.FrmAddNaturalPerson;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextField;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import utils.Validation;

/**
 *
 * @author Paulo Ramos
 */
public class FrmAddNaturalPersonTest {

    @Test
    public void testInstanceNotNull() {
        FrmAddNaturalPerson frm = new FrmAddNaturalPerson();
        assertNotNull(frm);
    }

    @Test
    public void testDateParsingYear() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        assertDoesNotThrow(() -> Integer.parseInt(sdf.format(now)));
    }

    @Test
    public void testDateParsingMonth() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        assertDoesNotThrow(() -> Integer.parseInt(sdf.format(now)));
    }

    @Test
    public void testDateParsingDay() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        assertDoesNotThrow(() -> Integer.parseInt(sdf.format(now)));
    }

    @Test
    public void testEmptyFieldsClearsName() throws Exception {
        FrmAddNaturalPerson frm = new FrmAddNaturalPerson();
        Field field = FrmAddNaturalPerson.class.getDeclaredField("txtName");
        field.setAccessible(true);
        ((JTextField) field.get(frm)).setText("Paulo");

        Method method = FrmAddNaturalPerson.class.getDeclaredMethod("emptyFields");
        method.setAccessible(true);
        method.invoke(frm);

        assertEquals("", ((JTextField) field.get(frm)).getText());
    }

    @Test
    public void testEmptyFieldsClearCity() throws Exception {
        FrmAddNaturalPerson frm = new FrmAddNaturalPerson();
        Field field = FrmAddNaturalPerson.class.getDeclaredField("txtCity");
        field.setAccessible(true);
        ((JTextField) field.get(frm)).setText("Quito");

        Method method = FrmAddNaturalPerson.class.getDeclaredMethod("emptyFields");
        method.setAccessible(true);
        method.invoke(frm);

        assertEquals("", ((JTextField) field.get(frm)).getText());
    }

    @Test
    public void testEmptyFieldsClearStreet() throws Exception {
        FrmAddNaturalPerson frm = new FrmAddNaturalPerson();
        Field field = FrmAddNaturalPerson.class.getDeclaredField("txtStreet");
        field.setAccessible(true);
        ((JTextField) field.get(frm)).setText("M58");

        Method method = FrmAddNaturalPerson.class.getDeclaredMethod("emptyFields");
        method.setAccessible(true);
        method.invoke(frm);

        assertEquals("", ((JTextField) field.get(frm)).getText());
    }

    @Test
    public void testEmptyFieldsClearSector() throws Exception {
        FrmAddNaturalPerson frm = new FrmAddNaturalPerson();
        Field field = FrmAddNaturalPerson.class.getDeclaredField("txtSector");
        field.setAccessible(true);
        ((JTextField) field.get(frm)).setText("485");

        Method method = FrmAddNaturalPerson.class.getDeclaredMethod("emptyFields");
        method.setAccessible(true);
        method.invoke(frm);

        assertEquals("", ((JTextField) field.get(frm)).getText());
    }

    @Test
    public void testEmptyFieldsClearNationality() throws Exception {
        FrmAddNaturalPerson frm = new FrmAddNaturalPerson();
        Field field = FrmAddNaturalPerson.class.getDeclaredField("txtNationality");
        field.setAccessible(true);
        ((JTextField) field.get(frm)).setText("ecuatoriana");

        Method method = FrmAddNaturalPerson.class.getDeclaredMethod("emptyFields");
        method.setAccessible(true);
        method.invoke(frm);

        assertEquals("", ((JTextField) field.get(frm)).getText());
    }

    @Test
    public void testEmptyFieldsClearCi() throws Exception {
        FrmAddNaturalPerson frm = new FrmAddNaturalPerson();
        Field field = FrmAddNaturalPerson.class.getDeclaredField("txtIdentification");
        field.setAccessible(true);
        ((JTextField) field.get(frm)).setText("1722249388");

        Method method = FrmAddNaturalPerson.class.getDeclaredMethod("emptyFields");
        method.setAccessible(true);
        method.invoke(frm);

        assertEquals("", ((JTextField) field.get(frm)).getText());
    }

    @Test
    public void testEmptyFieldsClearEmail() throws Exception {
        FrmAddNaturalPerson frm = new FrmAddNaturalPerson();
        Field field = FrmAddNaturalPerson.class.getDeclaredField("txtEmail");
        field.setAccessible(true);
        ((JTextField) field.get(frm)).setText("paulo@gmail.com");

        Method method = FrmAddNaturalPerson.class.getDeclaredMethod("emptyFields");
        method.setAccessible(true);
        method.invoke(frm);

        assertEquals("", ((JTextField) field.get(frm)).getText());
    }

    @Test
    public void testEmptyFieldsClearPhone() throws Exception {
        FrmAddNaturalPerson frm = new FrmAddNaturalPerson();
        Field field = FrmAddNaturalPerson.class.getDeclaredField("txtPhone");
        field.setAccessible(true);
        ((JTextField) field.get(frm)).setText("0995785176");

        Method method = FrmAddNaturalPerson.class.getDeclaredMethod("emptyFields");
        method.setAccessible(true);
        method.invoke(frm);

        assertEquals("", ((JTextField) field.get(frm)).getText());
    }

    @Test
    public void testEmptyFieldsClearOcuppation() throws Exception {
        FrmAddNaturalPerson frm = new FrmAddNaturalPerson();
        Field field = FrmAddNaturalPerson.class.getDeclaredField("txtOcuppation");
        field.setAccessible(true);
        ((JTextField) field.get(frm)).setText("1722249388");

        Method method = FrmAddNaturalPerson.class.getDeclaredMethod("emptyFields");
        method.setAccessible(true);
        method.invoke(frm);

        assertEquals("", ((JTextField) field.get(frm)).getText());
    }

    @Test
    public void testInvalidEmailDoesNotPassValidation() {
        String invalidEmail = "correo-malo";

        boolean result = Validation.isEmail(invalidEmail);

        assertFalse(result);
    }

    @Test
    public void testInvalidPhoneDoesNotPassValidation() {
        String invalidPhone = "09ABCD123";

        boolean result = Validation.isInteger(invalidPhone);

        assertFalse(result);
    }

    @Test
    public void testInvalidDataDoesNotPassBusinessRules() {
        String email = "correo-malo";
        String phone = "09ABCD123";

        assertFalse(Validation.isEmail(email));
        assertFalse(Validation.isInteger(phone));
    }

    @Test
    public void testValidDataPassValidation() {
        assertTrue(Validation.isEmail("paulo"));
        assertTrue(Validation.isInteger("09dsa85176"));
        assertTrue(Validation.isAlphabetic("P548ulo"));
    }

}
