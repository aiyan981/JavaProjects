package com.example.user.kryptonote;

public class Cipher {
    public static final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String key;

    public Cipher(String k){
        this.key = k;
    }

    private String makePad(String note){
        String pad = this.key;

        for(; pad.length() < note.length();){
            pad += this.key;
        }

        return pad;
    }

    public String encrypt(String note){
        String pad = makePad(note);
        String result = "";
        for(int i=0; i<note.length(); i++){
            String c = note.substring(i, i+1);
            int position = ALPHABET.indexOf(c);
            int shift = Integer.parseInt(pad.substring(i,i+1));

            int newPosition = position + shift;
            if (newPosition > ALPHABET.length()){
                newPosition = newPosition - ALPHABET.length();
            }
            //an alternate way of circulating
            //int newPosition = (position + shift) % ALPHABET.length();

            result = result + ALPHABET.substring(newPosition, newPosition+1);
        }
        return result;
    }

    public String decrypt(String note){
        String pad = makePad(note);
        String result = "";
        for (int j = 0; j < note.length(); j++){
            String d = note.substring(j, j+1);
            int position = ALPHABET.indexOf(d);
            int shift = Integer.parseInt(pad.substring(j,j+1));

            int newPosition = position - shift;
            if (newPosition < 0){
                newPosition = ALPHABET.length() + newPosition;
            }
            result = result + ALPHABET.substring(newPosition, newPosition + 1);
        }

        return result;
    }
}
