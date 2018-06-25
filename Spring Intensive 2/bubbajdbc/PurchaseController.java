/* Created by Vince Chang
 * Example of Spring MVC Pattern
 * This Controller will interact with the services, to be specific it will
 * interact with the PurchaseSvc interface that will have access to all of
 * its implementation methods and any other dependencies!
 * This also defines all the routes.
 */

package com.example.bubba;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// This annotation is how to distinguish that this class is a Controller
@Controller
public class PurchaseController {

  // This annotation goes to PurchasSvc.java and intiantiates a psvc
  // Equivalent to private PurchaseSvc psvc = new PurchaseSvc();
  @Autowired
  private PurchaseSvc psvc;

  @GetMapping("/index.html")
  public String getIndex() {
    return "index";
  }

  @GetMapping("/")
  public String getRoot() {
    return "redirect:/index.html"; // The browser brings you to the page
  }

  // Providing the date to the src/main/resources/templates/footer.html
  @ModelAttribute("date")
  public Date getDate() {
    return new Date();
  }

  @RequestMapping("/browse")
  public ModelAndView browsePurchases() {
    Iterable<Purchase> p = psvc.findAllPurchases();
    return new ModelAndView("browsePurchases","purchaseList",p);
  }
}