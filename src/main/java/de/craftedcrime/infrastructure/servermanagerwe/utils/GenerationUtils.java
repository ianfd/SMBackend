package de.craftedcrime.infrastructure.servermanagerwe.utils;
/*
 * Created by ian on 20.03.21
 * Location: de.ianfd.infrastructure.servermanagerwe.utils
 * Created for the project servermanagerwe with the name GenerationUtils
 */

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class GenerationUtils {


    public String generateRandomAlphanumericString(int length, boolean includeNumbers, boolean includeLetters) {
        return RandomStringUtils.random(length, includeLetters, includeNumbers);
    }



}
