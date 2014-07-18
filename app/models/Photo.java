package models;

import play.db.ebean.Model;

import javax.persistence.*;

@Entity
public class Photo extends Model{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long id;
    public String title;
    public String url;

    public Photo() {}
    public Photo(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public static Finder<Long,Photo> find = new Finder<Long,Photo>(
            Long.class, Photo.class
    );

    public static void InitData(){
        new Photo("aaa","//dummyimage.com/200x200/333/fff.png").save();
        new Photo("bbb","//dummyimage.com/200x200/333/fff.png").save();
        new Photo("ccc","//dummyimage.com/200x200/333/fff.png").save();
        new Photo("ddd","//dummyimage.com/200x200/333/fff.png").save();
        new Photo("eee","//dummyimage.com/200x200/333/fff.png").save();
        new Photo("fff","//dummyimage.com/200x200/333/fff.png").save();
        new Photo("ggg","//dummyimage.com/200x200/333/fff.png").save();
    }
}
