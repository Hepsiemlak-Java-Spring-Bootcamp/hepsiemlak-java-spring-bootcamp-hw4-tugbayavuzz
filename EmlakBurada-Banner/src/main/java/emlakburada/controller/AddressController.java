package emlakburada.controller;

import emlakburada.dto.request.AddressRequest;
import emlakburada.dto.response.AddressResponse;
import emlakburada.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping(value = "/address")
    @ResponseStatus(HttpStatus.CREATED)
    public AddressResponse createAddres(@RequestBody AddressRequest addressRequest) {
        return addressService.createAddres(addressRequest);
    }

    @GetMapping(value = "/address{id}")
    public ResponseEntity<AddressResponse> getByAdressId(@PathVariable(required = false) int addressId) {
        return new ResponseEntity<>(addressService.getByAdressId(addressId), HttpStatus.OK);
    }

    @DeleteMapping(value = "/address{id}")
    public ResponseEntity<AddressResponse> deleteAddress(@PathVariable(required = false) int addressId) {
        return new ResponseEntity<>(addressService.deleteAddress(addressId), HttpStatus.OK);
    }

    @PutMapping(value = "/address")
    public ResponseEntity<AddressResponse> updateAddress(@RequestBody AddressRequest addressRequest) {
        return new ResponseEntity<>(addressService.updateAddress(addressRequest), HttpStatus.OK);
    }
}
