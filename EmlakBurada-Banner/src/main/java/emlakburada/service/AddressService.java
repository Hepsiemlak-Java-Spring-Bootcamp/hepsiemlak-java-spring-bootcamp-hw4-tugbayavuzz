package emlakburada.service;

import emlakburada.dto.request.AddressRequest;
import emlakburada.dto.response.AddressResponse;
import emlakburada.model.Address;
import emlakburada.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public AddressResponse createAddres(AddressRequest addressRequest) {
        if (Objects.isNull(addressRequest.getAddress().getAddressId())) {
            return convertAddressEntityToAddressResponse(null, "100", "name is required");
        }

        Address address = addressRepository.save(addressRequest.getAddress());

        return convertAddressEntityToAddressResponse(address, "000", "success");
    }

    public AddressResponse getByAdressId(int addressId) {
        Optional<Address> address = addressRepository.findById(addressId);
        return convertAddressEntityToAddressResponse(address.get(), "200", "suuccess");

    }

    public AddressResponse updateAddress(AddressRequest addressRequest) {
        Optional<Address> address = addressRepository.findById(addressRequest.getAddress().getAddressId());
        if (address.isEmpty()) {
            return convertAddressEntityToAddressResponse(null, "102", "Member not found");
        }

        Address updatedMember = addressRepository.save(addressRequest.getAddress());

        return convertAddressEntityToAddressResponse(updatedMember, "200", "success");
    }

    public AddressResponse deleteAddress(Integer addressId) {
        Optional<Address> address = addressRepository.findById(addressId);
        if (address.isEmpty()) {
            return convertAddressEntityToAddressResponse(null, "102", "Member not found");
        }

        addressRepository.deleteById(addressId);

        return convertAddressEntityToAddressResponse(null, "000", "success");
    }

    public AddressResponse convertAddressEntityToAddressResponse(Address address, String code, String text) {
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setAddress(address);
        addressResponse.setErrorCode(code);
        addressResponse.setErrorText(text);
        return addressResponse;
    }
}
