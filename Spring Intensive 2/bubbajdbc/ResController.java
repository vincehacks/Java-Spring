/* Created by Vince Chang
 * Example of Spring MVC Pattern
 * This Controller will interact with the services, to be specific it will
 * interact with the PurchaseSvc interface  & CustomerSvc interface. It will
 * have access to all of its implementation methods and any other dependencies!
 * This also defines all the routes.
 */

package com.example.bubba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// This annotation is how to distinguish that this class is a Controller
@RestController
public class ResController{

  // This annotation goes to PurchasSvc.java and intiantiates a psvc
  // Equivalent to private PurchaseSvc psvc = new PurchaseSvc();
  @Autowired
  private PurchaseSvc psvc;

  @Autowired
  private CustomerSvc csvc;

  // When querying this route, I will return a Purchase Object matching the id
  @RequestMapping(path="/purchase/{id}", method = RequestMethod.GET)
  @ResponseBody
  public Purchase findPurchaseById(@PathVariable("id") int id) {
    return psvc.findPurchaseById(id);
  }

  // When querying this route, I will return a Customer Object matching the id
  @RequestMapping(path="/customer/{id}", method = RequestMethod.GET)
  @ResponseBody
  public Customer findCustomerById(@PathVariable("id") int id) {
    return csvc.findCustomerById(id);
  }

  // This will save a Purchase into PURCHASES table (Purchase.java)
  @RequestMapping(path="/addEditPurchase", method = RequestMethod.POST)
  public void savePurchase(@RequestBody Purchase p) {
    psvc.savePurchase(p);
  }

  // This will save a Customer into CUSTOMERS table (Customer.java)
  @RequestMapping(path="a", method = RequestMethod.POST)
  public void saveCustomer(@RequestBody Customer c) {
    csvc.saveCustomer(c);
  }
}