package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.dto.BrandDto;
import bg.softuni.mobilelele.model.dto.ModelDto;
import bg.softuni.mobilelele.model.entity.Brand;
import bg.softuni.mobilelele.model.entity.Model;
import bg.softuni.mobilelele.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    public List<BrandDto> getAllBrands() {
        return brandRepository
                .findAll()
                .stream()
                .map(this::mapBrand)
                .collect(Collectors.toList());
    }

    private BrandDto mapBrand(Brand brand) {

        List<ModelDto> models = brand
                .getModels()
                .stream()
                .map(this::mapModel)
                .toList();

        BrandDto result = new BrandDto()
                .setModels(models)
                .setName(brand.getName());

        return result;
    }

    private ModelDto mapModel(Model model) {
        return new ModelDto()
                .setId(model.getId())
                .setName(model.getName());
    }

}
