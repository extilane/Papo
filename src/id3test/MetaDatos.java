package id3test;
///mnt/hgfs/Ubunto
import java.io.*;
import org.blinkenlights.jid3.*;
import org.blinkenlights.jid3.v1.*;
import org.blinkenlights.jid3.v2.*;
public class MetaDatos
{
    private String Artista,Album,Titulo;
    private int anno;
    
    public MetaDatos(String mp3 ) throws ID3Exception
        
    {
        // the file we are going to read
        File oSourceFile = new File(mp3);

        // create an MP3File object representing our chosen file
        MediaFile oMediaFile = new MP3File(oSourceFile);

        // any tags read from the file are returned, in an array, in an order which you should not assume
        ID3Tag[] aoID3Tag = oMediaFile.getTags();
        // let's loop through and see what we've got
        // (NOTE:  we could also use getID3V1Tag() or getID3V2Tag() methods, if we specifically want one or the other)
        for (int i=0; i < aoID3Tag.length; i++){
        
            // check to see if we read a v1.0 tag, or a v2.3.0 tag (just for example..)
            if (aoID3Tag[i] instanceof ID3V1_0Tag)
            {
                ID3V1_0Tag oID3V1_0Tag = (ID3V1_0Tag)aoID3Tag[i];
                // does this tag happen to contain a title?
                if (oID3V1_0Tag.getTitle() != null)
                {
                    System.out.println("Title = " + oID3V1_0Tag.getTitle());
                }
                // etc.
            }
            else if (aoID3Tag[i] instanceof ID3V2_3_0Tag)
            {
                ID3V2_3_0Tag oID3V2_3_0Tag = (ID3V2_3_0Tag)aoID3Tag[i];
                // check if this v2.3.0 frame contains a title, using the actual frame name
                if (oID3V2_3_0Tag.getTIT2TextInformationFrame() != null)
                {
                 //   System.out.println("Title = " + oID3V2_3_0Tag.getTIT2TextInformationFrame().getTitle());
                    //System.out.println(oID3V2_3_0Tag.getAlbum())
                }
                     //System.out.println("Year = " + oID3V2_3_0Tag.getYear());
                    //oID3V2_3_0Tag.setYear(500);
                    //System.out.println("Year = " + oID3V2_3_0Tag.getYear());
                    //System.out.println("Album = " + oID3V2_3_0Tag.getAlbum());
                    //oID3V2_3_0Tag.setAlbum("tila se va a morir");
                   // System.out.println("Album = " + oID3V2_3_0Tag.getAlbum());
                   // System.out.println("Artista = " + oID3V2_3_0Tag.getArtist());
                    Artista=oID3V2_3_0Tag.getArtist();
                    Album=oID3V2_3_0Tag.getAlbum();
                    Titulo=oID3V2_3_0Tag.getTitle();
                    anno=oID3V2_3_0Tag.getYear();
                    
            }
        }
    }
    public String getArtista(){
    return this.Artista;
    }
    public String getTitulo(){
    return this.Titulo;
    }
    public String getAlbum(){
    return this.Album;
    }
    public int getAnno(){
    return this.anno;
    }
}

