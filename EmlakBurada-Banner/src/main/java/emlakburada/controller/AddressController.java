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

    @GetMapping(value = "/address{id}")
    public ResponseEntity<AddressResponse> getByAdressId(@PathVariable(required = false) int addressId) {
        return new ResponseEntity<>(addressService.getByAdressId(addressId), HttpStatus.OK);
    }

    @PutMapping(value = "/address")
    public ResponseEntity<AddressResponse> updateMember(@RequestBody AddressRequest addressRequest) {
        return new ResponseEntity<>(addressService.updateMember(addressRequest), HttpStatus.OK);
    }
}
