package ec.edu.espe.alertsystem.controller;

import ec.edu.espe.alertsystem.model.Business;
import ec.edu.espe.alertsystem.model.Customer;
import ec.edu.espe.alertsystem.model.NaturalPerson;


/**
 *
 * @author Paulo Ramos
 */
public class CustomerController {
    
    
    public static Customer getCustomerByName(String name) {

        Business business = BusinessController.getBusinessByName(name);
        if (business != null) {
            return business;
        }

        NaturalPerson person = NaturalPersonController.getPersonByName(name);
        if (person != null) {
            return person;
        }

        return null;
    }
}
