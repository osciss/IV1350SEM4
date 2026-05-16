package se.kth.iv1350.repairelectricbike.integration;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.repairelectricbike.integration.exception.CustomerNotFoundException;
import se.kth.iv1350.repairelectricbike.integration.exception.DatabaseFailureException;
import se.kth.iv1350.repairelectricbike.model.dto.CustomerDTO;

/**
 * Unit tests for the CustomerRegistry class.
 */
public class CustomerRegistryTest {

    private CustomerRegistry customerRegistry;

    private static final String EXISTING_PHONE = "01234";
    private static final String NONEXISTENT_PHONE = "00000";
    private static final String DB_FAILURE_PHONE = "99999";

    @BeforeEach
    public void setUp() {
        RegistryCreator creator = new RegistryCreator();
        customerRegistry = creator.getCustomerRegistry();
    }

    @Test
    public void testFindCustomerReturnsOscarForExistingPhone() throws CustomerNotFoundException {
        CustomerDTO customer = customerRegistry.findCustomer(EXISTING_PHONE);
        assertNotNull(customer, "Customer should not be null for existing phone.");
        assertEquals("Oscar", customer.getName(), "Customer name should be Oscar.");
    }

    @Test
    public void testFindCustomerThrowsCustomerNotFoundExceptionForUnknownPhone() {
        assertThrows(CustomerNotFoundException.class,
                () -> customerRegistry.findCustomer(NONEXISTENT_PHONE),
                "Should throw CustomerNotFoundException for unknown phone number.");
    }

    @Test
    public void testCustomerNotFoundExceptionContainsPhoneNumber() {
        CustomerNotFoundException ex = assertThrows(CustomerNotFoundException.class,
                () -> customerRegistry.findCustomer(NONEXISTENT_PHONE),
                "Should throw CustomerNotFoundException for unknown phone number.");
        assertEquals(NONEXISTENT_PHONE, ex.getPhoneNumber(),
                "Exception should contain the phone number that was not found.");
    }

    @Test
    public void testFindCustomerThrowsDatabaseFailureExceptionForSimulatedFailure() {
        assertThrows(DatabaseFailureException.class,
                () -> customerRegistry.findCustomer(DB_FAILURE_PHONE),
                "Should throw DatabaseFailureException for the simulated failure phone number.");
    }

    @Test
    public void testFindCustomerReturnsAleenaForExistingPhone() throws CustomerNotFoundException {
        CustomerDTO customer = customerRegistry.findCustomer("05678");
        assertNotNull(customer, "Customer should not be null for existing phone.");
        assertEquals("Aleena", customer.getName(), "Customer name should be Aleena.");
    }

    @Test
    public void testFindCustomerReturnsEmiliaForExistingPhone() throws CustomerNotFoundException {
        CustomerDTO customer = customerRegistry.findCustomer("091011");
        assertNotNull(customer, "Customer should not be null for existing phone.");
        assertEquals("Emilia", customer.getName(), "Customer name should be Emilia.");
    }

    @Test
    public void testFindCustomerReturnsNullForUnknownPhone() {
        assertThrows(CustomerNotFoundException.class,
                () -> customerRegistry.findCustomer(NONEXISTENT_PHONE),
                "findCustomer should throw for an unknown phone number.");
    }
}