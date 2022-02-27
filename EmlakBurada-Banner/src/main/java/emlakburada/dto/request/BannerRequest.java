package emlakburada.dto.request;

import emlakburada.model.Address;
import emlakburada.model.Banner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BannerRequest {

    private Banner banner;

}
