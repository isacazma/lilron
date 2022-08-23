package almereGym.Persistence;

import almereGym.model.User;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;

import java.io.*;

public class PersistenceManager {
    private  static String ENDPOINT= "https://egebep.blob.core.windows.net/";
//    "?sv=2021-06-08&ss=bfqt&srt=sco&sp=rwdlacupitfx&se=2022-06-22T17:06:47Z&st=2022-06-22T09:06:47Z&spr=https&sig=08aXCwWklPtFOarA%2BHcxUwh6kBwraBrReYtkXXWn6%2F4%3D";
//

    private  static String SASTOKEN =  "?sv=2021-06-08&ss=bfqt&srt=sco&sp=rwdlacupiytfx&se=2023-04-06T08:19:46Z&st=2022-08-23T00:19:46Z&spr=https&sig=P9RW%2FUQ6XHmwt8bziy3bAvgbHerlk3H64xFfDZQN%2BhQ%3D";

    private  static String CONTAINER = "worldcontainer";

    private static BlobContainerClient blobContainer = new BlobContainerClientBuilder()
            .endpoint(ENDPOINT)
            .sasToken(SASTOKEN)
            .containerName(CONTAINER)
            .buildClient();

    public static void loadWorldFromAzure() throws IOException, ClassNotFoundException {
        if (blobContainer.exists()) {
            BlobClient blob = blobContainer.getBlobClient("world_blob");

            if (blob.exists()) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                blob.download(baos);
                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(bais);
                User loadedWorld = (User) ois.readObject();
                User.setAanWezig(loadedWorld);
            }
        }
    }

    public static void saveWorldToAzure() throws IOException {
        if (!blobContainer.exists()) {
            blobContainer.create();
        }
        BlobClient blob = blobContainer.getBlobClient("world_blob");
        User worldToSave = User.getGAanwezig();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(worldToSave);

        byte[] bytez = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(bytez);
        blob.upload(bais, bytez.length, true);
    }


}
