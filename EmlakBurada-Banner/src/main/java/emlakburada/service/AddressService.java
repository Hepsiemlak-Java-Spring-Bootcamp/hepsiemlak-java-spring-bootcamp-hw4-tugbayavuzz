package emlakburada.service;

import emlakburada.dto.request.AddressRequest;
import emlakburada.dto.response.AddressResponse;
import emlakburada.model.Address;
import emlakburada.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public AddressResponse getByAdressId(int addressId) {
        Optional<Address> address = addressRepository.findById(addressId);
        return convertAddressEntityToAddressResponse(address.get(), "200","suuccess");

    }

    public AddressResponse updateMember(AddressRequest addressRequest) {
        Optional<Address> address = addressRepository.findById(addressRequest.getAddress().getAddressId());
        if (address.isEmpty()) {
            return convertAddressEntityToAddressResponse(null, "102", "Member not found");
        }

        Address updatedMember = addressRepository.save(addressRequest.getAddress());

        return convertAddressEntityToAddressResponse(updatedMember, "000", "success");
    }

    public AddressResponse convertAddressEntityToAddressResponse(Address address, String code, String text) {
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setAddress(address);
        addressResponse.setErrorCode(code);
        addressResponse.setErrorText(text);
        return addressResponse;
    }
}
