package de.craftedcrime.infrastructure.servermanagerwe.controller;

import de.craftedcrime.infrastructure.servermanagerwe.model.ConfigEdit;
import de.craftedcrime.infrastructure.servermanagerwe.model.ConfigUpload;
import de.craftedcrime.infrastructure.servermanagerwe.model.KeySecretPair;
import de.craftedcrime.infrastructure.servermanagerwe.service.ConfigEditService;
import de.craftedcrime.infrastructure.servermanagerwe.service.ConfigUploadService;
import de.craftedcrime.infrastructure.servermanagerwe.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/*
 * Created by ian on 20.03.21
 * Location: de.craftedcrime.infrastructure.servermanagerwe.controller
 * Created for the project servermanagerwe with the name ConfigurationUploadController
 */
@RestController
public class ConfigurationUploadController {

    private SecurityService securityService;
    private ConfigUploadService configUploadService;
    private ConfigEditService configEditService;

    @Autowired
    public ConfigurationUploadController(SecurityService securityService, ConfigUploadService configUploadService, ConfigEditService configEditService) {
        this.securityService = securityService;
        this.configUploadService = configUploadService;
        this.configEditService = configEditService;
    }

    @PostMapping("/generatekey")
    public ResponseEntity<?> generateKey(@RequestBody ConfigUpload configUpload) {
        if (configUpload != null) {
            KeySecretPair keySecretPair = securityService.generateNewKeyAndSecret();
            configUploadService.saveConfigUpload(keySecretPair.getKey(), configUpload);
            configEditService.saveConfig(keySecretPair.getKey(), new ConfigEdit(new ArrayList<>(), configUpload.getMotdBungee(), configUpload.getMaxPlayerBungee()));
            return new ResponseEntity<>(keySecretPair, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/download")
    public ResponseEntity<?> downloadUploadedConfig(@RequestParam("key") String key, @RequestParam("secret") String secret) {
        if ((key != null) && (secret != null)) {
            if (securityService.validKeyAndSecret(key, secret)) {
                return new ResponseEntity<>(configUploadService.getConfigUpload(key), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/reset")
    public ResponseEntity<?> resetKey(@RequestParam("key") String key) {
        if (key != null) {
            securityService.resetCredentials(key);
            return new ResponseEntity<>("Key reset successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

}
