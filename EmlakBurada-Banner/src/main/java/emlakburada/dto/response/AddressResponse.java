package emlakburada.dto.response;

import emlakburada.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
    private Address address;
    private String errorCode;
    private String errorText;
}
