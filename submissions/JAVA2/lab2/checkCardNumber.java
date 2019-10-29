//Checks if it's a valid Mastercard or Visa
boolean validProvider (String cardNumber){
    boolean isValid = false;
    int masterCard1 = Integer.valueOf(cardNumber.substring(0,4));
    int masterCard2 = Integer.valueOf(cardNumber.substring(0,2));
    if(cardNumber.substring(0,1).equals("4")){
        isValid = true;
    }
    if(cardNumber.substring(0,2).equals("34") || cardNumber.substring(0,2).equals("37")){
        isValid = true;
    }
    if( (masterCard1 >= 2221 && masterCard1 <= 2720) || (51<= masterCard2  && masterCard2 <=55)){
        isValid = true;
    }
    return isValid;
}
//Checkes if the length of the card is valid
boolean validLengthOfCard(String cardNumber){
    boolean isValid = false;
    int length = cardNumber.length();
    switch(length){
        case 16:
            isValid = true;
            break;
        case 13:
            isValid = true;
            break;
        case 19:
            isValid = true;
            break;
        case 15:
            isValid = true;
            break; 
    }
    return isValid;
}

//Checks if the sum of digits is valid. i.e is divisible by 10 with the given algorithm.
boolean checkDigit(String cardNumber){
    int cardLen = cardNumber.length();
    int cardDigitalRoot = 0; //the sum of digits
    if(cardLen%2==0){ 
        for(int i=0;i<cardLen; i++){
            int digit = Integer.valueOf(cardNumber.substring(i,i+1));
            if(i%2==0){
                switch(digit){
                    case 0:
                        cardDigitalRoot+=0;
                        break;
                    case 1:
                        cardDigitalRoot+=2;
                        break;
                    case 2:
                        cardDigitalRoot+=4;
                        break;
                    case 3:
                        cardDigitalRoot+=6;
                        break;
                    case 4:
                        cardDigitalRoot+=8;
                        break;
                    case 5:
                        cardDigitalRoot+=1;
                        break;
                    case 6:
                        cardDigitalRoot+=3;
                        break;
                    case 7:
                        cardDigitalRoot+=5;
                        break;
                    case 8:
                        cardDigitalRoot+=7;
                        break;
                    case 9:
                        cardDigitalRoot+=9;
                        break;
                }
            }
            else{
                cardDigitalRoot+=digit;
            }
        }
    }
    else{
        for(int i=0;i<cardLen; i++){
            int digit = Integer.valueOf(cardNumber.substring(i,i+1));
            if(i%2==1){
                switch(digit){
                    case 0:
                        cardDigitalRoot+=0;
                        break;
                    case 1:
                        cardDigitalRoot+=2;
                        break;
                    case 2:
                        cardDigitalRoot+=4;
                        break;
                    case 3:
                        cardDigitalRoot+=6;
                        break;
                    case 4:
                        cardDigitalRoot+=8;
                        break;
                    case 5:
                        cardDigitalRoot+=1;
                        break;
                    case 6:
                        cardDigitalRoot+=3;
                        break;
                    case 7:
                        cardDigitalRoot+=5;
                        break;
                    case 8:
                        cardDigitalRoot+=7;
                        break;
                    case 9:
                        cardDigitalRoot+=9;
                        break;
                }
            }
            else{
                cardDigitalRoot+=digit;
            }
        }
    }
    
    if(cardDigitalRoot%10==0){
        return true;
    }
    else{
        return false;
    }
}
//checks if the code passed all 3 criterias.
boolean checkCardNumber (String cardNumber){
    if(!validLengthOfCard(cardNumber)){ //checking valid length of card first to avoid cards with length less than 4.
        return false;
    }
    if(validProvider(cardNumber) && validLengthOfCard(cardNumber) && checkDigit(cardNumber)){
        return true;
    }
    else{
        return false;
    }
}