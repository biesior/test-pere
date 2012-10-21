package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class FeaturedModule extends Model {
    @Id
    public Long id;

    @OneToOne(optional = false)
    public Module module;

    public String name;

    public static Finder<Long, FeaturedModule> find
            = new Finder<Long, FeaturedModule>(Long.class, FeaturedModule.class);

}
