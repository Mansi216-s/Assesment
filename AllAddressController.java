import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AllAddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<Address>> getAddressesByEmployeeId(@PathVariable Long employeeId) {
        try {
            List<Address> addresses = addressService.getAddressesByEmployeeId(employeeId);
            if (!addresses.isEmpty()) {
                return new ResponseEntity<>(addresses, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
