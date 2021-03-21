package de.craftedcrime.infrastructure.servermanagerwe.controller;

import de.craftedcrime.infrastructure.servermanagerwe.model.ConfigUpload;
import de.craftedcrime.infrastructure.servermanagerwe.model.KeySecretPair;
import de.craftedcrime.infrastructure.servermanagerwe.service.ConfigUploadService;
import de.craftedcrime.infrastructure.servermanagerwe.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
 * Created by ian on 20.03.21
 * Location: de.craftedcrime.infrastructure.servermanagerwe.controller
 * Created for the project servermanagerwe with the name ConfigurationUploadController
 */
@RestController
public class ConfigurationUploadController {

    private SecurityService securityService;
    private ConfigUploadService configUploadService;

    @Autowired
    public ConfigurationUploadController(SecurityService securityService, ConfigUploadService configUploadService) {
        this.securityService = securityService;
        this.configUploadService = configUploadService;
    }

    @PostMapping("/generatekey")
    public ResponseEntity<?> generateKey(@RequestBody ConfigUpload configUpload) {
        if (configUpload != null) {
            KeySecretPair keySecretPair = securityService.generateNewKeyAndSecret();
            configUploadService.saveConfigUpload(keySecretPair.getKey(), configUpload);
            return new ResponseEntity<>(keySecretPair, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}
