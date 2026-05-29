public class Codec {

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String encode=new String();
        if(longUrl.length()==0){
            encode=encode+'#';
            encode=encode+'2';
            return encode;

        }
        String[]arr=longUrl.split("");
        
        for(int i=0;i<arr.length;i++){
            encode=encode+arr[i];
            if(i!=arr.length-1){
                encode=encode+'#';
                encode=encode+'2';
            }
        }
        return encode;
        
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String decode=new String();
        if(decode.length()==2 && decode.equals("#2")){
            return decode;
        }
        String[]arr=shortUrl.split("#2");
        for(int i=0;i<arr.length;i++){
            decode=decode+arr[i];
        }
        return decode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));