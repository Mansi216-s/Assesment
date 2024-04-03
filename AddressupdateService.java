import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressupdateService {
    @Autowired
    private AddressRepository addressRepository;

    public Address updateAddress(Long id, Address address) {
        Address existingAddress = addressRepository.findById(id).orElse(null);
        if (existingAddress != null) {
            existingAddress.setStreet(address.getStreet());
            
            return addressRepository.save(existingAddress);
        }
        return null;
    }
}
