/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id3test;

import org.blinkenlights.jid3.ID3Exception;

/**
 *
 * @author guillermo
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ID3Exception {
        MetaDatos p=new MetaDatos("/mnt/hgfs/Ubunto/03 Obsesionario en LA Mayor.mp3");
        System.out.println(p.getArtista());
        System.out.println(p.getAnno());
        System.out.println(p.getTitulo());
        System.out.println(p.getAlbum());
    }
    
}
