package session12;

import java.util.List;

/**
 * Created by PaHod on 10.06.2014.
 */
public interface RegionDao {

    void create(Region region);
    Region read(Long id);
    void update(Region region);
    void delete(Region region);
    List<Region> findAll();
    List<Region> findByName(String name);
    List<Region> findByPartOfName(String partOfName);
    List<Region> findByIdRange(Long firstId, Long lastId);


}
