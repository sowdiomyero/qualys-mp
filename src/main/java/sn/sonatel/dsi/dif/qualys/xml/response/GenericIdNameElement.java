package sn.sonatel.dsi.dif.qualys.xml.response;

/**
 * Created by ext_sow18 on 10/01/2017.
 */
public class GenericIdNameElement {

    private int id;
    private String name;

    public GenericIdNameElement() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GenericIdNameElement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
