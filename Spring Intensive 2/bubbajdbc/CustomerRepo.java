/* Created by Vince Chang
 * This interface inherits predefined methods from the CrudRepository that I
 * will use.
 */

package com.example.bubba;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer, Long> {}