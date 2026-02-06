package ec.espe.edu.alertsystem.view;

import static com.mongodb.assertions.Assertions.assertNotNull;
import ec.edu.espe.alertsystem.view.FrmAddBussines;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Paulo Ramos
 */
public class FrmAddBussinesTest {

    @Test
    public void testInstanceNotNull() {
        FrmAddBussines frm = new FrmAddBussines();
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
        FrmAddBussines frm = new FrmAddBussines();
        Field field = FrmAddBussines.class.getDeclaredField("txtNameBussines");
        field.setAccessible(true);
        ((JTextField) field.get(frm)).setText("Caramelos");

        Method method = FrmAddBussines.class.getDeclaredMethod("emptyFields");
        method.setAccessible(true);
        method.invoke(frm);

        assertEquals("", ((JTextField) field.get(frm)).getText());
    }

    @Test
    public void testEmptyFieldsClearsLegalRepresentative() throws Exception {

        final FrmAddBussines[] frm = new FrmAddBussines[1];

        SwingUtilities.invokeAndWait(() -> {
            frm[0] = new FrmAddBussines();
        });

        Field field = FrmAddBussines.class.getDeclaredField("txtLegalRepresentative");
        field.setAccessible(true);

        JTextField txt = (JTextField) field.get(frm[0]);
        assertNotNull(txt);

        txt.setText("Caramelos");

        Method method = FrmAddBussines.class.getDeclaredMethod("emptyFields");
        method.setAccessible(true);
        method.invoke(frm[0]);

        assertEquals("", txt.getText());
    }

    @Test
    public void testEmptyFieldTypeBussines() throws Exception {
        FrmAddBussines frm = new FrmAddBussines();
        Field field = FrmAddBussines.class.getDeclaredField("txtTypeBusiness");
        field.setAccessible(true);
        ((JTextField) field.get(frm)).setText("999");

        Method method = FrmAddBussines.class.getDeclaredMethod("emptyFields");
        method.setAccessible(true);
        method.invoke(frm);

        assertEquals("", ((JTextField) field.get(frm)).getText());
    }

    @Test
    public void testEmptyFieldsClearCity() throws Exception {
        FrmAddBussines frm = new FrmAddBussines();
        Field field = FrmAddBussines.class.getDeclaredField("txtCity");
        field.setAccessible(true);
        ((JTextField) field.get(frm)).setText("8999");

        Method method = FrmAddBussines.class.getDeclaredMethod("emptyFields");
        method.setAccessible(true);
        method.invoke(frm);

        assertEquals("", ((JTextField) field.get(frm)).getText());
    }

    @Test
    public void testEmptyFieldsClearStreet() throws Exception {
        FrmAddBussines frm = new FrmAddBussines();
        Field field = FrmAddBussines.class.getDeclaredField("txtStreet");
        field.setAccessible(true);
        ((JTextField) field.get(frm)).setText("Q51");

        Method method = FrmAddBussines.class.getDeclaredMethod("emptyFields");
        method.setAccessible(true);
        method.invoke(frm);

        assertEquals("", ((JTextField) field.get(frm)).getText());
    }

    @Test
    public void testEmptyFieldsClearSector() throws Exception {
        FrmAddBussines frm = new FrmAddBussines();
        Field field = FrmAddBussines.class.getDeclaredField("txtSector");
        field.setAccessible(true);
        ((JTextField) field.get(frm)).setText("Quito");

        Method method = FrmAddBussines.class.getDeclaredMethod("emptyFields");
        method.setAccessible(true);
        method.invoke(frm);

        assertEquals("", ((JTextField) field.get(frm)).getText());
    }

    @Test
    public void testEmptyFieldsClearRuc() throws Exception {
        FrmAddBussines frm = new FrmAddBussines();
        Field field = FrmAddBussines.class.getDeclaredField("txtRuc");
        field.setAccessible(true);
        ((JTextField) field.get(frm)).setText("1748597859785");

        Method method = FrmAddBussines.class.getDeclaredMethod("emptyFields");
        method.setAccessible(true);
        method.invoke(frm);

        assertEquals("", ((JTextField) field.get(frm)).getText());
    }

    @Test
    public void testEmptyFieldsClearPhone() throws Exception {
        FrmAddBussines frm = new FrmAddBussines();
        Field field = FrmAddBussines.class.getDeclaredField("txtPhone");
        field.setAccessible(true);
        ((JTextField) field.get(frm)).setText("0995785176");

        Method method = FrmAddBussines.class.getDeclaredMethod("emptyFields");
        method.setAccessible(true);
        method.invoke(frm);

        assertEquals("", ((JTextField) field.get(frm)).getText());
    }

    @Test
    public void testEmptyFieldsClearEmail() throws Exception {
        FrmAddBussines frm = new FrmAddBussines();
        Field field = FrmAddBussines.class.getDeclaredField("txtEmail");
        field.setAccessible(true);
        ((JTextField) field.get(frm)).setText("paulo@gmail.com");

        Method method = FrmAddBussines.class.getDeclaredMethod("emptyFields");
        method.setAccessible(true);
        method.invoke(frm);

        assertEquals("", ((JTextField) field.get(frm)).getText());
    }

    @Test
    public void testEmptyFieldsClearHour() throws Exception {
        FrmAddBussines frm = new FrmAddBussines();
        Field field = FrmAddBussines.class.getDeclaredField("txtHour");
        field.setAccessible(true);
        ((JTextField) field.get(frm)).setText("14:45");

        Method method = FrmAddBussines.class.getDeclaredMethod("emptyFields");
        method.setAccessible(true);
        method.invoke(frm);

        assertEquals("", ((JTextField) field.get(frm)).getText());
    }

    @Test
    public void testEmptyFieldsClearDescription() throws Exception {
        FrmAddBussines frm = new FrmAddBussines();

        Field field = FrmAddBussines.class.getDeclaredField("txtDescription");
        field.setAccessible(true);

        JTextArea txt = (JTextArea) field.get(frm);
        txt.setText("Hola");

        Method method = FrmAddBussines.class.getDeclaredMethod("emptyFields");
        method.setAccessible(true);
        method.invoke(frm);

        assertEquals("", txt.getText());
    }

}
