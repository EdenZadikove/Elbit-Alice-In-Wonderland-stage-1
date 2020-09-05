package com.company;

public class ExtractText {
    private String text;
    private int[] decimalIndexes = new int[17];
    private String[] hexIndexes;

    public ExtractText(String text) {
        this.text = text.replaceAll("\\s+","");
    }

    public void setHexIndexes(String[] hexIndexes) {
        this.hexIndexes = hexIndexes;
    }

    public void convertToDec() {
        //base 15
        char tav;
        int pos = 0, pow = 0, index;
        for(int i = 0; i < hexIndexes.length; i++) {
            index = hexIndexes[i].length()-1;
            pow = 0;
            pos = 0;
            for(int j = index; j >= 0; j--) {
                tav = hexIndexes[i].charAt(j);
                int tavIntoNum = tav-48;
                if(tav>=65 && tav<=69)
                    tavIntoNum = tav-55; //in ascii, e.g A=65. 65-55 = 10
                pos += tavIntoNum * (Math.pow(15,pow));
                pow++;
            }
            decimalIndexes[i] = pos*2;
        }
    }

    public String generateAnswer() {
        String answer = "aaaaaa//aaaaa/aaaaaa";
        for(int i = 0; i < decimalIndexes.length; i++) {
            int index = decimalIndexes[i];
            answer = answer.replaceFirst("a", String.valueOf(text.charAt(index)));
        }
        return answer;
    }

    public void printIndexes() {
        for(int i = 0; i<this.decimalIndexes.length; i++) {
            System.out.println(decimalIndexes[i]);
        }
    }
}
