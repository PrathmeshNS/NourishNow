package com.pscode.nourish_now.service;

import com.pscode.nourish_now.entity.UserProfile;
import com.pscode.nourish_now.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public UserProfile getProfile(String profileName) {
        return profileRepository.findByName(profileName);
    }

    public UserProfile saveProfile(MultipartFile file) throws IOException {
        UserProfile profile =
                UserProfile.builder()
                        .profileName(file.getOriginalFilename())
                        .profileType(file.getContentType())
                        .profileImageDate(file.getBytes())
                        .build();
        return profileRepository.save(profile);
    }
}
