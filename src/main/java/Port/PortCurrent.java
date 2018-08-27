package Port;

import Description.PortDescription;
import Port.Service.PortA;

import java.util.HashSet;
import java.util.List;

/**
 * @author alex_jd
 */
public class PortCurrent extends PortA {

    private Integer idLink = null;
    private String description = null;

    public PortCurrent() {
        //getDB = new GetFromDB();
        //snmp = new SNMPManager1();
    }

    public PortCurrent(Integer idLink) {
        //getDB = new GetFromDB();
        //snmp = new SNMPManager1();
        this.idLink = idLink;
        makeDescription();
    }

    @Override
    public String getPortDescription() {
        return description;
    }

    public void setDescription() {
        makeDescription();
    }

    private void makeDescription() {
        HashSet<List> idSwitchFromDB = new HashSet<List>();
        String sqlRequestSwByIdConn = "select * from ports where id = " + idLink + ";";
        // 1 - id_conn, 2 - id_switch(main)
        HashSet<List> idSwitches = getDB.selectExecute(sqlRequestSwByIdConn, 1, 2);
        // Get id_switch from List
        PortDescription descr = new PortDescription(Integer.valueOf(idSwitches.iterator().next().get(1).toString()));
        description = descr.getDescription();
    }
}