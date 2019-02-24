

import java.math.BigInteger;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aneta
 */
public class Validation extends FileManager {
  
    public String[] Validation(String[] ibanai, String fileName){
        
        HashMap<Character, Integer> countryCodes = new HashMap< Character, Integer>();
        countryCodes.put('A', 10);
        countryCodes.put('B', 11); 
        countryCodes.put('C', 12);
        countryCodes.put('D', 13);
        countryCodes.put('E', 14);
        countryCodes.put('F', 15);
        countryCodes.put('G', 16); 
        countryCodes.put('H', 17);
        countryCodes.put('I', 18);
        countryCodes.put('J', 19); 
        countryCodes.put('K', 20);
        countryCodes.put('L', 21); 
        countryCodes.put('M', 22);
        countryCodes.put('N', 23);
        countryCodes.put('O', 24);
        countryCodes.put('P', 25);
        countryCodes.put('Q', 26);
        countryCodes.put('R', 27);
        countryCodes.put('S', 28);
        countryCodes.put('T', 29);
        countryCodes.put('U', 30);
        countryCodes.put('V', 31);
        countryCodes.put('W', 32);
        countryCodes.put('X', 33);
        countryCodes.put('Y', 34); 
        countryCodes.put('Z', 35);
        countryCodes.put('0', 0);
        countryCodes.put('1', 1);
        countryCodes.put('2', 2);
        countryCodes.put('3', 3);
        countryCodes.put('4', 4);
        countryCodes.put('5', 5);
        countryCodes.put('6', 6);
        countryCodes.put('7', 7);
        countryCodes.put('8', 8); 
        countryCodes.put('9', 9);

        HashMap<String, Integer> countryIbanLength = new HashMap< String, Integer>();
        countryIbanLength.put("AD", 24 );// Andorra
        countryIbanLength.put("AE", 23); // United Arab Emirates
        countryIbanLength.put("AL", 28); // Albania
        countryIbanLength.put("AT", 20); // Austria
        countryIbanLength.put("AZ", 28);// Republic of Azerbaijan
        countryIbanLength.put("BA", 20); // Bosnia and Herzegovina
        countryIbanLength.put("BE", 16); // Belgium
        countryIbanLength.put("BG", 22); // Bulgaria
        countryIbanLength.put("BH", 22);// Bahrain (Kingdom of)
        countryIbanLength.put("BR", 29); // Brazil
        countryIbanLength.put("BY", 28);// Republic of Belarus
        countryIbanLength.put("CH", 21); // Switzerland
        countryIbanLength.put("CR", 22); // Costa Rica
        countryIbanLength.put("CY", 28); // Cyprus
        countryIbanLength.put("CZ", 24); // Czech Republic
        countryIbanLength.put("DE", 22); // Germany
        countryIbanLength.put("DK", 18); // Denmark
        countryIbanLength.put("DO", 28); // Dominican Republic
        countryIbanLength.put("EE", 20); // Estonia
        countryIbanLength.put("ES", 24); // Spain
        countryIbanLength.put("FI", 18); // Finland
        countryIbanLength.put("FO", 18); // Denmark (Faroes)
        countryIbanLength.put("FR", 27); // France
        countryIbanLength.put("GB", 22);// United Kingdom
        countryIbanLength.put("GE", 22); // Georgia
        countryIbanLength.put("GI", 23); // Gibraltar
        countryIbanLength.put("GL", 18); // Denmark (Greenland)
        countryIbanLength.put("GR", 27); // Greece
        countryIbanLength.put("GT", 28); // Guatemala
        countryIbanLength.put("HR", 21); // Croatia
        countryIbanLength.put("HU", 28); // Hungary
        countryIbanLength.put("IE", 22); // Ireland
        countryIbanLength.put("IL", 23); // Israel
        countryIbanLength.put("IS", 26); // Iceland
        countryIbanLength.put("IT", 27); // Italy
        countryIbanLength.put("IQ", 23); // Iraq
        countryIbanLength.put("JO", 30); // Jordan
        countryIbanLength.put("KW", 30); // Kuwait
        countryIbanLength.put("KZ", 20); // Kazakhstan
        countryIbanLength.put("LB", 28); // Lebanon
        countryIbanLength.put("LC", 32); // Saint Lucia
        countryIbanLength.put("LI", 21); // Liechtenstein (Principality of)
        countryIbanLength.put("LT", 20);// Lithuania
        countryIbanLength.put("LU", 20); // Luxembourg
        countryIbanLength.put("LV", 21); // Latvia
        countryIbanLength.put("MC", 27); // Monaco
        countryIbanLength.put("MD", 24); // Moldova
        countryIbanLength.put("ME", 22); // Montenegro
        countryIbanLength.put("MK", 19); // Macedonia, Former Yugoslav Republic of
        countryIbanLength.put("MR", 27); // Mauritania
        countryIbanLength.put("MT", 31); // Malta
        countryIbanLength.put("MU", 30);// Mauritius
        countryIbanLength.put("NL", 18); // The Netherlands
        countryIbanLength.put("NO", 15); // Norway
        countryIbanLength.put("PK", 24); // Pakistan
        countryIbanLength.put("PL", 28); // Poland
        countryIbanLength.put("PS", 29);// Palestine, State of
        countryIbanLength.put("PT", 25); // Portugal
        countryIbanLength.put("QA", 29); // Qatar
        countryIbanLength.put("RO", 24); // Romania
        countryIbanLength.put("RS", 22); // Serbia
        countryIbanLength.put("SA", 24); // Saudi Arabia
        countryIbanLength.put("SC", 31); // Seychelles
        countryIbanLength.put("SE", 24); // Sweden
        countryIbanLength.put("SI", 19); // Slovenia
        countryIbanLength.put("SK", 24);// Slovak Republic
        countryIbanLength.put("SM", 27); // San Marino
        countryIbanLength.put("ST", 25);// Sao Tome and Principe
        countryIbanLength.put("TL", 23); // Timor-Leste
        countryIbanLength.put("TN", 24);// Tunisia
        countryIbanLength.put("TR", 26); // Turkey
        countryIbanLength.put("UA", 29); // Ukraine
        countryIbanLength.put("VG", 24);// Virgin Islands, British
        countryIbanLength.put("XK", 20); // Republic of Kosovo
    
 
        BigInteger MOD = new BigInteger("97");
        String resultOfIbanCheck[];
        resultOfIbanCheck = new String[ibanai.length];

        for (int i = 0; i < ibanai.length; i++) {
            
            String countryCode = ibanai[i].substring(0,2);
            
            if ( ibanRegexCheck(ibanai[i]) || ibanai[i].substring(2,3).matches("[a-zA-Z]+")
                || countryIbanLength.get(countryCode) == null 
                || ibanai[i].length() != countryIbanLength.get(countryCode)) {
                
                resultOfIbanCheck[i] = ibanai[i] + " " + "False";
                continue;
                
            } else {
                
                char[] ibanaiToChar = ibanai[i].toCharArray();
                int[] ibanaiToInt = new int[ibanai[i].length()];
                String convertedIban  = "";

                for(int g = 0; g< ibanai[i].length(); g++){
                  ibanaiToInt[g] = countryCodes.get(ibanaiToChar[g]);
                  convertedIban += String.valueOf(ibanaiToInt[g]);
                }



                 String convertedCountryCodeAndCheckDigits = convertedIban.substring(0,6);
                 String accountNumber = convertedIban.substring(6, convertedIban.length());


                 String convertedFinalIban = accountNumber + convertedCountryCodeAndCheckDigits;
                 BigInteger parsedIbanString = new BigInteger(convertedFinalIban);
                 int moduloResult = parsedIbanString.modInverse(MOD).intValue();

                 if (moduloResult != 1) {    
                    resultOfIbanCheck[i] = ibanai[i] + " " + "False";
                 } else {
                    resultOfIbanCheck[i] = ibanai[i] + " " + "True";    
                 }
            }
       
        }
        
        if(fileName != "") {
          writeToFile(resultOfIbanCheck, fileName);
        }
        
        return resultOfIbanCheck;
    }
    
    
    public boolean ibanRegexCheck(String iban){
        
        Pattern regexPattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher matchedIban = regexPattern.matcher(iban);
        boolean checkedForIllegalIban = matchedIban.find();
        return checkedForIllegalIban;
    }
    
}
        
    



