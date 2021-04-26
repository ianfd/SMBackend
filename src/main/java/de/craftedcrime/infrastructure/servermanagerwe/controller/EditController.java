package de.craftedcrime.infrastructure.servermanagerwe.controller;

import de.craftedcrime.infrastructure.servermanagerwe.model.ConfigEdit;
import de.craftedcrime.infrastructure.servermanagerwe.service.ConfigEditService;
import de.craftedcrime.infrastructure.servermanagerwe.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Created by ian on 19.03.21
 * Location: de.craftedcrime.infrastructure.servermanagerwe.controller
 * Created for the project servermanagerwe with the name DownloadConfigController
 */
@RestController
@RequestMapping("/edit")
public class EditController {

    private final SecurityService securityService;
    private final ConfigEditService configEditService;
    private final Logger logger;

    @Autowired
    public EditController(SecurityService securityService, ConfigEditService configEditService) {
        this.securityService = securityService;
        this.configEditService = configEditService;
        this.logger = Logger.getLogger("DOWNLOADER");
    }

    @GetMapping("/get")
    public ResponseEntity<?> downloadEdits(@RequestParam("key") String key, @RequestParam String secret) {
        if ((key != null) && (secret != null)) {
            if (securityService.validKeyAndSecret(key, secret)) {
                if (configEditService.configEditExists(key)) {
                    return new ResponseEntity<>(configEditService.getConfigEdit(key), HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveEdit(@RequestParam("key") String key, @RequestParam("secret") String secret, @RequestBody ConfigEdit configEdit) {
        if ((key != null) && (secret != null) && (configEdit != null)) {
            if (securityService.validKeyAndSecret(key, secret)) {
                configEditService.saveConfig(key, configEdit);
                return new ResponseEntity<>(42, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/getserver")
    public ResponseEntity<?> downloadServerEdits(@RequestParam("key") String key, @RequestParam("secret") String secret) {
        logger.log(Level.INFO, "Starting download of edit.");
        if ((key != null) && (secret != null)) {
            logger.log(Level.INFO, "Key and secret aren't null.");
            if (securityService.validKeyAndSecret(key, secret)) {
                logger.log(Level.INFO, "Key and secret are validated.");
                ConfigEdit configEdit = configEditService.getConfigEdit(key);
                securityService.resetCredentials(key);
                return new ResponseEntity<>(configEdit, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }


}
