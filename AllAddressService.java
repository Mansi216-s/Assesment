import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllAddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAddressesByEmployeeId(Long employeeId) {
        return addressRepository.findByEmployeeId(employeeId);
    }
}
