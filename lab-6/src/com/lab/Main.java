package com.lab;

public class Main {

    public static void main(String[] args) {
        System.out.println(StringReader.findLongestWord("How to call your name"));
        System.out.println("__________________");

        String[] blacklist = {"a", "w", "b", "u", "p", "q"};
        System.out.println(StringReader.hasNoneLetters("hosdfp", blacklist));
        System.out.println("__________________");

        String[] input = {"Don't", "worry", "be", "happy"};
        String[] result = StringReader.reverseStringArray(input);
        for(int i =0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
        System.out.println();
        System.out.println("__________________");

        int[] resultInt = Multiplies.findMultiplies(4,8);
        for(int i =0; i < resultInt.length; i++){
            System.out.print(resultInt[i] + " ");
        }
        System.out.println();
        System.out.println("__________________");

        System.out.println(DigitalRoot.digitalRootFind(432423));
        System.out.println();
        System.out.println("__________________");

        System.out.println(Time.secondsToTime(55555));
    }
}

class StringReader{
    public static int findLongestWord(String str){
        if(str == null){
            System.out.println("String is null");
            return 0;
        }
        else{
            String[] spl = str.split(" ");
            int max = spl[0].length();
            for(int i = 0; i < spl.length; i++){
                if(max < spl[i].length()){
                    max = spl[i].length();
                }
            }
            return max;
        }
    }

    public static boolean hasNoneLetters(String str, String[] blacklist){
        if(blacklist.length <= 0)
            return false;
        for(int i =0; i < blacklist.length; i++){
            if(str.toLowerCase().contains(blacklist[i]))
                return false;
        }
        return true;
    }

    public static String[] reverseStringArray(String[] str){
        //TODO: StringBuilder
        String temp = "";
        for(int i = 0; i < str.length; i++){
            temp += str[i];
        }

        String reverse = "";
        for(int i = temp.length() - 1; i >=0; i--){
            reverse += temp.charAt(i);
        }

        String[] result = new String[str.length];
        int count = 0;
        for(int i = 0; i < str.length; i++){
            result[i] = reverse.substring(count, count+str[i].length());
            count += str[i].length();
        }
        return result;
    }
}

class Multiplies{
    public static int[] findMultiplies(int x, int n){
        int[] result = new int[x];
        for(int i = 0; i < x; i++){
            result[i] = n;
            n += n;
        }
        return result;
    }
}

class DigitalRoot{
    public static int digitalRootFind(Integer n){
        if(n.toString().length() > 1){
            int tempInt = 0;
            char[] chars = n.toString().toCharArray();
            for(int i = 0; i < chars.length; i++){
                tempInt += Integer.parseInt(String.valueOf(chars[i]));
            }
            return digitalRootFind(tempInt);
        }
        return n;
    }
}

class Time{
    public static String secondsToTime(int seconds){
        if(seconds < 0){
            return "No seconds";
        }
        int hour = 0;
        int minute = 0;
        int second = 0;
        int rem = 0;
        hour = (int)seconds/ 3600;
        if(hour > 99){
            return "To much seconds";
        }
        rem = (int) seconds - hour * 3600;
        minute = (int) rem / 60;
        rem = (int) rem - minute * 60;
        second = rem;
        return hour + ":" + minute + ":" + second;
    }
}
