package com.simplon.dvdstore;
import com.simplon.dvdstore.services.dvd.DvdStoreService;
import com.simplon.dvdstore.services.dvd.DvdServiceModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
    @Autowired
    private DvdStoreService dvdStoreService;

    private DvdServiceModel createDvdServiceModel(String name, String genre,String synopsis,Float prix,Integer quantite, String photo) {
        return new DvdServiceModel(name,genre,synopsis,prix,quantite, photo);
    }

    @Test
    public void add_dvd_returns_true()
            throws Exception {


        assertTrue(dvdStoreService.add(createDvdServiceModel("The Matrix", "Science Fiction", "Synopsis", 5F, 19, "photo.jpg")));
    }
    // je teste si le titre est null
    @Test
    public void add_dvd_returns_false_if_property_name_is_null()
            throws Exception {


        assertFalse(dvdStoreService.add(createDvdServiceModel(null,"Science Fiction", "Synopsis", 5F, 19, "photo.jpg")));
    }


    @Test
    public void add_dvd_returns_false_if_property_genre_is_null()
            throws Exception {


        assertFalse(dvdStoreService.add(createDvdServiceModel("The Matrix",null, "Synopsis", 5F, 19, "photo.jpg")));
    }

}
