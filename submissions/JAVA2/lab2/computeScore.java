int computeScore (String word){
    int finalScore = 0; //finalscore of scrabble.
    for(char c : word.toLowerCase().toCharArray()){ //iterating through all characters to find the sum.
        switch (c) { 
            case 'a':
                finalScore+=1;
                break;
            case 'b':
                finalScore+=3;
                break;
            case 'c':
                finalScore+=3;
                break;
            case 'd':
                finalScore+=2;
                break;
            case 'e':
                finalScore+=1;
                break;
            case 'f':
                finalScore+=4;
                break;
            case 'g':
                finalScore+=2;
                break;
            case 'h':
                finalScore+=4;
                break;
            case 'i':
                finalScore+=1;
                break;
            case 'j':
                finalScore+=8;
                break;
            case 'k':
                finalScore+=5;
                break;
            case 'l':
                finalScore+=1;
                break;
            case 'm':
                finalScore+=3;
                break;
            case 'n':
                finalScore+=1;
                break;
            case 'o':
                finalScore+=1;
                break;
            case 'p':
                finalScore+=3;
                break;
            case 'q':
                finalScore+=10;
                break;
            case 'r':
                finalScore+=1;
                break;
            case 's':
                finalScore+=1;
                break;
            case 't':
                finalScore+=1;
                break;
            case 'u':
                finalScore+=1;
                break;
            case 'v':
                finalScore+=4;
                break;
            case 'w':
                finalScore+=4;
                break;
            case 'x':
                finalScore+=8;
                break;
            case 'y':
                finalScore+=4;
                break;
            case 'z':
                finalScore+=10;
                break;
        }
    }
    return finalScore; //returns the final character sum.
}
