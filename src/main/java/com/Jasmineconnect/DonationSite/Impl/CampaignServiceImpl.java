package com.Jasmineconnect.DonationSite.Impl;

import com.Jasmineconnect.DonationSite.Dto.CampaignDto;
import com.Jasmineconnect.DonationSite.Entity.Campaign;
import com.Jasmineconnect.DonationSite.Mappers.CampaignMapper;
import com.Jasmineconnect.DonationSite.Repository.CampaignRepository;
import com.Jasmineconnect.DonationSite.Service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Component
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository campaignRepository;
    private final CampaignMapper campaignMapper;

    @Autowired
    public CampaignServiceImpl(CampaignRepository campaignRepository, CampaignMapper campaignMapper) {
        this.campaignRepository = campaignRepository;
        this.campaignMapper = campaignMapper;
    }

    @Override
    public CampaignDto createCampaign(CampaignDto campaignDto) {
        Campaign campaign = campaignMapper.dtoToEntity(campaignDto);
        Campaign savedCampaign = campaignRepository.save(campaign);
        return campaignMapper.entityToDto(savedCampaign);
    }

    @Override
    public Optional<CampaignDto> getCampaignById(Long id) {
        Optional<Campaign> campaignOptional = campaignRepository.findById(id);
        return campaignOptional.map(campaignMapper::entityToDto);
    }

    @Override
    public Optional<CampaignDto> updateCampaignNameAndDescription(Long id, String name, String description) {
        return Optional.empty();
    }

    @Override
    public Optional<CampaignDto> updateCampaign(Long id, CampaignDto campaignDto) {
        Optional<Campaign> existingCampaignOptional = campaignRepository.findById(id);
        if (existingCampaignOptional.isPresent()) {
            Campaign existingCampaign = existingCampaignOptional.get();
            campaignMapper.updateEntityFromDto(campaignDto, existingCampaign); // Update entity from DTO
            Campaign updatedCampaign = campaignRepository.save(existingCampaign);
            return Optional.of(campaignMapper.entityToDto(updatedCampaign)); // Convert updated entity to DTO
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<CampaignDto> findAllCampaigns() {
        List<Campaign> campaigns = campaignRepository.findAll();
        return campaignMapper.entitiesToDtos(campaigns);
    }

    @Override
    public boolean deleteCampaign(Long id) {
        if (campaignRepository.existsById(id)) {
            campaignRepository.deleteById(id);
            return true;
        }
        return false;
    }

        @Override
        public List<CampaignDto> findByGoalAmount(Double goalAmount) {
            List<Campaign> campaigns = campaignRepository.findByGoalAmount(goalAmount);
            return campaigns.stream().map(campaignMapper::entityToDto).collect(Collectors.toList());
        }

        @Override
        public List<CampaignDto> findByName(String name) {
            List<Campaign> campaigns = campaignRepository.findByName(name);
            return campaigns.stream().map(campaignMapper::entityToDto).collect(Collectors.toList());
        }

        // Additional search and filter methods can be added here
    }

//@Service
//public class CampaignServiceImpl implements CampaignService {
//
//    private final CampaignRepository campaignRepository;
//    private final CampaignMapper campaignMapper;
//
//    @Autowired
//    public CampaignvServiceImpl(CampaignRepository campaignRepository, CampaignMapper campaignMapper) {
//        this.campaignRepository = campaignRepository;
//        this.campaignMapper = campaignMapper;
//    }
//
//    @Override
//    public CampaignDto createCampaign(CampaignDto campaignDto) {
//        Campaign campaign = campaignMapper.dtoToEntity(campaignDto);
//        Campaign savedCampaign = campaignRepository.save(campaign);
//        return campaignMapper.entityToDto(savedCampaign);
//    }
//
//    @Override
//    public Optional<CampaignDto> getCampaignById(Long campaignId) {
//        Optional<Campaign> campaignOptional = campaignRepository.findById(campaignId);
//        return campaignOptional.map(campaignMapper::entityToDto);
//    }
//
//    @Override
//    public Optional<CampaignDto> updateCampaignNameAndDescription(Long id, String name, String description) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Optional<CampaignDto> updateCampaign(Long campaignId, CampaignDto updatedCampaignDto) throws ChangeSetPersister.NotFoundException {
//        Campaign existingCampaign = campaignRepository.findById(campaignId)
//                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
//
//        campaignMapper.updateEntityFromDto(updatedCampaignDto, existingCampaign);
//
//        Campaign updatedCampaign = campaignRepository.save(existingCampaign);
//        return Optional.of(campaignMapper.entityToDto(updatedCampaign));
//    }
//
//    @Override
//    public boolean deleteCampaign(Long campaignId) {
//        if (campaignRepository.existsById(campaignId)) {
//            campaignRepository.deleteById(campaignId);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public List<CampaignDto> findByGoalAmount(Double goalAmount) {
//        return null;
//    }
//
//    @Override
//    public List<CampaignDto> findByName(String name) {
//        return null;
//    }
//
//    @Override
//    public List<CampaignDto> findAllCampaigns() {
//        List<Campaign> campaigns = campaignRepository.findAll();
//        return campaignMapper.entitiesToDtos(campaigns);
//    }
