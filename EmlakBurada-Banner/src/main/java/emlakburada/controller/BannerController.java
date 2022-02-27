package emlakburada.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import emlakburada.dto.request.BannerRequest;
import emlakburada.dto.response.BannerResponse;
import emlakburada.service.BannerService;

@RestController
@RequestMapping("/banners")
public class BannerController {

	@Autowired
	private BannerService bannerService;

	@GetMapping
	public ResponseEntity<List<BannerResponse>> getAllBanners() {
		return new ResponseEntity<>(bannerService.getAllBanners(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<BannerResponse> saveBanner(@RequestBody BannerRequest request) {
		return new ResponseEntity<>(bannerService.saveBanner(request), HttpStatus.CREATED);
	}


	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public BannerResponse deleteBanner(@PathVariable Integer advertNo) {
		return bannerService.deleteBanner(advertNo);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public BannerResponse updateBanner(@RequestBody BannerRequest bannerRequest) {
		return bannerService.updateBanner(bannerRequest);
	}


}
