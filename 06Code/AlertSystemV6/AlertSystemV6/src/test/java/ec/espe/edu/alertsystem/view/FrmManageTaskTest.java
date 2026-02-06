package ec.espe.edu.alertsystem.view;

import ec.edu.espe.alertsystem.view.FrmManageTask;
import java.lang.reflect.Field;
import javax.swing.JTable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Paulo Ramos
 */
public class FrmManageTaskTest {

    @Test
    public void testInstanceNotNull() {
        FrmManageTask frm = new FrmManageTask();
        assertNotNull(frm);
    }

    @Test
    public void testTableModelColumnCount() throws NoSuchFieldException, IllegalAccessException {
        FrmManageTask frm = new FrmManageTask();
        Field field = FrmManageTask.class.getDeclaredField("tblTask");
        field.setAccessible(true);
        JTable table = (JTable) field.get(frm);
        assertEquals(6, table.getModel().getColumnCount());
    }

    @Test
    public void testColumnNameId() throws NoSuchFieldException, IllegalAccessException {
        FrmManageTask frm = new FrmManageTask();
        Field field = FrmManageTask.class.getDeclaredField("tblTask");
        field.setAccessible(true);
        JTable table = (JTable) field.get(frm);
        assertEquals("ID", table.getModel().getColumnName(0));
    }

    @Test
    public void testColumnDescription() throws NoSuchFieldException, IllegalAccessException {
        FrmManageTask frm = new FrmManageTask();
        Field field = FrmManageTask.class.getDeclaredField("tblTask");
        field.setAccessible(true);
        JTable table = (JTable) field.get(frm);
        assertEquals("Descripcion", table.getModel().getColumnName(1));
    }

    @Test
    public void testColumnNameClient() throws NoSuchFieldException, IllegalAccessException {
        FrmManageTask frm = new FrmManageTask();
        Field field = FrmManageTask.class.getDeclaredField("tblTask");
        field.setAccessible(true);
        JTable table = (JTable) field.get(frm);
        assertEquals("Cliente", table.getModel().getColumnName(2));
    }

    @Test
    public void testColumnNameState() throws NoSuchFieldException, IllegalAccessException {
        FrmManageTask frm = new FrmManageTask();
        Field field = FrmManageTask.class.getDeclaredField("tblTask");
        field.setAccessible(true);
        JTable table = (JTable) field.get(frm);
        assertEquals("Estado", table.getModel().getColumnName(3));
    }

    @Test
    public void testColumnNameAssistant() throws NoSuchFieldException, IllegalAccessException {
        FrmManageTask frm = new FrmManageTask();
        Field field = FrmManageTask.class.getDeclaredField("tblTask");
        field.setAccessible(true);
        JTable table = (JTable) field.get(frm);
        assertEquals("Asistente", table.getModel().getColumnName(4));
    }

    @Test
    public void testColumnNameDeliveryDate() throws NoSuchFieldException, IllegalAccessException {
        FrmManageTask frm = new FrmManageTask();
        Field field = FrmManageTask.class.getDeclaredField("tblTask");
        field.setAccessible(true);
        JTable table = (JTable) field.get(frm);
        assertEquals("Fecha Entrega", table.getModel().getColumnName(5));
    }

}
