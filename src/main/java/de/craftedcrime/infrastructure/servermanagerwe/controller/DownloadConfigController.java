package de.craftedcrime.infrastructure.servermanagerwe.controller;

import de.craftedcrime.infrastructure.servermanagerwe.service.ConfigEditService;
import de.craftedcrime.infrastructure.servermanagerwe.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * Created by ian on 19.03.21
 * Location: de.ianfd.infrastructure.servermanagerwe.controller
 * Created for the project servermanagerwe with the name DownloadConfigController
 */
@RestController
@RequestMapping("/edit")
public class DownloadConfigController {

    private SecurityService securityService;

    private ConfigEditService configEditService;

    @Autowired
    public DownloadConfigController(SecurityService securityService, ConfigEditService configEditService) {
        this.securityService = securityService;
        this.configEditService = configEditService;
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
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
