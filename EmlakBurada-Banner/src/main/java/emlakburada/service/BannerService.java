package emlakburada.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakburada.dto.request.BannerRequest;
import emlakburada.dto.response.BannerResponse;
import emlakburada.model.Banner;
import emlakburada.repository.BannerRepository;

@Service
public class BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    public List<BannerResponse> getAllBanners() {
        List<BannerResponse> bannerResponses = new ArrayList<>();
        for (Banner banner : bannerRepository.findAll()) {
            bannerResponses.add(convertToBannerResponse(banner));
        }
        return bannerResponses;
    }

    public BannerResponse saveBanner(BannerRequest bannerRequest) {
        Banner banner = bannerRepository.save(bannerRequest.getBanner());
        return convertToBannerResponse(banner);
    }

    public BannerResponse deleteBanner(Integer advertNo) {
        Optional<Banner> banner = bannerRepository.findById(advertNo);
        if (banner.isEmpty()) {
            return convertToBannerResponse(null);
        }

        bannerRepository.deleteById(advertNo);
        return convertToBannerResponse(banner.get());
    }

    public BannerResponse updateBanner(BannerRequest bannerRequest) {
        Optional<Banner> banner = bannerRepository.findById(bannerRequest.getBanner().getId());
        if (banner.isEmpty()) {
            return convertToBannerResponse(null);
        }

        Banner updatedBanner = bannerRepository.save(bannerRequest.getBanner());

        return convertToBannerResponse(updatedBanner);
    }

    private BannerResponse convertToBannerResponse(Banner banner) {
        BannerResponse response = new BannerResponse();
        response.setAdvertNo(banner.getAdvertNo());
        response.setPhone(banner.getPhone());
        response.setTotal(banner.getTotal());
        return response;
    }


}
