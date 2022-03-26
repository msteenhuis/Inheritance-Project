import java.util.ArrayList;

public class VolumeGroup extends LocalVolumeManager{

    private String pvInitial;
    private ArrayList<PhysicalVolume> pvStore = new ArrayList();
    private ArrayList<LogicalVolume> lvStore = new ArrayList();

    private VolumeGroup(String n, String u, PhysicalVolume p)
    {
        super(n, u);
        this.pvInitial = p + "";

    }

    public void add(LogicalVolume v)
    {
        lvArr.add(v);
    }

    public void pvSet(PhysicalVolume p)
    {
        for(int i = 0; i < pvArr.size(); i++)
        {
            if (pvArr.get(i).getName() == p.getName())
            {
                break;
            }
        }
        for (int i = 0; i < vgArr.size(); i++)
        {
            if(pvArr.get(i).getDrive().equals(p.getName()))
            {
                break;
            }
        }
        pvStore.add(p);
        System.out.println(p.getName() + " is now attached to Volume Group: " + super.getName());
    }


    public void lvSet(LogicalVolume l)
    {
        for(int i = 0; i < pvArr.size(); i++)
        {
            if (pvArr.get(i).getName() == l.getName())
            {
                break;
            }
        }
        for (int i = 0; i < vgArr.size(); i++)
        {
            if(pvArr.get(i).getDrive().equals(l.getName()))
            {
                break;
            }
        }
        lvStore.add(l);
        System.out.println(l.getName() + " is now attached to Volume Group: " + super.getName());
    }

}
