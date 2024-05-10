package com.Jasmineconnect.DonationSite.Service;

import com.Jasmineconnect.DonationSite.Dto.CampaignDto;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface CampaignService {
    CampaignDto createCampaign(CampaignDto campaignDto);
    Optional<CampaignDto> getCampaignById(Long id);
    Optional<CampaignDto> updateCampaignNameAndDescription(Long id, String name, String description);
    Optional<CampaignDto> updateCampaign(Long id, CampaignDto campaignDto) throws ChangeSetPersister.NotFoundException;
    List<CampaignDto> findAllCampaigns();
    boolean deleteCampaign(Long id);
    List<CampaignDto> findByGoalAmount(Double goalAmount);
    List<CampaignDto> findByName(String name);
}
//    private final CampaignRepository campaignRepository;
//    @Autowired
//    @Getter
//    private final CampaignMapper campaignMapper;
//
//    @Autowired
//    public CampaignService(CampaignRepository campaignRepository, CampaignMapper campaignMapper) {
//        this.campaignRepository = campaignRepository;
//        this.campaignMapper = campaignMapper;
//    }
//
//    public CampaignDto createCampaign(CampaignDto campaignDto) {
//        Campaign newCampaign = campaignMapper.convertToEntity(campaignDto);
//        newCampaign = campaignRepository.save(newCampaign);
//        return campaignMapper.convertToDTO(newCampaign);
//    }
//
//
//    public Optional<CampaignDto> getCampaignById(Long id) {
//        return campaignRepository.findById(id)
//                .map(this::convertToDTO);
//    }
//
//    public Optional<CampaignDto> updateCampaignNameAndDescription(Long id, String name, String description) {
//        return campaignRepository.findById(id).map(existingCampaign -> {
//            existingCampaign.setName(name);
//            existingCampaign.setDescription(description);
//            existingCampaign = campaignRepository.save(existingCampaign);
//            return convertToDTO(existingCampaign);
//        });
//    }
//
//    public Optional<CampaignDto> updateCampaign(Long id, CampaignDto campaignDto) {
//        return campaignRepository.findById(id).map(existingCampaign -> {
//            existingCampaign.setName(campaignDto.getName());
//            existingCampaign.setDescription(campaignDto.getDescription());
//            existingCampaign.setGoalAmount(campaignDto.getGoalAmount());
//            existingCampaign.setStartDate(campaignDto.getStartDate());
//            existingCampaign.setEndDate(campaignDto.getEndDate());
//            existingCampaign = campaignRepository.save(existingCampaign);
//            return convertToDTO(existingCampaign);
//        });
//    }
//
//    public List<CampaignDto> findAllCampaigns() {
//        return campaignRepository.findAll()
//                .stream()
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
//    }
//
//    public boolean deleteCampaign(Long id) {
//        return campaignRepository.findById(id).map(campaign -> {
//            campaignRepository.delete(campaign);
//            return true;
//        }).orElse(false);
//    }
//
//    private CampaignDto convertToDTO(Campaign campaign) {
//        CampaignDto dto = new CampaignDto();
//        dto.setId(campaign.getId());
//        dto.setName(campaign.getName());
//        dto.setDescription(campaign.getDescription());
//        dto.setGoalAmount(campaign.getGoalAmount());
//        dto.setStartDate(campaign.getStartDate());
//        dto.setEndDate(campaign.getEndDate());
//        return dto;
//    }
//
//    public List<CampaignDto> findByGoalAmount(Double goalAmount) {
//        return campaignRepository.findByGoalAmount(goalAmount)
//                .stream()
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
//    }
//
//    public List<CampaignDto> findByName(String name) {
//        return campaignRepository.findByName(name)
//                .stream()
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
//    }
//
//}
//
